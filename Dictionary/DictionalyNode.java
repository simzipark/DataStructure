
public class DictionalyNode {
	
	private DictionalyNode prev;
	private DictionalyNode next;
	private int key;
	private String arr[] = new String[10];
	
	public DictionalyNode(){
		this.prev = null;
		this.next = null;
		this.key = 0;
		this.arr[0] = null;
	}
	//initialization1
	
	public DictionalyNode(int key, String value){
		this.prev = null;
		this.next = null;
		this.key = key;
		this.arr[0] = value;
	}
	//initialization2
	
	public void setPrev(DictionalyNode p){
		this.prev = p;
	}
	public void setNext(DictionalyNode n){
		this.next = n;
	}
	public DictionalyNode getPrev(){
		return this.prev;
	}
	public DictionalyNode getNext(){
		return this.next;
	}
	public int getKey(){
		return this.key;
	}
	public String[] getString(){
		return this.arr;
	}
	//Setter, Getter

}
