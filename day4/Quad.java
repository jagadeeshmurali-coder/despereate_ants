package day4;

public class Quad {

	int a,b,c;
	public Quad() {
		this.a=1;
		this.b=1;
		this.c=1;
	}
	public Quad(int a,int b,int c){
		this.a=a;
		this.b=b;
		this.c=c;
	}
	public int getA() {
		return a;
	}
	public void setA(int a) {
		this.a = a;
	}
	public int getB() {
		return b;
	}
	public void setB(int b) {
		this.b = b;
	}
	public int getC() {
		return c;
	}
	public void setC(int c) {
		this.c = c;
	}
	public int compute(int x) {
		int res;
		res = (int) (a*(Math.pow(x, 2))+(b*x)+c);
		System.out.println(res);
		return res;
	}

	public static void main(String[] args) {
		
		Quad q = new Quad(2, 3, 4);
		q.compute(2);

	}

}
