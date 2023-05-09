import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Stack;

public class LatinSquareSolver implements Cloneable  {
	public static final int UNFILLED = 0; 
	public int[][] grid;
	public int size;
	public int currR, currC;
	public LatinSquareSolver prevNode;

	public LatinSquareSolver(int[][] grid) {
		this.grid = gridCopy(grid);
		this.size = grid.length;
		this.currR = 0;
		this.currC = 0;
		this.prevNode = null;
	}
	
	public ArrayList<LatinSquareSolver> expand() {
		int tmpR = currR;
		int tmpC = currC;
		
		// find unfilled position
		boolean isFoundPos = false;
		for (int i=0; i<size; i++) {
			for (int j=0; j<size; j++) {
				if (this.grid[i][j] == UNFILLED) {
					currR = i;
					currC = j;
					isFoundPos = true;
					break;
				}
			}
			if (isFoundPos) break;
		}
		if (!isFoundPos) return null;	// cannot found unfilled position (all filled)
		
		// get set of used values by row and col
		HashSet<Integer> rowSet = new HashSet<>();
		for (int j = 0; j < size; j++)
			if (grid[currR][j] != UNFILLED) {rowSet.add(grid[currR][j]);}
		
		HashSet<Integer> colSet = new HashSet<>();
		for (int i = 0; i < size; i++)
			if (grid[i][currC] != UNFILLED) {colSet.add(grid[i][currC]);}
				
		ArrayList<LatinSquareSolver> children = new ArrayList<>();
		for (int val=1; val<=size; val++) {
			if (!rowSet.contains(val) && !colSet.contains(val)) {
				LatinSquareSolver child = clone(currR, currC, val);
				children.add(child);
			}
		}
		currR = tmpR;
		currC = tmpC;
		return children;
	}
	
	public static LatinSquareSolver search(LatinSquareSolver node) {
		// DFS
		Stack<LatinSquareSolver> stack = new Stack<>();
		stack.add(node);
		while (!stack.isEmpty()) {
			LatinSquareSolver currNode = stack.pop();
			if (currNode.isAllFilled()) return currNode;
			
			ArrayList<LatinSquareSolver> children = currNode.expand();
			// found unfilled position and found unfilled position with a suitable value to fill in
			if (children != null && children.size() > 0) {
				for (LatinSquareSolver child : children) {
					stack.push(child);
				}
			}
		}
		return null;
	}
	
	public static boolean solve(int[][] grid) {
		LatinSquareSolver node = new LatinSquareSolver(grid);
		
		// if the original grid is invalid, return false
		if (!node.isValidGrid()) return false;
		// else find solution
		LatinSquareSolver goal = LatinSquareSolver.search(node);

		if (goal != null && goal.isValidGrid()) {	// if found, copy from goal/solution to grid
			gridFillVal(grid, goal.grid);
			return true;
		}
		else {	// if not found, grid must be the original param grid 
			return false;
		}
	}

	public LatinSquareSolver clone(int row, int col, int val) {
		try {
			LatinSquareSolver copy = (LatinSquareSolver) super.clone();
			copy.size = size;
			copy.currR = row;
			copy.currC = col;
			copy.grid = gridCopy(this.grid);
			copy.grid[row][col] = val;
			copy.prevNode = this;
			return copy;
		} catch (CloneNotSupportedException e) {e.printStackTrace();}
		return null;
	}
	
	public boolean isValidGrid() {
		// check each row
		for (int i = 0; i < size; i++) {
			HashSet<Integer> rowSet = new HashSet<>();
			for (int j = 0; j < size; j++) {
				if (grid[i][j] == UNFILLED) continue;
				if (rowSet.contains(grid[i][j])) return false;
				rowSet.add(grid[i][j]);
			}
		}
		// check each col
		for (int j = 0; j < size; j++) {
			HashSet<Integer> colSet = new HashSet<>();
			for (int i = 0; i < size; i++) {
				if (grid[i][j] == UNFILLED) continue;
				if (colSet.contains(grid[i][j])) return false;
				colSet.add(grid[i][j]);
			}
		}
		return true;
	}
	
	public boolean isAllFilled() {
		for (int i=0; i<size; i++)
			for (int j=0; j<size; j++)
				if (this.grid[i][j] == UNFILLED) return false;
		return true;
	}
	
	@Override
	public String toString() {
		return getGridString(this.grid);
	}
	
	
	public static String getGridString(int[][] grid) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < grid.length; i++) {
			for(int j = 0; j < grid.length; j++) {sb.append(grid[i][j] + " ");}
			sb.append("\n");
		}
		return sb.toString();
	}
	

	public static int[][] gridCopy(int[][] toCopy){
		int gridSize = toCopy.length;
		int[][] cp = new int[gridSize][gridSize];
		gridFillVal(cp, toCopy);
		return cp;
	}
	
	public static void gridFillVal(int[][] myGrid, int[][] gridData){
		if (myGrid.length == gridData.length) {
			int gridSize = gridData.length;
			for (int i = 0; i < gridSize; i++) {
				for(int j = 0; j < gridSize; j++) {
					myGrid[i][j] = gridData[i][j];
				}
			}
		}
	}

	public static void main(String[] args) {
		Random rand = new Random(0);
		int size = 9;
		int[][] tmpgrid = new int[size][size];
//		for (int i = 0; i < 5; i++) {tmpgrid[rand.nextInt(size)][rand.nextInt(size)] = rand.nextInt(size)+1;}
		tmpgrid[1][1]=2;
		tmpgrid[2][2]=2;
		tmpgrid[3][2]=2;
		
		System.out.println(getGridString(tmpgrid));
		
		boolean isFound = solve(tmpgrid);
		System.out.println(isFound);
		System.out.println(getGridString(tmpgrid));
		
	}

}
