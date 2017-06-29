import java.util.*;

public class Dictionary {
	
	DictionaryNode header = new DictionaryNode();
	DictionaryNode trailer = new DictionaryNode();
	
	public Dictionary(){
		
		this.header.setNext(this.trailer);
		this.trailer.setPrev(this.header);
	}
	
	public DictionaryNode searchReculsive(String word, DictionaryNode node){
		if(node.getKey().equals(word))
			return node;
		else
			return searchReculsive(word, node.getNext());
	}
	
	public void insert(String word, String description){
		DictionaryNode node = new DictionaryNode();
		WordNode wnode = new WordNode(word, description);
		node.setDetail(wnode);
		
		node.setPrev(this.trailer.getPrev());
		node.setNext(this.trailer);
		
		this.trailer.getPrev().setNext(node);
		this.trailer.setPrev(node);	
	}
	
	public void remove(String word){
		DictionaryNode node = this.header.getNext();
		
		while(node!=this.trailer){
			if(node.getKey()==word){
				node.getPrev().setNext(node.getNext());
				node.getNext().setPrev(node.getPrev());
			}
			node = node.getNext();
		}
	}
	
	public WordNode find(String word){
		DictionaryNode node = this.header.getNext();
		
		while(node!=this.trailer){
			if(node.getDetail().getWord().equals(word)){
				return node.getDetail();
			}
			node = node.getNext();
		}
		return null;
	}

	public ArrayList<WordNode> findAll(String word){
		DictionaryNode node = this.header.getNext();
		ArrayList<WordNode> ret = new ArrayList<>();
		
		while(node!=this.trailer){
			if(node.getKey()==word){
				ret.add(node.getDetail());
			}
			node = node.getNext();
		}
		return ret;
	}
	
	public void printList(){
		DictionaryNode node = this.header.getNext();
		
		while(node!=this.trailer){
			System.out.println(node.getDetail().getWord());
			node = node.getNext();
		}
	}
}
