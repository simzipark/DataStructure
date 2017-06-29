
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/*
		//1
		Dictionary dict = new Dictionary();
		dict.insert("apple", "An apple is a round");
		dict.insert("orange", "Something that is orange is");
		System.out.println(dict.find("apple").getDescription());
		dict.printList();
		*/
		
		//2
		BinarySearchTree dictTree = new BinarySearchTree();
		dictTree.addWord("apple", "An apple is a round");
		dictTree.addWord("pine paale", "A pineapple is a large oval");
		dictTree.addWord("orange", "Something that is orange is");
		dictTree.addWord("peach", "A peach is a soft, round");
		dictTree.addWord("grape", "Grapes are small green or dark puple");
		
		dictTree.findWord("orange");
		dictTree.findWord("grape");
		System.out.println();
		dictTree.removeWord("orange");
		dictTree.removeWord("peach");
		System.out.println();
		dictTree.printDictionary('p');
	}

}
