
import java.util.Scanner;
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scanner = new Scanner(System.in);		
		LinkedList list = new LinkedList();
		
		System.out.println("ù �ܾ� �Է� : ");
		list.addLast(scanner.next());
		
		
		while(true)
		{
			System.out.println("���� �ܾ� �Է� : ");
			String nextWord = scanner.next();
			
			if(nextWord.equals("exit"))
			{
				System.out.println("*����*");
				break;
			}
			
			else
			{
				String temp; 
				temp = list.trailer.getPrev().getString();
				
				//if(temp.regionMatches(temp.length()-1, nextWord, 0, 1))	
				if(temp.charAt(temp.length()-1) == nextWord.charAt(0))
				{
					if(list.isEqual(nextWord))
						System.out.println("*�ߺ� �ܾ�*");		
					
					else	
						list.addLast(nextWord);									
				}//if		
			}//else			
		}//while
		
		System.out.println("*���*");
		list.printAlWords();
}
	
}
