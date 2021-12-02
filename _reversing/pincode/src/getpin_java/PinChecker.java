package getpin_java;

import java.security.MessageDigest;

/* loaded from: classes2.dex */
class PinChecker {
    PinChecker() {
    }

    public static boolean checkPin( String pin) {
        if (pin.length() != 6) {
            return false;
        }
        try {
            byte[] pinBytes = pin.getBytes();
            for (int i = 0; i < 25; i++) {
                for (int j = 0; j < 400; j++) {
                    MessageDigest md = MessageDigest.getInstance("MD5");
                    md.update(pinBytes);
                    pinBytes = (byte[]) md.digest().clone();
                }
            }
            if (toHexString(pinBytes).equals("d04988522ddfed3133cc24fb6924eae9")) {
                return true;
            }
            return false;
        } catch (Exception e) {
            System.out.println("MOBISEC "+"Exception while checking pin");
            return false;
        }
    }

    public static String toHexString(byte[] bytes) {
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
}