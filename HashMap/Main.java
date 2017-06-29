import java.util.*;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Graph<String, Integer> graph = new Graph<>();
		
//		System.out.println("Test Code");
//		System.out.println("===== print Graph =====");
//		graph.addVertex("A");
//		graph.addVertex("B");
//		graph.addVertex("C");
//		graph.addEdge("A", "B", 1);
//		graph.addEdge("B", "C", 3);
//		graph.addEdge("C", "A", 4);
//		graph.printGraph();
		
		graph.addVertex("건대입구"); graph.addVertex("성수");
		graph.addVertex("구의");	graph.addVertex("강변");
		graph.addVertex("뚝섬");	graph.addVertex("한양대");
		graph.addVertex("왕십리 ");	graph.addVertex("상왕십리 ");
		graph.addVertex("응답");	graph.addVertex("신답");
		graph.addVertex("마장");	graph.addVertex("행당");
		graph.addVertex("답십리");	graph.addVertex("장한평");
		graph.addVertex("군자");	graph.addVertex("아차산");
		graph.addVertex("뚝섬유원지");	graph.addVertex("어린이대공원");
		graph.addVertex("중곡");
		graph.printVertices();
		
		Integer[][] table = 
			{
					{0,2,3,0,0,0,0,0,0,0,0,0,0,0,0,0,2,2,0},
					{2,0,0,0,1,0,0,0,3,0,0,0,0,0,0,0,0,0,0},
					{3,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
					{0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
					{0,1,0,0,0,2,0,0,0,0,0,0,0,0,0,0,0,0,0},
					{0,0,0,0,2,0,2,0,0,0,0,0,0,0,0,0,0,0,0},
					{0,0,0,0,0,2,0,1,0,0,2,2,0,0,0,0,0,0,0},
					{0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0},
					{0,3,0,0,0,0,0,0,0,2,0,0,0,0,0,0,0,0,0},
					{0,0,0,0,0,0,0,0,2,0,0,0,0,0,0,0,0,0,0},
					{0,0,0,0,0,0,2,0,0,0,0,0,2,0,0,0,0,0,0},
					{0,0,0,0,0,0,2,0,0,0,0,0,0,0,0,0,0,0,0},
					{0,0,0,0,0,0,0,0,0,0,2,0,0,3,0,0,0,0,0},
					{0,0,0,0,0,0,0,0,0,0,0,0,3,0,3,0,0,0,0},
					{0,0,0,0,0,0,0,0,0,0,0,0,0,3,0,2,0,2,2},
					{0,0,0,0,0,0,0,0,0,0,0,0,0,0,2,0,0,0,0},
					{2,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
					{2,0,0,0,0,0,0,0,0,0,0,0,0,0,2,0,0,0,0},
					{0,0,0,0,0,0,0,0,0,0,0,0,0,0,2,0,0,0,0}};
		
		graph.convertGraph(table);
		graph.printGraph();
		System.out.println("=====DFS=====");
		graph.depthFirstSearch("건대입구", "성수");
		
		/*graph.printTranslateStation();
    	graph.getTime("�Ǵ��Ա�");
    	graph.pathFind("�Ǵ��Ա�","������");*/
	}
}
