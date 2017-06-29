

public class List {

	ListNode header;
	ListNode trailer;
	
	public List(){
		header = new ListNode();
		trailer = new ListNode();
		header.setNextNode(trailer);
		trailer.setPrevNode(header);
	}

	public ListNode getHeader() {
		return header;
	}

	public void setHeader(ListNode header) {
		this.header = header;
	}

	public ListNode getTrailer() {
		return trailer;
	}

	public void setTrailer(ListNode trailer) {
		this.trailer = trailer;
	}
	public void initialization(){
		header.setNextNode(trailer);
		trailer.setPrevNode(header);
	}
	public void addLast(String command){
		ListNode newNode = new ListNode(command, trailer.getPrevNode(), trailer);
		trailer.getPrevNode().setNextNode(newNode);
		trailer.setPrevNode(newNode);
	}
	public void addFirst(String command){
		ListNode newNode = new ListNode(command, header, header.getNextNode());
		header.getNextNode().setPrevNode(newNode);
		header.setNextNode(newNode);
	}
	public ListNode getNode(int i){
		ListNode tmp = new ListNode();
		for(int c=0;c<i;c++){
			tmp=tmp.getNextNode();
		}
		return tmp;
	}
	public void printAllNodes(){
		ListNode temp = header.getNextNode();
		while(temp!=trailer){
			System.out.println(temp.getCommand());// 해당 값 출력
			temp=temp.getNextNode();//다음 노드로 이동
		}
	}
}
