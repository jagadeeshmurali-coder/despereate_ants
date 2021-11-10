package day4;

import java.util.Arrays;

public class LabDay4 {
	static boolean val1;
	   static double val2;
	   static float val3;
	   static int val4;
	   static long val5;
	   static String val6;
	  
	   //prime or not meth
	   public boolean prime(int n) {
		   
		   boolean flag = false;
		    for (int i = 2; i <= n / 2; i++) {
		      if (n % i == 0) {
		        flag = true;
		        break;
		      }
	   }
		    return flag;
	   }
	   
	   //calc avg
	   public float avg(int a[]) {
		   int sum = 0;
		   for (int i = 0; i < a.length; ++i) {
			     sum +=a[i];
		   }
		   float av = sum/a.length;
		   System.out.println(av);
		   return av;
	   }
	   
	   //asc or desc order
	   
	   public int[] asc(int a[]){
		    Arrays.sort(a);
		    for (int i = 0; i < a.length; ++i) {
		    	 System.out.print(a[i]+",");
		   }
		   
		    return a;	   
	   }
	   
	   //desc
	   
	   public int[] desc(int a[]){
		    Arrays.sort(a);
		    int b[] = new int[a.length];
		    int count=0;
		    for (int i = a.length-1; i >=0; --i) {
			     b[count]=a[i];
			     count++;
		    }
		    for (int i = 0; i < a.length; ++i) {
		    	 System.out.print(b[i]+",");
		   }
		    return b;	   
	   }

	   
	   //locate
	   
	   public int locate(int a[],int ele) {
		   int pos=0,count=0;
		   for (int i = 0; i < a.length; ++i) {
		    	 if(ele==a[i]) {
		    		 count++;
		    		 pos =i;
		    	 }
		   }
		   System.out.println("position"+pos+" "+count);
		   return pos;
	   }
	   
	   
	   //reverse
	   public int[] rev(int a[]){
		    int b[] = new int[a.length];
		    int count=0;
		    for (int i = a.length-1; i >=0; --i) {
			     b[count]=a[i];
			     count++;
		    }
		    for (int i = 0; i < a.length; ++i) {
		    	 System.out.print(b[i]+",");
		   }
		    return b;	   
	   }
	   
	   
	 //rect matrx
	   
	   public int[][] rectmatrix(int[][] a) {
		   
		   for (int i = 0; i < a.length; ++i) {
			   for (int j = 0; j<=i; ++j) {
			    	 System.out.print(a[i][j]+"\t");
			   }
			   System.out.println();
		   }
		   return a;
	   }
	   
	 //stud and marks..

	 public int[][] stdmarks(int a[][]){
		 int st=1;
		 for(int q[]:a) {
			 int sum=0;
				for(int j:q) {
					sum=sum+j;
				}
				System.out.println("Results of student"+" "+st+" "+"is"+" "+sum);
				st++;
			}
		 return a;
	 }
	 
	 //To generate a Prime number list between 1 to 100 
	 
	 public int primeList() {
		 for(int i=3;i<100;i++) {
			 boolean fl = true;
			 for(int j=2;j<i/2;j++) {
				 if(i%j==0) {
					fl=false;
					break;
				 }	
			 }
			 if(fl)
			 {System.out.print(i+" ");}
		 }
		 return 1;
	 }
	 
	 //armstrong
	 
	 public boolean armstrong(int n) {
		 int originalNumber,remainder, result = 0;
		 originalNumber=n;
		  while (originalNumber != 0)
	        {
	            remainder = originalNumber % 10;
	            result += Math.pow(remainder, 3);
	            originalNumber /= 10;
	        }

	        if(result == n)
	           return true;
	        else
	           return false;
	 }
	 
	//perfect number
	 
	 public boolean perfect(int n) {
		 
		 int sum=0;
		 for(int i = 1; i < n; i++)
	        {
	            if(n % i == 0)
	            {
	                sum = sum + i;
	            }
	        }
	        if(sum == n)
	        {
	        	return true;
	        }
	        else
	        {
	        	return false;
	        }    
	 }
	 
	 //palindrome
	 
	 public boolean palindrome(int n) {
		 int r,sum=0,temp;
		  temp=n;    
		  while(n>0){    
		   r=n%10;  //getting remainder  
		   sum=(sum*10)+r;    
		   n=n/10;    
		  }    
		  if(temp==sum)    
		   return true;    
		  else    
		  return false;    
	 }
	 
	
	 
	 //number to words conversion
	 
