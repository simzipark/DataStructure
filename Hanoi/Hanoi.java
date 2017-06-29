import java.util.Stack;

public class Hanoi {
	
	private int numOfDisk;
	private int num = 0;

	/*
	private Stack<Integer> tower1;
	private Stack<Integer> tower2;
	private Stack<Integer> tower3;
	private int numOfDisk;
	private int numOfMove;

	public Hanoi(){
		this.tower1 = new Stack<Integer>();
		this.tower2 = new Stack<Integer>();
		this.tower3 = new Stack<Integer>();
		this.numOfDisk = 0;
	}

	public void init(int cnt){
		for(int i = 0; i<n; i++){
			tower1.puch(i);			
		}

		this.numOfDisk = cnt;
		this.numOfMove = 0;
	}
	*/
	
	public Hanoi(int n, Stack stack1){
		this.numOfDisk = n;
		for(int i = 0; i<n; i++){
			stack1.push(i);			
		}
		
	}//initialize height of hanoi tower
	
	public void movement(int numOfDisk, Stack stack1, Stack stack2, Stack stack3){
		if(numOfDisk == 1){
			
			stack3.push(stack1.pop());
			printStack(stack1,1);
			printStack(stack2,2);
			printStack(stack3,3);
			System.out.println("--------------");
		}
		else {
			movement(numOfDisk-1, stack1, stack3, stack2);
			printStack(stack1,1);
			printStack(stack2,2);
			printStack(stack3,3);
			System.out.println("--------------");
			
			stack3.push(stack1.pop());
			printStack(stack1,1);
			printStack(stack2,2);
			printStack(stack3,3);
			System.out.println("--------------");
			
			movement(numOfDisk-1, stack2, stack1, stack3);
			printStack(stack1,1);
			printStack(stack2,2);
			printStack(stack3,3);
			System.out.println("--------------");
		}
		num++;
	}
	
	public void printStack(Stack stack, int n){
		
		System.out.print("stack " + n + " :");
		
		for(int i = 0; i<stack.size(); i++)
			System.out.print(stack.get(i)+" ");
		System.out.println("");
		
	
		
	}
	
	public int numOfMovement(){
		return this.num;
	}
	

}
