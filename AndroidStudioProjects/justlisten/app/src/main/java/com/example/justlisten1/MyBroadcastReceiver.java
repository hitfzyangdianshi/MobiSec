package com.example.justlisten1;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

public class MyBroadcastReceiver extends BroadcastReceiver {
    private static final String TAG = "MOBISEC";

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.i(TAG,"begin");
      /*  StringBuilder sb = new StringBuilder();
        sb.append("Action: " + intent.getAction() + "\n");
        sb.append("URI: " + intent.toUri(Intent.URI_INTENT_SCHEME).toString() + "\n");
        sb.append("key: "+intent.getBundleExtra("key").toString()+"\n");
        String log = sb.toString();*/
        Bundle bundle =intent.getExtras();
        if(bundle!=null) {
            String flag=bundle.getString("flag");
            Log.i(TAG, flag);
        }
        //Toast.makeText(context, log, Toast.LENGTH_LONG).show();
    }
}
