package com.example.justask;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.text.style.BulletSpan;
import android.util.Log;

/*There is an app installed on the system. The app has four activities.
Each of them has one part of the flag. If you ask them nicely, they will all kindly reply with their part of the flag.
They will reply with an Intent, the part of the flag is somehow contained there.
Check the app's manifest for the specs. Good luck ;-)*/
public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent sendIntent1 = new Intent();
        sendIntent1.setClassName("com.mobisec.justask","com.mobisec.justask.PartOne");
        startActivityForResult(sendIntent1,1);


        Intent sendIntent2 = new Intent("com.mobisec.intent.action.JUSTASK");
        sendIntent2.setClassName("com.mobisec.justask","com.mobisec.justask.PartTwo");
        startActivityForResult(sendIntent2,2);

        Intent sendIntent3 = new Intent();
        sendIntent3.setClassName("com.mobisec.justask","com.mobisec.justask.PartThree");
        startActivityForResult(sendIntent3,3);

        Intent sendIntent4 = new Intent("com.mobisec.intent.action.JUSTASKBUTNOTSOSIMPLE");
        sendIntent4.setClassName("com.mobisec.justask","com.mobisec.justask.PartFour");
        startActivityForResult(sendIntent4,4);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        Bundle bundle =data.getExtras();
       /* for (String key: bundle.keySet() ) {
            if(bundle.getString(key)!=null){//if(!key.equals("follow")) {
                Log.i("MOBISEC", requestCode + "   " + resultCode + "   Key=" + key + ", content=" + bundle.getString(key));
            }
            else
            {
                Bundle bundle1 = (Bundle)bundle.get(key);
                for (String key1: bundle1.keySet() )
                {
                    Log.i("MOBISEC", requestCode + "   " + resultCode + "   Key=" + key1 + ", content=" + bundle1.getString(key));
                }
            }
        }*/
        //  Log.i("MOBISEC",requestCode+"  "+resultCode+"  "+data.getExtras().toString());
        unzipBundle( bundle,  requestCode,  resultCode);
    }

    protected void unzipBundle(Bundle bundle, int requestCode, int resultCode)
    {
        for(String k:bundle.keySet())
        {
            Object v=bundle.get(k);
            if(v.getClass().getSimpleName().equals("String"))
            {
                Log.i("MOBISEC", requestCode + "   " + resultCode + "   Key=" + k + ", content=" + bundle.getString(k));
            }
            else {
                unzipBundle((Bundle) v,requestCode,resultCode);
            }
        }
    }
}
/*Output of logcat:
10-19 11:53:33.029  4479  4479 E MOBISEC : onCreate
10-19 11:53:33.029  4479  4479 E MOBISEC : flag set correctly
The analysis terminated without errors.*/
/*10-24 02:03:41.083  4512  4512 I MOBISEC : 4   -1   Key=follow, content=null
10-24 02:03:41.083  4512  4512 I MOBISEC : 4   -1   Key=flag, content=see the hint for the third part of the flag. Have fun ;-)
10-24 02:03:41.083  4512  4512 I MOBISEC : 3   -1   Key=hiddenFlag, content=I_got_the_f
10-24 02:03:41.083  4512  4512 I MOBISEC : 3   -1   Key=flag, content=Mmm, come on, let's spicy this up. Have fun finding the third part of the flag somewhere in this intent ;-)
10-24 02:03:41.083  4512  4512 I MOBISEC : 2   -1   Key=flag, content=_asked_and_
10-24 02:03:41.083  4512  4512 I MOBISEC : 1   -1   Key=flag, content=MOBISEC{Ive
*/
/*10-24 02:05:27.965  4511  4511 I MOBISEC : 4   -1   Key=the, content=null
10-24 02:05:27.965  4511  4511 I MOBISEC : 4   -1   Key=flag, content=see the hint for the third part of the flag. Have fun ;-)
10-24 02:05:27.965  4511  4511 I MOBISEC : 3   -1   Key=hiddenFlag, content=I_got_the_f
10-24 02:05:27.965  4511  4511 I MOBISEC : 3   -1   Key=flag, content=Mmm, come on, let's spicy this up. Have fun finding the third part of the flag somewhere in this intent ;-)
10-24 02:05:27.965  4511  4511 I MOBISEC : 2   -1   Key=flag, content=_asked_and_
10-24 02:05:27.966  4511  4511 I MOBISEC : 1   -1   Key=flag, content=MOBISEC{Ive
*/
/*
10-24 01:32:30.020  4511  4511 I MOBISEC : theywillneverfindthisfourthpart :  lag_how_nice!}
10-24 01:32:30.020  4511  4511 I MOBISEC : flag :  see the hint for the third part of the flag. Have fun ;-)
10-24 01:32:30.020  4511  4511 I MOBISEC : hiddenFlag :  I_got_the_f
10-24 01:32:30.020  4511  4511 I MOBISEC : flag :  Mmm, come on, let's spicy this up. Have fun finding the third part of the flag somewhere in this intent ;-)
10-24 01:32:30.020  4511  4511 I MOBISEC : flag :  _asked_and_
10-24 01:32:30.020  4511  4511 I MOBISEC : flag :  MOBISEC{Ive
* */