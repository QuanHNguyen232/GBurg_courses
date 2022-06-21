import java.util.Random;
import java.util.Scanner;

public class PigAdvantage {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.print("Games? ");
		int numGames = in.nextInt();

		System.out.println("Probability of first player win: " + getAdvantage(numGames));

		in.close();
	}


	public static double getAdvantage(int numGames) {
		int timesPlay1Win = 0;
		
		for (int i = 1; i <= numGames; i++) {
			Random rand = new Random();

			int score = 0;
			int player1 = 0;
			int player2 = 0;
			int turn = 0;

			while (player2 < 100 && player1 < 100) {
				// Switch Turn
				if (turn%2 == 0) {
					score = player1;
				}
				else {
					score = player2;
				}
				
				// Roll
				int turnTotal = 0;
				int roll = 0;
				while ((turnTotal < 20) && (score + turnTotal < 100)) {
					roll = rand.nextInt(6)+1;
					if (roll != 1) {
						turnTotal += roll;
					}
					else {
						turnTotal = 0;
						break;
					}
				}
				score += turnTotal;
				
				// Update score
				if (turn%2 == 0) {
					player1 = score;
				}
				else {
					player2 = score;
				}
				
				turn++;
			}
			
			// Count times player 1 win
			if (player1 >= 100) {
				timesPlay1Win++;
			}
//			System.out.println("timesPlay1Win: " + timesPlay1Win);

		}
		
		
		return timesPlay1Win/(double) numGames;
	}
}
