import java.util.Arrays;
import java.util.Random;

public class YahtzeeScoring {

	public static void main(String[] args) {
		
		// Arrays are fixed-length _list_of same-type data
		// Arrays are object (like Strings) so array variables can contain references to the array object location
		// Usual syntax for declaration and initialization of an array:
		// - <type>[] <var. name> = new <type>[<length>];  
		
		// generate rolls for 5 6-sided dice
		int[] roll = new int[5];
		
		// Also legal:
//		int[] roll;	// roll == null (i.e. no object reference) and is later initialized
//		int[] roll = {0, 0, 0, 0, 0};
//		roll = new int[] {1, 2, 3, 4, 5};	// dynamically with array literal
		
		Random rand = new Random();
		for (int i = 0; i < roll.length; i++) {	// .length: array length
			roll[i] = rand.nextInt(6) + 1;	// writing to an array
		}
		roll = new int[] {2, 1, 4, 5, 3};
		System.out.println("Hand: " + Arrays.toString(roll));
		
		
		// count how many of each rank have been rolled
		int[] rankCount = new int[7];
//		for (int i = 0; i < roll.length; i++) {
//			rankCount[roll[i]]++;
//		}
		
		int sum = 0;
		for (int rank : roll) {
			rankCount[rank]++;
			sum += rank;
		}
		System.out.println(Arrays.toString(rankCount));
		
		// print upper section scores
		for (int rank = 1; rank <= 6; rank++) {
			System.out.printf("%d's\t\t%d\n", rank, rank * rankCount[rank]);
		}
		
		// compute statistics relevant to lower-section scores
		int[] freqCount = new int[6];
		int maxRankCount = 0, inARow = 0, maxInARow = 0;
		
		for (int rank = 1; rank <= 6; rank++) {
			freqCount[rankCount[rank]]++;
			maxRankCount = Math.max(maxRankCount, rankCount[rank]);
			inARow = (rankCount[rank] > 0) ? inARow +1 : 0;
			maxInARow = Math.max(maxInARow, inARow);
		}
		System.out.println("rankCount: " + Arrays.toString(freqCount));
		
		// print lower-section scores
		System.out.printf("3 of a kind\t%d\n", maxRankCount >= 3 ? sum : 0);
		System.out.printf("4 of a kind\t%d\n", maxRankCount >= 4 ? sum : 0);
		System.out.printf("Full house\t%d\n", ((freqCount[3] == 1) && (freqCount[2] == 1) || (freqCount[5] == 1)) ? 25 : 0);
		System.out.printf("Small straight\t%d\n", maxInARow >= 4 ? 30 : 0);
		System.out.printf("Large straight\t%d\n", maxInARow == 5 ? 40 : 0);
		System.out.printf("Yahtzee\t\t%d\n", maxRankCount == 5 ? 50 : 0);
		System.out.printf("Chance\t\t%d\n", sum);
		
		
	}

}
