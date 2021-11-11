package day13;

import java.util.List;

public class P8 {
	public static <E extends Number> List<E> process(List<E> nums) {
		return nums;
		
	}
public static void main(String[] args) {
	List<Number> input = null;
	List<Number> output = null; 
	 output = process(input);
	System.out.println(output);
}
}
