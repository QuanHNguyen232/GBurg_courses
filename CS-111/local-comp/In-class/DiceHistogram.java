import java.util.Random;
import java.util.Scanner;

public class DiceHistogram {

	public static void main(String[] args) {
		Random rand = new Random();
		Scanner in = new Scanner(System.in);
		System.out.print("How many rolls? ");
		int numRolls = in.nextInt();

		int[] score = new int[13];

		for (int i = 0; i < numRolls; i++) {
			int dice1 = rand.nextInt(6) + 1;
			int dice2 = rand.nextInt(6) + 1;
			int sum = dice1 + dice2;
			score[sum]++;
		}

		int maxCount = score[0];
		for (int i = 1; i < score.length; i++) {
			if (maxCount < score[i]) {
				maxCount = score[i];
			}
		}

		System.out.println("Max count: " + maxCount);
		
		
		// Print result
		for (int i = 2; i <= 12; i++) {
			System.out.printf("%2d ", i);
			int count = (int) (60.0 * score[i] / maxCount);
			for (int j = 0; j < count; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		

		in.close();
	}

}
