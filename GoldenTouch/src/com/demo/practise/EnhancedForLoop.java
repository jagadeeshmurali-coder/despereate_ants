package com.demo.practise;
import java.lang.String;

public class EnhancedForLoop {

	public static void main(String[] args) {
		// TODO Auto-generated method
		int arr[] = {22,34,55,66,77};
		//int []arr2 = new int[5];
		 
		for(int i = 0 ; i < arr.length ; i++) {
			System.out.print(arr[i] + "\t");
		}
		
		System.out.println("\n ---------------------enhanced for loop----------------");
		
		for(int i : arr) {
			System.out.print(i + "\t");
		}
		
		System.out.println("\n ---------------------String using for loop----------------");
		
		String str[] = new String[5];
		for(int i = 0 ;i < str.length ;i++) {
			str[i]= "hi" + i;
			System.out.println("string values" + str[i]);
		}
		System.out.println("\n ---------------------String using Enhanced for loop----------------");
		for(String s : str) {
			System.out.println("enhanced string value" + s);
		}
		
		
	}

}

