package day13;

import java.util.PriorityQueue;

public class P10 {

	public static void main(String[] args) {
		PriorityQueue<String> pq = new PriorityQueue<String>(); 
		pq.add("2"); 
		pq.add("4"); 
		System.out.print(pq.peek() + " "+pq); 
		pq.offer("1"); 
		pq.add("3"); 
		pq.remove("1"); 
		System.out.print(pq.poll() + " "+pq); 
		pq.add("2"); 
		if(pq.remove("2")) {
			System.out.print(pq.poll() + " "+pq); 
		}
	}
	
}
