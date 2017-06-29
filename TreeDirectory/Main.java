

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Tree directory = new Tree("home");
		directory.addChild(directory.getRoot(), "DataStructure");
		directory.addChild(directory.getRoot(), "ComputerPractice");
		directory.addChild(directory.findNodes("DataStructure"), "List");
		directory.addChild(directory.findNodes("DataStructure"), "Tree");
		directory.addChild(directory.findNodes("ComputerPractice"), "Java");
		directory.addChild(directory.findNodes("ComputerPractice"), "CPP");
		directory.addChild(directory.findNodes("List"), "ArrayList");
		directory.addChild(directory.findNodes("List"), "LinkedList");
		System.out.println();
		System.out.println("Hello, Start Terminal..");
		Scanner scan = new Scanner(System.in);
		
		while(true){
			String currenNodePath = directory.getCurrentNodePath();
			System.out.print("SC-Terminal : "+currenNodePath+" $ ");
			
			String cmdLine= scan.nextLine();
			
			if(cmdLine.equals("exit"))break;
			else
				directory.executeCommand(cmdLine);
			
		}
		System.out.println("Bye. End Terminal..");
		

	}

}
