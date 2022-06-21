import java.util.Random;
import java.util.Scanner;

public class Flip5 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.print("Bet (0) more tails, or (1) more heads: ");
		int betValue = in.nextInt();
		
		Random rand = new Random();
		int numOfHead = 0;
		
		
		if (betValue != 0 && betValue != 1) {
			System.out.println("Invalid bet.");
		}
		else {
			// 1st
			int flipValue = rand.nextInt(2);
			if (flipValue == 1) {
				System.out.print("H");
				numOfHead += 1;
			}
			else {
				System.out.print("T");
				numOfHead -= 1;
			}
			// 2nd
			flipValue = rand.nextInt(2);
			if (flipValue == 1) {
				System.out.print("H");
				numOfHead += 1;
			}
			else {
				System.out.print("T");
				numOfHead -= 1;
			}
			// 3rd
			flipValue = rand.nextInt(2);
			if (flipValue == 1) {
				System.out.print("H");
				numOfHead += 1;
			}
			else {
				System.out.print("T");
				numOfHead -= 1;
			}
			// 4th
			flipValue = rand.nextInt(2);
			if (flipValue == 1) {
				System.out.print("H");
				numOfHead += 1;
			}
			else {
				System.out.print("T");
				numOfHead -= 1;
			}
			// 5th
			flipValue = rand.nextInt(2);
			if (flipValue == 1) {
				System.out.print("H");
				numOfHead += 1;
			}
			else {
				System.out.print("T");
				numOfHead -= 1;
			}
			
			// print " --> "
			System.out.print(" --> ");
			
			
			// print result
			if (betValue == 0) {	// bet tail
				if (numOfHead == -5 || numOfHead == 5) {
					System.out.print("All flips are the same. You lose.\n");
				}
				else if (numOfHead > 0) {
					System.out.print("You lose.\n");
				}
				else {
					System.out.print("You win!\n");
				}
			}
			else {	// bet head
				if (numOfHead == -5 || numOfHead == 5) {
					System.out.print("All flips are the same. You lose.\n");
				}
				else if (numOfHead > 0) {
					System.out.print("You win!\n");
				}
				else {
					System.out.print("You lose.\n");
				}
			}

		}
		
		
		
		in.close();
	}

}
