package day4;

public class labInheritance {
	
	//pass by value and referrence
	
	public static void incrementNumber(int x) {
	    x += 1;
	}
	
//	public static void incrementNumber(int x) {
//	    x.value += 1;
//	}

	public class Number {
	    int value;
	    public Number(int n) {
			this.value=n;
		}
	}
	
	
	public static void main(String[] args) {
		
		int x = 0;
//		    incrementNumber(x);
//		    System.out.println(x);
		//labInheritance l = new labInheritance();
		    
		 //  int x = l.new Number(0);
		    incrementNumber(x);
		    System.out.println(x);
		    
		    
		    
	}

}
