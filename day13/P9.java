package day13;

import java.util.*;
public class P9 { 
	public static void main(String[] args) { 
		Object o = new Object(); 
		//Set s = new HashSet();--compiles
		 //TreeSet s = new TreeSet(); --runtime classcastexceptoin
		 LinkedHashSet s = new LinkedHashSet(); //compiles
		s.add("o"); 
		s.add(o); 
		System.out.println(s);
		} 
 
	}
