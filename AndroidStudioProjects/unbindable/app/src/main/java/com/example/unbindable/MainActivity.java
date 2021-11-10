/*Bind to the service and get the flag. It can't get any easier.*/
package com.example.unbindable;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    /** Messenger for communicating with the service. */
    Messenger mService = null;

    /** Flag indicating whether we have called bind on the service. */
    boolean bound;

    private ServiceConnection mConnection = new ServiceConnection() {
        public void onServiceConnected(ComponentName className, IBinder service) {
            // This is called when the connection with the service has been
            // established, giving us the object we can use to
            // interact with the service.  We are communicating with the
            // service using a Messenger, so here we get a client-side
            // representation of that from the raw IBinder object.
            mService = new Messenger(service);
            bound = true;

            sayHello();
        }

        public void onServiceDisconnected(ComponentName className) {
            // This is called when the connection with the service has been
            // unexpectedly disconnected -- that is, its process crashed.
            mService = null;
            bound = false;
        }

        public void sayHello(){
            if (!bound) return;
            // Create and send a message to the service, using a supported 'what' value
            Message msg=Message.obtain(null,MessengerService.MSG_REGISTER_CLIENT);
            msg.replyTo=MessengerService.mMessenger;
            try {
                mService.send(msg);
            } catch (RemoteException e) {
                e.printStackTrace();
                Log.i("MOBISEC", "RemoteException e 1: "+e);
            }

            msg=Message.obtain(null,MessengerService.MSG_SET_VALUE);
            try {
                mService.send(msg);
            } catch (RemoteException e) {
                e.printStackTrace();
                Log.i("MOBISEC", "RemoteException e 2: "+e);
            }

            msg=Message.obtain(null,MessengerService.MSG_GET_FLAG);
            try {
                mService.send(msg);
            } catch (RemoteException e) {
                e.printStackTrace();
                Log.i("MOBISEC", "RemoteException e 3: "+e);
            }
        }

    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Bind to the service
        Intent intent = new Intent();
        intent.setClassName("com.mobisec.unbindable","com.mobisec.unbindable.UnbindableService");
        bindService(intent, mConnection, Context.BIND_AUTO_CREATE);
        bound=true;
        Log.i("MOBISEC", "bindService : " );
    }

   /* @Override
    protected void onStart() {
        super.onStart();
        // Bind to the service
        Intent intent = new Intent();
        intent.setClassName("com.mobisec.unbindable","com.mobisec.unbindable.UnbindableService");
        bindService(intent, mConnection, Context.BIND_AUTO_CREATE);
        bound=true;
        Log.i("MOBISEC", "bindService : " );
    }*/


}