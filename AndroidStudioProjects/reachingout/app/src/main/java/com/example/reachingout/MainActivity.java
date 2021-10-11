package com.example.reachingout;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.util.Log;

import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        new Thread (){
            @Override
            public void run()
            {
                netRequest();
            }
        }.start();
    }


    private void netRequest(){
        HttpURLConnection connection=null;
        try{
            URL url=new URL("http://10.0.2.2:31337/flag");
            connection=(HttpURLConnection) url.openConnection();
            /*connection.setConnectTimeout(3000);
            connection.setReadTimeout(3000);*/
            connection.setRequestMethod("POST");
            //connection.setDoInput(true);
            connection.setDoOutput(true);
            //connection.setChunkedStreamingMode(0);

            //connection.setRequestProperty("User-Agent", "Mozilla/5.0");
            //connection.setRequestProperty("Accept-Language", "en-US,en;q=0.5");
            connection.setRequestProperty("Content-Type","application/x-www-form-urlencoded");
            //connection.setRequestProperty("Content-Type", "application/json");
            //String urlParameters = "answer=\"9\"&val1=\"3\"&oper=\"+\"&val2=\"6\"";
            // String urlParameters = "answer=9";
            //String urlParameters = "answer=9&val1=3&oper=+&val2=6";

            Uri.Builder builder = new Uri.Builder()
                    .appendQueryParameter("answer", "9")
                    .appendQueryParameter("val1", "3")
                    .appendQueryParameter("oper", "+")
                    .appendQueryParameter("val2", "6")
                    ;
            String query = builder.build().getEncodedQuery();

            OutputStream os = connection.getOutputStream();
            BufferedWriter writer = new BufferedWriter(
                    new OutputStreamWriter(os, "UTF-8"));
            writer.write(query);
            writer.flush();
            writer.close();
            os.close();

            connection.connect();

            //JSONObject jsonParam = new JSONObject();
            //jsonParam.put("answer", "9");
            /*  jsonParam.put("val1","3");
            jsonParam.put("oper","+");
            jsonParam.put("val2","6");*/
           // DataOutputStream dos=new DataOutputStream(connection.getOutputStream());
           // dos.writeBytes(URLEncoder.encode(jsonParam.toString(),"UTF-8"));
            //dos.writeBytes(jsonParam.toString());
            /*dos.writeBytes("answer=9");
            dos.flush ();
            dos.close();*/


            int responseCode=connection.getResponseCode();
            if(responseCode!=HttpURLConnection.HTTP_OK){
                Log.i("MOBISEC","HTTP error code "+responseCode);
              //  throw new IOException("HTTP error code "+responseCode);
            }
            String result =getStringByStream(connection.getInputStream());
            if(result==null){
                Log.i("MOBISEC","failed ");
            }
            else{
                Log.i("MOBISEC","success ");
                Log.i("MOBISEC",result);
            }

        } catch(Exception e){
            e.printStackTrace();
        }
    }

/*
10-07 10:53:14.571  4484  4503 E MOBISEC :
10-07 10:53:14.571  4484  4503 E MOBISEC :         How much is 3 + 6?
10-07 10:53:14.571  4484  4503 E MOBISEC :         <form action="/flag" method="POST">
10-07 10:53:14.571  4484  4503 E MOBISEC :           <label for="answer">Insert Answer</label>
10-07 10:53:14.571  4484  4503 E MOBISEC :           <input id="answer" name="answer" required type="text" value="">
10-07 10:53:14.571  4484  4503 E MOBISEC :           <input id="val1" name="val1" type="hidden" value="3">
10-07 10:53:14.571  4484  4503 E MOBISEC :           <input id="oper" name="oper" type="hidden" value="+">
10-07 10:53:14.571  4484  4503 E MOBISEC :           <input id="val2" name="val2" type="hidden" value="6">
10-07 10:53:14.571  4484  4503 E MOBISEC :           <input type="submit" value="Get Flag">
10-07 10:53:14.571  4484  4503 E MOBISEC :         </form>
10-07 10:53:14.571  4484  4503 E MOBISEC :
* */
    private String getStringByStream(InputStream inputStream){
        Reader reader;
        try{
            reader = new InputStreamReader(inputStream , "UTF-8");
            char []  rawBuffer = new char [512];
            StringBuffer buffer=new StringBuffer();
            int length;
            while( (length=reader.read(rawBuffer))!=-1){
                buffer.append(rawBuffer,0,length);
            }
            return buffer.toString();
        } catch (UnsupportedEncodingException e){
            e.printStackTrace();
        } catch(IOException e){
            e.printStackTrace();
        }
        return null;
    }
}