import java.util.*;

public class Vertex<T1, T2> {

	private T1 element;
	private HashMap<T1, T2> edgeList = new HashMap<>();
	//have to initialize 'edgeList'

	public Vertex(T1 ele){
		this.element = ele;
	}
	//have to initialize 'Vertex'
	
	public T1 getElement(){
		return this.element;
	}

	public void addEdge(T1 edge,T2 value){
		edgeList.put(edge, value);
		//edgeList.keySet();
	}
	
	public HashMap<T1, T2> getEdgeList(){
		return this.edgeList;
	}
	
	public void printEdgeList(){
		
		Iterator<T1> iter = (Iterator<T1>) edgeList.keySet().iterator();
		while(iter.hasNext()){
			T1 e = iter.next();
			System.out.print("-->");
			System.out.print(e+"("+edgeList.get(e)+")");
		}
	}
	//HashMap can read by using Iterator
	//set iterator T1 and contain HashMap's key
	//and in while loop, make temp value 'e' and contain iterator's next content
}
