import java.util.*;

public class BinarySearchTree {

	private TreeNode root;
	
	public BinarySearchTree(){
		this.root=null;		
	}
	
	public TreeNode TreeSearch(char value, TreeNode node){
		if(node==null) return node;
		
		if(value < node.getData())
			return TreeSearch(value, node.getLeft());
		else if(value > node.getData())
			return TreeSearch(value, node.getRight());
		
		return node;
	}
	
	public TreeNode getSuccessor(TreeNode deleteNode){
		TreeNode successor = null;
		TreeNode successorParent = null;
		TreeNode current = deleteNode.right;
		
		while(current!=null){
			successorParent = successor;
			successor = current;
			current = current.left;
		}
		if(successor!=deleteNode.right){
			successorParent.right = successor.right;
			successor.right = deleteNode.right;
		}
		return successor;
	}
	
	public TreeNode insertReculsive(char value, TreeNode node){
		if(node == null){
			TreeNode add = new TreeNode(value);
			return add;
		}
		
		else if(value < node.getData()){
			TreeNode ret = insertReculsive(value, node.getLeft());
			node.setLeft(ret);
			return node;
		}
		
		else if(value > node.getData()){
			TreeNode ret = insertReculsive(value, node.getRight());
			node.setRight(ret);
			return node;
		}
		
		else return node;
	}
	
	public void printBSTReculsive(TreeNode node){
		if(node!=null){
			printBSTReculsive(node.left);
			System.out.print(" " + node.data);
			printBSTReculsive(node.right);
		}
	}
	
	//f
	public void printAllReculsive(TreeNode node){
		if(node!=null){
			printBSTReculsive(node.left);
			System.out.print(" " + node.data);
			node.words.printList();
			printBSTReculsive(node.right);
		}
	}
	
	public void insert(char value){
		if(this.root==null){
			TreeNode add = new TreeNode(value);
			this.root = add;
		}
		insertReculsive(value, root);
	}

	public TreeNode find(char value){
		TreeNode search = TreeSearch(value, root);
		
		if(search==null){
			return null;
		}
		else{
			return search;}
		
	}
	
	public void delete(char value){
		TreeNode parent = this.root;
		TreeNode current = this.root;
		boolean isLeftChild = false;
		
		while(current.getData()!=value){
			parent = current;
			if(current.getData()>value){
				isLeftChild = true;
				current = current.getLeft();
			}
			else{
				isLeftChild = false;
				current = current.getRight();
			}			
		}
		
		if(current.getLeft()==null && current.getRight()==null){
			if(current==root)
				root = null;
			if(isLeftChild)
				parent.setLeft(null);
			else
				parent.setRight(null);			
		}//Case 1
		
		else if(current.getRight()==null){
			if(current==root)
				root = current.getLeft();
			if(isLeftChild)
				parent.setLeft(current.getLeft());
			else
				parent.setRight(current.getLeft());	
		}
		else if(current.getLeft()==null){
			if(current==root)
				root = current.getRight();
			if(isLeftChild)
				parent.setLeft(current.getRight());
			else
				parent.setRight(current.getRight());	
		}//Case 2
		
		else if(current.getLeft()!=null && current.getRight()!=null){
			TreeNode successor = getSuccessor(current);
			
			if(current==root)
				root = successor;
			else if(isLeftChild)
				parent.left = successor;
			else
				parent.right = successor;
			
			successor.left = current.left;
		}
	}//Delete
	
	//j
	public void printBST(){
				
	}
	
	//k
	public void printAll(){
		
	}
	
	
	public void printBSTReculsive(TreeNode node){
		if(node!=null){
			printBSTReculsive(node.left);
			System.out.print(" " + node.data);
			printBSTReculsive(node.right);
		}
	}
	
	//f
	public void printAllReculsive(TreeNode node){
		if(node!=null){
			printBSTReculsive(node.left);
			System.out.print(" " + node.data);
			node.words.printList();
			printBSTReculsive(node.right);
		}
	}
	
	//page 9
	public void addWord(String word, String description){
		
		//if there is a TreeNode which have a key
		if(find(word.charAt(0))!=null){
			DictionaryNode temp = find(word.charAt(0)).getWords().header;
			while(temp!=find(word.charAt(0)).getWords().trailer){
				if(temp.getKey().charAt(0)==word.charAt(0))
					temp.getDetail().setWord(word);
					temp.getDetail().setDescription(description);
			}
		}
		//if there is not a TreeNode have a key
		else{
			this.insert(word.charAt(0));
			find(word.charAt(0)).insertWord(word, description);
			
		}
		
	}
	
	public void findWord(String word){
		System.out.println("-");
	}
	
	public void removeWord(String word){
		System.out.println("-");
	}
	
	public void printDictionary(char c){
		System.out.println("-");
	}
}
