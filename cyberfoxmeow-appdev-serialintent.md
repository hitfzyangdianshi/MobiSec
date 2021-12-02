# Solution


## Description of the problem

start the activity of the intent, and get the response. The response contains a bundle that includes the class "com.mobisec.serialintent.FlagContainer". I need to call the function "getFlag()" in this class to get the flag

## Solution

Firstly, I set an intent and start the activity, and to check the result. The result contains the FlagContainer class.

```java
 @Override
 protected void onCreate(Bundle savedInstanceState) {
     super.onCreate(savedInstanceState);
     setContentView(R.layout.activity_main);

     Intent intent =new Intent();
     intent.setClassName("com.mobisec.serialintent", "com.mobisec.serialintent.SerialActivity");
    startActivityForResult(intent,9);
 }
```



My first idea is to unbundle the received data and call the function getFlag() to the content to get the flag. I tried some cases, but I got the errors.

```java
@Override
public void onActivityResult(int requestCode, int resultCode, Intent data) {
    super.onActivityResult(requestCode, resultCode, data);

    Log.i("MOBISEC","data.toString()  "+data.toString());

    Bundle bundle = data.getExtras();
    Log.i("MOBISEC","bundle.toString()  "+bundle.toString());

    try {
        Log.i("MOBISEC", " keysize   " + bundle.keySet().size());
    } catch (Exception e) {
        Log.i("MOBISEC", " e bundle.keySet().size()  " + e.toString());
    }

    try {
        Log.i("MOBISEC", " getSerializable   " + bundle.getSerializable("flag").getClass().getName());
    } catch (Exception e) {
        Log.i("MOBISEC", " e getClass().getName())  " + e.toString());
    }

    try {
        Log.i("MOBISEC", " getSerializable   " + bundle.getSerializable("flag").toString());
    } catch (Exception e) {
        Log.i("MOBISEC", " e .toString()  " + e.toString());
    }

    try {
        FlagContainer fc = (FlagContainer) bundle.getSerializable("flag");
        Log.i("MOBISEC", " fcflag  " + fc.getFlag() );
    }catch (Exception e) {
        Log.i("MOBISEC", " fc  bundle.getSerializable " + e.toString());
    }

    try {
        FlagContainer fc = (FlagContainer) getIntent().getSerializableExtra("flag");
        Log.i("MOBISEC", " fcflag  " + fc.getFlag() );
    }catch (Exception e) {
        Log.i("MOBISEC", " fc getIntent().getSerializableExtra  " + e.toString());
    }

    try {
        FlagContainer fc =(FlagContainer)  bundle.get("flag");
        Log.i("MOBISEC", " fcflag  " + fc.getFlag() );
    }catch (Exception e) {
        Log.i("MOBISEC", " fcbundle  " + e.toString());
    }

    try {
        Log.i("MOBISEC", " getByteArray  " + Arrays.toString(bundle.getByteArray("flag")));;

    }catch (Exception e) {
        Log.i("MOBISEC", " getByteArray  e " + e.toString());
    }
}
```

```verilog
09-29 16:40:47.109  4486  4486 I MOBISEC : data.toString()  Intent { (has extras) }
09-29 16:40:47.110  4486  4486 I MOBISEC : bundle.toString()  Bundle[mParcelledData.dataSize=804]
09-29 16:40:47.117  4486  4486 I MOBISEC :  e bundle.keySet().size()  java.lang.RuntimeException: Parcelable encountered IOException reading a Serializable object (name = com.mobisec.serialintent.FlagContainer)
09-29 16:40:47.117  4486  4486 I MOBISEC :  e getClass().getName())  java.lang.NullPointerException: Attempt to invoke virtual method 'java.lang.Class java.lang.Object.getClass()' on a null object reference
09-29 16:40:47.117  4486  4486 I MOBISEC :  e .toString()  java.lang.NullPointerException: Attempt to invoke virtual method 'java.lang.String java.lang.Object.toString()' on a null object reference
09-29 16:40:47.117  4486  4486 I MOBISEC :  fc  bundle.getSerializable java.lang.NullPointerException: Attempt to invoke virtual method 'java.lang.String com.mobisec.serialintent.FlagContainer.getFlag()' on a null object reference
09-29 16:40:47.117  4486  4486 I MOBISEC :  fc getIntent().getSerializableExtra  java.lang.NullPointerException: Attempt to invoke virtual method 'java.lang.String com.mobisec.serialintent.FlagContainer.getFlag()' on a null object reference
09-29 16:40:47.117  4486  4486 I MOBISEC :  fcbundle  java.lang.NullPointerException: Attempt to invoke virtual method 'java.lang.String com.mobisec.serialintent.FlagContainer.getFlag()' on a null object reference
09-29 16:40:47.117  4486  4486 I MOBISEC :  getByteArray  null
```

