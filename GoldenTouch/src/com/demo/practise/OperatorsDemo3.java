package com.demo.practise;

public class OperatorsDemo3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int i=10;
		int j=10;
		
		boolean result=(i==j);//comparison
		
		System.out.println(result);
		
		System.out.println(i<j);
		System.out.println(i>j);
		System.out.println(i!=j);
		System.out.println(i<=j);
		System.out.println(i>=j);
		
		if(result) {
			
		}
		
		if(i==j) {
			
		}
		
		if(true) {
			
		}
		
		result=i<=j && i==20; // and - both should satisfy
		
		System.out.println(result);
		
		result=i<j || i==10; //either or
		
		System.out.println(result);
	}

}
