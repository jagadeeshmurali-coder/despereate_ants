package day13;

import java.util.Set;
import java.util.TreeSet;

public class SetDemo {

	public static void main(String[] args) {
		Set set = new TreeSet<Student>((Student o1,Student o2)->{return o1.compareTo(o2);});
		set.add(new Student(100));
		set.add(new Student(200));
		set.add(new Student(300));
		
		System.out.println(set);
	}
	
}
class Student implements Comparable<Student>{
	
	Integer marks;
	public Student(Integer marks) {
		this.marks=marks;
	}

	@Override
	public int compareTo(Student o) {
		
		return o.marks.compareTo(marks);
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return ""+this.marks;
	}
	
}