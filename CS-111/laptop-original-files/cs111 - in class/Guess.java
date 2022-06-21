
import java.util.Random;
import java.util.Scanner;

public class Guess {

	public static void main(String[] args) {
		// Get the secret number upper bound from the user
		System.out.print("What is the maximum secret numer? ");
		Scanner in = new Scanner(System.in);
		int maxSecret =  in.nextInt();
		
		// "I'm thinking of a number ... " and instructions
		Random rand = new Random();
		int secret = rand.nextInt(maxSecret) + 1;
		System.out.println("I'm thinking of a number from 1 to " + maxSecret + ".	Try to guess my number.");
		
		// Turn loop - while the user guess is not correct
		int numGuesses = 0;
		boolean isCorrect = false;
		while (!isCorrect) {
			// Prompt the user for a guess and input the guess
			System.out.print("Your guess? ");
			int guess = in.nextInt();
			numGuesses++;
			
			// Check the guess and give user feedback
			if (guess < secret) {	// higher
				System.out.println("Higher");
			}
			else if (guess > secret) {	// Lower
				System.out.println("Lower");
			}
			else {	// Correct
				System.out.println("Correct!");
				isCorrect = true;
			}
		}
		
		System.out.printf("Your guessed it in %d guesses.\n", numGuesses);
		
		
		
		
		
		in.close();
	}

}
