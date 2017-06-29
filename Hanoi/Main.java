
import java.util.Scanner;
import java.util.Stack;


public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		
		Stack stack1 = new Stack();
		Stack stack2 = new Stack();
		Stack stack3 = new Stack();
		
		System.out.println("Number of disk : ");
		int n = scan.nextInt();
		
		Hanoi hanoi = new Hanoi(n, stack1);
		
		hanoi.printStack(stack1, 1);
		hanoi.printStack(stack2, 2);
		hanoi.printStack(stack3, 3);
		System.out.println("--------------");
		
		
		hanoi.movement(n, stack1, stack2, stack3);
		System.out.println("Number of Movement : " + hanoi.numOfMovement());
		
	}


}
