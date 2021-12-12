package _upos;

//import android.content.Context;
//import android.support.v4.internal.view.SupportMenu;
import java.util.Base64;
import java.util.Iterator;
import java.util.List;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.lang.reflect.Method;
import java.security.Certificate;
import java.security.MessageDigest;
import java.security.Signature;
import java.security.cert.CertificateFactory;

/* loaded from: classes2.dex */
public class FC {
    //public static Context ctx = null;
    public static long[][] m = (long[][]) Array.newInstance(long.class, 256, 256);
    	/* Code decompiled incorrectly, please refer to instructions dump */
    public static int checkFlag(String fl) {
        /*
        // Method dump skipped, instructions count: 1371
        */
        //throw new UnsupportedOperationException("Method not decompiled: com.mobisec.upos.FC.checkFlag(android.content.Context, java.lang.String):boolean");
    	
    	long lVar1;
        boolean bVar2;
        boolean bVar3;
        boolean bVar4;
        char cVar5;
        char cVar6;
        int iVar7;
        String ref;
        String pSVar8;
        String[] ppSVar9;
        //PackageManager pPVar10;
        List ref_00;
        Iterator ref_01;
        Object pOVar11;
        int iVar12;
        Class ref_02;
        Method ref_03;
      //  PackageInfo pPVar13;
        byte[] pbVar14;
        CertificateFactory ref_04;
        Certificate ref_05;
        MessageDigest ref_06;
        int iVar15;
        int iVar16;
        String pSVar17;
        String pSVar18;
        boolean[] pbVar19;
        Streamer ref_07;
        StringBuilder pSVar20;
        Class[] ppCVar21;
        Object[] ppOVar22;
        Signature ref_08;
        InputStream ref_09;
        String pSVar23;
        
        pSVar17 = " ";
        pSVar18 = "mayb";
        
        pbVar19 = new boolean[200];
        ref_07 = new Streamer();
        try {
			lm(m);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        iVar7 = fl.length();
        
        
        ref_07.step(); ref_07.step();  ref_07.step();  ref_07.step();  ref_07.step();  
        ref_07.step();  ref_07.step();  ref_07.step();  ref_07.step();  ref_07.step(); 
        ref_07.step(); ref_07.step(); 
        
        ref = fl.substring(8);

    //    if ((pbVar19[0] != false) && (pbVar19[1] != false)) {
          iVar7 = 0;
          iVar16 = 100;
          while (iVar7 < 30) {
	            pbVar19[iVar16] = true;
	            pSVar20 = new StringBuilder();
	            cVar5 = ref.charAt(iVar7 * 2);
	            pSVar17 = Character.toString(cVar5);
	            pSVar20.append(pSVar17);
	            cVar5 = ref.charAt(iVar7 * 2 + 1);
	            pSVar17 = Character.toString(cVar5);
	            pSVar20.append(pSVar17);
	            pSVar17 = pSVar20.toString();
	            bVar2 = FC.ip(iVar7);
	            if (bVar2 != false) {
		              iVar12 = 0;
		              while (iVar12 < iVar7) {
		                ref_07.step();
		                iVar12 = iVar12 + 1;
		              }
	            }
	            iVar12 = ref_07.g2();
	            iVar15 = ref_07.g2();
	            pSVar17 = FC.r(pSVar17);
	            lVar1 = FC.sq(pSVar17);
	            if (lVar1 != FC.m[iVar12 & 255][(iVar15 & 65280) >> 8]) {
	            	System.out.println(m[iVar12 & 255][(iVar15 & 65280) >> 8]);
	            	pbVar19[iVar16] = false;
	            }
	            iVar16 = iVar16 + 1;
	            iVar7 = iVar7 + 1;
          }
          iVar7 = iVar16 + -30;
          while( true ) {
            if (iVar16 <= iVar7) {
              pSVar17 = FC.h(fl);
              bVar2 =pSVar17.equals("4193d9b72a5c4805e9a5cc739f8a8fc23b2890e13b83bb887d96f86c30654a12");
              if (bVar2 != false) {
                return 1;
              }
              return 0;
            }
            if (pbVar19[iVar7] == false) break;
            iVar7 = iVar7 + 1;
          }
          return 0;
    	
    }
    
    
    public static long checkFlag1(String fl, int position) {
        /*
        // Method dump skipped, instructions count: 1371
        */
        //throw new UnsupportedOperationException("Method not decompiled: com.mobisec.upos.FC.checkFlag(android.content.Context, java.lang.String):boolean");
    	
    	long lVar1;
        boolean bVar2;
        boolean bVar3;
        boolean bVar4;
        char cVar5;
        char cVar6;
        int iVar7;
        String ref;
        String pSVar8;
        String[] ppSVar9;
        //PackageManager pPVar10;
        List ref_00;
        Iterator ref_01;
        Object pOVar11;
        int iVar12;
        Class ref_02;
        Method ref_03;
      //  PackageInfo pPVar13;
        byte[] pbVar14;
        CertificateFactory ref_04;
        Certificate ref_05;
        MessageDigest ref_06;
        int iVar15;
        int iVar16;
        String pSVar17;
        String pSVar18;
        boolean[] pbVar19;
        Streamer ref_07;
        StringBuilder pSVar20;
        Class[] ppCVar21;
        Object[] ppOVar22;
        Signature ref_08;
        InputStream ref_09;
        String pSVar23;
        
        pSVar17 = " ";
        pSVar18 = "mayb";
        
        pbVar19 = new boolean[200];
        ref_07 = new Streamer();
        try {
			lm(m);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        iVar7 = fl.length();
        
        
        ref_07.step(); ref_07.step();  ref_07.step();  ref_07.step();  ref_07.step();  
        ref_07.step();  ref_07.step();  ref_07.step();  ref_07.step();  ref_07.step(); 
        ref_07.step(); ref_07.step(); 
        
        ref = fl.substring(8);

    //    if ((pbVar19[0] != false) && (pbVar19[1] != false)) {
          iVar7 = 0;
          iVar16 = 100;
          while (iVar7 < 30) {
	            pbVar19[iVar16] = true;
	            pSVar20 = new StringBuilder();
	            cVar5 = ref.charAt(iVar7 * 2);
	            pSVar17 = Character.toString(cVar5);
	            pSVar20.append(pSVar17);
	            cVar5 = ref.charAt(iVar7 * 2 + 1);
	            pSVar17 = Character.toString(cVar5);
	            pSVar20.append(pSVar17);
	            pSVar17 = pSVar20.toString();
	            bVar2 = FC.ip(iVar7);
	            if (bVar2 != false) {
		              iVar12 = 0;
		              while (iVar12 < iVar7) {
		                ref_07.step();
		                iVar12 = iVar12 + 1;
		              }
	            }
	            iVar12 = ref_07.g2();
	            iVar15 = ref_07.g2();
	            pSVar17 = FC.r(pSVar17);
	            lVar1 = FC.sq(pSVar17);
	            if (lVar1 != FC.m[iVar12 & 255][(iVar15 & 65280) >> 8]) {
	            	//System.out.println(m[iVar12 & 255][(iVar15 & 65280) >> 8]);
	            	pbVar19[iVar16] = false;
	            	return 0;
	            }
	            else {
	            	if(position==iVar7)
	            		return m[iVar12 & 255][(iVar15 & 65280) >> 8];
	            }
	            iVar16 = iVar16 + 1;
	            iVar7 = iVar7 + 1;
          }
          iVar7 = iVar16 + -30;
          while( true ) {
            if (iVar16 <= iVar7) {
              pSVar17 = FC.h(fl);
              bVar2 =pSVar17.equals("4193d9b72a5c4805e9a5cc739f8a8fc23b2890e13b83bb887d96f86c30654a12");
              if (bVar2 != false) {
                return 1;
              }
              return 0;
            }
            if (pbVar19[iVar7] == false) break;
            iVar7 = iVar7 + 1;
          }
          return 0;
    	
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
            BufferedReader reader2 = new BufferedReader(new InputStreamReader(new FileInputStream("../resources/assets/lotto.dat")));
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
        return (long) Math.pow((double) ((a.charAt(0) + (a.charAt(1) << '\b')) & 65535), 2.0d);
    }

    public static String dec(String x) {
        return new String(Base64.getDecoder().decode(x));
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
