
import java.util.Scanner;

public class Guess2 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int max;
		int min=1;
		String s = " ";
		int numGuess = 0;
		int compNum = 0;
		
		System.out.print("I'm thinking of a number from 1 to " );
		max = in.nextInt();
		
		do {
			// Computer guess
			System.out.println("min: " + min + "; max: " + max);
			compNum = (min + max)/2;
			System.out.print("I guess " + compNum);
			numGuess++;
			
			// Check if correct
			System.out.print(". [h]igher, [l]ower, [c]orrect? ");
			
			s = in.nextLine().toLowerCase().substring(0);
			in.next();

//			s = in.next().toLowerCase().substring(0);
			
			System.out.println("s: " + "[" + s + "]");
			
			// Change min and max
			if (s.startsWith("h")) {
				min = compNum + 1;
			}
			if (s.startsWith("l")) {
				max = compNum - 1;
			}

			
		} while (!s.startsWith("c"));
		
		
		
		
		System.out.println("I guess in " + numGuess + " times.");
		
		
		
		in.close();
	}

}
