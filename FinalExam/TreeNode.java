import java.util.Iterator;

public class TreeNode {
	
	TreeNode left;
	TreeNode right;
	char data;
	Dictionary words;
	
	public TreeNode(char data){
		this.left=null;
		this.right=null;
		this.data=data;
	}

	public TreeNode getLeft() {
		return left;
	}

	public void setLeft(TreeNode left) {
		this.left = left;
	}

	public TreeNode getRight() {
		return right;
	}

	public void setRight(TreeNode right) {
		this.right = right;
	}

	public char getData() {
		return data;
	}

	public void setData(char data) {
		this.data = data;
	}

	public Dictionary getWords() {
		return words;
	}

	public void setWords(Dictionary words) {
		this.words = words;
	}
	
	
	//page 9
	public void insertWord(String word, String description){
		this.words.insert(word, description);
	}
	
	public WordNode searchWord(String word){
		if(words.find(word)==null)
			return null;
		
		WordNode temp = words.find(word);
		return temp;
	}
	
	//c
	public boolean removeWord(String word){
		if(searchWord(word)==null)
			return false;
		words.remove(word);
		return true;
	}
	
	//d
	public void printAllWord(){
		//딕셔너리가 끝날 때 까지 반복해서 출력 
		words.printList();
	}
	

}
