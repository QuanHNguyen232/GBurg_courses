import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class SpellingDictionary {
	
	// field
	private final String FILE_SOURCE = "/Accounts/turing/students/s24/nguyqu03/CS 112/10-04-2021/src/ENABLE.txt";
	private ArrayList<String> wordList = new ArrayList<String>();
	
	
	
	// constructor
	// open file ../ENABLE and read words in the ArrayList
	public SpellingDictionary () {
		Scanner in;
		try {
			in = new Scanner(new File(FILE_SOURCE));
			while (in.hasNext()) {
				wordList.add(in.next());
			}
		} catch (FileNotFoundException e) {
			System.out.println(e + " cannot find file at " + FILE_SOURCE);
		}
		
	}
	
	
	
	
	
	// method
	
	// boolean method lookup(String word) returns true if the word is in the dictionary
	public boolean lookup(String word) {
//		for (String s : wordList) {
//			if (s.equalsIgnoreCase(word)) {
//				return true;
//			}
//		}
		// Faster way:
		for (int i=0; i<wordList.size(); i++) {
			if (wordList.get(i).equalsIgnoreCase(word)) {
				return true;
			}
		}
		return false;
	}
	
	// String getWordAt(int index) returns the words stored at a given index
	public String getWordAt(int index) {
		try {
			return wordList.get(index);
		}
		catch (IndexOutOfBoundsException ioobe) {
			throw new IndexOutOfBoundsException("index must be >= 0 and <= 173528");
		}
	}
	
	// Int getNumWord() returns the number of words
	public int getNumWords() {
		return wordList.size();
	}
	
	
	
//	public static void main(String[] args) {
//	}

}
