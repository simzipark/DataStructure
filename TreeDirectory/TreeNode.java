

import java.util.ArrayList;
import java.util.List;


public class TreeNode {
	private String data;
	private TreeNode parent;
	private List<TreeNode> child_List;
	
	public TreeNode(String data, TreeNode parent){
		this.data = data;
		this.parent = parent;
		this.child_List = new ArrayList<TreeNode>();
		
	}
	public TreeNode() {
		this.data= null;
		this.parent=null;
		this.child_List = new ArrayList<TreeNode>();
		
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public TreeNode getParent() {
		return parent;
	}

	public void setParent(TreeNode parent) {
		this.parent = parent;
	}

	public List<TreeNode> getChild_List() {
		return child_List;
	}

	public void setChild_List(List<TreeNode> child_List) {
		this.child_List = child_List;
	}
	
	

}
