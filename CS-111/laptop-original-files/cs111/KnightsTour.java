import java.util.Scanner;

public class KnightsTour {

	public static void main(String[] args) {
		// Compute an open knight's tour on a square board of a given size with a given starting position
		// https://en.wikipedia.org/wiki/Knight%27s_tour
		// Initialize (initialize board, starting row, col)
		Scanner in = new Scanner(System.in);
		System.out.print("Board size? ");
		int size = in.nextInt();
		System.out.print("Starting row (0-based)? ");
		int row = in.nextInt();
		System.out.print("Starting column (0-based)? ");
		int col = in.nextInt();

		boolean[][] isVisited = new boolean[size][size];
		isVisited[row][col] = true;

		int[][] knightMoves = {{2, -1}, {1, -2}, {-1, -2}, {-2, -1}, {-2, 1}, {-1, 2}, {1, 2}, {2, 1}};

		// Follow a heuristic for finding a knight's tour
		while (true) {
			// find next unvisited position with the least knight's moves available from it
			int[] bestMove = null;	// best move to our most constrain position
			int leastMoves = Integer.MAX_VALUE;	// least number of moves
			
			for (int[] knightMove : knightMoves) {
				int r = row + knightMove[0];
				int c = col + knightMove[1];
				if (r >= 0 && r < size && c >= 0 && c < size && !isVisited[r][c]) {	// in bounds and not visited
					
					// count the number of legal moves from [r][c]
					int moveCount = 0;
					for (int[] knightMove2 : knightMoves) {
						int r2 = r + knightMove2[0];	// next move row
						int c2 = c + knightMove2[1];	// next move column
						if (r2 >= 0 && r2 < size && c2 >= 0 && c2 < size && !isVisited[r2][c2]) {	// in bounds and not visited
							moveCount++;
						}
					}
					// record this move if it's our best move yet 
					if (moveCount < leastMoves) {
						leastMoves = moveCount;
						bestMove = knightMove;
					}
				}
			}

			// if no such next position, break
			if (bestMove == null) {
				break;
			}

			// otherwise, move to the next position, print it, and mark it as visited
			row += bestMove[0];
			col += bestMove[1];
			System.out.printf("%d, %d\n", row, col);
			isVisited[row][col] = true;
		}

		// Check whether or not the entire board has been visited and report the result
		boolean allVisited = true;
		for (int r = 0; r < size && allVisited; r++) {
			for (int c = 0; c < size && allVisited; c++) {
				if (!isVisited[r][c]) {
					allVisited = false;
				}
			}
		}
		System.out.println(allVisited ? "All posotions were toured." : "All positions were not toured.");



		in.close();
	}

}
