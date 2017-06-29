
public class Dictionary {

	DictionalyNode header = new DictionalyNode();
	DictionalyNode trailer = new DictionalyNode();
		
	public Dictionary(){
		header.setNext(trailer);
		trailer.setPrev(header);
	}
	
	public void insert(int k, String v){
		DictionalyNode node = new DictionalyNode(k, v);
		
		node.setPrev(this.trailer.getPrev());
		node.setNext(this.trailer);
		
		this.trailer.getPrev().setNext(node);
		this.trailer.setPrev(node);
		
	}
	
	public void remove(int k){
		DictionalyNode temp = header.getNext();
		
		while(temp!=trailer){
			if(temp.getKey()==k){
				temp.getPrev().setNext(temp.getNext());
				temp.getNext().setPrev(temp.getPrev());
			}
			temp = temp.getNext();
		}
	}
	
	public void print(){
		DictionalyNode temp = header.getNext();
		
		while(temp!=trailer){
			/*
			System.out.print("key : " + temp.getKey() + ", value : " + temp.getValue);
			temp = temp.getNext();
			*/
			String[] arr = temp.getString();
			for(int i = 0; i<10; i++){
				if(arr[i]!=null)
					System.out.print("("+temp.getKey()+", "+arr[i]+")");
			}
			temp = temp.getNext();
		}
		System.out.println("");
	}
	
	public String find(int k){
		DictionalyNode temp = header.getNext();
		
		while(temp!=trailer){
			if(temp.getKey()==k){
				String[] arr = temp.getString();
				return arr[0];
			}	
			temp = temp.getNext();
		}
		return null;
	}

	/*
	public String find(String key){
		DictionalyNode temp = header.getNext();
		Strung rtValue = "";

		while(temp!=trailer){
			if(key.equls(temp.getKey())){
				rtValue = temp.getValue();
				findOf = true;
				break;
			}
			temp = temp.getNext;
		}
		return reValue;
	}
	*/
	
	public String[] findAll(int k){
		DictionalyNode temp = header.getNext();
		
		while(temp!=trailer){
			if(temp.getKey()==k){
				return temp.getString();
			}
			temp = temp.getNext();
		}
		return null;
	}
	

}
