/*You need to declare and implement a service with an intent filter with action com.mobisec.intent.action.GIMMELOCATION.
The system will find your service and it will start it with a startService() method (and an appropriate intent as argument).
The system expects to get back the current location (as a Location object).

During the test, the system will change the current location at run-time and it will query your service to get the updated location.
If the expected location matches with what you reply back, the flag will be printed in the logs.

Your service should "return" the reply to the system with a broadcast intent, with a specific action and bundle, as in the snippet below:

Location currLoc = getCurrentLocation(); // put your magic here
Intent i = new Intent();
i.setAction("com.mobisec.intent.action.LOCATION_ANNOUNCEMENT");
i.putExtra("location", currLoc);
sendBroadcast(i);*/
package com.example.whereareyou;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    public static LocationManager mLocationManager;//位置管理器

    public static Location location;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        mLocationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        //获取到GPS_PROVIDER
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
           // return;
             ActivityCompat.requestPermissions( this, new String[] {"android.permission.ACCESS_COARSE_LOCATION","android.permission.ACCESS_FINE_LOCATION","android.permission.ACCESS_BACKGROUND_LOCATION"}, 1);
             Log.i("MOBISEC", "requestPermissions:   ");
        }
        location = mLocationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
        Log.i("MOBISEC", "getLastKnownLocation   ");
        //侦听位置发生变化，2000毫秒更新一次，位置超过8米也更新一次
        mLocationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 1, 1, new LocationListener() {

            @Override
            public void onStatusChanged(String provider, int status, Bundle extras) {
                // TODO Auto-generated method stub
            }

            @Override
            public void onProviderEnabled(String provider) {
                // 当GPS Location Provider可用时，更新位置
                updata(mLocationManager.getLastKnownLocation(provider));
            }

            @Override
            public void onProviderDisabled(String provider) {
                // TODO Auto-generated method stub

            }
            @Override
            public void onLocationChanged(Location location) {
                // 当GPS定位信息发生改变时，更新位置
                updata(location);
            }
        });
        //更新位置信息显示到
        updata(location);
    }

    public static void updata(Location location){
        if(location != null){
            StringBuilder sb = new StringBuilder();
            sb.append("实时的位置信息:\n");
            sb.append("经度:");
            sb.append(location.getLongitude());
            sb.append("\n纬度:");
            sb.append(location.getLatitude());
            sb.append("\b高度:");
            sb.append(location.getAltitude());
            sb.append("\n速度：");
            sb.append(location.getSpeed());
            sb.append("\n方向：");
            sb.append(location.getBearing());
            Log.i("MOBISEC", "updata:  "+sb.toString());
        }
    }

}