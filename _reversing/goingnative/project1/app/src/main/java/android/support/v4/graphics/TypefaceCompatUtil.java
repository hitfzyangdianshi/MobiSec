package android.support.v4.graphics;

import android.content.Context;
import android.content.res.Resources;
import android.os.Process;
import android.os.StrictMode;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.annotation.RestrictTo;
import android.util.Log;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes.dex */
public class TypefaceCompatUtil {
    private static final String CACHE_FILE_PREFIX = ".font";
    private static final String TAG = "TypefaceCompatUtil";

    private TypefaceCompatUtil() {
    }

    @Nullable
    public static File getTempFile(Context context) {
        String str = CACHE_FILE_PREFIX + Process.myPid() + "-" + Process.myTid() + "-";
        for (int i = 0; i < 100; i++) {
            File file = new File(context.getCacheDir(), str + i);
            if (file.createNewFile()) {
                return file;
            }
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0027  */
    @android.support.annotation.RequiresApi(19)
    @android.support.annotation.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump */
    private static java.nio.ByteBuffer mmap(java.io.File r9) {
        /*
            r0 = 0
            java.io.FileInputStream r1 = new java.io.FileInputStream     // Catch: IOException -> 0x0036
            r1.<init>(r9)     // Catch: IOException -> 0x0036
            java.nio.channels.FileChannel r2 = r1.getChannel()     // Catch: Throwable -> 0x001f, all -> 0x001c
            long r6 = r2.size()     // Catch: Throwable -> 0x001f, all -> 0x001c
            java.nio.channels.FileChannel$MapMode r3 = java.nio.channels.FileChannel.MapMode.READ_ONLY     // Catch: Throwable -> 0x001f, all -> 0x001c
            r4 = 0
            java.nio.MappedByteBuffer r9 = r2.map(r3, r4, r6)     // Catch: Throwable -> 0x001f, all -> 0x001c
            if (r1 == 0) goto L_0x001b
            r1.close()     // Catch: IOException -> 0x0036
        L_0x001b:
            return r9
        L_0x001c:
            r9 = move-exception
            r2 = r0
            goto L_0x0025
        L_0x001f:
            r9 = move-exception
            throw r9     // Catch: all -> 0x0021
        L_0x0021:
            r2 = move-exception
            r8 = r2
            r2 = r9
            r9 = r8
        L_0x0025:
            if (r1 == 0) goto L_0x0035
            if (r2 == 0) goto L_0x0032
            r1.close()     // Catch: Throwable -> 0x002d, IOException -> 0x0036
            goto L_0x0035
        L_0x002d:
            r1 = move-exception
            r2.addSuppressed(r1)     // Catch: IOException -> 0x0036
            goto L_0x0035
        L_0x0032:
            r1.close()     // Catch: IOException -> 0x0036
        L_0x0035:
            throw r9     // Catch: IOException -> 0x0036
        L_0x0036:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.graphics.TypefaceCompatUtil.mmap(java.io.File):java.nio.ByteBuffer");
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0042  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x005c  */
    @android.support.annotation.RequiresApi(19)
    @android.support.annotation.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump */
    public static java.nio.ByteBuffer mmap(android.content.Context r8, android.os.CancellationSignal r9, android.net.Uri r10) {
        /*
            android.content.ContentResolver r8 = r8.getContentResolver()
            r0 = 0
            java.lang.String r1 = "r"
            android.os.ParcelFileDescriptor r8 = r8.openFileDescriptor(r10, r1, r9)     // Catch: IOException -> 0x006b
            if (r8 != 0) goto L_0x0013
            if (r8 == 0) goto L_0x0012
            r8.close()     // Catch: IOException -> 0x006b
        L_0x0012:
            return r0
        L_0x0013:
            java.io.FileInputStream r9 = new java.io.FileInputStream     // Catch: Throwable -> 0x0054, all -> 0x0051
            java.io.FileDescriptor r10 = r8.getFileDescriptor()     // Catch: Throwable -> 0x0054, all -> 0x0051
            r9.<init>(r10)     // Catch: Throwable -> 0x0054, all -> 0x0051
            java.nio.channels.FileChannel r1 = r9.getChannel()     // Catch: Throwable -> 0x003a, all -> 0x0037
            long r5 = r1.size()     // Catch: Throwable -> 0x003a, all -> 0x0037
            java.nio.channels.FileChannel$MapMode r2 = java.nio.channels.FileChannel.MapMode.READ_ONLY     // Catch: Throwable -> 0x003a, all -> 0x0037
            r3 = 0
            java.nio.MappedByteBuffer r10 = r1.map(r2, r3, r5)     // Catch: Throwable -> 0x003a, all -> 0x0037
            if (r9 == 0) goto L_0x0031
            r9.close()     // Catch: Throwable -> 0x0054, all -> 0x0051
        L_0x0031:
            if (r8 == 0) goto L_0x0036
            r8.close()     // Catch: IOException -> 0x006b
        L_0x0036:
            return r10
        L_0x0037:
            r10 = move-exception
            r1 = r0
            goto L_0x0040
        L_0x003a:
            r10 = move-exception
            throw r10     // Catch: all -> 0x003c
        L_0x003c:
            r1 = move-exception
            r7 = r1
            r1 = r10
            r10 = r7
        L_0x0040:
            if (r9 == 0) goto L_0x0050
            if (r1 == 0) goto L_0x004d
            r9.close()     // Catch: Throwable -> 0x0048, all -> 0x0051
            goto L_0x0050
        L_0x0048:
            r9 = move-exception
            r1.addSuppressed(r9)     // Catch: Throwable -> 0x0054, all -> 0x0051
            goto L_0x0050
        L_0x004d:
            r9.close()     // Catch: Throwable -> 0x0054, all -> 0x0051
        L_0x0050:
            throw r10     // Catch: Throwable -> 0x0054, all -> 0x0051
        L_0x0051:
            r9 = move-exception
            r10 = r0
            goto L_0x005a
        L_0x0054:
            r9 = move-exception
            throw r9     // Catch: all -> 0x0056
        L_0x0056:
            r10 = move-exception
            r7 = r10
            r10 = r9
            r9 = r7
        L_0x005a:
            if (r8 == 0) goto L_0x006a
            if (r10 == 0) goto L_0x0067
            r8.close()     // Catch: Throwable -> 0x0062, IOException -> 0x006b
            goto L_0x006a
        L_0x0062:
            r8 = move-exception
            r10.addSuppressed(r8)     // Catch: IOException -> 0x006b
            goto L_0x006a
        L_0x0067:
            r8.close()     // Catch: IOException -> 0x006b
        L_0x006a:
            throw r9     // Catch: IOException -> 0x006b
        L_0x006b:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.graphics.TypefaceCompatUtil.mmap(android.content.Context, android.os.CancellationSignal, android.net.Uri):java.nio.ByteBuffer");
    }

    @RequiresApi(19)
    @Nullable
    public static ByteBuffer copyToDirectBuffer(Context context, Resources resources, int i) {
        File tempFile = getTempFile(context);
        if (tempFile == null) {
            return null;
        }
        try {
            if (!copyToFile(tempFile, resources, i)) {
                return null;
            }
            return mmap(tempFile);
        } finally {
            tempFile.delete();
        }
    }

    public static boolean copyToFile(File file, InputStream inputStream) {
        Throwable th;
        IOException e;
        FileOutputStream fileOutputStream;
        StrictMode.ThreadPolicy allowThreadDiskWrites = StrictMode.allowThreadDiskWrites();
        FileOutputStream fileOutputStream2 = null;
        try {
            try {
                fileOutputStream = new FileOutputStream(file, false);
            } catch (IOException e2) {
                e = e2;
            }
        } catch (Throwable th2) {
            th = th2;
        }
        try {
            byte[] bArr = new byte[1024];
            while (true) {
                int read = inputStream.read(bArr);
                if (read != -1) {
                    fileOutputStream.write(bArr, 0, read);
                } else {
                    closeQuietly(fileOutputStream);
                    StrictMode.setThreadPolicy(allowThreadDiskWrites);
                    return true;
                }
            }
        } catch (IOException e3) {
            e = e3;
            fileOutputStream2 = fileOutputStream;
            Log.e(TAG, "Error copying resource contents to temp file: " + e.getMessage());
            closeQuietly(fileOutputStream2);
            StrictMode.setThreadPolicy(allowThreadDiskWrites);
            return false;
        } catch (Throwable th3) {
            th = th3;
            fileOutputStream2 = fileOutputStream;
            closeQuietly(fileOutputStream2);
            StrictMode.setThreadPolicy(allowThreadDiskWrites);
            throw th;
        }
    }

    public static boolean copyToFile(File file, Resources resources, int i) {
        InputStream inputStream;
        Throwable th;
        try {
            inputStream = resources.openRawResource(i);
            try {
                boolean copyToFile = copyToFile(file, inputStream);
                closeQuietly(inputStream);
                return copyToFile;
            } catch (Throwable th2) {
                th = th2;
                closeQuietly(inputStream);
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            inputStream = null;
        }
    }

    public static void closeQuietly(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException unused) {
            }
        }
    }
}
