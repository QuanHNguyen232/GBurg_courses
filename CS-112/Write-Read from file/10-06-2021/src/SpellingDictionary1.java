import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;


public class SpellingDictionary1 {
	//public static final String DICTIONARY_FILE = "/Courses/cs112/ENABLE";
//	public static final String DICTIONARY_FILE = "../ENABLE.txt";
	public static final String DICTIONARY_FILE = "../10-04-2021/src/ENABLE.txt";	// "/Accounts/turing/students/s24/nguyqu03/CS 112/10-04-2021/src/ENABLE.txt"
	protected ArrayList<String> words;
	
	
	public SpellingDictionary1(){
		words = new ArrayList<String>();
		try {
			Scanner inFromFile = new Scanner(new File(DICTIONARY_FILE));
		
			while(inFromFile.hasNext()){
				words.add(inFromFile.next());
			}
			
			inFromFile.close();
		}
		catch(FileNotFoundException e){
			System.out.println("Unable to open dictionary file.");
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
	
	
    //get a word at a given index
    public String getWordAt(int i){
    	return words.get(i);
    }

    public int getNumWords(){
    	return words.size();
    }

}