	 public void conv(int number) {
		 
		 
		 int digit4 = number%10;
			number = number/10;
			int digit3 = number%10;
			number = number/10;
			int digit2 = number%10;
			number = number/10;
			int digit1 = number%10;
			number = number/10;
			
			switch (digit1)
			{
			case 1: System.out.print("One thousand ");break;
			case 2: System.out.print("Two thousand "); break;
			case 3: System.out.print("Three thousand "); break;
			case 4: System.out.print("Four thousand "); break;
			case 5: System.out.print("Five thousand "); break;
			case 6: System.out.print("Six thousand "); break;
			case 7: System.out.print("Seven thousand "); break;
			case 8: System.out.print("Eight thousand "); break;
			case 9: System.out.print("Nine thousand "); break;
			case 0: System.out.print("Zero "); break;
			default: System.out.print(""); break;
			}
			switch (digit2)
			{
			case 1: System.out.print("One hundred and ");break;
			case 2: System.out.print("Two hundred and"); break;
			case 3: System.out.print("Three hundred and "); break;
			case 4: System.out.print("Four hundred and"); break;
			case 5: System.out.print("Five hundred and "); break;
			case 6: System.out.print("Six hundred and"); break;
			case 7: System.out.print("Seven hundred and "); break;
			case 8: System.out.print("Eight hundred and "); break;
			case 9: System.out.print("Nine hundred and "); break;
			case 0: System.out.print("Zero "); break;
			default: System.out.print(""); break;
			}
			switch (digit3)
			{
			case 1: System.out.print("ten ");break;
			case 2: System.out.print("Twenty "); break;
			case 3: System.out.print("Thirty "); break;
			case 4: System.out.print("Forty "); break;
			case 5: System.out.print("Fifty "); break;
			case 6: System.out.print("Sixty "); break;
			case 7: System.out.print("Seventy "); break;
			case 8: System.out.print("Eighty "); break;
			case 9: System.out.print("Ninety "); break;
			case 0: System.out.print("Zero "); break;
			default: System.out.print(""); break;
			}
			switch (digit4)
			{
			case 1: System.out.print("One ");break;
			case 2: System.out.print("Two "); break;
			case 3: System.out.print("Three "); break;
			case 4: System.out.print("Four "); break;
			case 5: System.out.print("Five "); break;
			case 6: System.out.print("Six "); break;
			case 7: System.out.print("Seven "); break;
			case 8: System.out.print("Eight "); break;
			case 9: System.out.print("Nine "); break;
			case 0: System.out.print("Zero "); break;
			default: System.out.print(""); break;
			}
	 }
	 
	 
	 //reversal in twoD array
	 
	 public void revTwoD(int [][]a){
		 int m=0,n=0;
		 int res[][]= {
					{0,0,0,0},
					{0,0,0,0},
					{0,0,0,0},
					{0,0,0,0}
			};
		 for(int i=0;i<a.length;i++) {
			 for(int j=a[i].length-1;j>0;j--) {
				 res[m][n]=a[i][j];
				 n++;
			 }
			 m++;
		 }
		 for(int i=0;i<m;i++) {
			 for(int j=0;j<n;j++) {
				 System.out.print(res[i][j]+" ");
			 }
			 System.out.println();
		 }
	 }
	 
	   //largest element of each row
	 
	 public void largestTwoDarray(int[][] a) {
		  
		 for(int i=0;i<a.length;i++) {
			 int maxi = 0;
			 for(int j=0;j<a[0].length;j++) {
				 if(a[i][j]>maxi) {
					 maxi=a[i][j];
				 }
			 }
			System.out.println(maxi);
		 }
	 }
	   
	 //no of days in month
	 
	 public void noOfFdays(int month) {
		 
		 switch(month)
			{
			  	case 1:
			  	case 3:
				case 5: 	
				case 7:
				case 8:
				case 10:
				case 12:			  	
					System.out.println("\n 31 Days in this Month");
				  	break;
				
				case 4:	
				case 6:
				case 9:
				case 11:			    	
					System.out.println("\n 30 Days in this Month");  
					break;
				
				case 2:
					System.out.println("29 days leap year/28 days non leap year"); 
					break;
				
				default:		  	
					System.out.println("Please enter Valid Number between 1 to 12");
			  }
	 }
	 
	 //investment calci
	 
	 public void invest(int invAmnt) {
		 double firstYear,secondYear,thirdYear;
		 firstYear = invAmnt+((0.40*invAmnt));
		 secondYear = firstYear-1500;
		 thirdYear = secondYear+((0.12*secondYear));
		 System.out.println(thirdYear);
	 }
	 
