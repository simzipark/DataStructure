import java.util.ArrayList;
import java.util.List;

public class TreeNode
{
	private String data;
	private TreeNode parent;
	private List<TreeNode> Child_list;

	public TreeNode()
	{
		this.data = null;
		this.parent = null;
		this.Child_list = new ArrayList<TreeNode> ();	
	}

	public TreeNode(TreeNode parent, String data)
	{
		this.data = data;
		this.parent = parent;
		this.Child_list = new ArrayList<TreeNode> ();
	}
	//������

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

	public void setList(ArrayList<TreeNode> list)
	{
		this.Child_list = list;
	}
	//�ش� ��忡 �ڽĳ�� ����

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

	public List<TreeNode> getList()
	{
		return this.Child_list;		
	}
	//�ڽĳ�� ��������

}//class TreeNode