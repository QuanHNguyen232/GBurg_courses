
public class ChompGame {
	
	// field
	private int rows;
	private int cols;
	private int player; 
	private int[][] grid;
	final private int NOT_CHOMPED = 0, IS_CHOMPED = 1;
	
	// method
	public ChompGame(int rows, int cols) {
		this.rows = rows;
		this.cols = cols;
		grid = new int[rows][cols];
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				grid[i][j] = NOT_CHOMPED;
			}
		}
		player = 1;
	}
	
	public int getRows() {
		return this.rows;
	}
	
	public int getCols() {
		return this.cols;
	}
	
	public int getCurrentPlayer() {
		return player;
	}

	public boolean checkIfChomped(int row, int col) {
		if (grid[row][col] == NOT_CHOMPED) {
			return false;
		}
		return true;
	}
	
	public boolean isLegalChomp(int row, int col) {
		return row < this.rows && row >= 0 && col < this.cols && col >= 0 && !checkIfChomped(row, col);
	}
	
	public boolean chompAt(int row, int col) {
		if (!isLegalChomp(row, col)) {
			System.out.println("That is not a legal chomp position.");
			System.out.println();
			return false;
		}
		// (1) chomp all positions in the rectangle of positions with [row][col] being the upper-left-most 
		// and [rows-1][cols-1] being the lower-right-most
		for (int i = row; i < getRows(); i++) {
			for (int j = col; j < getCols(); j++) {
				if (!checkIfChomped(i, j)) {
					grid[i][j] = IS_CHOMPED;
				}
			}
		}
		System.out.println();
		// (2) change the current player from 1 to 2 or vice versa
		player = getCurrentPlayer() == 1 ? 2 : 1;
		
		// (3) return true
		return true;
	}
	
	public boolean isGameOver() {
//		if (grid[0][0] == IS_CHOMPED) {
//			return true;
//		}
//		return false;
		return checkIfChomped(0, 0);
	}
	
	public java.lang.String toString(){
		StringBuilder sb = new StringBuilder(" ");
		for (int c = 0; c < cols; c++) {
			sb.append(c);
		}
		sb.append("\n");
		for (int r = 0; r < rows; r++) {
			sb.append(r);
			for (int c = 0; c < cols; c++) {
				sb.append(grid[r][c] == NOT_CHOMPED ? "*" : " ");
			}
			sb.append("\n");
		}
		return sb.toString();
	}
	
}
