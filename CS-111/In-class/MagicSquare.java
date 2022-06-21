import java.util.Scanner;

public class MagicSquare {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.print("Please enter a positive odd integer: ");
		final int SIZE = in.nextInt();

		int a = Math.pow(SIZE, 2) >= 100 ? 3 : (Math.pow(SIZE, 2) >= 10 ? 2 : 1);
		
		// print the square
		for (int i = 0; i < SIZE; i++) {
			// for each column
			for (int j = 0; j < SIZE; j++) {
				// print matrix entry
				if (a==3) {
					System.out.printf("%3d%s",getMagicSquare(SIZE)[i][j], (j < SIZE - 1 ? " " : " \n"));
				}
				else if (a==2) {
					System.out.printf("%2d%s",getMagicSquare(SIZE)[i][j], (j < SIZE - 1 ? " " : " \n"));
				}
				else {
					System.out.printf("%1d%s",getMagicSquare(SIZE)[i][j], (j < SIZE - 1 ? " " : " \n"));
				}
			}
		}

		in.close();
	}

	public static int[][] getMagicSquare(int SIZE) {
		int[][] magicSquare = new int[SIZE][SIZE];
		boolean[][] isUsed = new boolean[SIZE][SIZE];
		int row = SIZE - 1;
		int col = (SIZE - 1) / 2;

		// Initialize the value into the square
		magicSquare[row][col] = 1;
		isUsed[row][col] = true;

		// Use for loop to run the value from 1 to size^2
		for (int i = 2; i <= Math.pow(SIZE, 2); i++) {

			int r = row + 1;
			int c = col + 1;
			r = (r > SIZE - 1 ? r - (SIZE) : r);
			c = (c > SIZE - 1 ? c - (SIZE) : c);

			// if not isUsed, move down and right. Else move up
			if (!isUsed[r][c]) {
				row = r;
				col = c;
			}
			else {
				row--;
			}

			magicSquare[row][col] = i;
			isUsed[row][col] = true;
		}

		return magicSquare;
	}





}
