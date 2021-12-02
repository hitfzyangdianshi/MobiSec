package getpin_java;

public class Main {
	public static void main(String []args) {
		
		for(int i=999999;i>=0;i--) {
			System.out.println(i);
			boolean r=PinChecker.checkPin(String.format("%06d", i));
			if(r==true) {
				 System.out.println("***********: "+i);
				 break;
			}
		}
	}
}
