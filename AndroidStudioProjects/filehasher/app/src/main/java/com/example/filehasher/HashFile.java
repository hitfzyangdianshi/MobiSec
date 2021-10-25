package com.example.filehasher;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.security.MessageDigest;


public class HashFile extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       // setContentView(R.layout.activity_main);

        Uri filePath=getIntent().getData();

        Log.e("MOBISEC","filePath.toString()\t"+filePath.toString());

        // calculate hash
        String hash = calcHash(filePath.toString());
    //    Log.i("MOBISEC",hash);

        // return the hash in a "result" intent
        Intent resultIntent = new Intent();
        resultIntent.putExtra("hash", hash);
        setResult(Activity.RESULT_OK, resultIntent);
        finish();
    }


    public String calcHash(String filePath) {
        InputStream inputStream = null;
        try {
            String[] prefix = {
                    "file:"};
            File file = new File(removePrefix(filePath,prefix)); // Create an FileInputStream instance according to the filepath
            byte[] buffer = new byte[1024]; // The buffer to read the file
            MessageDigest digest = MessageDigest.getInstance("SHA-256"); // Get a SHA-  instance
            inputStream = new FileInputStream(file);
            int numRead = 0; // Record how many bytes have been read
            while (numRead != -1) {
                numRead = inputStream.read(buffer);
                if (numRead > 0)
                    digest.update(buffer, 0, numRead); // Update the digest
            }
            byte[] sha2Bytes = digest.digest(); // Complete the hash computing
            return convertHashToString(sha2Bytes); // Call the function to convert to hex digits
        } catch (Exception e) {
            {
                Log.e("MOBISEC","calcHash\t"+e);
                return null;
            }
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close(); // Close the InputStream
                } catch (Exception e) {
                }
            }
        }
    }


    private static String convertHashToString(byte[] hashBytes) {
        String returnVal = "";
        for (int i = 0; i < hashBytes.length; i++) {
            returnVal += Integer.toString(( hashBytes[i] & 0xff) + 0x100, 16).substring(1);
        }
        return returnVal.toLowerCase();
    }


    /**
     * 去掉字符串指定的前缀
     * @param str 字符串名称
     * @param prefix 前缀数组
     * @return
     */
    public static String removePrefix(String str, String[] prefix) {

        if (str.isEmpty()) {

            return "";
        } else {

            if (null != prefix) {

                String[] prefixArray = prefix;

                for(int i = 0; i < prefix.length; ++i) {

                    String pf = prefixArray[i];
                    if (str.toLowerCase().matches("^" + pf.toLowerCase() + ".*")) {

                        return str.substring(pf.length());//截取前缀后面的字符串
                    }
                }
            }

            return str;
        }
    }




}