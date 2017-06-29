import java.util.Scanner;
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		LinkedList list = new LinkedList();
		
		list.addLast("A");
		list.addLast("B");
		list.addLast("C");
		list.addLast("D");
		list.addLast("E");
		list.addLast("F");
		list.addLast("G");
		list.addLast("H");
		list.addLast("I");
		list.printAlNodes();
		list.addBefore(2, "a");
		list.addBefore(2, "b");
		list.printAlNodes();
		list.addBefore(10, "c");
		list.printAlNodes();
	}
}
