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
	}//�ڽĳ�带 ���� �����Ͽ� (������) �� ����� �θ𸮽�Ʈ�� ������ ����带 �߰��Ѵ�


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
		System.out.print(n.getData() + " ");	//�Ű������� �־��� ����� �����͸� ���

		for(TreeNode num : n.getList())
			preOrder(num);

	}

	public void postOrder(TreeNode n)
	{
		for(TreeNode num : n.getList())
			preOrder(num);
		
		System.out.print(n.getData() + " ");	//�Ű������� �־��� ����� �����͸� ���		
	}

	//////////////////////////////////////////////////////////////////

	public static int depth(Tree t, TreeNode n)
	{
		if(t.isRoot(n))
			return 0;

		else
			return 1+ depth(t, t.parent(n));

	}//��Ʈ���� ���� 0

	public static int height(Tree t, TreeNode n)
	{
		if(t.isExternal(n)) return 0;

		int h = 0;

		for(TreeNode w : n.getList())
			h = Math.max(h, height(t, w));

		return 1+h;		

	}//�ͽ��ͳγ����� ���� 0
	

}//class Tree