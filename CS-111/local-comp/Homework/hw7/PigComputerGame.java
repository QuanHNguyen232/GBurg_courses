import java.util.Random;

public class PigComputerGame {

	public static void main(String[] args) {
		Random rand = new Random();

		int score = 0;
		int player1 = 0;
		int player2 = 0;
		int turn = 0;

		while (player2 < 100 && player1 < 100) {
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
			score += turnTotal;
			
			// Print result
			System.out.println("Turn total: " + turnTotal);
			System.out.println("New score: " + (score));
			
			if (turn%2 == 0) {
				player1 = score;
			}
			else {
				player2 = score;
			}
			
			turn++;
		}













	}

}
