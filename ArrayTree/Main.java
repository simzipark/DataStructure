
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		TreeNode root = new TreeNode(null, "A");
		Tree tree = new Tree(root);

		tree.addChild(root, "B");
		tree.addChild(root, "E");
		tree.addChild(root, "I");

		tree.addChild(root.getList().get(0), "C");
		tree.addChild(root.getList().get(0), "D");

		tree.addChild(root.getList().get(1), "F");
		tree.addChild(root.getList().get(1), "G");
		tree.addChild(root.getList().get(1), "H");

		//depth
		System.out.println("-------------dapth-------------");
		System.out.println(tree.depth(tree, root.getList().get(0).getList().get(0)));
		
		//height
		System.out.println("-------------height-------------");
		System.out.println(tree.height(tree, root));
		
		//preOrder
		System.out.println("-------------preOrder-------------");
		tree.preOrder(root);
		System.out.println("");

		//postOrder
		System.out.println("-------------postOrder-------------");
		tree.postOrder(root);
		
		//Exercise1

	}


}
