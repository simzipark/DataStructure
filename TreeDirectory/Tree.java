

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Tree {

	private TreeNode root;
	private TreeNode currentNode;
	
	private String command;
	private Queue<String> options;
	
	private List history;
	
	public Tree(String data){
		root = new TreeNode(data, null);
		currentNode = root;
		history = new List();
	}
	
	public TreeNode getRoot(){
		return root;
	}
	public TreeNode parent(TreeNode v){
		return v.getParent();
	}
	public java.util.List<TreeNode> child(TreeNode v){
		return v.getChild_List();
	}
	public boolean isInternal(TreeNode v){
		if(v.getChild_List().isEmpty()){
			return false;
		}
		else return true;
	}
	public boolean isExternal(TreeNode v){
		if(v.getChild_List().isEmpty()){
			return true;
		}
		else return false;
	}
	public boolean isRoot(TreeNode v){
		if(v.getParent()==null){
			return true;
		}
		else return false;
	}
	public TreeNode addChild(TreeNode v,String data){
		TreeNode newNode = new TreeNode(data, v);
		v.getChild_List().add(newNode);
		return newNode;	
	}
	public TreeNode findNodes(String data){
		return recursiveFinder(root,data);
	}
	private TreeNode recursiveFinder(TreeNode v,String data){
		if(v.getData().equals(data))
			return v;
		else{
			if(v.getChild_List().isEmpty())
				return null;
			else{
				
				TreeNode findNode = null;
				
				for(int i =0; i<v.getChild_List().size();i++){
					findNode= this.recursiveFinder(v.getChild_List().get(i), data);
					if(findNode!=null) return findNode;
				}
				return findNode;
			}
			
			
		}
		
	}
	public void setCurrentNode(TreeNode v){
		this.currentNode = v;
	}
	public String getCurrentNodePath(){
		Stack<String> stack = new Stack<>();
		TreeNode tmp = this.currentNode;
		stack.push(tmp.getData());
		while(tmp.getParent()!=null){
			tmp= tmp.getParent();
			stack.push(tmp.getData());
		}
		String path = "";
		while(!stack.isEmpty())
			path = path +"/"+stack.pop();
		return path;
	}
	public String getCommand(){
		return this.command;
	}
	public Queue<String> getOptions(){
		return this.options;
	}
	public void parseCommand(String str){
		this.options = new LinkedList<>();
		String strArr[]=str.split(" ");
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
		else if(this.command.equals("rm"))
			this.executeRm();
		else if(this.command.equals("mv"))
			this.executeMv();
		else if(this.command.equals("cp"))
			this.executeCp();
		options.clear();
	}
	
	private void executeLs(){
		for(int i =0; i<this.currentNode.getChild_List().size();i++){
			System.out.print(this.currentNode.getChild_List().get(i).getData()+" ");
		}
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
			for(int i=0;i<this.currentNode.getChild_List().size();i++){
				if(dir.equals(this.currentNode.getChild_List().get(i).getData())){
					this.currentNode = this.currentNode.getChild_List().get(i);
						return;
					}
				}
			
				System.out.println("Error: invalid option");
			}
		}
	}
	
 

	private void executeMkdir(){
		if(options.size()==0){}
		else{
			String tmp =options.poll();
			for(int i =0; i<this.currentNode.getChild_List().size();i++){
				if(this.currentNode.getChild_List().get(i).getData().equals(tmp)){
					System.out.println("Already exist!");
					return;}
			}
			TreeNode newNode = new TreeNode(tmp, this.currentNode);
			this.currentNode.getChild_List().add(newNode);
			
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
			TreeNode tmp = findNodes(dir);
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
	
	private void executeRm(){
		if(options.size()==0){System.out.println("Error : size 0");}
		
		else if(options.size()==1){
			String tmp = options.poll();
			for(int i=0;i<this.currentNode.getChild_List().size();i++)
				if(this.currentNode.getChild_List().get(i).getData().equals(tmp)){
					TreeNode rmNode = this.currentNode.getChild_List().get(i);
					if(rmNode.getChild_List().isEmpty()){
						this.currentNode.getChild_List().remove(i);
					}// 자식 없는 해당 파일 삭제
					else
						System.out.println("You Can`t remove this DIR!");// 안되는 경우 못지워요!
					
				}
		}
		else if(options.size()==2){
			String tmp = options.poll();
			if(!tmp.equals("-r")){
				System.out.println("Option Error!");// -r 옵션을 쓰지 않음!
				return;
			}
			tmp=options.poll();
			for(int i=0;i<this.currentNode.getChild_List().size();i++){
				if(this.currentNode.getChild_List().get(i).getData().equals(tmp)){
						this.currentNode.getChild_List().remove(i);
						
				}
			}
			
		}
		
	}
	
		private void executeMv(){
			if(options.size()==0){
				System.out.println("Error : size 0");
			}
			else if(options.size()==1){
				System.out.println("Error : size 1");
			}
			else if(options.size()==2){
				String tmp = options.poll();
				int count =0;
				for(int i=0;i<this.currentNode.getChild_List().size();i++){
					if(this.currentNode.getChild_List().get(i).getData().equals(tmp)){
						if(this.currentNode.getChild_List().get(i).getChild_List().isEmpty()){
							tmp=options.poll();
						
							if(findNodes(tmp)!=null){
								findNodes(tmp).getChild_List().add(this.currentNode.getChild_List().get(i));
								this.currentNode.getChild_List().remove(i);
								return;
							}
							else System.out.println("Error:"+tmp+" file Not exist! ");
						}
						else{
							System.out.println("Option Error!!");//자식있으면 옮기기 불가능!
						return;}
						}
					
				count++;		
				}
				if(count==this.currentNode.getChild_List().size())
					System.out.println("Error: Check the directory name!");
			}
			else if(options.size()==3){
				String tmp=options.poll();
				if(!tmp.equals("-r")){
					System.out.println("Option Error!");
					return;
				}
				else{
					int count=0;
					tmp=options.poll();
					for(int i=0;i<this.currentNode.getChild_List().size();i++){
						if(this.currentNode.getChild_List().get(i).getData().equals(tmp)){
							TreeNode mvNode = this.currentNode.getChild_List().get(i);
							tmp=options.poll();
							if(findNodes(tmp)!=null){
							findNodes(tmp).getChild_List().add(this.currentNode.getChild_List().get(i));
							this.currentNode.getChild_List().remove(i);return;
							}//else
								//System.out.println("Error: Check the directoryname!");
						}
						count++;
					
					}
					if(count ==this.currentNode.getChild_List().size())
						System.out.println("Error: Check the directoryname!");
				}//-r을 썼을 경우!
			}
		}
		
		private void executeCp(){

			if(options.size()==0){
				System.out.println("Error : size 0");
			}
			else if(options.size()==1){
				System.out.println("Error : size 1");
			}
			else if(options.size()==2){
				String tmp = options.poll();
				int count =0;
				for(int i=0;i<this.currentNode.getChild_List().size();i++){
					if(this.currentNode.getChild_List().get(i).getData().equals(tmp)){
						if(this.currentNode.getChild_List().get(i).getChild_List().isEmpty()){
							tmp=options.poll();
						
							if(findNodes(tmp)!=null){
								findNodes(tmp).getChild_List().add(this.currentNode.getChild_List().get(i));
								return;
							}
							else System.out.println("Error:"+tmp+" file Not exist! ");
						}
						else{
							System.out.println("Option Error!!");//자식있으면 옮기기 불가능!
						return;}
						}
					
				count++;		
				}
				if(count==this.currentNode.getChild_List().size())
					System.out.println("Error: Check the directory name!");
			}
			else if(options.size()==3){
				String tmp=options.poll();
				if(!tmp.equals("-r")){
					System.out.println("Option Error!");
					return;
				}
				else{
					int count=0;
					tmp=options.poll();
					for(int i=0;i<this.currentNode.getChild_List().size();i++){
						if(this.currentNode.getChild_List().get(i).getData().equals(tmp)){
							TreeNode mvNode = this.currentNode.getChild_List().get(i);
							tmp=options.poll();
							if(findNodes(tmp)!=null){
							findNodes(tmp).getChild_List().add(this.currentNode.getChild_List().get(i));
							return;
							}//else
								//System.out.println("Error: Check the directoryname!");
						}
						count++;
					
					}
					if(count ==this.currentNode.getChild_List().size())
						System.out.println("Error: Check the directoryname!");
				}
			}
		
			
		}
	
	
	 
	
}
