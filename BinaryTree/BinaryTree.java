
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
			System.out.println("이미 왼쪽 자식이 있읍니다...");
		
		else
			v.setLeft(d);			
		
		return d;
	}
	
	public TreeNode insertRight(TreeNode v, String data)
	{
		TreeNode d = new TreeNode(v, data);
		
		if(hasRight(v))
			System.out.println("이미 오른쪽 자식이 있읍니다...");
		
		else
			v.setRight(d);			
		
		return d;
	}
	//각 위치에서 왼오에 새로운 노드를 만들고 추가하긔 

	//////////////////////////////////////////////////////////////////

	public void remove(TreeNode v)
	{
		if(hasLeft(v) || hasRight(v))
			System.out.println("자식이 있어 지울 수 없읍니다...");
		
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
		//inOrder 서칭 구현
		if(hasLeft(v))
			inOrder(v.getLeft());
		
		System.out.print(v.getData() + " ");
		
		if(hasRight(v))
			inOrder(v.getRight());
	}
	
	
	

}
