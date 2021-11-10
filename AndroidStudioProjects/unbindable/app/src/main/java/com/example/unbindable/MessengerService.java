package com.example.unbindable;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.util.Log;
import android.widget.Toast;

public class MessengerService extends Service {
    /**
     * Command to the service to display a message
     */
    static final int MSG_REGISTER_CLIENT = 1;
    static final int MSG_UNREGISTER_CLIENT = 2;
    static final int MSG_SET_VALUE = 3;
    static final int MSG_GET_FLAG = 4;


    /**
     * Handler of incoming messages from clients.
     */
    static class IncomingHandler extends Handler {
        /*private Context applicationContext;

        IncomingHandler(Context context) {
            applicationContext = context.getApplicationContext();
        }*/

        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
//                case MSG_SAY_HELLO:
//                    Toast.makeText(applicationContext, "hello!", Toast.LENGTH_SHORT).show();
//                    break;
                case MSG_REGISTER_CLIENT:
                    break;
                case MSG_UNREGISTER_CLIENT:
                    break;
                case MSG_SET_VALUE:
                    Log.i("MOBISEC", "MSG_SET_VALUE:  msg.arg1  " + msg.arg1 );
                    Log.i("MOBISEC", "MSG_SET_VALUE:  msg.arg2" + msg.arg2);
                    break;
                case MSG_GET_FLAG:
                    Bundle b = (Bundle) msg.obj;
                    //String info = (String) ((Bundle) msg.obj).get("flag");
                    String info = (String) b.get("flag");
                    Log.i("MOBISEC", "MSG_GET_FLAG: "+info);
                    break;
                default:
                    super.handleMessage(msg);
            }
        }
    }

    /**
     * Target we publish for clients to send messages to IncomingHandler.
     */
    //static Messenger mMessenger;
    static Messenger mMessenger = new Messenger(new IncomingHandler( ));

    /**
     * When binding to the service, we return an interface to our messenger
     * for sending messages to the service.
     */
    @Override
    public IBinder onBind(Intent intent) {
        //Toast.makeText(getApplicationContext(), "binding", Toast.LENGTH_SHORT).show();
        Log.i("MOBISEC","binding");
        //mMessenger = new Messenger(new IncomingHandler( ));
        return mMessenger.getBinder();
    }
}