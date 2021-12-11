package loadme_rev;

/*import android.content.Context;
import android.os.StrictMode;
import android.util.Base64;
import dalvik.system.DexClassLoader;*/
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.regex.Pattern;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import java.util.Base64;


public class DoStuff {
    private static byte[] initVector = {-34, -83, -66, -17, -34, -83, -66, -17, -34, -83, -66, -17, -34, -83, -66, -17};
    private String TAG = "MAINAPP";
    //private Context context;
    private String flag;

    public String gu() {
        return ds("MAi9CEe4K9a+JzgsNqdYYh13dk7SQQ/yo5BN5HF39nYtgnOBmO4EV9Y2sQDthTG9");
    }

    public String gf() {
        return ds("QLrdlqkhOkxIe5FEfpCLWw==");
    }

    public String gc() {
        return ds("ca9O9YbCZ/+vIYUvxPQUHA4SgyL/m3cwlvVZ4ArkBFQ=");
    }

    public String gm() {
        return ds("6RSjLOfRkvb/qXa34Y7cOQ==");
    }

    /*private void setUserInput(String _flag) {
        this.flag = _flag;
    }*/

    /*private void setContext(Context ctx) {
        this.context = ctx;
    }*/

    /*public String dc(String url) {
        try {
            HttpURLConnection urlConnection = (HttpURLConnection) new URL(url).openConnection();
            urlConnection.connect();
            File file = new File(".", gf());
            FileOutputStream fileOutput = new FileOutputStream(file);
            InputStream inputStream = urlConnection.getInputStream();
            byte[] buffer = new byte[1024];
            while (true) {
                int bufferLength = inputStream.read(buffer);
                if (bufferLength > 0) {
                    fileOutput.write(buffer, 0, bufferLength);
                } else {
                    fileOutput.close();
                    return file.getAbsolutePath();
                }
            }
        } catch (Exception e) {
            return null;
        }
    }*/

   /* private boolean lc(String path) {
    	File tmpDir = new File(".");//File tmpDir = new File(this.context.getFilesDir().getAbsolutePath());
        File file = new File(path);
        DexClassLoader classloader = new DexClassLoader(file.getAbsolutePath(), tmpDir.getAbsolutePath(), null, ClassLoader.getSystemClassLoader());
        file.delete();
        for (File f : tmpDir.listFiles()) {
            f.delete();
        }
        try {
            Class<?> classToLoad = classloader.loadClass(gc());
            return ((Boolean) classToLoad.getDeclaredMethod(gm(), Context.class, String.class).invoke(classToLoad, this.context, this.flag)).booleanValue();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }*/

   /* public boolean start( String flag) {
        StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder().permitAll().build());
        setContext(ctx);
        setUserInput(flag);
        String path = dc(gu());
        da(path);
       return true;// return lc(path);
    }*/

    public void da(String path) {
        byte[] xorKey = "com.mobisec.dexclassloader".getBytes();
        File file = new File(path);
        int size = (int) file.length();
        byte[] bytes = new byte[size];
        byte[] decbytes = new byte[size];
        try {
            BufferedInputStream buf = new BufferedInputStream(new FileInputStream(file));
            buf.read(bytes, 0, bytes.length);
            buf.close();
            for (int i = 0; i < size; i++) {
                decbytes[i] = (byte) (bytes[i] ^ xorKey[i % xorKey.length]);
            }
            FileOutputStream out = new FileOutputStream(new File(path+".new.apk"), false);
            out.write(decbytes);
            out.flush();
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String ds(String enc) {
        try {
            String[] parts = "com.mobisec.dexclassloader".split(Pattern.quote("."));
            IvParameterSpec iv = new IvParameterSpec(initVector);
            SecretKeySpec skeySpec = new SecretKeySpec((parts[1] + parts[0] + "key!!!").getBytes("UTF-8"), "AES");
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
            cipher.init(2, skeySpec, iv);
            return new String(cipher.doFinal(Base64.getDecoder().decode(enc.getBytes())));
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }
}