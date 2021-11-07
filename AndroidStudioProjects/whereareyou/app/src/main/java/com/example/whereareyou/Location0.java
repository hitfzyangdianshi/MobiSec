package com.example.whereareyou;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.app.Activity;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.location.LocationProvider;
import android.os.Bundle;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Looper;
import android.util.Log;
import android.widget.Toast;

import java.util.Timer;
import java.util.TimerTask;

public class Location0 extends Service {
    //https://developer.android.com/guide/components/services#LifecycleCallbacks
    int startMode;       // indicates how to behave if the service is killed
    IBinder binder;      // interface for clients that bind
    boolean allowRebind; // indicates whether onRebind should be used

 //  String serviceString = Context.LOCATION_SERVICE;// 获取的是位置服务
  //  LocationManager locationManager = (LocationManager) getSystemService(serviceString);// 调用getSystemService()方法来获取LocationManager对象

    public static LocationManager mLocationManager;//位置管理器

    public static Location location;

    @Override
    public void onCreate() {
        // The service is being created
      //  getCurrentLocation();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        // The service is starting, due to a call to startService()


        Log.i("MOBISEC", "my onStartCommand");
      //  Location currLoc = getCurrentLocation(); // put your magic here
        Intent i = new Intent();
        Log.i("MOBISEC", "my Intent i = new Intent();");
        i.setAction("com.mobisec.intent.action.LOCATION_ANNOUNCEMENT");


        mLocationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        //获取到GPS_PROVIDER
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED || ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            // return;
          //  ActivityCompat.requestPermissions( , new String[] {"android.permission.ACCESS_COARSE_LOCATION","android.permission.ACCESS_FINE_LOCATION","android.permission.ACCESS_BACKGROUND_LOCATION"}, 1);
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
                MainActivity.updata(mLocationManager.getLastKnownLocation(provider));
            }

            @Override
            public void onProviderDisabled(String provider) {
                // TODO Auto-generated method stub

            }
            @Override
            public void onLocationChanged(Location location) {
                // 当GPS定位信息发生改变时，更新位置
                MainActivity.updata(location);
            }
        });
        //更新位置信息显示到
        MainActivity.updata(location);


        Log.i("MOBISEC", " .location:     "+location);
        double lat = location.getLatitude();//获取纬度
        double lng = location.getLongitude();//获取经度
        Log.i("MOBISEC", "currLoc" +lat+"   " +lng);
        i.putExtra("location", location);
        Log.i("MOBISEC", "sendBroadcast(i) ");
        sendBroadcast(i);

        return startMode;
    }


  /*  Location getCurrentLocation() {
        //https://cloud.tencent.com/developer/article/1740232

        // Log.i("MOBISEC", "locationManager locationManager = (LocationManager) getSystemService(serviceString);");


        String provider = LocationManager.GPS_PROVIDER;// 指定LocationManager的定位方法
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED || ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            Log.i("MOBISEC","ActivityCompat.checkSelfPermission failed................");
            //ActivityCompat.requestPermissions( this, new String[] {"android.permission.ACCESS_COARSE_LOCATION","android.permission.ACCESS_FINE_LOCATION","android.permission.ACCESS_BACKGROUND_LOCATION"}, 1);

        }
        Location location = locationManager.getLastKnownLocation(provider);// 调用getLastKnownLocation()方法获取当前的位置信息
        Log.i("MOBISEC","Location location = locationManager.getLastKnownLocation(provider);");
        if (location != null) {
            updateUI(location);
            Log.i("MOBISEC","locationManager.requestLocationUpdates");
            Intent i = new Intent();
            i.setAction("com.mobisec.intent.action.LOCATION_ANNOUNCEMENT");
            Log.i("MOBISEC", "onLocationChanged o"  );
            i.putExtra("location", location);
            Log.i("MOBISEC", "sendBroadcast(i)  o");
            sendBroadcast(i);
        }

        locationManager.requestLocationUpdates(provider, 1,0, locationListener);



        Log.i("MOBISEC","location getLatitude: "+location.getLatitude());
        return location;
    }*/

/*
    private LocationListener locationListener = new LocationListener() {
        */
/**
         * 位置信息变化时触发:当坐标改变时触发此函数，如果Provider传进相同的坐标，它就不会被触发
         * @param location
         *//*

        @Override
        public void onLocationChanged(Location location) {
            Log.i("MOBISEC","onLocationChanged");
            updateUI(location);
            Log.i("MOBISEC", "时间：" + location.getTime());
            Log.i("MOBISEC", "经度：" + location.getLongitude());
            Log.i("MOBISEC", "纬度：" + location.getLatitude());
            Log.i("MOBISEC", "海拔：" + location.getAltitude());
        }

        */
/**
         * GPS状态变化时触发:Provider被disable时触发此函数，比如GPS被关闭
         * @param provider
         * @param status
         * @param extras
         *//*

        @Override
        public void onStatusChanged(String provider, int status, Bundle extras) {
            switch (status) {
                //GPS状态为可见时
                case LocationProvider.AVAILABLE:
                    Log.i("MOBISEC","onStatusChanged：当前GPS状态为可见状态");
                    break;
                //GPS状态为服务区外时
                case LocationProvider.OUT_OF_SERVICE:
                    Log.i("MOBISEC", "onStatusChanged:当前GPS状态为服务区外状态" );
                    break;
                //GPS状态为暂停服务时
                case LocationProvider.TEMPORARILY_UNAVAILABLE:
                    Log.i("MOBISEC","onStatusChanged:当前GPS状态为暂停服务状态" );
                    break;
            }
        }

        */
/**
         * 方法描述：GPS开启时触发
         * @param provider
         *//*

        @Override
        public void onProviderEnabled(String provider) {
            Log.i("MOBISEC", "onProviderEnabled:方法被触发" );
            getCurrentLocation();
        }

        */
/**
         * 方法描述： GPS禁用时触发
         * @param provider
         *//*

        @Override
        public void onProviderDisabled(String provider) {

        }
    };//https://blog.csdn.net/u012810020/article/details/52517976



    private void updateUI(Location location) {
        double longitude = location.getLongitude();
        double latitude = location.getLatitude();
        Log.i("MOBISEC","当前经度：" + longitude + "\n当前纬度：" + latitude);
    }//https://blog.csdn.net/u012810020/article/details/52517976

*/








    @Override
    public IBinder onBind(Intent intent) {
        // A client is binding to the service with bindService()
        return binder;
    }

    @Override
    public boolean onUnbind(Intent intent) {
        // All clients have unbound with unbindService()
        return allowRebind;
    }

    @Override
    public void onRebind(Intent intent) {
        // A client is binding to the service with bindService(),
        // after onUnbind() has already been called
    }

    @Override
    public void onDestroy() {
        // The service is no longer used and is being destroyed
    }


}