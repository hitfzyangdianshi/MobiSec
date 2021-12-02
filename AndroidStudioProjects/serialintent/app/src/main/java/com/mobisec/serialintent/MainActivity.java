/*Start the SerialActivity, it will give you back the flag. Kinda.*/
package com.mobisec.serialintent;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import android.util.Log;

import android.content.Intent;

import com.mobisec.serialintent.R;
import com.mobisec.serialintent.FlagContainer;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;

import dalvik.system.DexClassLoader;
import dalvik.system.PathClassLoader;


public class MainActivity extends AppCompatActivity implements Serializable {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent intent =new Intent();
        intent.setClassName("com.mobisec.serialintent","com.mobisec.serialintent.SerialActivity");
       // startActivity(intent,null);
        startActivityForResult(intent,9);
   //     FlagContainer fc=(FlagContainer) intent.getSerializableExtra("flag");

   //     Log.i("MOBISEC",fc.getFlag());
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

       /* Log.i("MOBISEC","data.toString()  "+data.toString());

        Bundle bundle = data.getExtras();
        Log.i("MOBISEC","bundle.toString()  "+bundle.toString());

        try {
            Log.i("MOBISEC", " keysize   " + bundle.keySet().size());
        } catch (Exception e) {
            Log.i("MOBISEC", " e bundle.keySet().size()  " + e.toString());
        }
        //java.lang.RuntimeException: Parcelable encountered ClassNotFoundException reading a Serializable object
        // (name = com.mobisec.serialintent.FlagContainer)

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


        //Log.i("MOBISEC",bundle.get("flag").getClass().getName());
        //bundle.get("flag").getClass();


        try {
            Log.i("MOBISEC", " getByteArray  " + Arrays.toString(bundle.getByteArray("flag")));;

        }catch (Exception e) {
            Log.i("MOBISEC", " getByteArray  e " + e.toString());
        }

       // Log.i("MOBISEC", requestCode + "   " + resultCode + ", content=" + ( (FlagContainer) (bundle.get("flag")) ).getFlag());

*/

        try{
            PackageManager pm = getPackageManager();
          //  @SuppressLint("QueryPermissionsNeeded") List<ResolveInfo> resolveinfoes =  pm.queryIntentActivities(data, 0);
          //  ActivityInfo actInfo = resolveinfoes.get(0).activityInfo;
            String apkPath=pm.getApplicationInfo("com.mobisec.serialintent",0).sourceDir;
            PathClassLoader classLoader=new PathClassLoader(
                    apkPath,
                //    getApplicationInfo().dataDir,
                //    actInfo.applicationInfo.nativeLibraryDir,
                    ClassLoader.getSystemClassLoader()  //   this.getClass().getClassLoader()
            );
          //ClassLoader classLoader =new ClassLoader();

            Class<?> clazz  =(Class<?>) classLoader.loadClass("com.mobisec.serialintent.FlagContainer");
            //Class<?> cls=Class.forName("com.mobisec.serialintent.FlagContainer");
            Method method  =clazz .getDeclaredMethod("getFlag");
            method .setAccessible(true);
            Bundle bundle=data.getExtras();
            bundle.setClassLoader(classLoader);
            String result = (String) method.invoke(bundle.get("flag"));
            Log.i("MOBISEC", result);
        }  catch (Exception e) {
            Log.i("MOBISEC",e.toString());
        }

    }
}


/*
11-16 18:48:26.689  4507  4507 I MOBISEC :  e   java.lang.RuntimeException: Parcelable encountered ClassNotFoundException reading a Serializable object (name = com.mobisec.serialintent.FlagContainer)
11-16 18:48:26.689  4507  4507 I MOBISEC :  e   java.lang.NullPointerException: Attempt to invoke virtual method 'java.lang.Class java.lang.Object.getClass()' on a null object reference
11-16 18:48:26.689  4507  4507 I MOBISEC :  e   java.lang.NullPointerException: Attempt to invoke virtual method 'java.lang.String java.lang.Object.toString()' on a null object reference

* */

/*Output of logcat:
09-29 16:40:45.159  4452  4452 E MOBISEC : SerialIntent:onCreate
09-29 16:40:45.159  4452  4452 E MOBISEC : flag set correctly
Output of logcat:
09-29 16:40:46.735  4452  4452 E MOBISEC : shuffling
09-29 16:40:46.740  4452  4452 E MOBISEC : sending back intent
09-29 16:40:46.870  4486  4486 I MOBISEC : data.toString()  Intent { (has extras) }
09-29 16:40:46.870  4486  4486 I MOBISEC : bundle.toString()  Bundle[mParcelledData.dataSize=804]
09-29 16:40:46.878  4486  4486 I MOBISEC :  e bundle.keySet().size()  java.lang.RuntimeException: Parcelable encountered IOException reading a Serializable object (name = com.mobisec.serialintent.FlagContainer)
09-29 16:40:46.878  4486  4486 I MOBISEC :  e getClass().getName())  java.lang.NullPointerException: Attempt to invoke virtual method 'java.lang.Class java.lang.Object.getClass()' on a null object reference
09-29 16:40:46.878  4486  4486 I MOBISEC :  e .toString()  java.lang.NullPointerException: Attempt to invoke virtual method 'java.lang.String java.lang.Object.toString()' on a null object reference
09-29 16:40:46.878  4486  4486 I MOBISEC :  fc  bundle.getSerializable java.lang.NullPointerException: Attempt to invoke virtual method 'java.lang.String com.mobisec.serialintent.FlagContainer.getFlag()' on a null object reference
09-29 16:40:46.879  4486  4486 I MOBISEC :  fc getIntent().getSerializableExtra  java.lang.NullPointerException: Attempt to invoke virtual method 'java.lang.String com.mobisec.serialintent.FlagContainer.getFlag()' on a null object reference
09-29 16:40:46.879  4486  4486 I MOBISEC :  fcbundle  java.lang.NullPointerException: Attempt to invoke virtual method 'java.lang.String com.mobisec.serialintent.FlagContainer.getFlag()' on a null object reference
09-29 16:40:46.879  4486  4486 I MOBISEC :  getByteArray  null
09-29 16:40:46.880  4486  4486 I MOBISEC :  ClassNotFoundException   java.lang.ClassNotFoundException: com.mobisec.serialintent.FlagContainer
*/