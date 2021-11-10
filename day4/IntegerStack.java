package day4;

import java.util.NoSuchElementException;

public class IntegerStack {
	
	public int len,top,size;
	public int arr[];
	
  public IntegerStack(int n) {
	
	  size=n;
	  top=-1;
	  len=0;
	  arr = new int[size];
	  
   }
  
  public boolean isEmpty()
  {
      return top == -1;
  }
  
  public boolean isFull()
  {
      return top == size -1 ;        
  }
  public int peek()
  {
      if( isEmpty() )
          throw new NoSuchElementException("Underflow Exception");
      return arr[top];
  }
  public int getSize()
  {
      return len ;
  }
  public void push(int i)
  {
      if(top + 1 >= size)
          throw new IndexOutOfBoundsException("Overflow Exception");
      if(top + 1 < size )
          arr[++top] = i;
      len++ ;
  }
  public int pop()
  {
      if( isEmpty() )
          throw new NoSuchElementException("Underflow Exception");
      len-- ;
      return arr[top--]; 
  }
  public void display()
  {
      System.out.print("\nStack = ");
      if (len == 0)
      {
          System.out.print("Empty\n");
          return ;
      }
      for (int i = top; i >= 0; i--)
          System.out.print(arr[i]+" ");
      System.out.println();
  }    

}
