package blockchain_reverse;

public class Main {
	public static void main(String []args) {
		for(int i=0;i<=0xff;i++) {
			for(int j=0;j<=0xff;j++) {
				for(int k=0;k<=0xff;k++) {
					byte [] key=new byte[]{(byte)i,(byte)j,(byte)k};
					try {
						FlagFinder.crackFlag(key);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}
	}
}
