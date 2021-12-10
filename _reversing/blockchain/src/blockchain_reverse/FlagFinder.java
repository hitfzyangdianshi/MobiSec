package blockchain_reverse;

import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileWriter;
import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.security.MessageDigest;
import javax.crypto.Cipher;
import javax.crypto.CipherOutputStream;
import javax.crypto.spec.SecretKeySpec;


public class FlagFinder {
	
	FlagFinder() {
    }
	
	
	
	public static boolean crackFlag(byte[] key) throws Exception {
       // byte[] digest = hash(keyStr.getBytes());
        byte[] currPt =hexToByteArray("0eef68c5ef95b67428c178f045e6fc8389b36a67bbbd800148f7c285f938a24e696ee2925e12ecf7c11f35a345a2a142639fe87ab2dd7530b29db87ca71ffda2af558131d7da615b6966fb0360d5823b79c26608772580bf14558e6b7500183ed7dfd41dbb5686ea92111667fd1eff9cec8dc29f0cfe01e092607da9f7c2602f5463a361ce5c83922cb6c3f5b872dcc088eb85df80503c92232bf03feed304d669ddd5ed1992a26674ecf2513ab25c20f95a5db49fdf6167fda3465a74e0418b2ea99eb2673d4c7e1ff7c4921c4e2d7b");
        
        byte[][] keys = new byte[11][];
        keys[0]=key;
        for(int i=1;i<=10;i++) {
        	keys[i]=hash(keys[i-1]);
        }
        
        for (int i = 10; i >= 1; i--) {
            currPt = decrypt(currPt, keys[i]);
        }
      //  System.out.println(currPt.toString());
        
        String currPtString = new String(currPt, StandardCharsets.UTF_8);
        String keyString = new String(key, StandardCharsets.UTF_8);
        
        File file =new File("javaio-appendfile.txt");
        FileWriter fileWritter = new FileWriter(file.getName(),true);
        BufferedWriter bufferWritter = new BufferedWriter(fileWritter);
        bufferWritter.write(keyString+"   "+currPtString+"\n");
        bufferWritter.close();
        
        /*if(currPtString.startsWith("MOBISEC")) {
        	System.out.println(currPtString);
        	return true;
        }
        
        return false;*/
        
        return true;
    }

	
	

	public static byte[] decrypt(byte[] in, byte[] key) throws Exception {
        Key aesKey = new SecretKeySpec(key, "AES");
        Cipher encryptCipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
        encryptCipher.init(Cipher.DECRYPT_MODE, aesKey);
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        CipherOutputStream cipherOutputStream = new CipherOutputStream(outputStream, encryptCipher);
        cipherOutputStream.write(in);
        cipherOutputStream.flush();
        cipherOutputStream.close();
        return outputStream.toByteArray();
    }//ref: https://segmentfault.com/a/1190000021123494 




	
	
	
	public static byte[] hash(byte[] in) throws Exception {
        MessageDigest md = MessageDigest.getInstance("MD5");
        md.update(in);
        return md.digest();
    }
	

	/** 
	 * Hex字符串转byte 
	 * @param inHex 待转换的Hex字符串 
	 * @return  转换后的byte 
	 */  
	public static byte hexToByte(String inHex){  
	   return (byte)Integer.parseInt(inHex,16);  
	}  
 
	/** 
	 * hex字符串转byte数组 
	 * @param inHex 待转换的Hex字符串 
	 * @return  转换后的byte数组结果 
	 */  
	public static byte[] hexToByteArray(String inHex){  
	    int hexlen = inHex.length();  
	    byte[] result;  
	    if (hexlen % 2 == 1){  
	        //奇数  
	        hexlen++;  
	        result = new byte[(hexlen/2)];  
	        inHex="0"+inHex;  
	    }else {  
	        //偶数  
	        result = new byte[(hexlen/2)];  
	    }  
	    int j=0;  
	    for (int i = 0; i < hexlen; i+=2){  
	        result[j]=hexToByte(inHex.substring(i,i+2));  
	        j++;  
	    }  
	    return result;   
	}//ref: https://blog.csdn.net/qq_34763699/article/details/78650272
}
