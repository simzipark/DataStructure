import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//���� 1�� ���� ��
		/*
		List list = new List();		
		list.addLast("ls");
		list.addLast("mkdir hello");
		list.addLast("cd hello");
		list.printAllNodes();
		
		System.out.println(list.getNode(1).getCommand());
		*/
		
		//���� 2�� ���� ��
		/*
		Tree tree = new Tree("home");
		tree.addLeft(tree.getRoot(), "DataStructure");
		tree.addRight(tree.getRoot(), "ComputerPractice");
		tree.addLeft(tree.findNode("DataStructure"), "List");
		tree.addRight(tree.findNode("DataStructure"), "Tree");
		tree.inoderTrav(tree.getRoot());
		*/
		
		//���� 3-1�� ���� ��
		/*
		Tree tree = new Tree("home");
		tree.addLeft(tree.getRoot(), "DataStructure");
		tree.addRight(tree.getRoot(), "ComputerPractice");
		tree.addLeft(tree.findNode("DataStructure"), "List");
		tree.addRight(tree.findNode("DataStructure"), "Tree");
		tree.setCurrentNode(tree.findNode("List"));
		System.out.println(tree.getCurrentNodePath());
		*/
		
		//���� 3-2�� ���� ��
		/*
		Tree tree = new Tree("home");
		tree.parseCommand("cd opt1 opt2");
		System.out.println(tree.getCommand());
		while(!tree.getOptions().isEmpty())
			System.out.println(tree.getOptions().poll());
		*/		
		
		//���� 3-3�� ���� ��
		/*
		Tree directory = new Tree("home");
		directory.addLeft(directory.getRoot(), "DataStructure");
		directory.addRight(directory.getRoot(),  "ComputerPractice");		
		directory.addLeft(directory.findNode("DataStructure"), "List");
		directory.addRight(directory.findNode("DataStructure"), "Tree");		
		directory.addLeft(directory.findNode("ComputerPractice"), "Java");
		directory.addRight(directory.findNode("ComputerPractice"), "CPP");		
		directory.addLeft(directory.findNode("List"), "ArrayList");
		directory.addRight(directory.findNode("List"), "LinkedList");
		
		System.out.println();
		System.out.println("Hello, Start Terminal..");
		Scanner scan = new Scanner(System.in);
		
		while(true)
		{
			String currentNodePath = directory.getCurrentNodePath();
			System.out.print("SC-Terminal : " + currentNodePath +" $ ");
			
			String cmdLine = scan.nextLine();
			
			if(cmdLine.equals("exit"))
				break;
			
			else
				directory.executeCommand(cmdLine);
		}
		System.out.println("Bye, End Terminal..");
		*/
	}

}
