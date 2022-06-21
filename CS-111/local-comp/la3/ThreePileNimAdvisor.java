import java.util.Arrays;
import java.util.Scanner;

public class ThreePileNimAdvisor {
	
	/**
	 * Given the number of pieces in each of three Nim piles, return a length 2 array with the pile index and number of pieces
	 * to take for a winning move, or return null if there is no winning move.  If there are multiple winning moves, return
	 * the move with the minimum pile and with the minimum number of pieces taken from that pile.  A winning move
	 * leaves the piles such that the number of pieces in each pile XOR'd (^) together yields a zero value, that is, 
	 * <code>(numPieces[0] ^ numPieces[1] ^ numPieces[2]) == 0</code>.  
	 * Array <code>numPieces</code> should not be changed by a call to advise.
	 * @param numPieces length three array of integers indicating how many pieces are in each pile
	 * @return a length 2 array with the pile index and number of pieces to take for a winning move, or null if there is no winning move
	 */
	public static int[] advise​(int[] numPieces) {
		int[] result = new int[2];
//		for (int i = 0; i < numPieces.length; i++) {
//			int[] numPieces2 = numPieces.clone();
//			int times = 0;
//			for (int j = 0; j <= numPieces2[i]; j++) {
//				times++;
//				numPieces2[i] -= 1;
//				if ((numPieces2[0] ^ numPieces2[1] ^ numPieces2[2]) == 0) {
//					result[0] = i;
//					result[1] = times;
//					return result;
//				}
//			}
//		}
//		return null;
		
		if ((numPieces[0] ^ numPieces[1] ^ numPieces[2]) != 0) {
			int smallest = numPieces[0];
			for (int i = 0; i < 3; i++) {
				if (numPieces[i] < smallest) {
					smallest = numPieces[i];
					result[0] = i;

				}
			}
			result[1] = numPieces[0] ^ numPieces[1] ^ numPieces[2];
			return result;
		}
		else {
			return null;
		}
	}

	/**
	 * Run given testing and play code.
	 * @param args (unused)
	 */
	public static void main(String[] args) {
		test();
		play();
	}

	/**
	 * Run given test code.
	 */
	public static void test() {
		for (int i = 0; i < 20; i++) {
			int[] numPieces = {(int) (6 * Math.random()), (int) (6 * Math.random()), (int) (6 * Math.random())};
			System.out.printf("advise(%s) -> %s\n", Arrays.toString(numPieces), Arrays.toString(advise​(numPieces)));
		}
	}
	
	/**
	 * Run given game play code where the computer player (as second player) plays according to the play advice.
	 * When there is no winning move, the computer takes a single pieces from a random pile, following the
	 * "enough rope" principle.
	 */
	public static void play() {
		@SuppressWarnings("resource")
		Scanner in = new Scanner(System.in);
		System.out.print("Enter Three Pile Nim pile sizes: ");
		int[] numPieces = {in.nextInt(), in.nextInt(), in.nextInt()};
		int turn = 0;
		for (; numPieces[0] + numPieces[1] + numPieces[2] > 0; turn++) {
			// print Nim pile
			for (int p = 0; p < 3; p++) {
				System.out.print(p + ":");
				for (int i = 0; i < numPieces[p]; i++)
					System.out.print("*");
				System.out.printf(" (%d)\n", numPieces[p]);
			}
			
			// player's turn
			if (turn % 2 == 0) {
				System.out.print("Enter a pile and number of pieces to take: ");
				numPieces[in.nextInt()] -= in.nextInt();
			}
			
			// computer's turn
			else {
				System.out.print("Computer play: ");
				int[] play = advise​(numPieces);
				if (play != null) {
					System.out.println(play[0] + " " + play[1]);
					numPieces[play[0]] -= play[1];
				}
				else {
					int pile = (int) (3 * Math.random());
					while (numPieces[pile] == 0)
						pile = (int) (3 * Math.random());
					System.out.println(pile + " 1");
					numPieces[pile]--; 
				}
			}
		}
		System.out.println((turn % 2 == 0) ? "The computer wins!" : "You win!");
		in.close();
	}
	
	
	
}
