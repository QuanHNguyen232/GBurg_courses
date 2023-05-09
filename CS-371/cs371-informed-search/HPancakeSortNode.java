import java.util.ArrayList;
import java.util.Random;

public class HPancakeSortNode extends HSearchNode {
	public int[] pancake;
	public int lastFlip;
	public int cost;
	private static final Random random = new Random();
	
	public HPancakeSortNode(int size, int numShuffleFlips) {
		// init
		this.cost = 0;
		this.lastFlip = 0;
		this.pancake = new int[size];
		for (int i=0; i<size; i++) {
			this.pancake[i] = i;
		}
		// shuffling
		for (int i=0; i<numShuffleFlips; i++) {
			this.flip(random.nextInt(size-1)+2);	// 0 and 1 does not flip
		}
	}
	
	public HPancakeSortNode(int[] pancake) {
		this.cost = 0;
		this.lastFlip = 0;
		this.pancake = pancake.clone();
	}
	
	public void flip(int n) {
		this.cost += n;
		this.lastFlip = n;
		int startIdx = 0;
		int endIdx = n-1;
		// perform flipping
		while (true) {
			if (startIdx >= endIdx || n<=0 || startIdx>this.pancake.length || endIdx<0) {break;}
			int tmp = this.pancake[startIdx];
			this.pancake[startIdx] = this.pancake[endIdx];
			this.pancake[endIdx] = tmp;
			startIdx++;
			endIdx--;
		}
	}

	public HPancakeSortNode clone() {
		HPancakeSortNode copy = (HPancakeSortNode) super.clone();
		copy.pancake = this.pancake.clone();
		return copy;
	}
	
	public int getLastFlip() {
		// This number should be 0 for the root, but in the range 2 --> number-of-pancakes for any child.
		return this.lastFlip;
	}

	@Override
	public double getG() {
		return this.cost;
	}

	@Override
	public double getH() {
		// Return an admissible heuristic estimate of the cost to a goal node that does not overestimate, nor is the trivial h(n) = 0 heuristic.
		// Hint: Consider how one can not overestimate the number of remaining flips, and consider the minimum flip cost.
		int count = 0;
		for (int i=0; i<this.pancake.length; i++) {
			// method 1
//			int val = pancake[i];
//			count += Math.abs(i - val);
			
			// method 2
			count += (pancake[i] == i) ? 0 : 1;
		}
		return count;
	}

	@Override
	public boolean isGoal() {
		for (int i=0; i<this.pancake.length; i++) {
			if (this.pancake[i] != i) {return false;}
		}
		return true;
	}

	@Override
	public ArrayList<SearchNode> expand() {
		ArrayList<SearchNode> children = new ArrayList<SearchNode>();
		for (int i=2; i<=this.pancake.length; i++) {
			HPancakeSortNode child = (HPancakeSortNode) childClone();
			child.flip(i);	// do we keep old cost and add new cost? or reset cost?
			children.add(child);
		}
		return children;
	}
	
	public static HPancakeSortNode getGoalNode(int[] pancake) {
		HSearcher searcher = new BestFirstSearcher(new AStarComparator());
		HSearchNode root = new HPancakeSortNode(pancake);
		if (searcher.search(root)) {
			return (HPancakeSortNode) searcher.goalNode;
		}
		return null;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (int i : this.pancake) {
			sb.append(i + " ");
		}
		sb.append("cost: " + this.cost);
		sb.append(" lastFlip: " + this.lastFlip);
		return sb.toString();
	}

	public static void main(String[] args) {
		// Create the searcher object (uncomment desired code)
//		HSearcher searcher = new BestFirstSearcher(new UniformComparator());
//		HSearcher searcher = new BestFirstSearcher(new GreedyComparator());
		HSearcher searcher = new BestFirstSearcher(new AStarComparator());

		// Create the root search node
		HSearchNode root = new HPancakeSortNode(8, 10);
		
		if (searcher.search(root)) {	// successful search
			System.out.println("Goal node found in " + searcher.getNodeCount() + " nodes.");
			System.out.println("Goal path:");
			searcher.printGoalPath();
		} else {	// unsuccessful search
			System.out.println("Goal node not found in " + searcher.getNodeCount() + " nodes.");
		}
		
		
//		int[] pancake = {1, 2, 3, 6, 4, 5};
//		HPancakeSortNode node = new HPancakeSortNode(pancake);
//		System.out.println(node.cost + " " + node.getLastFlip());
//		ArrayList<SearchNode> arr = node.expand();
//		for (SearchNode n : arr) {
//			System.out.println(n + "\t" + n.depth);
//			HPancakeSortNode n1 = (HPancakeSortNode) n;
//			System.out.println("\t" + n1.cost + " " + n1.lastFlip);
//		}
	}

}
