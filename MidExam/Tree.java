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
		TreeNode node = new TreeNode(data, v);	//v를 부모로 하는 새로운 자식노드를 생성
		
		if(hasLeft(v))
		{
			System.out.println("이미 왼쪽 자식이 있어 추가하지 못합니다.");
			return null;
		}//왼쪽에 자식이 있으면 널을 출력하고 추가못함
		
		else
		{
			v.setLeft(node);
			return node;
		}//왼쪽에 자식이 없으면 새로운 노드를 v에 연결시켜주고 새로운노드 리턴
	}//e
	
	public TreeNode addRight(TreeNode v, String data)
	{
		TreeNode node = new TreeNode(data, v);	//v를 부모로 하는 새로운 자식노드를 생성
		
		if(hasRight(v))
		{
			System.out.println("이미 오른쪽 자식이 있어 추가하지 못합니다.");
			return null;
		}//오른쪽에 자식이 있으면 널을 출력하고 추가못함
		
		else
		{
			v.setRight(node);
			return node;
		}//오른쪽에 자식이 없으면 새로운 노드를 v에 연결시켜주고 새로운노드 리턴
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
	
	
	TreeNode findNode;	//h, i 함수를 위해 찾은 노드를 담아두는 변수
	
	private TreeNode reculsiveFinder(TreeNode v, String data)
	{
		if(v.getData().contains(data))	//노드의 데이터가 매개변수 데이터와 일치한다면
		{
			findNode = v;
			return v;	//그걸 리턴하라
		}
		if(hasLeft(v))
			reculsiveFinder(v.getLeft(), data);
		if(hasRight(v))
			reculsiveFinder(v.getRight(), data);
		
		//리컬시브하게 수행
		
		return null;
	}//h
	
	public TreeNode findNode(String data)
	{
		reculsiveFinder(root, data);
		//리컬시브 파인더를 통해 구한 그 노드값을 전역변수로 선언했던 findNode에 담아 리턴하라
		
		return findNode;
	}//i
	
	///////////////////////////////////////////////////////////////////////

	public void setCurrentNode(TreeNode v)
	{
		this.currentNode = v;
	}//b
	
	public String getCurrentNodePath()
	{
		Stack path = new Stack();	//스택으로 패스를 저장하기 위해 선언				
		TreeNode temp = this.currentNode;	//임시변수 템프에 커렌트노드를 넣어 스택에 넣기 귀함
		
		while(temp != null)	//커렌트를 넣은 임시변수가 (루트까지) 전부다 타고 올라갈 때 까지
		{
			path.push(temp.getData());	//템프의 문자열을 스택에 넣고
			temp = temp.getParent();	//템프는 그 부모를 받는다
		}

		List<String> strings = new LinkedList<>();	//스택의 문자열을 임시로 받을 스트링변수
		String message = "/";	//패스들을받아 저장하여 최종적으로 리턴할 문자열		
		
		for(int i = 0; path.isEmpty() != true ; i++)	//스택이 빌 때 까지
		{			
		     strings.add((String) path.pop());	//스택에서 pop 하여 스트링에 넣고
		     message = String.join("/", strings);	//그 스트링을 메세지에 저장하여 리턴할 것이다
		}
		
		return message;
		
	}//반드시 스택을 사용해서 경로를 반환해야한다
	
	public void parseCommand(String str)
	{
		String strArr[] = str.split(" ");
		
		this.command = strArr[0];

		if(options.isEmpty() == false)
			options.clear();
		//큐 사용전에 비우고
		
		for(int i = 1; i<strArr.length; i++)
			this.options.add(strArr[i]);
		//큐에 요소 하나씩 넣어준다
		
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

	String cmd = this.command;	//커맨드 저장
	String op;	//옵션 저장
	
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
		inoderTrav(this.root);	//인오더로 모두 출력한다
	}//b
	
	public void executeCd()
	{
		this.currentNode.setData((String)this.options.poll());
	}//c
	
	public void executeMkdir()
	{
		
		if(hasLeft(this.currentNode) || hasRight(this.currentNode))	//디렉토리가 가득 차 있는 경우
			System.out.println("Exception!!!");
		
		if(hasLeft(this.currentNode) == false)	//왼쪽에 생성
		{
			TreeNode dir = new TreeNode(op, this.currentNode);
			this.currentNode.setLeft(dir);
		}
		else if(hasRight(this.currentNode) == false)	//오른쪽에 생성
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
		this.currentNode.setData(op);	//currentNode에 옵션을 넣어서 패스를 찍을 수 있도록
		System.out.println(getCurrentNodePath());
	}//f


	///////////////////////////////////////////////////////////////////////

}


















