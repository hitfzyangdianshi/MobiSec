package com.mobisec.upos;

import android.content.Context;
import android.support.v4.internal.view.SupportMenu;
import android.util.Base64;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.security.MessageDigest;

/* loaded from: classes2.dex */
public class FC {
    public static Context ctx = null;
    public static long[][] m = (long[][]) Array.newInstance(long.class, 256, 256);

    /* JADX INFO: Multiple debug info for r9v1 android.content.pm.Signature[]: [D('e' android.content.pm.PackageManager$NameNotFoundException), D('signatures' android.content.pm.Signature[])] */
    /* JADX WARN: Can't wrap try/catch for region: R(26:16|17|366|18|19|355|20|21|343|22|(15:27|29|30|341|31|(1:33)(1:34)|35|36|370|37|(1:(2:39|(2:373|41)(1:42))(1:372))|43|345|44|(7:46|47|368|48|49|50|(1:52)(9:53|54|(2:55|(1:375)(2:57|(2:374|59)))|60|364|61|62|63|(1:65)(2:66|(2:71|72)(2:70|(1:172)(32:173|(1:175)(1:176)|177|178|179|180|336|181|182|186|187|346|188|189|193|334|194|195|199|349|200|201|351|202|203|353|204|205|221|363|222|(2:224|(1:392)(8:228|(8:231|232|(3:234|(1:236)|379)|237|238|(5:240|359|241|242|378)(2:253|377)|254|229)|376|255|(2:257|(2:381|259)(1:260))|380|261|(1:263)(1:264)))(2:266|267))))))(2:103|104))|28|29|30|341|31|(0)(0)|35|36|370|37|(2:(0)(0)|42)|43|345|44|(0)(0)) */
    /* JADX WARN: Can't wrap try/catch for region: R(4:(15:27|29|30|341|31|(1:33)(1:34)|35|36|370|37|(1:(2:39|(2:373|41)(1:42))(1:372))|43|345|44|(7:46|47|368|48|49|50|(1:52)(9:53|54|(2:55|(1:375)(2:57|(2:374|59)))|60|364|61|62|63|(1:65)(2:66|(2:71|72)(2:70|(1:172)(32:173|(1:175)(1:176)|177|178|179|180|336|181|182|186|187|346|188|189|193|334|194|195|199|349|200|201|351|202|203|353|204|205|221|363|222|(2:224|(1:392)(8:228|(8:231|232|(3:234|(1:236)|379)|237|238|(5:240|359|241|242|378)(2:253|377)|254|229)|376|255|(2:257|(2:381|259)(1:260))|380|261|(1:263)(1:264)))(2:266|267))))))(2:103|104))|345|44|(0)(0)) */
    /* JADX WARN: Code restructure failed: missing block: B:108:0x0249, code lost:
        r9 = r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:116:0x025c, code lost:
        r3 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:118:0x0262, code lost:
        r3 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:120:0x0268, code lost:
        r3 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:384:?, code lost:
        return false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:388:?, code lost:
        return false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:389:?, code lost:
        return false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:395:?, code lost:
        return false;
     */
    /* JADX WARN: Removed duplicated region for block: B:103:0x023d A[Catch: IllegalFormatCodePointException -> 0x024d, IllformedLocaleException -> 0x0248, NullPointerException -> 0x0243, BatchUpdateException -> 0x04e5, CertificateEncodingException -> 0x04e0, RejectedExecutionException -> 0x04db, GeneralSecurityException -> 0x04d7, Exception -> 0x04d3, TRY_ENTER, TryCatch #69 {CertificateEncodingException -> 0x04e0, blocks: (B:44:0x013a, B:46:0x0142, B:50:0x015b, B:53:0x0170, B:54:0x0174, B:55:0x0183, B:57:0x0189, B:63:0x01b1, B:66:0x01c7, B:68:0x01d0, B:70:0x01d4, B:71:0x01e6, B:72:0x01eb, B:103:0x023d, B:104:0x0242, B:179:0x0340, B:181:0x0359, B:185:0x0361, B:186:0x0364, B:188:0x0373, B:192:0x037d, B:194:0x0381, B:198:0x038d, B:216:0x03c7, B:219:0x03d1), top: B:345:0x013a }] */
    /* JADX WARN: Removed duplicated region for block: B:172:0x031e A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:173:0x0320 A[Catch: BatchUpdateException -> 0x0533, CertificateEncodingException -> 0x052e, RejectedExecutionException -> 0x0529, GeneralSecurityException -> 0x053d, Exception -> 0x0538, TryCatch #28 {GeneralSecurityException -> 0x053d, blocks: (B:3:0x001b, B:4:0x001d, B:20:0x005e, B:31:0x0085, B:35:0x0096, B:156:0x02b9, B:158:0x02d0, B:160:0x02d4, B:162:0x02d9, B:164:0x02df, B:167:0x0310, B:168:0x0312, B:173:0x0320, B:177:0x033a, B:232:0x0403, B:236:0x0435, B:237:0x043b, B:257:0x0496, B:260:0x049c, B:261:0x049f, B:288:0x04ea, B:289:0x04ef, B:290:0x04f0, B:291:0x04f5), top: B:340:0x001b }] */
    /* JADX WARN: Removed duplicated region for block: B:224:0x03ee A[Catch: BatchUpdateException -> 0x04cd, CertificateEncodingException -> 0x04c7, RejectedExecutionException -> 0x04c1, GeneralSecurityException -> 0x04bc, Exception -> 0x04b7, TryCatch #33 {CertificateEncodingException -> 0x04c7, GeneralSecurityException -> 0x04bc, BatchUpdateException -> 0x04cd, RejectedExecutionException -> 0x04c1, Exception -> 0x04b7, blocks: (B:222:0x03de, B:224:0x03ee, B:226:0x03f3, B:266:0x04b1, B:267:0x04b6), top: B:363:0x03de }] */
    /* JADX WARN: Removed duplicated region for block: B:266:0x04b1 A[Catch: BatchUpdateException -> 0x04cd, CertificateEncodingException -> 0x04c7, RejectedExecutionException -> 0x04c1, GeneralSecurityException -> 0x04bc, Exception -> 0x04b7, TRY_ENTER, TryCatch #33 {CertificateEncodingException -> 0x04c7, GeneralSecurityException -> 0x04bc, BatchUpdateException -> 0x04cd, RejectedExecutionException -> 0x04c1, Exception -> 0x04b7, blocks: (B:222:0x03de, B:224:0x03ee, B:226:0x03f3, B:266:0x04b1, B:267:0x04b6), top: B:363:0x03de }] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0093  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0095  */
    /* JADX WARN: Removed duplicated region for block: B:372:0x0138 A[EDGE_INSN: B:372:0x0138->B:43:0x0138 ?: BREAK  , SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00dc A[Catch: IllegalFormatCodePointException -> 0x0275, IllformedLocaleException -> 0x0271, NullPointerException -> 0x026d, BatchUpdateException -> 0x0267, CertificateEncodingException -> 0x0261, RejectedExecutionException -> 0x025b, GeneralSecurityException -> 0x0256, Exception -> 0x0251, TRY_LEAVE, TryCatch #28 {NullPointerException -> 0x026d, CertificateEncodingException -> 0x0261, GeneralSecurityException -> 0x0256, BatchUpdateException -> 0x0267, IllegalFormatCodePointException -> 0x0275, IllformedLocaleException -> 0x0271, RejectedExecutionException -> 0x025b, Exception -> 0x0251, blocks: (B:37:0x009d, B:39:0x00dc), top: B:370:0x009d }] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0142 A[Catch: IllegalFormatCodePointException -> 0x024d, IllformedLocaleException -> 0x0248, NullPointerException -> 0x0243, BatchUpdateException -> 0x04e5, CertificateEncodingException -> 0x04e0, RejectedExecutionException -> 0x04db, GeneralSecurityException -> 0x04d7, Exception -> 0x04d3, TRY_LEAVE, TryCatch #69 {CertificateEncodingException -> 0x04e0, blocks: (B:44:0x013a, B:46:0x0142, B:50:0x015b, B:53:0x0170, B:54:0x0174, B:55:0x0183, B:57:0x0189, B:63:0x01b1, B:66:0x01c7, B:68:0x01d0, B:70:0x01d4, B:71:0x01e6, B:72:0x01eb, B:103:0x023d, B:104:0x0242, B:179:0x0340, B:181:0x0359, B:185:0x0361, B:186:0x0364, B:188:0x0373, B:192:0x037d, B:194:0x0381, B:198:0x038d, B:216:0x03c7, B:219:0x03d1), top: B:345:0x013a }] */
    /* Code decompiled incorrectly, please refer to instructions dump */
    public static boolean checkFlag(android.content.Context r28, java.lang.String r29) {
        /*
        // Method dump skipped, instructions count: 1371
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mobisec.upos.FC.checkFlag(android.content.Context, java.lang.String):boolean");
    }

    private static String h(String flag) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            md.update(flag.getBytes());
            return th(md.digest());
        } catch (Exception e) {
            return null;
        }
    }

    public static String th(byte[] bytes) {
        StringBuilder hexString = new StringBuilder();
        for (byte b : bytes) {
            String hex = Integer.toHexString(b & 255);
            if (hex.length() == 1) {
                hexString.append('0');
            }
            hexString.append(hex);
        }
        return hexString.toString();
    }

    private static void lm(long[][] matrix) throws Exception {
        BufferedReader reader = null;
        try {
            BufferedReader reader2 = new BufferedReader(new InputStreamReader(ctx.getAssets().open("lotto.dat")));
            int rowIdx = 0;
            while (true) {
                String row = reader2.readLine();
                if (row != null) {
                    int colIdx = 0;
                    for (String elem : row.split(" ")) {
                        matrix[rowIdx][colIdx] = Long.parseLong(elem);
                        colIdx++;
                    }
                    if (colIdx == 256) {
                        rowIdx++;
                    } else {
                        throw new Exception("error");
                    }
                } else if (rowIdx == 256) {
                    reader2.close();
                    return;
                } else {
                    throw new Exception("error");
                }
            }
        } catch (Throwable th) {
            if (0 != 0) {
                reader.close();
            }
            throw th;
        }
    }

    public static boolean ip(int x) {
        for (int i = 2; i < x; i++) {
            if (x % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static String r(String s) {
        String out = BuildConfig.FLAVOR;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c >= 'a' && c <= 's') {
                c = (char) (c + 7);
            } else if (c >= 'A' && c <= 'S') {
                c = (char) (c + 7);
            } else if (c >= 't' && c <= 'z') {
                c = (char) (c - 19);
            } else if (c >= 'T' && c <= 'Z') {
                c = (char) (c - 19);
            }
            out = out + c;
        }
        return out;
    }

    public static long sq(String a) {
        return (long) Math.pow((double) ((a.charAt(0) + (a.charAt(1) << '\b')) & SupportMenu.USER_MASK), 2.0d);
    }

    public static String dec(String x) {
        return new String(Base64.decode(x, 0));
    }

    public static String ec(String cmd) {
        String out = new String();
        try {
            InputStream stdout = Runtime.getRuntime().exec(cmd).getInputStream();
            byte[] buffer = new byte[102400];
            while (true) {
                int read = stdout.read(buffer);
                if (read > 0 && read <= 102400) {
                    out = out + new String(buffer, 0, read);
                } else if (stdout.available() <= 0) {
                    break;
                }
            }
            stdout.close();
        } catch (Exception e) {
        }
        return out;
    }
}
