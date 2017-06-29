

public class ListNode {
	private String command;
	private ListNode prevNode;
	private ListNode nextNode;
	public ListNode() {
		this.command = null;
		this.nextNode = null;
		this.prevNode = null;
	}
	public ListNode(String command, ListNode prevNode, ListNode nextNode) {
		
		this.command = command;
		this.prevNode = prevNode;
		this.nextNode = nextNode;
	}
	public String getCommand() {
		return command;
	}
	public void setCommand(String command) {
		this.command = command;
	}
	public ListNode getPrevNode() {
		return prevNode;
	}
	public void setPrevNode(ListNode prevNode) {
		this.prevNode = prevNode;
	}
	public ListNode getNextNode() {
		return nextNode;
	}
	public void setNextNode(ListNode nextNode) {
		this.nextNode = nextNode;
	}
	
	
	
	
	

}
