package com.demo.practise;

public class ConditionDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int i=10;
		String s="hello";
		boolean b=true;
		
		if(i>5) {
			System.out.println("I value is bigger than 5");
		}
		else {
			System.out.println("I value is smaller than 5");
		}
		//...............................
		
		if(s.equals("hello")) {
			System.out.println("its hello");
		}
		else if(s.equals("hai")) {
			System.out.println("its hai");
		}
		else if(s.equals("world")) {
			System.out.println("its world");
		}
		else {
			System.out.println("its out of world");
		}
		
		//.....................................
		
		if(b) {
			System.out.println("b value is true...");
		}
	}

}
