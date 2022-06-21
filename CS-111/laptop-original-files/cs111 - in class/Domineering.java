import java.util.Scanner;

public class Domineering {
	// static - pertaining to the class / associated with the class
	// nonstatic - pertaining to the object / associated with the object
	
	// class variable definitions
	private Scanner in = new Scanner(System.in);
	
	// state description:
	// int[][] - 2D rectangular array representing board position contents
	// int current player
	public static final int EMPTY = 0, VERTICAL = 1, HORIZONTAL = 2; 
	
	private int[][] grid;
	private int rows, cols, player;	// number of rows, columns, and current player (1 or 2)	
	
	// constructor - initializing method for the object
	public Domineering() {
		// initialize Domineering project
		System.out.print("Rows (<=10)? ");
		rows = in.nextInt();
		System.out.print("Columns (<=10)? ");
		cols = in.nextInt();
		grid = new int[rows][cols];
		player = 1;
	}
	
	public Domineering(int rows, int cols) {
		this.rows = rows;	// this.<field> unambiguously refers to the field <field>
		this.cols = cols;
		grid = new int[rows][cols];
		player = 1;
	}
	
	public boolean isLegalPlay(int r, int c) {
		// compute second position of play
		int r2 = player == VERTICAL ? r + 1 : r;
		int c2 = player == HORIZONTAL ? c + 1 : c;
		// test and return legality of play
		return r >= 0 && c >= 0 && r2 < rows && c2 < cols && grid[r][c] == EMPTY && grid[r2][c2] == EMPTY;
	}
	
	public boolean makeLegalPlay(int r, int c) {
		if (!isLegalPlay(r, c)) {
			return false;
		}
		// compute second position of play
		int r2 = player == VERTICAL ? r + 1 : r;
		int c2 = player == HORIZONTAL ? c + 1 : c;
		// make play and return true
		grid[r][c] = (grid[r2][c2] = player);
		// change player
		player = player == VERTICAL ? HORIZONTAL : VERTICAL;
		return true;
	}
	
	public boolean makeLegalPlay() {
		System.out.printf("Please enter the %s grid coordinates of your domino seperated by a space: ", player == VERTICAL ? "upper" : "left");
		int r = in.nextInt();
		int c = in.nextInt();
		return makeLegalPlay(r, c);
	}
	
	public boolean hasLegalPlay() {
		for (int r = 0; r < rows; r++) {
			for (int c = 0; c < cols; c++) {
				if (isLegalPlay(r, c)) {
					return true;
				}
			}
		}
		return false;
	}
	
	private void play() {
		// Introduction
		System.out.println("The Game of Domineering");
		System.out.println("Two players take turns placing vertical and hirozontal two-square dominoes");
		System.out.println("into a rectangular grid. The first player who cannot make a move loses.");
		System.out.println(this);	// "this" refers to what?
		// Game loop (take turns until the game is over)
		while (hasLegalPlay()) {
			System.out.printf("It is the %s player's turn.\n", player == VERTICAL ? "vertical" : "horizontal");
			while (!makeLegalPlay());
			System.out.println();
			System.out.println(this);
		}
		// Winner message
		System.out.printf("The %s player wins!\n", player == HORIZONTAL ? "vertical" : "horizontal");
	}
	
	public String toString() {
		char[] boardChar = {'-', 'V', 'H'};
		StringBuilder sb = new StringBuilder(" ");
		for (int c = 0; c < cols; c++) {
			sb.append(c);
		}
		sb.append("\n");
		for (int r = 0; r < rows; r++) {
			sb.append(r);
			for (int c = 0; c < cols; c++) {
				sb.append(boardChar[grid[r][c]]);
			}
			sb.append("\n");
		}
		return sb.toString();
	}
	
	public static void main(String[] args) {
		Domineering game = new Domineering();
		game.play();
	}

}
