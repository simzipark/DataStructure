
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
	}//����� Ʈ���Ϸ� ������ ������� �����־� initialization ���ش�
	
	public void addLast(String command)
	{
		ListNode node = new ListNode(trailer.getPrevNode(), trailer, command);
		//���ο� ��� ����
		
		trailer.getPrevNode().setNextNode(node);
		trailer.setPrevNode(node);
	}
	//�������� ���ο� ��带 �����Ѵ�

	public void addFirst(String command)
	{
		ListNode node = new ListNode(header, header.getNextNode(), command);
		//���ο� ��� ����

		header.getNextNode().setPrevNode(node);
		header.setNextNode(node);
	}
	//��� ������ ���ο� ��带 �����Ѵ�
	
	public ListNode getNode(int i)
	{
		ListNode temp = header.getNextNode(); //�ӽú����� temp�� ����Ʈ�� ����� �־� �ϳ��� �־� �˻� �� �� �ֵ���
		
		for(int index = 0; index < i; index++)	//i�� ° ��带 ã�� ���� ������ index
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
	}//��� ��带 ����ϴ� �Լ�

}
