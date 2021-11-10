package com.demo.practise;

public class OperatorsDemo2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int i=10;
		
		//i=i+1; or i++; or ++i;
		
		System.out.println(i++);//post increment - after printing it increments
		System.out.println(i);
		
		i=10;
		
		System.out.println(++i);//pre increment - before printing it increments
		System.out.println(i);
		
		i=10;
		
		System.out.println(i--);//post decrement - after printing it decrements
		System.out.println(i);
		
		i=10;
		
		System.out.println(--i);//pre decrement - before printing it decrements
		System.out.println(i);
		
		//i=i+20 or i+=20;
		
		i=10;
		i+=20;//i=i+20;
		System.out.println(i);
		
		i=10;
		i-=20;//i=i-20;
		System.out.println(i);
		
		i=10;
		i*=20;//i=i*20;
		System.out.println(i);
		
		i=10;
		i/=2;//i=i/2;
		System.out.println(i);
		
		i=11;
		i%=2;//i=i%2;
		System.out.println(i);
	}

}
