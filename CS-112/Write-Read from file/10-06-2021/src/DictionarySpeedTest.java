import java.util.Calendar;
import java.util.Random;


public class DictionarySpeedTest {

	public static final int TRIALS = 10000*10;

	/**
	 * @param args
	 */
	public static void main(String[] args){
		//get current time
		long t1 = Calendar.getInstance().getTimeInMillis();

		//load the dictionary into memory
		SpellingDictionary1 words = new SpellingDictionary1();
		SpellingDictionary1 words1 = new FastSpellingDictionary();
		
		//get current time
		long t2 = Calendar.getInstance().getTimeInMillis();

		System.out.printf("Dictionary loading time: %d milliseconds.\n", (t2-t1));

		//get current time
		//doing this again since IO can be slow
		long t3 = Calendar.getInstance().getTimeInMillis();

		//stress test
		Random rand = new Random();
		int totalWords = words.getNumWords();
//		int totalW= words1.getNumWords();
		
		for(int i = 0; i < TRIALS; i++){
		    int n = rand.nextInt(totalWords);

		    //get a random word
//		    String w = words.getWordAt(n);
		    String w = words1.getWordAt(n);
		    
		    //check if it exists (it better)
		    if(!words1.lookup(w)){
		    	System.out.println("Word not found (bad).");
		    }
		}

		//get current time
		long t4 = Calendar.getInstance().getTimeInMillis();
		System.out.printf("Lookups: %d milliseconds.\n", (t4-t3));

		
	}

}
