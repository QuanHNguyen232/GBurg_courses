import java.util.Scanner;

public class Chomp {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		System.out.println("CHOMP");
		System.out.println("In the game of Chomp, players bite a rectangular cookie in turn.");
		System.out.println("The player chomping the last bite (0,0) loses.");
		System.out.println("Each chomp, a row and column, bites off all below and to the right.");
		System.out.print("Rows? ");
		int rows = in.nextInt();
		System.out.print("Columns? ");
		int cols = in.nextInt();
		System.out.println();

		ChompGame game = new ChompGame(rows, cols);

		while (!game.isGameOver()) {
			System.out.println(game);

			System.out.printf("Player %d chomp? ", game.getCurrentPlayer());
			int row = in.nextInt();
			int col = in.nextInt();
			
			// check if input is legal
			game.chompAt(row, col);

		}
		
		System.out.printf("Player %d wins!\n", game.getCurrentPlayer() == 1 ? 1 : 2);
		
		in.close();
	}

}
