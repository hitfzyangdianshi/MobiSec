# Solution

## Description of the problem

The flag is announced on the system with a broadcast intent with action `com.mobisec.intent.action.FLAG_ANNOUNCEMENT`. The flag is in the Intent's bundle, under the "flag" key.

## Solution

I've solved the challenge by developing an app with a broadcast receiver. 

Firstly, I specify the <receiver> element in the app's manifest. The <receiver> element is included in the <application>

```xml
<receiver android:name=".MyBroadcastReceiver"  android:exported="true" android:enabled="true">
    <intent-filter>
        <action android:name="com.mobisec.intent.action.FLAG_ANNOUNCEMENT"/>
    </intent-filter>
</receiver>
```

Also, I set a public class MyBroadcastReceiver subclassing `BroadcastReceiver` and implementing `onReceive(Context, Intent)`. I get the string with the "flag" key from the bundle, and print it out as log. 

```java
public class MyBroadcastReceiver extends BroadcastReceiver {
    private static final String TAG = "MOBISEC";

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.i(TAG,"begin");
        Bundle bundle =intent.getExtras();
        if(bundle!=null) {
            String flag=bundle.getString("flag");
            Log.i(TAG, flag);
        }
    }
}
```



In the MainActivity class, I set a private function to register the broad receiver with creating instance of `IntentFilter` and `BroadcastReceiver`. 

```java
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        receiveBroad();
    }

    private void receiveBroad() {
        BroadcastReceiver br = new MyBroadcastReceiver();
        IntentFilter filter = new IntentFilter();
        filter.addAction("com.mobisec.intent.action.FLAG_ANNOUNCEMENT");
        registerReceiver(br, filter);
    }
}
```

The flag is:

![flag](screenshots\justlisten\result.PNG)




## Optional Feedback

I forgot this sentence at the beginning: **However, only logs with the tag "MOBISEC" will appear in the public log**(https://mobisec.reyammer.io/analysis). I tried many times before but did not get any flag on condition that apk analysis is passed, because I did not add MOBISEC tag, so I could see nothing output. 

## reference



https://developer.android.com/guide/components/broadcasts#java

https://www.jianshu.com/p/b0fce242e91b

https://developer.android.com/reference/android/content/BroadcastReceiver