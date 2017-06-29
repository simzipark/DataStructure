
public class List {
	
	ListNode header = new ListNode();
	ListNode trailer = new ListNode();;
	
	public List()
	{
		this.header.setNextNode(trailer);
		this.trailer.setPrevNode(header);
	}
	
	public void setTrailer(ListNode trailer)
	{
		this.trailer = trailer;
	}
	public void setHeader(ListNode header)
	{
		this.header = header;
	}
	//setter
	
	public ListNode getTrailer()
	{
		return this.trailer;
	}
	public ListNode getHeader()
	{
		return this.header;
	}
	//getter header, trailer
	
	public void initialization()
	{
		this.header.setNextNode(trailer);
		this.trailer.setPrevNode(header);
	}//헤더와 트레일러 사이의 연결들을 없애주어 initialization 해준다
	
	public void addLast(String command)
	{
		ListNode node = new ListNode(trailer.getPrevNode(), trailer, command);
		//새로운 노드 생성
		
		trailer.getPrevNode().setNextNode(node);
		trailer.setPrevNode(node);
	}
	//마지막에 새로운 노드를 삽입한다

	public void addFirst(String command)
	{
		ListNode node = new ListNode(header, header.getNextNode(), command);
		//새로운 노드 생성

		header.getNextNode().setPrevNode(node);
		header.setNextNode(node);
	}
	//헤더 다음에 새로운 노드를 삽입한다
	
	public ListNode getNode(int i)
	{
		ListNode temp = header.getNextNode(); //임시변수값 temp에 리스트의 헤더를 넣어 하나씩 넣어 검색 할 수 있도록
		
		for(int index = 0; index < i; index++)	//i번 째 노드를 찾기 위한 변수값 index
		{
			temp = temp.getNextNode();
		}
		return temp;
	}
	
	public void printAllNodes()
	{
		ListNode temp = header.getNextNode();
		while(temp != trailer)
		{
			System.out.println(temp.getCommand());
			temp = temp.getNextNode();
		}
	}//모든 노드를 출력하는 함수

}
