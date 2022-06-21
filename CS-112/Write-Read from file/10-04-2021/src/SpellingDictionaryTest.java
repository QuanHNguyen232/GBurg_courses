import java.util.Calendar;
import java.util.Random;

public class SpellingDictionaryTest {

	public static void main(String[] args) {
		
//		SpellingDictionary sd = new SpellingDictionary();
//		System.out.println(sd.getWordAt(10));
//		System.out.println(sd.getNumWords());
//		System.out.println(sd.lookup("zyme2"));
//		System.out.println(sd.lookup("zyme"));
//		System.out.println(sd.getWordAt(173529));
		
		// From: http://cs.gettysburg.edu/~cpresser/cs112/examples/DictionarySpeedTest.java.html
		final int TRIALS = 10000;
		//get current time
        long t1 = Calendar.getInstance().getTimeInMillis();

        //load the dictionary into memory
        SpellingDictionary words = new SpellingDictionary();

        //get current time
        long t2 = Calendar.getInstance().getTimeInMillis();
        System.out.printf("Dictionary loading time: %d milliseconds.\n", (t2-t1));
        //get current time
        //doing this again since IO can be slow
        long t3 = Calendar.getInstance().getTimeInMillis();
        //stress test
        Random rand = new Random();
        int totalWords = words.getNumWords();
        for(int i = 0; i < TRIALS; i++){
            int n = rand.nextInt(totalWords);
            //get a random word
            String w = words.getWordAt(n);
            //check if it exists (it better)
            if(!words.lookup(w)){
                System.out.println("Word not found (bad).");
            }
        }
        //get current time
        long t4 = Calendar.getInstance().getTimeInMillis();
        System.out.printf("Lookups: %d milliseconds.\n", (t4-t3));


	}

}
