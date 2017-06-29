
public class BinaryTree {
	
	TreeNode root;
	
	public BinaryTree(TreeNode root)
	{
		this.root = root;
	}
	
	public TreeNode left(TreeNode v)
	{
		return v.getLeft();
	}
	
	public TreeNode right(TreeNode v)
	{
		return v.getRight();
	}
	//get

	//////////////////////////////////////////////////////////////////

	public boolean hasLeft(TreeNode v)
	{
		if(v.getLeft() == null)
			return false;
		
		else
			return true;
	}
	
	public boolean hasRight(TreeNode v)
	{
		if(v.getRight() == null)
			return false;
		
		else
			return true;
	}

	//////////////////////////////////////////////////////////////////

	public TreeNode insertLeft(TreeNode v, String data)
	{
		TreeNode d = new TreeNode(v, data);
		
		if(hasLeft(v))
			System.out.println("�̹� ���� �ڽ��� �����ϴ�...");
		
		else
			v.setLeft(d);			
		
		return d;
	}
	
	public TreeNode insertRight(TreeNode v, String data)
	{
		TreeNode d = new TreeNode(v, data);
		
		if(hasRight(v))
			System.out.println("�̹� ������ �ڽ��� �����ϴ�...");
		
		else
			v.setRight(d);			
		
		return d;
	}
	//�� ��ġ���� �޿��� ���ο� ��带 ����� �߰��ϱ� 

	//////////////////////////////////////////////////////////////////

	public void remove(TreeNode v)
	{
		if(hasLeft(v) || hasRight(v))
			System.out.println("�ڽ��� �־� ���� �� �����ϴ�...");
		
		else
		{
			if(v.getParent().getRight() == v)
				v.getParent().setRight(null);
			
			else if(v.getParent().getLeft() == v)
				v.getParent().setLeft(null);
			
			v.setParent(null);		
			
			
		}
	}
	
	public void inOrder(TreeNode v)
	{
		//inOrder ��Ī ����
		if(hasLeft(v))
			inOrder(v.getLeft());
		
		System.out.print(v.getData() + " ");
		
		if(hasRight(v))
			inOrder(v.getRight());
	}
	
	
	

}
