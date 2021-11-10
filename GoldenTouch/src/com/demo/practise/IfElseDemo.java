package com.demo.practise;

import java.util.Scanner;

public class IfElseDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("enter number");
	    int checkingNumber = sc.nextInt();
	    
	    if(checkingNumber == 10) {
	    	System.out.println("your right");
	    } else if (checkingNumber == 12) {
	    	System.out.println("your near to guess");
	    } else if (checkingNumber == 14) {
	    	System.out.println("far away from the number");
	    } else {
	    	System.out.println("your guess is wrong");
	    }
	    
	    System.out.println("enter another number");
	    int j = sc.nextInt();
	    if(checkingNumber == 10 && j < 12) {
	    	System.out.println("your range is between 10 and 12");
	    } else if (checkingNumber == 14 && j < 16) {
	    	System.out.println("your range is between 14 and 16");
	    } else {
	    	System.out.println("your not in range");
	    }
	    
	}

}
