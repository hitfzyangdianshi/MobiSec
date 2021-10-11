# Solution

## Description of the problem

There is an HTTP server listening on 10.0.2.2:31337 (reachable from within the emulator where the app is running). The flag is there.

## Solution

I've solved the challenge by developing an app to send GET and POST request to the server

Firstly, I specify the <uses-permission> element in the app's manifest with `android.permission.ACCESS_NETWORK_STATE` and `android.permission.INTERNET` to give permission of accessing the internet.

```xml
    <uses-permission android:name="android.permission.ACCESS_NETWORK_STATE" />
    <uses-permission android:name="android.permission.INTERNET" />
```

Then I set a function ``private void netRequest()` to send GET and POST request to the URL. The GET request is sent to http://10.0.2.2:31337 , with the response below:

<img src="screenshots/reachingout/1.png" alt="flag" style="zoom:60%;" />



Then the GET request is sent to http://10.0.2.2:31337/flag , with the response below:

<img src="screenshots/reachingout/2.png" alt="flag" style="zoom:60%;" />



According to the response, I need to POST a request with answer=9, and the hidden values val1=3, oper=+, and val2=6.

After POST these values to http://10.0.2.2:31337/flag, the flag is got. 

The flag is:

<img src="screenshots/reachingout/3.png" alt="flag" style="zoom:60%;" />



The code to POST values is:

```java
    private void netRequest(){
        HttpURLConnection connection=null;
        try{
            URL url=new URL("http://10.0.2.2:31337/flag");
            connection=(HttpURLConnection) url.openConnection();
            connection.setRequestMethod("POST");
            connection.setDoOutput(true);
            connection.setRequestProperty("Content-Type","application/x-www-form-urlencoded");

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
```



Also, a function is defined go get the response of the GET/POST request.

```java
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
```




## Optional Feedback

I think it would be better if the problem can give a hint about the functions that can be used for sending POST request. At first I tried to post by json data type as below, but it returned `You passed some weird values or your HTTP query was malformed. Something went wrong. Bye.`. Then I tried to post by adding parameters at the end of URL (ttp://10.0.2.2:31337/flag?answer=9&val1=3&oper=+&val2=6), but this did not work either. Some days have gone, and I tried `Uri.Builder().appendQueryParameter("answer", "9")`, and it worked. 

```java
            JSONObject jsonParam = new JSONObject();
            jsonParam.put("answer", "9");
            jsonParam.put("val1","3");
            jsonParam.put("oper","+");
            jsonParam.put("val2","6");*/
            DataOutputStream dos=new DataOutputStream(connection.getOutputStream());
            dos.writeBytes(URLEncoder.encode(jsonParam.toString(),"UTF-8"));
            dos.writeBytes(jsonParam.toString());
            dos.writeBytes("answer=9");
            dos.flush ();
            dos.close();*/
```

## reference

http://www.voycn.com/article/ruheshiyongandroid-studiofasongyigejiandandegetpostwangluoqingqiu

https://developer.android.com/reference/android/net/Uri.Builder#appendQueryParameter(java.lang.String,%20java.lang.String)