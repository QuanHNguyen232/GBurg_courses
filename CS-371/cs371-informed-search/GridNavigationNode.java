import java.util.ArrayList;

public class GridNavigationNode extends HSearchNode {

	int row, col;
	final int START_ROW, START_COL, GOAL_ROW, GOAL_COL;
	static boolean[][] maze; //true == blocked
	static boolean[][] isVisited; //true == blocked
	double currDist = 0;

	GridNavigationNode(int startRow, int startCol, int goalRow, int goalCol, boolean[][] isBlocked) {
		//row, col, and parent will change. The maze and goal position will not
		START_ROW = startRow;
		START_COL = startCol;
		row = startRow;
		col = startCol;
		GOAL_ROW = goalRow;
		GOAL_COL = goalCol;
		maze = isBlocked;
		parent = null;
		
		isVisited = new boolean[isBlocked.length][isBlocked[0].length];
		for(int r=0; r<isBlocked.length; r++) {
			for(int c=0; c<isBlocked[0].length; c++) {
				isVisited[r][c] = isBlocked[r][c];
			}
		}
//		System.out.println("done create node");
	}

	public int getRow() {
		return row;
	}

	public int getCol() {
		return col;
	}

	public double getG() {
		//Get the total Euclidean distance traveled to reach this node.
		//"odometer" method is technically not euclidian, so just calculate pyth from start pos to current
		// method 1
//		double a = Math.abs(row - START_ROW);
//		double b = Math.abs(col - START_COL);
//		double c = Math.sqrt(Math.pow(a, 2) + Math.pow(b, 2)); // c = sqrt (a^2 + b^2)
		
		// method 2
		return currDist;
	}

	public double getH() {
		//Get an admissible estimate of the remaining distance to the goal row and column
		//in the form of the Euclidean distance from this node to the goal.
		double a = Math.abs(row - GOAL_ROW);
		double b = Math.abs(col - GOAL_COL);
		double c = Math.sqrt(Math.pow(a, 2) + Math.pow(b, 2)); // c = sqrt (a^2 + b^2)
//		System.out.println("H: " + c);
		return c;
	}

	@Override
	public boolean isGoal() {
		if (row == GOAL_ROW && col == GOAL_COL) {
			return true;
		}
		return false;
	}

	@Override
	public ArrayList<SearchNode> expand() {
		//for all 8 directions:
		//check if they exist (no out of bounds please), then if is blocked - done via move method
		//rsd: no backtracking - check against parent node row and col - done via parentCheck method

		ArrayList<SearchNode> children = new ArrayList<>();
		//8 dirs, 0-7, clockwise from upper left
		// 0 1 2
		// 7 x 3
		// 6 5 4
		for(int dir = 0; dir < 8; dir++) {
			GridNavigationNode child = (GridNavigationNode) childClone(); //parent and depth, plus all other fields
//			if(child.move(dir) && child.parentCheck((GridNavigationNode) this.parent)) {//child has updated row, col going into parentCheck
			if(child.move(dir)) {
				children.add(child);
			}
		}
//		System.out.println(children.size());
		return children;
	}
	// 0 1 2
	// 7 x 3
	// 6 5 4
	//adapted from HTilePuzzleNode
	//this should only be run on the child, ensures there is no repeated state from parent, but not parent's parent
	private boolean move(int dir) { //0-7
		final int[] dRow = {1, 1, 1, 0, -1, -1, -1, 0};
		final int[] dCol = {-1, 0, 1, 1, 1, 0, -1, -1};
		int moveRow = row + dRow[dir];
		int moveCol = col + dCol[dir];
		//bounds check
		if (moveRow < 0 || moveRow >= maze.length || moveCol < 0 || moveCol >= maze[row].length) //maze[row].length assumes rectangular maze
			return false;
		if(!maze[moveRow][moveCol] && !isVisited[moveRow][moveCol]) { //if valid move, update and return
			row = moveRow;
			col = moveCol;
			isVisited[moveRow][moveCol] = true;
			currDist += dir%2==0 ? Math.sqrt(2) : 1;
			return true;
		}
		return false; //blocked
	}
	//RSD check: backtracking - if child's row, col == parent's, do not add child 
	private boolean parentCheck(GridNavigationNode parent) { //incoming node should be this's parent, so child's parent's parent
		if (parent == null) { //skip the root
			return true;
		}
		if (parent.row == row && parent.row == col) {
			return false;
		}
		return true;
	}
}
