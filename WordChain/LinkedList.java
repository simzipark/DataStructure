
public class LinkedList {
	
	Word header = new Word();
	Word trailer = new Word();
	
	public LinkedList()
	{
		header.setNext(trailer);
		trailer.setPrev(header);
	}
	
	public void addLast(String value)
	{
		Word wordNew = new Word(trailer.getPrev(), trailer, value);
		trailer.getPrev().setNext(wordNew);
		trailer.setPrev(wordNew);
	}
	
	public boolean addBefore(int n, String value)
	{
		Word temp = header.getNext();
		
		int index = 0;
		
		while(temp != trailer)
		{
			if(index == n)	
			{
				Word wordNew = new Word(temp.getPrev(), temp, value);
				temp.getPrev().setNext(wordNew);
				temp.setPrev(wordNew);
				return true;
			}
			
			temp = temp.getNext();
			index++;
			
		}//while
		
		return false;
	}
	
	public void printAlWords()
	{
		Word temp = header.getNext();
		
		while(temp != trailer)
		{
			System.out.print(temp.getString()+" ");
			temp = temp.getNext();
		}
		
		System.out.println("");
	}


	public boolean isEqual(String word)
	{
		Word temp = new Word();
		temp = header.getNext();
		
		while(temp != trailer)
		{
			
			if(temp.getString().equals(word))
				return true;
			
			temp = temp.getNext();
		}
		
		return false;
	}
	
	
}
