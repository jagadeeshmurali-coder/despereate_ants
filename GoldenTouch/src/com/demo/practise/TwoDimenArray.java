package com.demo.practise;

public class TwoDimenArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[][] = {
				{100,200,300,400},
				{10,20,30,40},
				{1000,2000,3000,4000},
				{23,45,65},
				{12,34}
		};
		for(int i = 0 ; i < arr.length ; i++) {
			for(int j=0;j< arr[i].length;j++) {
				System.out.print(arr[i][j] + "\t");
			}
			System.out.println();
		}
		
		System.out.println("\n----------------------------------------------");
		for(int row[]:arr) {
			for(int j : row) {
				System.out.print(j + "\t");
			}
			System.out.println();
		}
	}

}
