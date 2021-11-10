package com.demo.practise;

import java.util.Scanner;

public class SwitchCaseInt {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("pls enter integer values");
		int i = sc.nextInt();
		
		switch(i) {
		default :{
			System.out.println("default code executed");
		}
		case 1:{
			System.out.println("value of int 1 is printed" + i);
			break;
		}
		case 2 :{
			System.out.println("value of int 2 is printed " + i);
			break;
		}
		case 3:{
			System.out.println("value of int 3 is printed" + i);
			break;
		}
			
	}

	}
}
