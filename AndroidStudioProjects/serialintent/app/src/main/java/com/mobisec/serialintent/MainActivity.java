/*Start the SerialActivity, it will give you back the flag. Kinda.*/
package com.mobisec.serialintent;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import android.content.Intent;

import com.mobisec.serialintent.R;
import com.mobisec.serialintent.FlagContainer;

import java.util.Arrays;


public class MainActivity extends AppCompatActivity {

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
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        Log.i("MOBISEC","data.toString()  "+data.toString());

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

      /*  ClassLoader classloader = new ClassLoader() {
            @Override
            public Class<?> loadClass(String name) throws ClassNotFoundException {
                return super.loadClass(name);
            }
        };
        Class <?> c= null;
        try {
            c = (Class<?>) classloader.loadClass("com.mobisec.serialintent.FlagContainer");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            Log.i("MOBISEC", " ClassNotFoundException   " + e.toString());
        }
        Method m = null;
        try {
            m =c.getDeclaredMethod("getFlag");
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
            Log.i("MOBISEC", " NoSuchMethodException   " + e.toString());
        }
        m.setAccessible(true);
        bundle.setClassLoader(classloader);
        try {
            String f=(String)m.invoke(bundle.get("flag"));
            Log.i("MOBISEC",f);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
            Log.i("MOBISEC", " IllegalAccessException   " + e.toString());
        } catch (InvocationTargetException e) {
            e.printStackTrace();
            Log.i("MOBISEC", " InvocationTargetException   " + e.toString());
        }*/


    }
}


/*
11-16 18:48:26.689  4507  4507 I MOBISEC :  e   java.lang.RuntimeException: Parcelable encountered ClassNotFoundException reading a Serializable object (name = com.mobisec.serialintent.FlagContainer)
11-16 18:48:26.689  4507  4507 I MOBISEC :  e   java.lang.NullPointerException: Attempt to invoke virtual method 'java.lang.Class java.lang.Object.getClass()' on a null object reference
11-16 18:48:26.689  4507  4507 I MOBISEC :  e   java.lang.NullPointerException: Attempt to invoke virtual method 'java.lang.String java.lang.Object.toString()' on a null object reference

* */