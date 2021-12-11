package loadme_rev;

public class Main {
	public static void main(String []args) {
		
		/* step1*/
		
		System.out.println(		new DoStuff().gu());
		System.out.println(		new DoStuff().gf());
		System.out.println(		new DoStuff().gc());
		System.out.println(		new DoStuff().gm());
		
		DoStuff  do1 = new DoStuff();
		do1.da("../../misc/_reversing/loadme/stage1.apk");
		
		
		LoadImage li=new LoadImage();
		
		/*
		 * step 2
		 * */
		System.out.println(li.getAssetsName());
		System.out.println(li.getCodeName());
		System.out.println(li.generateMethod());
		System.out.println(li.generateClass());
		
		
		
		li.load("NO FLAG HERE!");
		
	}
}
