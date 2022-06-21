import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class SpellingDictionary {
	public static final String DICTIONARY_FILE = "../10-04-2021/src/ENABLE.txt";	// "/Accounts/turing/students/s24/nguyqu03/CS 112/10-04-2021/src/ENABLE.txt"
	protected ArrayList<String> words;
	
	
	public SpellingDictionary(){
		words = new ArrayList<String>();
		Scanner in = new Scanner(System.in);
		
		while (true) {
			System.out.print("Dictionary filepath: ");
			String dictPath = in.next();
			try {
//				Scanner inFromFile = new Scanner(new File(DICTIONARY_FILE));
				Scanner inFromFile = new Scanner(new File(dictPath));
				while(inFromFile.hasNext()){
					words.add(inFromFile.next());
				}

				inFromFile.close();
				break;
			}
			catch(FileNotFoundException e){
				System.out.println("Unable to open dictionary file.");
			}
		}
	}
	
	public boolean lookup(String word){
		for(String s: words){
			if(s.equalsIgnoreCase(word)){
				return true;
			}
		}
		return false;
	}
	
	public boolean lookupFast(String word){

		int first = 0;
		int last = words.size()-1;
		int mid = (last + first + 1)/2;

		while(first <= last){
			String w = words.get(mid);
			int diff = word.compareTo(w);
			if(diff == 0){
				return true;
			}
			else if(diff < 0){
				last = mid - 1;
			}
			else {
				first = mid + 1;
			}


			mid = (last + first + 1)/2;
		}
		return false;
	}
	
    //get a word at a given index
    public String getWordAt(int i){
    	return words.get(i);
    }

    public int getNumWords(){
    	return words.size();
    }
    
//	public static void main(String[] args) {
//	}

}
