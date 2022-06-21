import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class SpellCheckFile {
	public static String toLowercaseLetters(String s) {
		s = s.toLowerCase();
		while (s.charAt(s.length()-1) < 'a' || s.charAt(s.length()-1) > 'z') {
			if (s.length()>1) {
				s = s.substring(0, s.length()-1);
			}
			else {
				break;
			}
		}
		return s;
	}
	public static void main(String[] args) {
		// Use the SpellingDictionary and FastSpellingDictionary classes
		Scanner in = new Scanner(System.in);
		String pathName;
		ArrayList<String> wordFindList = new ArrayList<String>();
		int numWordsFounded = 0, totalWords;
		SpellingDictionary dict = new SpellingDictionary();
		
		
		// Collect words that are needed to be found
		while (true) {
			System.out.print("Enter a file: ");
			pathName = in.next();
			try {
				Scanner inFromFile = new Scanner(new File(pathName));
				
				while (inFromFile.hasNext()) {
					String word = toLowercaseLetters(inFromFile.next());
					wordFindList.add(word);
				}
				inFromFile.close();
				break;
				
			} catch (FileNotFoundException e) {
				System.out.println("Cannot open file: " + pathName);
			}
		}
		
		
		// Print result
		totalWords = wordFindList.size();
		while (!wordFindList.isEmpty()) {
			String wordFind = wordFindList.remove(0);
			if (dict.lookupFast(wordFind)) {
				numWordsFounded++;
			}
			else {
				System.out.println(wordFind);
			}
		}
		System.out.printf("%.2f%% are in the dictionary.\n", numWordsFounded*100.0/totalWords);
		
	}
	
// test cases
//	Is instanceof a word?@
//	What is instanceof??
//	aahing@
//	ah4#
//	aa 3!
}
