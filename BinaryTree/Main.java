
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		TreeNode root = new TreeNode(null, "A");
		BinaryTree bt = new BinaryTree(root);
		
		bt.insertLeft(root, "B");
		bt.insertRight(root, "E");
		
		bt.insertLeft(root.getLeft(), "C");
		bt.insertRight(root.getLeft(), "D");
		
		bt.insertLeft(root.getRight(), "F");
		bt.insertRight(root.getRight(), "G");
		
		bt.insertLeft(root.getLeft().getRight(), "H");
		bt.insertRight(root.getLeft().getRight(), "I");
		
		bt.inOrder(root);
		
		System.out.println("\n-------------------------------------------------");
		
		bt.remove(root.getRight());
		bt.inOrder(root);
		
		System.out.println("\n-------------------------------------------------");
		
		bt.remove(root.getRight().getRight());
		bt.inOrder(root);

	}

}
