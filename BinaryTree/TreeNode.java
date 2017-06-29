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
	//������

	//////////////////////////////////////////////////////////////////

	public TreeNode getParent()
	{
		return this.parent;	
	}
	//�θ��� ��������

	public String getData()
	{
		return this.data;		
	}
	//������ ��������

	public TreeNode getRight()
	{
		return this.right;		
	}
	//�ڽĳ�� ��������
	
	public TreeNode getLeft()
	{
		return this.left;		
	}
	//�ڽĳ�� ��������

	//////////////////////////////////////////////////////////////////

	public void setParent(TreeNode p)
	{
		this.parent = p;
	}
	//�ش� ��忡 �θ��� ����

	public void setData(String d)
	{
		this.data = d;
	}
	//�ش� ��忡 ������ ����
	
	public void setRight(TreeNode right)
	{
		this.right = right;
	}
	//�ش� ��忡 �ڽĳ�� ����

	public void setLeft(TreeNode left)
	{
		this.left = left;
	}
	//�ش� ��忡 �ڽĳ�� ����

}//class TreeNode