
public class ListNode {
	
	private String command;
	private ListNode nextNode;
	private ListNode prevNode;
	
	public ListNode()
	{
		this.command = null;
		this.nextNode = null;
		this.prevNode = null;
	}//持失切
	
	public ListNode(ListNode prevNode, ListNode nextNode, String command)
	{
		this.command = command;
		this.nextNode = nextNode;
		this.prevNode = prevNode;
	}//持失切2
	
	public void setNextNode(ListNode nextNode)
	{
		this.nextNode = nextNode;
	}
	public void setPrevNode(ListNode prevNode)
	{
		this.prevNode = prevNode;
	}
	//setter
	
	public String getCommand()
	{
		return this.command;
	}
	public ListNode getNextNode()
	{
		return this.nextNode;
	}
	public ListNode getPrevNode()
	{
		return this.prevNode;
	}
	//getter
	
}
