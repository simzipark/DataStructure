
public class ArrayList {
	
	private int[] arr = new int[128];
	private int arrayIndex = 0;
	
	public ArrayList()
	{
		for(int i=0; i<arr.length; i++)		
			arr[i] = 0;
		System.out.println("Array is Initialized.");
		
	}
	
	public boolean add(int i, int num)
	{
		if(arr.length-1 <arrayIndex)
		{
			System.out.println("Error : Array is Full");
			return false;
		}
		else
		{
			if(i>arrayIndex||i<0)
			{
				System.out.println("Error : Invalid Index");
				return false;
			}
			else if(i < arrayIndex)
			{
				for(int index=arrayIndex; index>i-1; index--)
					arr[index+1] = arr[index];
			}
			arrayIndex++;
			arr[i] = num;
			return true;
		}
	}
	public int remove(int i)
	{
		int res = arr[i];
		
		if(i>arrayIndex)
		{
			System.out.println("Error : Invalid Index");
			return -1;
		}
		else if(i < arrayIndex)
		{
			for(int index=i; index<arrayIndex; index++)
				arr[index] = arr[index+1];
		}
		arrayIndex--;
		return res;
	}
	public void printAll()
	{
		System.out.print("{");
		for(int i = 0; i<arrayIndex; i++)
		{
			System.out.print(arr[i]);
			if(i<arrayIndex - 1)
				System.out.print(", ");
		}
		System.out.println("}");
	}

}