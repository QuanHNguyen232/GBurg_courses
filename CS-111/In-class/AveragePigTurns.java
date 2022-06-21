import java.util.Random;
import java.util.Scanner;

public class AveragePigTurns {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.print("Games? ");
		int numGames = in.nextInt();
		
		System.out.println("Average turns: " + getAverageTurns(numGames));
		
		
		
		
		
		
		
		
		
		
		
		in.close();
	}
	
	public static double getAverageTurns(int numGames) {
		int totalTurn = 0;
		for (int i = 1; i <= numGames; i++) {
			Random rand = new Random();
			// Initialization
			int score = 0;
			int turnTotal = 0;
			int roll;
			
			while (score < 100) {
				totalTurn++;
				turnTotal = 0;
				roll = 0;
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
			}
		}
		
		return (totalTurn/ (double)numGames);
	}

}
