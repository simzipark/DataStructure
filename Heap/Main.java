
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Heap heap = new Heap();
		
		int[] arr = {22, 28, 6, 9, 29};
		
		for(int i = 0; i<arr.length; i++)
			System.out.print(arr[i] + " / ");
		
		System.out.println("");
		
		int[] ret = heap.heapSort(arr);
		
		
		for(int i = 0; i<ret.length; i++)
			System.out.print(ret[i] + " / ");
	}

}
