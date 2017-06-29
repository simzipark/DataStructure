
public class TreeNode {
	
	private String data;
	private TreeNode left;
	private TreeNode right;
	private TreeNode parent;
	
	public TreeNode(String data, TreeNode parent)
	{
		this.data = data;
		this.parent = parent;
		this.right = null;
		this.left = null;
	}//»ý¼ºÀÚ
	
	public String getData()
	{
		return this.data;
	}
	public TreeNode getLeft()
	{
		return this.left;
	}
	public TreeNode getRight()
	{
		return this.right;
	}
	public TreeNode getParent()
	{
		return this.parent;
	}
	//b~e
	
	public void setData(String data)
	{
		this.data = data;
	}
	public void setLeft(TreeNode left)
	{
		this.left = left;
	}
	public void setRight(TreeNode right)
	{
		this.right = right;
	}
	public void setParent(TreeNode parent)
	{
		this.parent = parent;
	}
	//f~i

}
