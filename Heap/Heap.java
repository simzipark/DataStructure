
public class Heap {
	
	private int[] data;
	private int size;
	private int maximumSize;

	public Heap()	{
		this.maximumSize = 127;
		this.data = new int[maximumSize];
		this.size = 0;
	}
	
	public Heap(int maximumSize){
		if(maximumSize < 1)
			this.maximumSize = 127;
		else
			this.maximumSize = maximumSize;
		
		this.size = 0;
		this.data = new int[this.maximumSize];
	}
	
	public boolean isEmpty(){
		return size == 0;
	}
	
	public boolean isFull(){
		return this.size == this.maximumSize;
	}
	
	public void clear(){
		data = null;
		size = 0;
	}
	
	public void insert(int newValue){
		int pointer;
		if(isFull())
			System.out.println("Heap is already Full.");
		else{
			data[size] = newValue;
			pointer = size;
			size ++;
			
			while(pointer > 0 && data[pointer] < data[(pointer-1)/2]){
				//util pointer is not root && pointer's data smaller than pointer's parent data
				//this while syntax is upBubbling
				int temp = data[pointer];
				data[pointer] = data[(pointer-1)/2];
				data[(pointer-1)/2] = temp;
				pointer = (pointer-1)/2;
			}
		/*
		else{
			data[size] = newValue;
			this.upBubbling();
			size++;
		}
		*/		
		}
	}

	/*
	private void upBubbling(){
		int pointer = size;

		while((pointer > 0) && (data[pointer] < data[pointer-1]/2)){
			int temp = data[(pointer-1)/2];
			
			data[(pointer-1)/2] = data[pointer];
			data[pointer] = temp;
			pointer = (pointer-1)/2;
		}
	}
	*/
	
	public void downBubbling() {
		int pointer = 0;
		int childValue = 0;
		
		while(pointer*2+2 < size) {
			if(data[pointer*2+1] < data[pointer*2+2])	//if L-child is smaller than R-child, chilValue will be 1.
				childValue = 1;
			else
				childValue = 2;
		
		
		int temp = data[pointer];	//get temp
		data[pointer] = data[pointer*2+childValue];	//insert smaller childValude in parent
		data[pointer*2+childValue] = temp;	//and than, insert original parent there
		pointer = pointer*2+childValue;	//down to child floor
		
		}
	}
	
	public int remove(){
		int retValue;
		
		if(isEmpty()){
			System.out.println("Heap is already Empty.");
			return -1;
		}
		else {
			retValue = data[0];
			size--;
			data[0] = data[size];
			data[size] = 0;
			this.downBubbling();
		}

		return retValue;
	}
	
	public void printAll() {
		int pointer = 0;
		while(pointer < size){
			System.out.print(data[pointer] + " ");
			pointer++;
		}
		System.out.println();
	}
	
	public int[] heapSort(int[] arr){
				
		Heap heap = new Heap();
		int[] ret = new int[arr.length];
		
		for(int i = 0; i<arr.length; i++)
			heap.insert(arr[i]);
		
		for(int i = 0; i<arr.length; i++)
			ret[i] = heap.remove();
		
		return ret;
	}
}
