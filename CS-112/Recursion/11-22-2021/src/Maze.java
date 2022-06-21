
import java.util.Random;


public class Maze {
	public static final int MIN_ROOM_SIZE = 1;
	public static final char WALL = '#';
	public static final char MARK = '@';
	public static final char PATH = 'x';
//	public static final char EMPTY = '.';
	public static final char EMPTY = ' ';
	public static final char START = 'S';
	public static final char FINISH = 'F';
	public static final char BORDER = '#';
	
	protected int directions[][] = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}, {-1, -1}, {-1, 1},  {1, -1}, {1, 1}};
//	protected int directions[][] = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};

	protected char[][] maze;
	protected int rows, cols;
	protected Random rand;

	public Maze(int rows, int cols){
		this.rows = rows;
		this.cols = cols;
		maze = new char[rows][cols];
		rand = new Random();
		
		for(int r = 0; r < rows; r++)
			for(int c = 0; c < cols; c++)
				maze[r][c] = EMPTY;
		
		maze[0][0] = START;
		maze[rows-1][cols-1] = FINISH;
				
		recBuildMaze(0, rows, 0, cols);
	}
	
	
	protected void recBuildMaze(int rowStart, int rowEnd, int colStart, int colEnd){
		if(colEnd - colStart <= 2*MIN_ROOM_SIZE || rowEnd - rowStart <= 2*MIN_ROOM_SIZE){
			//room is small enough, stop subdividing
			return;
		}
		System.out.printf("Build maze (%d, %d) , (%d, %d)\n", rowStart, colStart, rowEnd, colEnd);
		System.out.println(this);
		
		//pick a random position (row and col)
		int c = rand.nextInt(colEnd - colStart-2*MIN_ROOM_SIZE) + colStart+MIN_ROOM_SIZE;
		int r = rand.nextInt(rowEnd - rowStart-2*MIN_ROOM_SIZE) + rowStart+MIN_ROOM_SIZE;
		
		//add walls going through the position
		for(int i = colStart; i < colEnd; i++){
			maze[r][i] =  WALL;
		}
		for(int i = rowStart; i < rowEnd; i++){
			maze[i][c] =  WALL;
		}
		//punch holes in each wall
		//pick a wall to not put a whole in
		//          0
		//       3     1
		//          2
		
		//pick the wall without a hole in it
		int safeWall = rand.nextInt(4);
		
		if(safeWall != 0){
			//find a random spot
			int door = rand.nextInt(r - rowStart) + rowStart;
			maze[door][c] = EMPTY;;
		}
		
		if(safeWall != 1){
			//find a random spot
			int door = rand.nextInt(c - colStart) + colStart;
			maze[r][door] = EMPTY;;
		}
		
		if(safeWall != 2){
			//find a random spot
			int door = rand.nextInt(rowEnd - r - 1) + r+1;
			maze[door][c] = EMPTY;
			
		}
		
		if(safeWall != 3){
			//find a random spot
			int door = rand.nextInt(colEnd - c - 1) + c + 1;
			maze[r][door] = EMPTY;
		}
		
		
		//recursive calls
		//top left
		recBuildMaze(rowStart, r, colStart, c);
		
		//top right
		recBuildMaze(rowStart, r, c+1, colEnd);
		
		//bottom left
		recBuildMaze(r+1, rowEnd, colStart, c);
		
		//bottom right
		recBuildMaze(r+1, rowEnd, c+1, colEnd);
	}
	
	public void solveMaze(){
		recSolveMaze(0, 0);
		//System.out.println(this);
		//clean up marked states
		cleanMaze();
	}
	
	public void cleanMaze(){	
		//change marked spaces to empty
		for(int r = 0; r < rows; r++)
			for(int c = 0; c < cols; c++)
				if(maze[r][c] == MARK)
					maze[r][c] = EMPTY;
		
		//reset the start and finish symbols
		maze[0][0] = START;
		maze[rows-1][cols-1] = FINISH;
		
	}
	
	
	protected boolean recSolveMaze(int r, int c){
		//base cases
		if(r < 0 || r >= rows || c < 0 || c >=cols)
			//current position is out of bounds
			return false;
		
		if(maze[r][c] == MARK)
			//current position has been used
			return false;
		
		if(maze[r][c] == FINISH) {
		//if(r == rows -1  && c == cols - 1){
			//got to the finish
			return true;
		}
		
		if(maze[r][c] == WALL){
			//current position is a wall
			return false;
		}
		
		//mark this spot
		maze[r][c] = MARK;
		
		//try solving from every direction from here (all eight)
		for(int i = 0; i < directions.length; i++){
			if(recSolveMaze(r + directions[i][0], c + directions[i][1])){
				maze[r][c] = PATH;
				return true;
			}
		}

		return false;
	}
	
	//turn the maze into a string
	public String toString(){
		StringBuilder result = new StringBuilder();
		
		//top wall
		for(int i = 0; i < cols+2; i++){
			result.append(BORDER);
		}
		result.append('\n');
		
		for(int i = 0; i < rows; i++){
			result.append(BORDER);
			for(int j = 0; j < cols; j++){
				result.append(maze[i][j]);
				
			}
			result.append(BORDER);
			result.append('\n');
		}
		
		
		//bottom wall
		for(int i = 0; i < cols+2; i++){
			result.append(BORDER);
		}
		result.append('\n');
		
		return result.toString();
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Maze m = new Maze(12, 12);
		
		System.out.println(m);
		m.solveMaze();
		System.out.println(m);
	}
	
}