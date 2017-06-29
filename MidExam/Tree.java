import java.security.cert.PKIXRevocationChecker.Option;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class Tree {
	
	TreeNode root = new TreeNode(null, null);
	TreeNode currentNode = new TreeNode(null, null);
	String command;
	Queue<String> options = new LinkedList();
	private List history;
	
	///////////////////////////////////////////////////////////////////////
	
	public Tree(String data)
	{
		this.root.setData(data);
		this.currentNode = root;
		this.history = null;
	}//a
	
	public TreeNode getRoot()
	{
		return this.root;
	}//b
	
	public boolean hasLeft(TreeNode v)
	{
		if(v.getLeft() != null)
			return true;
		else
			return false;
	}//c
	
	public boolean hasRight(TreeNode v)
	{
		if(v.getRight() != null)
			return true;
		else
			return false;		
	}//d
	
	public TreeNode addLeft(TreeNode v, String data)
	{
		TreeNode node = new TreeNode(data, v);	//v�� �θ�� �ϴ� ���ο� �ڽĳ�带 ����
		
		if(hasLeft(v))
		{
			System.out.println("�̹� ���� �ڽ��� �־� �߰����� ���մϴ�.");
			return null;
		}//���ʿ� �ڽ��� ������ ���� ����ϰ� �߰�����
		
		else
		{
			v.setLeft(node);
			return node;
		}//���ʿ� �ڽ��� ������ ���ο� ��带 v�� ��������ְ� ���ο��� ����
	}//e
	
	public TreeNode addRight(TreeNode v, String data)
	{
		TreeNode node = new TreeNode(data, v);	//v�� �θ�� �ϴ� ���ο� �ڽĳ�带 ����
		
		if(hasRight(v))
		{
			System.out.println("�̹� ������ �ڽ��� �־� �߰����� ���մϴ�.");
			return null;
		}//�����ʿ� �ڽ��� ������ ���� ����ϰ� �߰�����
		
		else
		{
			v.setRight(node);
			return node;
		}//�����ʿ� �ڽ��� ������ ���ο� ��带 v�� ��������ְ� ���ο��� ����
	}
	//f
	
	public void inoderTrav(TreeNode v)
	{
		if(hasLeft(v))
			inoderTrav(v.getLeft());
		
		System.out.println(v.getData());
		
		if(hasRight(v))
			inoderTrav(v.getRight());
	}//g
	
	
	TreeNode findNode;	//h, i �Լ��� ���� ã�� ��带 ��Ƶδ� ����
	
	private TreeNode reculsiveFinder(TreeNode v, String data)
	{
		if(v.getData().contains(data))	//����� �����Ͱ� �Ű����� �����Ϳ� ��ġ�Ѵٸ�
		{
			findNode = v;
			return v;	//�װ� �����϶�
		}
		if(hasLeft(v))
			reculsiveFinder(v.getLeft(), data);
		if(hasRight(v))
			reculsiveFinder(v.getRight(), data);
		
		//���ýú��ϰ� ����
		
		return null;
	}//h
	
	public TreeNode findNode(String data)
	{
		reculsiveFinder(root, data);
		//���ýú� ���δ��� ���� ���� �� ��尪�� ���������� �����ߴ� findNode�� ��� �����϶�
		
		return findNode;
	}//i
	
	///////////////////////////////////////////////////////////////////////

	public void setCurrentNode(TreeNode v)
	{
		this.currentNode = v;
	}//b
	
	public String getCurrentNodePath()
	{
		Stack path = new Stack();	//�������� �н��� �����ϱ� ���� ����				
		TreeNode temp = this.currentNode;	//�ӽú��� ������ Ŀ��Ʈ��带 �־� ���ÿ� �ֱ� ����
		
		while(temp != null)	//Ŀ��Ʈ�� ���� �ӽú����� (��Ʈ����) ���δ� Ÿ�� �ö� �� ����
		{
			path.push(temp.getData());	//������ ���ڿ��� ���ÿ� �ְ�
			temp = temp.getParent();	//������ �� �θ� �޴´�
		}

		List<String> strings = new LinkedList<>();	//������ ���ڿ��� �ӽ÷� ���� ��Ʈ������
		String message = "/";	//�н������޾� �����Ͽ� ���������� ������ ���ڿ�		
		
		for(int i = 0; path.isEmpty() != true ; i++)	//������ �� �� ����
		{			
		     strings.add((String) path.pop());	//���ÿ��� pop �Ͽ� ��Ʈ���� �ְ�
		     message = String.join("/", strings);	//�� ��Ʈ���� �޼����� �����Ͽ� ������ ���̴�
		}
		
		return message;
		
	}//�ݵ�� ������ ����ؼ� ��θ� ��ȯ�ؾ��Ѵ�
	
	public void parseCommand(String str)
	{
		String strArr[] = str.split(" ");
		
		this.command = strArr[0];

		if(options.isEmpty() == false)
			options.clear();
		//ť ������� ����
		
		for(int i = 1; i<strArr.length; i++)
			this.options.add(strArr[i]);
		//ť�� ��� �ϳ��� �־��ش�
		
	}//B-a
	
	public String getCommand()
	{
		return this.command;
		
	}//B-b
	
	public Queue<String> getOptions()
	{
		return this.options;
	}//B-c


	///////////////////////////////////////////////////////////////////////

	String cmd = this.command;	//Ŀ�ǵ� ����
	String op;	//�ɼ� ����
	
	public void executeCommand(String str)
	{
		parseCommand(str);		
		
		op=options.poll();
		
		if(this.command.equals("ls"))
			executeLs();
		
		else if(this.command.equals("cd"))
			executeCd();
		
		else if(this.command.equals("mkdir"))
			executeMkdir();
		
		else if(this.command.equals("pwd"))
			executePwd();
		
		else if(this.command.equals("whereis"))
			executeWhereis();
		
		else if(this.command.equals("history"));
	}//a
	
	public void executeLs()
	{
		inoderTrav(this.root);	//�ο����� ��� ����Ѵ�
	}//b
	
	public void executeCd()
	{
		this.currentNode.setData((String)this.options.poll());
	}//c
	
	public void executeMkdir()
	{
		
		if(hasLeft(this.currentNode) || hasRight(this.currentNode))	//���丮�� ���� �� �ִ� ���
			System.out.println("Exception!!!");
		
		if(hasLeft(this.currentNode) == false)	//���ʿ� ����
		{
			TreeNode dir = new TreeNode(op, this.currentNode);
			this.currentNode.setLeft(dir);
		}
		else if(hasRight(this.currentNode) == false)	//�����ʿ� ����
		{
			TreeNode dir = new TreeNode(op, this.currentNode);
			this.currentNode.setRight(dir);
		}
	}//d
		
	
	public void executePwd()
	{
		System.out.println(getCurrentNodePath());
	}//e
	
	public void executeWhereis()
	{
		this.currentNode.setData(op);	//currentNode�� �ɼ��� �־ �н��� ���� �� �ֵ���
		System.out.println(getCurrentNodePath());
	}//f


	///////////////////////////////////////////////////////////////////////

}


















