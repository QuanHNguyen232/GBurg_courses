import java.util.Random;
import java.util.Scanner;

public class PigTurn2 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		Random rand = new Random();
		
		System.out.print("Score? ");
		int score = in.nextInt();
		
		
		// Calculate Turntotal
		int turnTotal = 0;
		int roll;
		while ((turnTotal < 20) && (score + turnTotal < 100)) {
			roll = rand.nextInt(6)+1;
			System.out.println("Roll: " + roll);
			if (roll != 1) {
				turnTotal += roll;
			}
			else {
				turnTotal = 0;
				break;
			}
		}
		
		System.out.println("Turn total: " + turnTotal);
		System.out.println("New score: " + (score + turnTotal));
		
		System.out.println();
		


		
		
		
		in.close();
	}

}
