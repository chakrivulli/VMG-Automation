package com.vmg.pagefactory;

import java.util.Calendar;

public class Test {

	public static void main(String[] args) {
		//System.out.println(isPrime(4));
		//System.out.println(System.currentTimeMillis());
		 Calendar now = Calendar.getInstance();
		    // 
		    System.out.println("Current Year is : " + now.get(Calendar.YEAR));
		    // month start from 0 to 11
		    System.out.println("Current Month is : " + (now.get(Calendar.MONTH) + 1));
		    System.out.println("Current Date is : " + now.get(Calendar.DATE));
	}
	
	/*public static boolean isPrime(int x) {
		if(x<2) {
			return false;
		}
			for(int i=2;i<x;i++) {
				if(x%i==0) {
					return false;
				}
		}
			return true;
	}*/
}
