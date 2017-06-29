import java.util.List;

public class Tree
{
	private TreeNode root;
	
	public Tree(TreeNode root)
	{
		this.root = root;
	}

	public TreeNode root()
	{
		return this.root;
	}

	//////////////////////////////////////////////////////////////////

	public TreeNode parent(TreeNode v)
	{
		return v.getParent();
	}

	public List<TreeNode> children(TreeNode v)
	{
		return v.getList();
	}

	public void addChild(TreeNode p, String data)
	{
		TreeNode newNode = new TreeNode(p, data);
		p.getList().add(newNode);
	}//자식노드를 새로 생성하여 (생성한) 그 노드의 부모리스트를 가져와 뉴노드를 추가한다


	//////////////////////////////////////////////////////////////////

	public boolean isInternal(TreeNode v)
	{
		if(v.getList().isEmpty())
			return false;
		else
			return true;
	
	}

	public boolean isExternal(TreeNode v)
	{
		if(v.getList().isEmpty())
			return true;
		else
			return false;
	
	}

	public boolean isRoot(TreeNode v)
	{
		if(v.getParent() == null)
			return true;
		else
			return false;
	
	}

	//////////////////////////////////////////////////////////////////

	public void preOrder(TreeNode n)
	{
		System.out.print(n.getData() + " ");	//매개변수로 넣어준 노드의 데이터를 출력

		for(TreeNode num : n.getList())
			preOrder(num);

	}

	public void postOrder(TreeNode n)
	{
		for(TreeNode num : n.getList())
			preOrder(num);
		
		System.out.print(n.getData() + " ");	//매개변수로 넣어준 노드의 데이터를 출력		
	}

	//////////////////////////////////////////////////////////////////

	public static int depth(Tree t, TreeNode n)
	{
		if(t.isRoot(n))
			return 0;

		else
			return 1+ depth(t, t.parent(n));

	}//루트부터 깊이 0

	public static int height(Tree t, TreeNode n)
	{
		if(t.isExternal(n)) return 0;

		int h = 0;

		for(TreeNode w : n.getList())
			h = Math.max(h, height(t, w));

		return 1+h;		

	}//익스터널노드부터 깊이 0
	

}//class Tree