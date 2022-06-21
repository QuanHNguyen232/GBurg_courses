
import java.util.Scanner;

public class PigAdvisor {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.print("Player's score? ");
		int i = in.nextInt();
		System.out.print("Opponent's score? ");
		int j = in.nextInt();
		System.out.print("Turn total? ");
		int k = in.nextInt();
		
		if (i + k >= 100) {
			System.out.println("hold");
		}
		else if (i >= 71 || j >= 71) {
			System.out.println("roll");
		}
		else if (k < 21 + Math.round((j-i)/8.0) ) {
			System.out.println("roll");
		}
		else {
			System.out.println("hold");
		}
		
		
		in.close();
	}

}
