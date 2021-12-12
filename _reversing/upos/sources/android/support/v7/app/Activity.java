package android.support.v7.app;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import com.mobisec.upos.FC;
import com.mobisec.upos.MainActivity;
import com.mobisec.upos.R;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateEncodingException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.Iterator;

/* loaded from: classes2.dex */
public class Activity {
    public static void initActivity(MainActivity ctx) {
        boolean found;
        boolean found2 = false;
        String[] lines = FC.ec(FC.dec(ctx.getString(R.string.s1)) + " " + FC.dec(ctx.getString(R.string.s2))).split("\n");
        int length = lines.length;
        int i = 0;
        while (true) {
            if (i >= length) {
                break;
            }
            if (FC.ec(FC.dec(ctx.getString(R.string.s3)) + " " + FC.dec(ctx.getString(R.string.s2)) + "/" + lines[i] + "/maps").contains(FC.dec(ctx.getString(R.string.s4)))) {
                found2 = true;
                break;
            }
            i++;
        }
        MainActivity.g2 = found2;
        Iterator<ApplicationInfo> it = ctx.getPackageManager().getInstalledApplications(128).iterator();
        while (true) {
            if (it.hasNext()) {
                if (it.next().packageName.equals(FC.dec(ctx.getString(R.string.s5)))) {
                    found = true;
                    break;
                }
            } else {
                found = false;
                break;
            }
        }
        MainActivity.g3 = !found;
        try {
            MainActivity.g1 = ((Boolean) Class.forName(FC.dec(ctx.getString(R.string.s7))).getMethod(FC.dec(ctx.getString(R.string.s8)), new Class[0]).invoke(null, new Object[0])).booleanValue();
        } catch (Exception e) {
            MainActivity.g1 = false;
        }
        PackageInfo packageInfo = null;
        try {
            packageInfo = ctx.getPackageManager().getPackageInfo(ctx.getPackageName(), 64);
        } catch (PackageManager.NameNotFoundException e2) {
            e2.printStackTrace();
        }
        InputStream input = new ByteArrayInputStream(packageInfo.signatures[0].toByteArray());
        CertificateFactory cf = null;
        try {
            cf = CertificateFactory.getInstance("X509");
        } catch (CertificateException e3) {
            e3.printStackTrace();
        }
        X509Certificate c = null;
        try {
            c = (X509Certificate) cf.generateCertificate(input);
        } catch (CertificateException e4) {
            e4.printStackTrace();
        }
        String hexString = null;
        try {
            hexString = FC.th(MessageDigest.getInstance("SHA1").digest(c.getEncoded()));
        } catch (NoSuchAlgorithmException e1) {
            e1.printStackTrace();
        } catch (CertificateEncodingException e5) {
            e5.printStackTrace();
        }
        MainActivity.g4 = !hexString.equals(ctx.getString(R.string.s6));
    }
}
