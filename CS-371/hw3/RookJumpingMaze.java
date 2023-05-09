import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public class RookJumpingMaze implements State {
	public static final int UNREACHED = 1000000;
	public static final int G = 0;

	public static final int LEFT=0, RIGHT=1, UP=2, DOWN=3;
	public static final int[] DIRECTIONS = {LEFT, RIGHT, UP, DOWN};
	public static final int[] MOVE_R = {0, 0, -1, 1};
	public static final int[] MOVE_C = {-1, 1, 0, 0};

	public int size;
	public int lastR, lastC, lastJump;

	public int[][] grid;
	
	Random rand;

	public RookJumpingMaze(int size) {
		this.size = size;
		this.grid = new int[size][size];
		
		rand = new Random();
		// init grid & isReached
		for (int i=0; i<size; i++) {
			for (int j=0; j<size; j++) {
				grid[i][j] = rand.nextInt(getLegalMove(i, j)) + 1;	// eg: legalMove=4 --> values range from 1->4 ---> random 0->3 +1
			}
		}
		// assign 0 to target (jump number)
		grid[size-1][size-1] = G;
	}

	@Override
	public void step() {
		// get rand position not the GOAL
		int newR = rand.nextInt(size);
		int newC = rand.nextInt(size);
		while (newR == size-1 && newC == size-1) {	// if is goal --> continue 
			newR = rand.nextInt(size);
			newC = rand.nextInt(size);
		}
		
		// find what the max valid number for that jump getLegalMove()
		int maxValidNumber = getLegalMove(newR, newC);
		int newJump = rand.nextInt(maxValidNumber) + 1;
		// while position has old jump number
		while (newJump == getJump(newR, newC)) {
			// set it to a random valid jump number
			newJump = rand.nextInt(maxValidNumber) + 1;
		}
		
		// store position + jump number for undo
		this.lastR = newR;
		this.lastC = newC;
		this.lastJump = getJump(newR, newC);

		this.grid[newR][newC] = newJump;
	}

	@Override
	public void undo() {
		// Undo = set location back to old jump number
		this.grid[lastR][lastC] = lastJump;
	}

	@Override
	public double energy() {
		// reset isSearch before BFS
		double energy = this.bfs();
		return (energy == UNREACHED) ? 1000000 : -energy;
	}

	public double bfs() {
		int[][] isReached = resetIsReached();

		int[] root = {0, 0, 0};	// (row, col, depth)
		isReached[0][0] = root[2];	// update depth

		Queue<int[]> queue = new LinkedList<>();
		queue.add(root);

		while(!queue.isEmpty()) {
			int[] currPos = queue.remove();
			int jump = getJump(currPos[0], currPos[1]);

			// check each direction
			for (int dir : DIRECTIONS) {
				int[] newPos = {currPos[0] + MOVE_R[dir]*jump,	// new row = currRow + (x)*jump (x can be -1, 0, 1 based on direction)
						currPos[1] + MOVE_C[dir]*jump,	// new col = currCol + (x)*jump (x can be -1, 0, 1 based on direction)
						currPos[2] + 1	// depth = currDepth + 1
				};

				// if not yet visited
				if (isValidMove(newPos[0], newPos[1]) && isReached[newPos[0]][newPos[1]]==UNREACHED) {
					isReached[newPos[0]][newPos[1]] = newPos[2];
					queue.add(newPos);
				}
			}
		}
//		System.out.println(printGrid(isReached));
		return isReached[this.size - 1][this.size - 1];
	}

	public int[][] resetIsReached() {
		int[][] isReached = new int[this.size][this.size];
		for (int i=0; i<size; i++) {
			for (int j=0; j<size; j++) {
				isReached[i][j] = UNREACHED;
			}
		}
		return isReached;
	}

	public int getJump(int row, int col) {
		return grid[row][col];
	}

	public int getSize() {
		return this.size;
	}

	@Override
	public Object clone() {
		try {
			RookJumpingMaze copy= (RookJumpingMaze) super.clone();
			copy.grid = new int[size][size];

			for (int i=0; i<size; i++) {
				for (int j=0; j<size; j++) {
					copy.grid[i][j] = this.grid[i][j];
				}
			}

			return copy;
		}
		catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public String toString() {
		return printGrid(this.grid);
	}

	public int getLegalMove(int r, int c) {
		int maxVertical = Math.max(size-1 - r, r);
		int maxHorizontal = Math.max(size-1 - c, c);
		return Math.max(maxVertical, maxHorizontal);
	}

	public boolean isValidMove(int newR, int newC) {	
		return 0 <= newR && newR < this.size && 0 <= newC && newC < this.size;
	}

	public String printGrid(int[][] grid) {
		StringBuilder sb = new StringBuilder();
		for (int i=0; i<size; i++) {
			for (int j=0; j<size; j++) {
				sb.append(grid[i][j] + " ");
			}
			sb.append("\n");
		}
		return sb.toString();
	}

//	public static void main(String[] args) {
//		RookJumpingMaze maze = new RookJumpingMaze(5);
//		System.out.println(maze);
//		System.out.println("Energy = " + maze.energy());
//		System.out.println();
//	}

}