I think these errors are due to the codes cannot find the corresponding class in the content of the bundle. I discussed these errors with TA, and he said there should be the problem with the name of the class I set in the codes. The class name of "FlagContainer" should be "com.mobisec.serialintent.FlagContainer", and I should make it the same as the challenge provides. Then I modified the name of the class, but there was still the same problem. I was thinking that there should be other issues here, but I could not find them out.



Anyway, I find another method to call the class, which is Reflection. It allows the running Java program to obtain its own information, and can manipulate the internal properties of the class or object. The types of general objects in the program are determined at compile time, and the Java reflection mechanism can dynamically create objects and call their properties. The type of such objects is unknown at compile time. So we can directly create an object through the reflection mechanism, even if the type of this object is unknown at compile time. 

Also, the classloader is needed to load class, converting the bytecode form of Class into a Class object in memory form. The bytecode can come from the disk file *.class, or it can be *.class in the jar package. 

There are different kinds of classloaders. 

- BootClassLoader (BootStrap ClassLoader for Java)
  Used to load class files of the Android Framework layer.
- PathClassLoader (App ClassLoader for Java)
  Used to load the class file in the apk that has been installed in the system (the apk storage path in the system must be passed in, so only the installed apk file can be loaded).
- DexClassLoader (Custom ClassLoader for Java)
  Used to load class files in the specified directory (jar/apk/dex can be loaded, and uninstalled apk can be loaded from the SD card).
- BaseDexClassLoader
  It is the parent class of PathClassLoader and DexClassLoader.

Here I use PathClassLoader  because the class included in apk has been installed. Also,  a "Method" is declarer, and invoke the instance. 

Then I get this error:

```verilog
12-01 22:40:40.919  4512  4512 I MOBISEC : java.lang.IllegalAccessException: Class java.lang.Class<com.mobisec.serialintent.MainActivity> cannot access private  method java.lang.String com.mobisec.serialintent.FlagContainer.getFlag() of class java.lang.Class<com.mobisec.serialintent.FlagContainer>
```



To solve this error, I make all entity classes implement the Serialzable interface. And I add the permission 

```xml
<permission android:name="android.permission.QUERY_ALL_PACKAGES" />
```

, and I use violent reflection to bypass API access restrictions

```java
 PackageManager pm = getPackageManager();
  String apkPath=pm.getApplicationInfo("com.mobisec.serialintent",0).sourceDir;
  PathClassLoader classLoader=new PathClassLoader(apkPath,ClassLoader.getSystemClassLoader()  );
  Class <?> clazz  = (Class<?>)  classLoader. loadClass ("com.mobisec.serialintent.FlagContainer");
  Method method  =clazz .getDeclaredMethod("getFlag");
  method .setAccessible(true);
  Bundle bundle=data.getExtras();
  bundle.setClassLoader(classLoader);
  String result = (String) method.invoke(bundle.get("flag"));
  Log.i("MOBISEC", result);
```



Finally, with the PathClassLoader, I get the flag

<img src="screenshots/serialintent/111.PNG" alt="flag" style="zoom:100%;" />





## Optional Feedback



## reference

What is Reflection: https://www.sczyh30.com/posts/Java/java-reflection-1/

Java Reflection, with Method: https://yi-yun.github.io/JavaReflect/#%E6%96%B9%E6%B3%95

Passing data through intent using Serializable: https://pretagteam.com/question/passing-data-through-intent-using-serializable

putSerializable: https://developer.android.com/reference/android/os/Bundle#putSerializable(java.lang.String,%20java.io.Serializable)

Android Developers Docs Reference - Serializable: https://developer.android.com/reference/java/io/Serializable

In-depth understanding of the ClassLoader in Android: https://juejin.cn/post/6844903520815022093#heading-1

Android ClassLoader: https://zhuanlan.zhihu.com/p/136083521 

Java ClassLoader: https://blog.51cto.com/u_14479502/3115664

JAVA Security Foundation (1)-ClassLoader: https://xz.aliyun.com/t/9002#toc-2

resolution of BootClassLoader PathClassLoader by Bundle.setClassLoader() method: https://blog.csdn.net/dongbaoming/article/details/54312824

Reflection and class loading: https://zhuanlan.zhihu.com/p/90218693 

ClassLoader: http://gityuan.com/2017/03/19/android-classloader/ 

Android Serializable error java.lang.RuntimeException: Parcelable encountered IOException writing: https://blog.csdn.net/Afanbaby/article/details/78615207

DexClassLoader and PathClassLoader: https://www.cnblogs.com/mingfeng002/p/7852643.html

DexClassLoader: https://www.cnblogs.com/zhengtu2015/p/5242940.html
