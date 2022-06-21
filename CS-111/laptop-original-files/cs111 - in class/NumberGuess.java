
import java.util.Random;
import java.util.Scanner;

public class NumberGuess {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int maxSecret = 10;
		int minSecret = 1;
		System.out.println("I'm thinking of a number from " + minSecret + "-" + maxSecret + ".");
		
		Random rand = new Random();
		int exactValue = 1 + rand.nextInt(maxSecret);
		
		System.out.println(exactValue);
		
		System.out.print("Your guess? ");
		int yourGuess = in.nextInt();
		
		if (yourGuess == exactValue) {
			System.out.println("Correct!");
		}
		else if (yourGuess < exactValue) {
			System.out.println("Higher.  Thus, my number is at least " + (yourGuess + 1) + " and at most " + maxSecret + ".");
		}
		else {
			System.out.println("Lower.  Thus, my number is at least " + minSecret + " and at most " + (yourGuess - 1) + ".");
		}
		
		
		
		
		
		
		in.close();
	}

}
