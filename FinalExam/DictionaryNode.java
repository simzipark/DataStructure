
public class DictionaryNode {
	
	private DictionaryNode prev;
	private DictionaryNode next;
	private String key;
	private WordNode detail;
	
	public DictionaryNode(){
		this.prev = null;
		this.next = null;
		this.key = null;
		//this.detail = new WordNode(null, null);
	}
	
	public DictionaryNode(String key, WordNode detail, DictionaryNode prev, DictionaryNode next){
		this.prev = prev;
		this.next = next;
		this.detail = detail;
		this.key = key;
	}

	public DictionaryNode getPrev() {
		return prev;
	}

	public void setPrev(DictionaryNode prev) {
		this.prev = prev;
	}

	public DictionaryNode getNext() {
		return next;
	}

	public void setNext(DictionaryNode next) {
		this.next = next;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public WordNode getDetail() {
		return detail;
	}

	public void setDetail(WordNode detail) {
		this.detail = detail;
	}
	

}