	public static void main(String[] args) {
		
		LabDay4 obj = new LabDay4();
		
		//print hello world
		System.out.println("Hello World");
		
		// printing default values
		 System.out.println("Default values.....");
	      System.out.println("Val1 = " + val1);
	      System.out.println("Val2 = " + val2);
	      System.out.println("Val3 = " + val3);
	      System.out.println("Val4 = " + val4);
	      System.out.println("Val5 = " + val5);
	      System.out.println("Val6 = " + val6);
		
	      //explicit typecast
	      
	      double d = 23.25; 
	      long l = (long)d;// double to long
	      int i = (int)l; //long to int
	      System.out.println("double,long,int--"+d+","+l+","+i);
	      int k = 257;
	      byte b = (byte)k;//int to byte
	      System.out.println("int val--"+k);
	      System.out.println("byte val---"+b);
	      
	      //implicit
	      
	      byte s = 50;
	      int m = s;
	      float g = m;
	      double n = g;
	      System.out.println(+s+","+m+","+g+","+n);
	      
	      //check prime
	      
	        int x=56;
	       // obj.prime(x);
	       if( obj.prime(x))
	          System.out.println(x + " is not a prime number.");
	        else
	          System.out.println(x + " is a prime number.");
	       
	       //calc avg
	       int[] arr = new int[]{ 1,2,3,4,5,6,11,7,8,9,10 }; 
	       obj.avg(arr);
	       
	       //asc or desc
	       obj.asc(arr);
	       System.out.println();
	       obj.desc(arr);
	       
	     //locate
	       System.out.println();
	       int[] arr2 = new int[]{5,9,0,77,44,8,2};
	       int el = 77;
	       obj.locate(arr2, el);
	      
	       
	       //reverse
	       obj.rev(arr2);
	       
	       //print twod array
	       System.out.println();
	       int twodarr[][]= {
					{1,2,3,4},
					{5,6,7,8},
					{9,10,11,12},
					{13,14,15,16}
			};
			   for(int q[]:twodarr) {
					for(int j:q) {
						System.out.print(j+"\t");
					}
					System.out.println();
				}
		  
	      //rect matrix
			   int twodarr2[][]= {
						{1},
						{2,3},
						{4,5,6},
						{7,8,9,10}
				};
			   obj.rectmatrix(twodarr2);
			   
		 //accesing cmnd line args..
			  System.out.println(args[0]);
			  
		// marks and stdnt
			  
			  int twodarr3[][]= {
						{99,92,53,74},//std-1
						{65,26,97,98},//std-2
						{89,70,61,92},//std-3
						{63,74,85,56}//std-4
				};
			  obj.stdmarks(twodarr3);
			  
			 
		//primelist 1-100
			  obj.primeList();
	
	   //to check for palindrome or armstrong or perfect
			  System.out.println();
			  
			  int z= 333;
			  if(obj.armstrong(z)) {
				  System.out.println("armstrong");
			  }
			  else if(obj.palindrome(z)) {
				  System.out.println("palindrome");
			  }
			  else if(obj.perfect(z)) {
				  System.out.println("perfect");
			  }
			  else {
				  System.out.println("none");
			  }
			
			  //check the location and count
			  
			  System.out.println();
			  
			  int[] arr4 = new int[]{5,9,9,77,9,8,9};
		       int el1 = 9;
		       obj.locate(arr4, el1);
		     
		       ////number to words conversion
		       int u = 4567;
		       obj.conv(u);
		  
			   //rev in twd array
		       
		       int twodarr4[][]= {
						{99,92,53,74},
						{65,26,97,98},
						{89,70,61,92},
						{63,74,85,56}
				};
		     //  obj.revTwoD(twodarr4);
		       
		       
		       
		    //largest element in a twDarray
		       
		       System.out.println();
		       obj.largestTwoDarray(twodarr4);
		       
		    //noOfDays in a month
		       
		       
		       System.out.println();
		       int v = 11;
		       obj.noOfFdays(v);
	       
		       
		       int one = -243;   int two= 243;   if(one == two)   System.out.println("numbers are the same"); 
		       
		       //investment calci
		       
		      obj.invest(14000);
		       
		       
	     //array cannot be resized--yet can have a new array and copy the contents	
	       
	       
	}
	
	protected class A{
		protected int a=0;
	}
	
	public class B{
		public void met(){
		//   System.out.println("accesing A's prot member"+A.a);
		}
	}
	
}


