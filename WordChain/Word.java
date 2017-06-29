
public class Word {
	
	private String str;
	private Word prev;
	private Word next;
	
	public Word()
	{
		prev = null;
		next = null;
		str = null;
	}
	
	public Word(Word prev, Word next, String str)
	{
		this.prev = prev;
		this.next = next;
		this.str = str;
	}
	
	public void setPrev(Word p)
	{
		prev = p;
	}
	public void setNext(Word n)
	{
		next = n;
	}
	//Link Method
	
	public Word getPrev()
	{
		return prev;
	}
	public Word getNext()
	{
		return next;
	}
	public String getString()
	{
		return str;
	}
	//Get Method

}
