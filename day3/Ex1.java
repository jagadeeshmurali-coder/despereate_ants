/*comments*/
package day3;
import java.applet.Applet;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;

import pack1.First;
public class Ex1  {
//	<applet name=Class<Ex1> code=Ex1.class height=400 width=400 HowOld=30 > 
//	</applet>

    //q1-line5
	
	//q2--op1
	
	//q3--op2 & op3
	
	//q4-- op1
	
	//q5--good
	
	//q6--if,case,while,goto
	
   //q7--legal identifiers--except op1
	
//	public void legalId(){
//	char	2variable;
//	 char variable2;
//	 char _vari;
//	 char _3_;
//	 char $one;
//	}
	
	//q9--2
	//q10--0
	
	//q11--Error Mine must be declared abstract
	
	//q12-op3
	
	//q13--default, zero
	
	//q14--op2,3
	
	//q15--No such file found, Doing finally, -1 
	
	//q16--Methods cannot be overriden to be more private
	
	//q17-- Compile time Exception 
	
	//q18---Error: no such parameter
	
	//q21--Value for i=1 Value for j=1,Value for i=2 Value for j=1
	
	//q23--all
	
	//q24--ceil
	
	//q25--- 19 followed by 11 
	
	//q26--ic 
	
	//q27--charAt(2)
	
	//q28--s3=ss + s2; 
	
	//q29--7
	
	//q30---pub,priv,static
	
	//q33--The code will cause an error at compile time. 
	
	//q35--comp.error--type mismatch
	
	//q36---if(s.equalsIgnoreCase(s2))
	
	//q38---FileName.chdir("DirName") 
	
	//q40--- super(10);
	
	//q41---10,40
	
	//42---for(int i=0; i< ia.length;i++) 
	
	//q43--error
	
	//q44--op3
	
	//q45--error.compile
	
	//q49---op1
	
	//q50--1
	
	//q51---comp.error
	
	//q58---comp.error
	
	//q59---over.amethod()
	
	
	
	static int j=20;
	
	
	
//	Ex1(){ 
//		
//		super(10);
//	    String s="Java"; 
//	    String s2="java"; 
//	    if(s.equalsIgnoreCase(s2)) {
//	        System.out.println("Equal"); 
//	        }else 
//	        { 
//	        System.out.println("Not equal"); 
//	        }
//	     } 
//	
	
	class Base {} 
	class Sub extends Base {} 
	class Sub2 extends Base {}
	
	public class MyInner {}
	
	
//	public void amethod1(String s){ 
//	    char c='H'; 
//	    c =c  + s; 
//	    System.out.println(c); 
//	    } 
	
	
//	class Background implements Runnable{ 
//		  int i=0; 
//		  public int run(){ 
//		         while(true){ 
//		                i++; 
//		                System.out.println("i="+i); 
//		            } //End while
//
//		     return 1;
//		     }//End run 
//		}//End class
//	
	
	public static void main(String[] args) {
		
       Ex1 e = new Ex1();
       
       e.amethod3();
       int i=10;
       Ex1 p = new Ex1();
       p.amethod(i);
       System.out.println(i);
       System.out.println(j);
		
//		System.out.println(args[2]);
//		int anar[] = new int[]{1,2,3};
//		System.out.println(anar[1]);
//		int q10[] = new int[5];
//		System.out.println(q10[0]);
		//int[] ar=new int[5];
//		for(int i=0;i<ar.length;i++) {
//			System.out.println(ar[i]);
//		}
//		int i=1; 
//        switch (i) { 
//                case 0: 
//                System.out.println("zero"); 
//        break; 
//        case 1: 
//                System.out.println("one"); 
//        case 2: 
//                System.out.println("two"); 
//        default: 
//                System.out.println("default"); 
//        }
//		
//	}
		
//		int i=9; 
//		switch (i) { 
//		        default: 
//		        System.out.println("default"); 
//		                case 0: 
//		        System.out.println("zero"); 
//		                break; 
//		        case 1: 
//		                System.out.println("one"); 
//		        case 2: 
//		        System.out.println("two"); 
	//	}
//		int i=1; 
//		int j=2; 
//		if(i==1|| j==2) 
//		        System.out.println("OK");
//		
//		boolean b=true; 
//		boolean b2=true; 
//		if(b==b2) { 
//		        System.out.println("So true"); 
//		        }
//
//		 Ex1 m=new Ex1(); 
//	        System.out.println(m.amethod()); 
	        
	        
//	        Base b=new Base();
//            Sub s=(Sub) b;
	        
//	        int i; 
//	        int j; 
//	        outer: 
//	        for (i=1;i <3;i++) 
//	            inner: 
//	             for(j=1; j<3; j++) { 
//	                        if (j==2) 
//	                        continue outer; 
//	                        System.out.println("Value for i=" + i + " Value for j=" +j); 
//	                        } 
	    
	        System.out.println(Math.ceil(-4.7));
	        
//	        Integer ten=new Integer(10); 
//	        Long nine=new Long (9);
//	        System.out.println(ten + nine); 
//	        int p=1;
	        //System.out.println(p + ten);
	        
	        String s=new String("Bicycle"); 
	        int iBegin=1; 
	        char iEnd=3; 
	        System.out.println(s.substring(iBegin,iEnd));
	        
	        String s1=new String("java"); 
            System.out.println(s1.charAt(2));
            
            
            String ss=new String("Hello") ;
            		String s2=new String("there"); 
            		String s3=new String();
            		s3=ss + s2; 
            		
            		
            		System.out.println(4 | 3); 
            		
//            		 Ex1 c=new Ex1(); 
//            	        String h=new String("ello"); 
//            	        c.amethod1(s);
            		
            		
     
            		   
//            		    public void derived()
//            		    {
//            		        //Three
//            		    }
            		
            		
	}


private void amethod(int x) {
	x=x*2;
    j=j*2;
	
}

public void amethod3(){
    int ia[] = new int[4];
    for (int i=0; i< ia.length; i++)        
                    {
       ia[i]=i;
       System.out.println(ia[i]);
       }
    }
	
	//void amethod(int i) throws Exception {}
	//void amethod(long i)throws Exception {} 
	//void amethod(long i){} 
	//public void amethod(int i) throws Exception {} 
//	public int amethod() { 
//        try {
//                FileInputStream dis=new FileInputStream("Hello.txt"); 
//                }catch (FileNotFoundException fne) { 
//                        System.out.println("No such file found"); 
//                        return -1; 
//                        }catch(IOException ioe) { 
//                        } finally{ 
//        System.out.println("Doing finally"); 
//        } 
//        return 0; 
//        } 
	
}
//abstract class MineBase{
//	abstract void amethod();
//	static int i;
//}

//class Base{ 
//    public void amethod(int i) {  }
//} 




//class Base{
//    Base(int i){
//    System.out.println("base constructor");
//    }
//    Base(){
//    }
//}
