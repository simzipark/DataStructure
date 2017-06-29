
public class BinaryTreeNode {
	private String data;
	private BinaryTreeNode left;
	private BinaryTreeNode right;
	private BinaryTreeNode parent;
	
	public BinaryTreeNode(String data, BinaryTreeNode parent){
		this.parent = parent;
		this.data = data;
		this.left =null;
		this.right = null;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public BinaryTreeNode getLeft() {
		return left;
	}

	public void setLeft(BinaryTreeNode left) {
		this.left = left;
	}

	public BinaryTreeNode getRight() {
		return right;
	}

	public void setRight(BinaryTreeNode right) {
		this.right = right;
	}

	public BinaryTreeNode getParent() {
		return parent;
	}

	public void setParent(BinaryTreeNode parent) {
		this.parent = parent;
	}
	
	
}
