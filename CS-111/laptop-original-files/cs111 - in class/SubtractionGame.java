
import java.util.Scanner;

public class SubtractionGame {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		// Input and Instruction
		int maxPieces = 6;
		System.out.println("Subtraction Game: Starting with some number of pieces,");
		System.out.println("two players take turns removing 1-" + maxPieces + " pieces at a time.");
		System.out.println("The player that removes the last piece wins.");
		System.out.print("How many pieces remain? ");
		int numPieces = in.nextInt();
		int numRemove = numPieces % (maxPieces + 1);
		
		// The advice
		if (numPieces <= maxPieces) {
			System.out.println("Remove all.");
		}
		else if (numRemove == 0){
			System.out.println("Remove 1.");
		}
		else {
			System.out.println("Remove " + numRemove);
		}
		
		
		in.close();
	}

}
