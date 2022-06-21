
import java.util.Random;
import java.util.Scanner;

public class RockPaperScissors {

	public static void main(String[] args) {
		// User's input
		Scanner in = new Scanner(System.in);
		System.out.print("Please enter 0 (rock), 1 (paper), or 2 (scissors): ");
		int p1 = in.nextInt();
		
		// Computer's input
//		int min = 0;
//		int max = 2;
//		int numValue = max - min + 1;
//		int p2 = min + (int) (numValue * Math.random());
		
		Random random = new Random();
		int p2 = random.nextInt(3);
		System.out.println("I played " +  (p2 == 0 ? "rock" : (p2 == 1 ? "paper" : "scissors"))	+ ".");
//		if (p2 == 0) {
//			System.out.println("I played rock.");
//		}
//		else if (p2 == 1) {
//			System.out.println("I played paper.");
//		}
//		else {
//			System.out.println("I played scissors.");
//		}
		
		
		
		if ((p1 - p2 +3)%3 == 0) {
			System.out.println("Draw.");
		}
		else if ((p1 - p2 +3)%3 == 1) {
			System.out.println("You win.");
		}
		else {
			System.out.println("You lose.");
		}
		
		
		
		
		
		in.close();
	}

}
