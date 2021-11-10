package com.demo.practise;

public class SwitchCondition {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	    int i=15;
		
		switch(i) {
		default:{
			System.out.println("The value is unknown...");
			break;
		}
		case 5:{
			System.out.println("The value is 5");
			break;
		}
		case 10:{
			System.out.println("The value is 10");
			//break;
		}
		
		}
		
		char c='d';
		
		switch(c) {
		case 'd':{
			System.out.println("The value is d");
			break;
		}
		case 'e':{
			System.out.println("The value is e");
			break;
		}
		default:{
			System.out.println("The value is unknown...");
		}
		}
		
		String str="hello";
		
		switch(str) {
		case "hello":{
			System.out.println("The value is hello");
			break;
		}
		case "hai":{
			System.out.println("The value is hai");
			break;
		}
		default:{
			System.out.println("The value is unknown...");
		}
		}
	}

}
