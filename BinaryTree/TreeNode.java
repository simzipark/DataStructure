import java.util.ArrayList;
import java.util.List;

public class TreeNode
{
	private String data;
	private TreeNode right;
	private TreeNode left;
	private TreeNode parent;
	
	public TreeNode()
	{
		this.data = null;
		this.right = null;
		this.left = null;
		this.parent = null;
	}

	public TreeNode(TreeNode parent, String data)
	{
		this.data = data;
		this.right = null;
		this.left = null;
		this.parent = parent;
	}
	//생성자

	//////////////////////////////////////////////////////////////////

	public TreeNode getParent()
	{
		return this.parent;	
	}
	//부모노드 가져오기

	public String getData()
	{
		return this.data;		
	}
	//데이터 가져오기

	public TreeNode getRight()
	{
		return this.right;		
	}
	//자식노드 가져오기
	
	public TreeNode getLeft()
	{
		return this.left;		
	}
	//자식노드 가져오기

	//////////////////////////////////////////////////////////////////

	public void setParent(TreeNode p)
	{
		this.parent = p;
	}
	//해당 노드에 부모노드 연결

	public void setData(String d)
	{
		this.data = d;
	}
	//해당 노드에 데이터 삽입
	
	public void setRight(TreeNode right)
	{
		this.right = right;
	}
	//해당 노드에 자식노드 연결

	public void setLeft(TreeNode left)
	{
		this.left = left;
	}
	//해당 노드에 자식노드 연결

}//class TreeNode