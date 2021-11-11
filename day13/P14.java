package day13;

import java.util.*;


class Doggie { 
	int size; 
	Doggie(int s) {
		this.size = s; 
		} } 


public class P14 { 
	public static void main(String[] args) { 
		TreeSet<Integer> i = new TreeSet<Integer>(); 
		TreeSet<Doggie> d = new TreeSet<Doggie>(); 
		d.add(new Doggie(1));
		d.add(new Doggie(2)); 
		d.add(new Doggie(1));
		i.add(1);
		i.add(2);
		i.add(1); 
		System.out.println(d.size() + " " + i.size()); 
		} 
	 } 