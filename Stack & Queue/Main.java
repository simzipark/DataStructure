import java.util.Stack;
import java.util.Queue;
import java.util.LinkedList;

public class Main {

	static Stack s = new Stack();
	static Queue q = new LinkedList();
	
	public static void push(int data)
	{
		s.push(data);
		System.out.println("Output : - Stack : "+s.toString());
	}
	
	public static int pop()
	{
		if(s.isEmpty() == true)
		{
			System.out.println("Error");
			return 0;
		}
		System.out.println("Output : "+ s.pop() +" Stack : "+s.toString());
		return 0;
	}
	
	public static void top()
	{
		System.out.println("Output : "+ s.peek() +" Stack : "+s.toString());
	}
	
	public static void isEmpty()
	{
		if(s.isEmpty() == true)
			System.out.println("Stack is Empty.");
		else
			System.out.println("Stack is not Empty.");
	}
	//Stack
	///////////////////////////////////////////////////////
	
	public static void enqueue(int data)
	{
		q.offer(data);
		System.out.println("Output : - Front : "+q.peek());
	}
	
	public static int dequeue()
	{
		if(q.isEmpty() == true)
		{
			System.out.println("Error");
			return 0;
		}
		else
		{
			System.out.println("Output : "+ q.poll() +" Front : "+q.peek());
			return 0;
		}
	}
	
	public static void front()
	{
		System.out.println("Output : "+q.peek()+" Front : "+q.peek());
	}
	
	public static void isEmpty2()
	{
		if(q.isEmpty() == true)
			System.out.println("Queue is Empty.");
		else
			System.out.println("Queue is not Empty.");
	}
	//Queue
	///////////////////////////////////////////////////////
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		push(5);
		push(3);
		pop();
		push(7);
		pop();
		top();
		pop();
		pop();
		isEmpty();
		//Exercise1
		
		enqueue(5);
		enqueue(3);
		dequeue();
		enqueue(7);
		dequeue();
		front();
		dequeue();
		dequeue();
		isEmpty2();
		//Exercise2
		
		
	}// Main
	
}
