import java.util.ArrayList;
import java.util.Random;

import javax.rmi.CORBA.Tie;

public class TilePuzzleNode extends SearchNode {
    static final Random random = new Random(42);
    int size;
    int[][] tiles;
    int zeroRow, zeroCol;


    public TilePuzzleNode(int size, int numShuffle){
        this.size = size;
        int i = 0;
        tiles = new int[size][size];
        for (int r = 0; r < size; r++){
            for (int c = 0; c < size; c++){
                tiles[r][c] = i++;
            }
        }
        // shuffle
        for (i = 0; i < numShuffle; i++){
            while (!move(random.nextInt(4)));
        }
    }

    private boolean move(int dir){
        final int[] dRow = {0, -1, 0, 1};
        final int[] dCol = {1, 0, -1, 0};
        int r2 = zeroRow + dRow[dir];
        int c2 = zeroCol + dCol[dir];
        if (r2 < 0 || r2 >= size || c2 < 0 || c2 >= size){
            return false;
        }
        tiles[zeroRow][zeroCol] = tiles[r2][c2];
        tiles[r2][c2] = 0;
        zeroRow = r2;
        zeroCol = c2;
        return true;
    }

    @Override
    public boolean isGoal(){
        int i = 0;
        for (int r = 0; r < size; r++){
            for (int c = 0; c < size; c++){
                if (tiles[r][c] != i++){
                    return false;
                }
            }
        }
        return true;
    }

    @Override
    public ArrayList<SearchNode> expand(){
        ArrayList<SearchNode> children = new ArrayList<>();
        for (int dir = 0; dir < 4; dir ++){
            TilePuzzleNode child = (TilePuzzleNode) childClone();
            if (child.move(dir)){
                children.add(child);
            }
        }
        return children;
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        int digits = ("" + (size * size - 1)).length();
        String fmt = "%" + digits + "d ";

        for (int r = 0; r < size; r++){
            for (int c = 0; c < size; c++){
                sb.append(String.format(fmt, tiles[r][c]));
            }
            sb.append("\n");
        }

        return sb.toString();
    }

    public TilePuzzleNode clone(){
        TilePuzzleNode copy = (TilePuzzleNode) super.clone();
        copy.tiles = new int[size][size];
        for (int r = 0; r < size; r++){
            for (int c = 0; c < size; c++){
                copy.tiles[r][c] = tiles[r][c];
            }
        }
        return copy;
    }
    
    public boolean equals(Object o) {
		if (o instanceof TilePuzzleNode) {
			TilePuzzleNode obj = (TilePuzzleNode) o;
			for (int r=0; r < size; r++) {
				for (int c=0; c < size; c++) {
					if (this.tiles[r][c] != obj.tiles[r][c]) {return false;}
				}
			}
			return true;
		}
		return false;
	}


    // repeated state detection:
    // - prohibit children equal to a node's parent
    // - check against most recent n ancestors
    // - check against all ancestors
    // - check against most recently generated nodes
    //
    // Multiple runs, median node count

    public static void main(String[] args){
        TilePuzzleNode root = new TilePuzzleNode(4, 12);
        System.out.println(root);
        System.out.println("Children");
        System.out.println(root.expand());
    }
}