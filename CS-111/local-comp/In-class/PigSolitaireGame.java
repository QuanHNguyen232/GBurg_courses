import java.util.Random;

public class PigSolitaireGame {

	public static void main(String[] args) {
		Random rand = new Random();
		
		int score = 0;
		int turnTotal = 0;
		int roll;

		while (score < 100) {
			turnTotal = 0;
			roll = 0;
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
			System.out.println("Turn total: " + turnTotal);
			System.out.println("New score: " + (score));
		}
		
		
		
		
		
		
		
		
		
		
		
	}

}
