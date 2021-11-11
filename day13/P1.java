package day13;

import java.util.ArrayList;
import java.util.List;

public class P1 {

	public static void main(String[] args) { 
//		List<ArrayList<Integer>> table = new ArrayList<ArrayList<Integer>>();
		 List<ArrayList<Integer>> table = new ArrayList<ArrayList<Integer>>();
		for (int i = 0; i <= 10; i++) {
			List<Integer> row = new ArrayList<Integer>(); 
			for (int j = 0; j <= 10; j++) {
				row.add(i * j); 
				table.add((ArrayList<Integer>) row); 
				} 
			for (List<Integer> row1 : table) {
				System.out.println(row1); } 
	}
	
}
}
