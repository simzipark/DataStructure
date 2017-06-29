
public class LinkedList {
	
	Node header = new Node();
	Node trailer = new Node();
	
	public LinkedList()
	{
		header.setNext(trailer);
		trailer.setPrev(header);
	}
	
	public void addLast(String value)
	{
		Node NodeNew = new Node(trailer.getPrev(), trailer, value);
		trailer.getPrev().setNext(NodeNew);
		trailer.setPrev(NodeNew);
	}
	
	public boolean addBefore(int n, String value)
	{
		Node temp = header.getNext();
		
		int index = 0;
		
		while(temp != trailer)
		{
			if(index == n) 
			{
				Node NodeNew = new Node(temp.getPrev(), temp, value);
				temp.getPrev().setNext(NodeNew);
				temp.setPrev(NodeNew);
				return true;
			}
			
			temp = temp.getNext();
			index++;
			
		}//while
		
		return false;
	}
	
	public void printAlNodes()
	{
		Node temp = header.getNext();
		
		while(temp != trailer)
		{
			System.out.print(temp.getString()+" ");
			temp = temp.getNext();
		}
		
		System.out.println("");
	}

}
