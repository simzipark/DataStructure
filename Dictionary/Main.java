import java.util.Scanner;
import java.util.Stack;


public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		
		Dictionary map = new Dictionary();
		
		map.insert(5, "A");
		map.print();
		map.insert(7, "B");
		map.print();
		map.insert(2, "C");
		map.print();
		map.insert(8, "D");
		map.print();
		map.insert(2, "E");
		map.print();
		
		map.find(7);
		map.print();
		map.find(4);
		map.print();
		map.find(2);
		map.print();
		
		map.findAll(2);
		map.print();
		
		map.remove(5);
		map.print();
		map.find(5);
		map.print();
	}


}
