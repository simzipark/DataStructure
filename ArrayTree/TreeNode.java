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
	//생성자

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

	public void setList(ArrayList<TreeNode> list)
	{
		this.Child_list = list;
	}
	//해당 노드에 자식노드 연결

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

	public List<TreeNode> getList()
	{
		return this.Child_list;		
	}
	//자식노드 가져오기

}//class TreeNode