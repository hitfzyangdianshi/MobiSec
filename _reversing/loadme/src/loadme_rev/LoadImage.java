package loadme_rev;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Base64;
import java.util.regex.Pattern;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/*import android.content.Context;
import android.util.Base64;
import dalvik.system.DexClassLoader;*/


public class LoadImage {
	//private static Context context;
    private static String TAG = "STAGE1";
    private static byte[] initVector = {-34, -83, -66, -17, -34, -83, -66, -17, -34, -83, -66, -17, -34, -83, -66, -17};

    public static String getAssetsName() {
        return decryptString("VYsdn556h+cox7bnQV4UsA==");
    }

    public static String getCodeName() {
        return decryptString("SXkAHK1O8Ssd6aCiqtpiAg==");
    }

    /*private static void setContext(Context ctx) {
        context = ctx;
    }*/

    public static boolean load( String flag) {
        byte[] xorKey = "weneedtogodeeper".getBytes();
        //setContext(ctx);
        try {
            InputStream in =new FileInputStream("../../misc/_reversing/loadme/assets/logo.png");//ctx.getAssets().open(getAssetsName());
            File outFile = new File("../../misc/_reversing/loadme/assets/logo.dex");
            OutputStream out = new FileOutputStream(outFile);
            byte[] buffer = new byte[1024];
            while (true) {
                int read = in.read(buffer);
                if (read != -1) {
                    out.write(buffer, 0, read);
                } else {
                    in.close();
                    out.close();
                    decryptApk(outFile.getAbsolutePath(), xorKey);
                   
                    // return loadClass(ctx, outFile.getAbsolutePath(), flag);
                    return true;
                }
            }
        } catch (Exception e) {
            return false;
        }
    }

    /*private static boolean loadClass(Context context2, String path, String flag) {
        File tmpDir = new File(context2.getFilesDir().getAbsolutePath());
        File file = new File(path);
        DexClassLoader classloader = new DexClassLoader(file.getAbsolutePath(), tmpDir.getAbsolutePath(), null, ClassLoader.getSystemClassLoader());
        file.delete();
        for (File f : tmpDir.listFiles()) {
            f.delete();
        }
        try {
            Class<?> classToLoad = classloader.loadClass(generateClass());
            return ((Boolean) classToLoad.getDeclaredMethod(generateMethod(), String.class).invoke(classToLoad, flag)).booleanValue();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }*/

    public static String generateMethod() {
        return decryptString("zkKQzoRGUwBJurGdAYVuMw==");
    }

    private static String decryptString(String enc) {
        try {
            String[] parts = "com.mobisec.stage1".split(Pattern.quote("."));
            IvParameterSpec iv = new IvParameterSpec(initVector);
            SecretKeySpec skeySpec = new SecretKeySpec(("!!!" + parts[0] + parts[1] + "key").getBytes("UTF-8"), "AES");
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
            cipher.init(2, skeySpec, iv);
            return new String(cipher.doFinal(Base64.getDecoder().decode(enc.getBytes())));
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public static String generateClass() {
        return decryptString("4hJIFOEdvGy81kngg5W2mh4ZMYOQVmqX+FqCg8UmFmc=");
    }

    private static void decryptApk(String path, byte[] xorKey) {
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
            FileOutputStream out = new FileOutputStream(new File(path), false);
            out.write(decbytes);
            out.flush();
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
