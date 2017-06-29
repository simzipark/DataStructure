
public class BSTree {
	
	Node root;

	public BSTree(){
		this.root = new Node(0);
	}
	
	public Node TreeSearch(int k, Node v){
		if(v==null) return v;
		
		if(k<v.getData())
			return TreeSearch(k, v.getLeft());
		else if(k>v.getData())
			return TreeSearch(k, v.getRight());
		
		return v;
	}
	
	public boolean find(int id){
		
		Node search = TreeSearch(id, root);
		if(search==null) return false;
		else return true;
	}
	
	public void displayInorder(Node root){
		if(root != null){
			displayInorder(root.left);
			System.out.print(" "+root.data);
			displayInorder(root.right);
		}
	}
	
	public void insert(int value){
		if(this.root==null){
			Node newNode = new Node(value);
			this.root = newNode;
		}
		insertReculsive(value, root);
	}
	
	public Node insertReculsive(int value, Node node){
		if(node == null){
			Node newNode = new Node(value);
			return newNode;
		}
		else if(value < node.getData()){
			Node ret = insertReculsive(value, node.getLeft());
			node.setLeft(ret);
			return node;
		}
		else if(value > node.getData()){
			Node ret = insertReculsive(value, node.getRight());
			node.setRight(ret);
			return node;
		}
		else return node;
	}

	
	public boolean delete(int value){
		Node parent = this.root;
		Node current = this.root;
		boolean isLeftChild = false;	//there is no Node in current tree
		
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
			
			if(current == null)
				return false;
		}
		
		//if I am here = we have fond the node
		//Case 1 : if node(to be deleted) has no children
		if(current.getLeft()==null && current.getRight()==null){
			if(current == root)
				root = null;
			if(isLeftChild == true)
				parent.setLeft(null);
			else
				parent.setRight(null);
		}
		
		//Case 2 : if node(to be deleted) has only one child
		else if(current.getRight()==null){
			if(current == root)
				root = current.getLeft();
			else if(isLeftChild)
				parent.setLeft(current.getLeft());
			else
				parent.setRight(current.getLeft());
		}
		else if(current.getLeft()==null){
			if(current == root)
				root = current.getRight();
			else if(isLeftChild)
				parent.setLeft(current.getRight());
			else
				parent.setRight(current.getRight());
		}
			
		//Case 3 : if node(to be deleted) has two child
		//then get successor
		else if(current.getLeft()!=null && current.getRight()!=null){
			Node successor = getSuccessor(current);
			if(current == root)
				root = successor;
			else if(isLeftChild)
				parent.left = successor;
			else parent.right = successor;
			successor.left = current.left;
		}
		return true;
	}
	
	public Node getSuccessor(Node deleteNode){
		//to get minimum node in the right subtree of deletion node
		Node successor = null;
		Node successorParent = null;
		Node current = deleteNode.right;
		
		while(current != null){
			successorParent = successor;
			successor = current;
			current = current.left;
		}
		
		//check, if successor has thr right chid, it cannot have left child
		//if it dose have thr right chid, add it to the left ofsuccessorParent
		
		if(successor!=deleteNode.right){
			successorParent.left = successor.right;
			successor.right = deleteNode.right;
		}
		
		return successor;
	}
	
}
