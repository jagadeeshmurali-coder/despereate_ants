package day13;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import day13.Quiz.Questions;

public class Quiz {
public static void main(String[] args){
	
	List<Questions> questions = new ArrayList<>();
	//Questions q = new Questions();
	Quiz q = new Quiz();

    String q1 = "What is hardware?\n"
          + "(a)virtual machine\n(b)the physical machine\n(c)applications such as browsers\n(d)part of the processor\n";

    String q2 = "What does counter++; do?\n"
          + "(a)Adds 1 to counter\n(b)Adds 2 to counter\n(c)Gets the sum\n(d)Multiplies the numbers\n";

    String q3 = "What is a loop that never stops?\n"
          + "(a)For Loop\n(b)Infinite Loop\n(c)Do-While Loop\n(d)Full Loop\n";

    String q4 = "In a while loop, if the boolean expression is true, what will the loop do?\n"
          + "(a)Break\n(b)Program will exit\n(c)Repeat\n(d)Continue through program\n";

    String q5 = "What special value is designated for controlling a loop?\n"
          + "(a)Control value\n(b)Mutator Method\n(c)Accessor Method\n(d)Sentinel Value\n";

    String q6 = "What is a method?\n"
          + "(a)A collection of statements grouped together to perform an operation\n(b)A value returned from a method using the return statement\n(c)The portion of the program where the variable can be accessed.\n(d)The combination of the name of a method and the list of its parameters\n";

    String q7 = "What is an object?\n"
          + "(a)Representation of an entity in the real world that can be distinctly identified\n(b)A static method can be called without creating an instance of the class\n(c)Instance variable/instance mthod\n(d)A template, blueprint or contract that defines what an object's data fields and methods will be.\n";

    String q8 = "What is an array?\n"
          + "(a)Numbers of items ArrayList can store without increasing its size\n(b)Number used as an index to pinpoint a specfic element within an array\n(c)Object that can store a group of values, all of the same type\n(d)Method of locating a specific item in a larger collection of data\n";

    String q9 = "You use this statement to throw an exception manually.\n"
          + "(a)Throw\n(b)call stack\n(c)try block\n(d)thrown\n";

    String qF = "When an exception is generated, it is said to have been what?\n"
          + "(a)Created\n(b)Called\n(c)Thrown\n(d)Generated\n";

         questions.add(q.new Questions(q1, "b"));
         questions.add(q.new Questions(q2, "a"));
         questions.add(q.new Questions(q3, "b"));
         questions.add(q.new Questions(q4, "c"));
         questions.add(q.new Questions(q5, "d"));
         questions.add(q.new Questions(q6, "a"));
         questions.add(q.new Questions(q7, "a"));
         questions.add(q.new Questions(q8, "c"));
         questions.add(q.new Questions(q9, "a"));
         questions.add(q.new Questions(qF, "c"));
         
            
            
            
//            Iterator<Questions> it = questions.iterator();
//            while(it.hasNext()) {
//    			System.out.println(it.next());
//    		}
         int c=0;
         for(int i=0;i<5;i++) {
        	boolean sc = takeTest(questions);
        	 if(sc) {c++;}
         }
         
         System.out.println("You got " + c + "/" + questions.size());
         
  // takeTest(questions);


}


public class Questions{
String prompt;
public String answer;

public Questions(String prompt, String answer) {
    this.prompt = prompt;
    this.answer = answer;
}
@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.prompt;
	}
public Questions() {
	
}}

public static boolean takeTest(List<Questions> questions){
    int score = 0;
    Scanner keyboardInput = new Scanner(System.in);

    Random generator = new Random();
    int r = generator.nextInt(questions.size());
    System.out.println(questions.get(r));

        String answer = keyboardInput.nextLine();
        if(answer.equals(questions.get(r).answer)) {
            score++;
        }
//        System.out.println("You got " + score + "/" + questions.size());
        if(score==0)
         return false;
        else 
        	return true;
    }
    
}




