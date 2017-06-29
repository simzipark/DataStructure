import java.util.*;

public class Graph<T1, T2> {
	
	private ArrayList<Vertex<T1,T2>> vertexList  = new ArrayList<>();
	private Hashtable<T1,T2> visited;

	public Graph(){
		visited = new Hashtable<>();
	}
	
	public void addVertex(T1 ele){
		Vertex<T1,T2> vertex = new Vertex(ele);
		vertexList.add(vertex);
	}

	public void addEdge(T1 v1,T1 v2,T2 value){
		Vertex<T1,T2> vertex = findVertex(v1,false);
		Vertex<T1,T2> vertex2 = findVertex(v2,false);
		vertex.addEdge(v2,value);
		vertex2.addEdge(v1, value);
	}
	
	public void printVertices(){
		System.out.println("=====printVertices=====");
		for(Vertex<T1,T2> vertex :vertexList ){
			System.out.print(vertex.getElement()+" ");			
		}
		System.out.println("");
	}
	
	public void printGraph(){
		System.out.println("=====printGraph=====");
		for(Vertex<T1,T2> vertex :vertexList ){
			System.out.print(vertex.getElement());
			vertex.printEdgeList();
			System.out.println();
		}
	}
	
	public Vertex<T1,T2> findVertex(T1 ele, Boolean print){
		for(int i=0;i<vertexList.size();i++){
			if(vertexList.get(i).getElement().equals(ele)){
				if(print)
					System.out.println(ele);
				return vertexList.get(i);
			}
		}
		return null;
	}


	public void convertGraph(T2[][] data){
		int i = 0;
		for(Vertex<T1,T2> vertex :vertexList ){
				for(int j=0; j<data[i].length; j++){
					if((Integer)data[i][j]!=0)
						this.addEdge(vertex.getElement(), this.vertexList.get(j).getElement(), data[i][j]);
				}
			i++;
		}
	}

	public void depthFirstSearch(T1 ele, T1 from){
		Vertex<T1,T2> vertex = findVertex(ele, false);
		
		System.out.println(vertex.getElement());
		
		this.visited.put(vertex.getElement(), (T2)"???");
		
		Iterator<T1> iter = vertex.getEdgeList().keySet().iterator();		
		while(iter.hasNext()){
			T1 t = iter.next();
			if(!this.visited.containsKey(t))
				depthFirstSearch(t, from);
		}
	}
	
	/*
	public void BreathFirstSearch(T1 ele, T1 ele2){
		//기준지점으로부터 몇정거장 떨어져있는지 출력 
		
	}
	public void printTranslateStation(T1 ele) {
		Vertex<T1,T2> find = this.findVertex(ele, false);
		
		visited.put(find.getElement(), (T2) "juj");
		Iterator<T1> iter = find.getEdgeList().keySet().iterator();
		int count =0;
		while(iter.hasNext()){
			T1 e = iter.next();
			if(!visited.containsKey(e))
				depthFirstSearch(e);
			if(count ==2)
				System.out.println(find.getElement());
			count++;
		}
	}
	
	public void getTime(T1 ele, T1 ele2){
		
	}
	
	public void pathFind(T1 ele, T1 ele2){
		
	}
	*/
}
