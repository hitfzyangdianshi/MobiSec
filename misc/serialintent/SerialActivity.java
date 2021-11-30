package com.mobisec.serialintent;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class SerialActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_serial);

        Log.e("MOBISEC", "shuffling");
        FlagShuffler fs = new FlagShuffler();
        FlagContainer fc = fs.shuffleFlag(MainActivity.flag);


        Log.e("MOBISEC", "sending back intent");
        Intent resultIntent = new Intent();
        resultIntent.putExtra("flag", fc);
        setResult(Activity.RESULT_OK, resultIntent);
        finish();
    }
}
