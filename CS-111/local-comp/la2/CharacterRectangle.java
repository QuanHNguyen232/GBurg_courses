import java.util.Arrays;

public class CharacterRectangle {
	
	// fields
	private int numRows, numCols;
	private char[][] grid;

	
	
	// constructors
	
	/**
	 * @param numRows
	 * @param numCols
	 */
	public CharacterRectangle(int numRows, int numCols) {
		this.numRows = numRows;
		this.numCols = numCols;
		grid = new char[numRows][numCols];
		for (int i = 0; i < grid.length; i++) {
			for (int j= 0; j < grid[i].length; j++) {
				grid[i][j] = ' ';
			}
		}
	}
	
	
	// methods
	public char getChar(int row, int col) {
		return grid[row][col];
	}

	public void setChar(int row, int col, char newChar) {
		grid[row][col] = newChar;
	}


	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < grid.length; i++) {
			for (int j= 0; j < grid[i].length; j++) {
				sb.append(grid[i][j]);
			}
			sb.append("\n");
		}
		return sb.toString();
	}

	
	
	
	
	
	
	
//	public static void main(String[] args) {
//		CharacterRectangle a = new CharacterRectangle(5, 3);
//		
//		a.setChar(4, 2, 'a');
//		
//		System.out.println(a);
//	}

}
