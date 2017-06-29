import java.util.Scanner;

public class Main {

	public static int recursiveFactorial(int i)
	{
		if(i==0) return 1;
		else return i*recursiveFactorial(i-1);
	}
	//recursiveFactorial
	
	public static int fibonacciAlgorithm1(int n)
	{
		int prev = 0;
		int curr = 1;
		int next = 0;
		
		if(n <= 1) return n;
		
		for(int i = 2; i <=n; i++)
		{
			next = curr + prev;
			prev = curr;
			curr = next;
		}
		return next;
		
	}
	//fibonacciAlgorithm1
	//Repetition
	
	public static int fibonacciAlgorithm2(int n)
	{
		if(n <= 2) return 1;
		else return fibonacciAlgorithm2(n-1) + fibonacciAlgorithm2(n-2);
		
	}	
	//fibonacciAlgorithm2
	//recursive way
	
	public static int fibonacciAlgorithm3(int n)
	{		
		int[] result= new int[n+1];
		
		result[0] = 0;
		result[1] = 1;
		
		if(n == 1) return 1;
		
		for(int i = 2; i<=n; i++)
			result[i] = result[i-1] + result[i-2];

		return result[n];

	}
	//fibonacciAlgorithm1
	//Repetition & array ver.
	
	
	public static void main(String[] args) {

		Scanner Keyboard = new Scanner(System.in);
		
		System.out.println("INPUT INT N VALUE : ");
		int n = Keyboard.nextInt();
		
		System.out.println(n+"! = "+recursiveFactorial(n));
				
		System.out.println("Repetition fibonacci("+n+") = " + fibonacciAlgorithm1(n));
		System.out.println("recursive  fibonacci("+n+") = " + fibonacciAlgorithm2(n));
		System.out.println("array ver  fibonacci("+n+") = " + fibonacciAlgorithm3(n));
		
	}

}
