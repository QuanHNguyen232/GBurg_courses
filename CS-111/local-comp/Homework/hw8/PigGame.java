import java.util.Random;
import java.util.Scanner;

public class PigGame {

	public static void main(String[] args) {
		Random rand = new Random();
		Scanner in = new Scanner(System.in);

		// which player the user will be?
		int a = rand.nextInt(2) + 1;
		System.out.printf("You will be player %d.\n", a);
		System.out.println("Enter nothing to roll; enter anything to hold.");

		// Game
		int score = 0;
		int player1 = 0;
		int player2 = 0;
		int turn = 0;

		while (player2 < 100 && player1 < 100) {
			// Print score before turn
			System.out.println("Player 1 score: " + player1);
			System.out.println("Player 2 score: " + player2);

			// Switch Turn
			if (turn%2 == 0) {
				System.out.println("It is player 1's turn.");
				score = player1;
			}
			else {
				System.out.println("It is player 2's turn.");
				score = player2;
			}

			// Roll
			int turnTotal = 0;
			int roll = 0;
			String s = "";
			while (s.length()==0 && (turnTotal < 20) && (score + turnTotal < 100)) {
				roll = rand.nextInt(6)+1;
				System.out.println("Roll: " + roll);
				if (roll != 1) {
					turnTotal += roll;
					if ((a==1&&turn%2==0) || (a==2&&turn%2==1)) {
						System.out.print("Turn total: " + turnTotal + "\tRoll/Hold? ");
						s = in.nextLine();
					}
				}
				else {
					turnTotal = 0;
					break;
				}
			}
			score += turnTotal;

			// Print result
			System.out.println("Turn total: " + turnTotal);
			System.out.println("New score: " + (score));

			// Switch turn
			if (turn%2 == 0) {
				player1 = score;
			}
			else {
				player2 = score;
			}
			turn++;
		}







		in.close();
	}

}
