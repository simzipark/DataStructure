
import java.util.Scanner;
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scanner = new Scanner(System.in);		
		LinkedList list = new LinkedList();
		
		System.out.println("첫 단어 입력 : ");
		list.addLast(scanner.next());
		
		
		while(true)
		{
			System.out.println("다음 단어 입력 : ");
			String nextWord = scanner.next();
			
			if(nextWord.equals("exit"))
			{
				System.out.println("*종료*");
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
						System.out.println("*중복 단어*");		
					
					else	
						list.addLast(nextWord);									
				}//if		
			}//else			
		}//while
		
		System.out.println("*기록*");
		list.printAlWords();
}
	
}
