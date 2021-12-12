package _upos;

import java.io.PrintStream;

public class Main {
	public static void main(String []args) {
		
		StringBuilder  flag  = new StringBuilder("MOBISEC{************************************************************}");
		//System.out.println(FC.checkFlag(flag));
		
		long[] values=new long[]{980441344,622452601,621355329,828461089,597411364,
			596531776,965531329,872493444,596434084,647804304,
			873320704,634183489,756745081,728352144,798514564,
			714706756,872907025,596727184,828921681,742235536,
			596727184,785232484,981380929,584430625,594774544,
			919908900,622053481,714172176,771117361,262148481};
		
		for(int i=0;i<30;i++) {
			boolean forfortag=false;
			for (char c1=32;c1<=126;c1++) {
				for (char c2=32;c2<=126;c2++)   {
					StringBuilder s=new StringBuilder();
					String temp=Character.toString(c1);
					s.append(temp);
					temp=Character.toString(c2);
					s.append(temp);
					
					flag.replace(2*i+8,2*i+10,s.toString());
					System.out.println(flag.toString());
					
		            if (FC.checkFlag1(flag.toString(),i) == values[i]) {//if (lVar1 != FC.m[iVar12 & 255][(iVar15 & 65280) >> 8]) {
		            	System.out.println(s);
		            	forfortag=true;
		            	break;
		            }
				}
				if(forfortag==true) {
					forfortag=false;
					break;
				}
			}
			
		}
		
	}
}
