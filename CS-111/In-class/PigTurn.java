import java.util.Random;

public class PigTurn {

	public static void main(String[] args) {
		Random rand = new Random();
		
		int turnTotal = 0;
		int roll;
		
		while (turnTotal < 20) {
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
		
		
		
		
	}

}
