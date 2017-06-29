import java.util.*;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		Map<Integer, String> map = new HashMap<Integer, String>();
		
		map.put(1, "Seoul");
		map.put(100, "Busan");
		map.put(20, "Incheon");
		map.put(30, "Konkuk");
		
		System.out.println(map.values());
		System.out.println(map.keySet());
		
		Iterator<Integer> iter = map.keySet().iterator();
		
		while(iter.hasNext()){
			int key = iter.next();
			String value = map.get(key);
			System.out.println(key + " = " + value);
		}
		
	}
}
