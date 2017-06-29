
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BinaryTree {
	private BinaryTreeNode root;
	private BinaryTreeNode currentNode;
	
	private String command;
	private Queue<String> options;
	
	private List history;
	
	public BinaryTree(String data){
		root = new BinaryTreeNode(data, null);
		currentNode = root;
		history = new List();
	}
	public BinaryTreeNode getRoot(){
		return root;
	}
	public boolean hasLeft(BinaryTreeNode v){
		if(v.getLeft()==null)
			return false;
		else return true;
	}
	public boolean hasRight(BinaryTreeNode v){
		if(v.getRight()==null)
			return false;
		else return true;
	}
	public BinaryTreeNode addLeft(BinaryTreeNode v, String data){
		if(hasLeft(v)==false){
			BinaryTreeNode nodeNew = new BinaryTreeNode(data, v);
			v.setLeft(nodeNew);
			return nodeNew;
		}
		else
			return null;
	}
	public BinaryTreeNode addRight(BinaryTreeNode v, String data){
		if(hasRight(v)==false){
			BinaryTreeNode nodeNew = new BinaryTreeNode(data, v);
			v.setRight(nodeNew);
			return nodeNew;
		}
		else
			return null;
	}
	private BinaryTreeNode recursiveFinder(BinaryTreeNode v, String data){
		if(v.getData().equals(data))
			return v;
		else{
			if(hasLeft(v)==false&&hasRight(v)==false){
				return null;
			}
			else{
				BinaryTreeNode findNode=null;
				BinaryTreeNode leftChild=v.getLeft();
				BinaryTreeNode rightChild= v.getRight();
				
				if(leftChild!=null){
					findNode= this.recursiveFinder(leftChild, data);
					if(findNode!=null)return findNode;
				}
				if(rightChild!=null && findNode==null){
					findNode = this.recursiveFinder(rightChild, data);
					if(findNode!=null)return findNode;
				}
				return findNode;
				
			}
		}
	}//recursive
	
	public BinaryTreeNode findNodes(String data){
		return recursiveFinder(root, data);
	}
	
	public void inOrderTrav(BinaryTreeNode v){
		if(hasLeft(v)){
			inOrderTrav(v.getLeft());
		}
		System.out.println(v.getData());
		if(hasRight(v)){
			inOrderTrav(v.getRight());
		}
	}
	
	public void setCurrentNode(BinaryTreeNode v){
		this.currentNode=v;
	}
	public String getCurrentNodePath(){
		Stack<String> stack= new Stack<>();
		BinaryTreeNode tmp = this.currentNode;
		stack.push(tmp.getData());
		while(tmp.getParent()!=null){
			tmp=tmp.getParent();
			stack.push(tmp.getData());
		}
		String path="";
		while(!stack.isEmpty()){
			path=path+ "/"+stack.pop();
		}
		return path;
		
	}
	public String getCommand(){
		return this.getCommand();
	}
	public Queue<String> getOptions(){
		return this.options;
	}
	public void parseCommand(String str){
		this.options = new LinkedList<>();
		String strArr[] = str.split(" ");
		this.command = strArr[0];
		for(int i=1;i<strArr.length;i++){
			this.options.offer(strArr[i]);
		}
	}
	public void executeCommand(String str){
		history.addLast(str);
		parseCommand(str);
		if(this.command.equals("ls"))
			this.executeLs();
		else if(this.command.equals("cd"))
			this.executeCd();
		else if(this.command.equals("mkdir"))
			this.executeMkdir();
		else if(this.command.equals("pwd"))
			this.executePwd();
		else if(this.command.equals("whereis"))
			this.executeWhereis();
		else if(this.command.equals("history"))
			this.executeHistory();
		else{
			System.out.println("===============================================");
			System.out.println("| Usage: [comman] [Option arg]                 |");
			System.out.println("| ->Command list: (pwd, ls, cd, mkdir, whereis)|");
			System.out.println("===============================================");
		}
	}
	
	private void executeLs(){
		if(hasLeft(this.currentNode))
			System.out.print(this.currentNode.getLeft().getData()+" ");
		if(hasRight(this.currentNode))
			System.out.print(this.currentNode.getRight().getData());
		System.out.println("");
	}
	private void executeCd(){
		if(options.size()==0){ System.out.println("Error: size 0");
		
	}
	else{
		String dir =options.poll();
		if(dir.equals("..")){
			if(this.currentNode!=root){
				this.currentNode =this.currentNode.getParent();
			}
		}
		else{
			if(dir.equals(this.currentNode.getLeft().getData())){
				this.currentNode=this.currentNode.getLeft();
			}
			else if(dir.equals(this.currentNode.getRight().getData())){
				this.currentNode=this.currentNode.getRight();
			}
			else{
				System.out.println("Error: invalid option");
			}
		}
	}
	
 }

	private void executeMkdir(){
		if(options.size()==0){}
		else{
			String newdir = options.poll();
			if(hasLeft(this.currentNode)==false){
				addLeft(this.currentNode, newdir);
			}
			else if(hasRight(this.currentNode)==false){
				addRight(this.currentNode, newdir);
			}
			else{
				System.out.println("Error: directory is full");
			}
		}
	
	}
	private void executePwd(){
		System.out.println(getCurrentNodePath());
	}
	private void executeWhereis(){
		if(options.size()==0){}
		else{
			String dir = options.poll();
			
			Stack<String> stack = new Stack<>();
			BinaryTreeNode tmp = findNodes(dir);
			stack.push(tmp.getData());
			while(tmp.getParent()!=null){
				tmp = tmp.getParent();
				stack.push(tmp.getData());
			}
			String path ="";
			while(!stack.isEmpty()){
				path= path+"/"+stack.pop();
			}
			System.out.println(path);
		}
	}
	private void executeHistory(){
		if(options.size()==0){
			ListNode temp = history.getHeader().getNextNode();
			while(temp!=history.getTrailer()){
				System.out.println(temp.getCommand());
				temp=temp.getNextNode();
			}
			
		}
		else{
			String opt =options.poll();
			if(opt.equals("-c")){
				history.initialization();
			}
		}
		
	}
	

	

}
