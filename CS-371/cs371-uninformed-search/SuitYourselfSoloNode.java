import java.util.ArrayList;
import java.util.Stack;

public class SuitYourselfSoloNode extends SearchNode implements Cloneable {
	public static ArrayList<Stack<Integer>> columns;
	public static int numSuits, numColumns;
	private int[] topIndices;
	
	public SuitYourselfSoloNode(int numSuits, int numRanks, int numColumns, int seed) {
		columns = SuitYourselfSoloGenerator.generate(numSuits, numRanks, numColumns, seed);
		SuitYourselfSoloNode.numSuits = numSuits;
		SuitYourselfSoloNode.numColumns = numColumns;
		topIndices = new int[numColumns];
		for (int i = 0; i < numColumns; i++) {
			topIndices[i] = columns.get(i).size() - 1;
		}
	}

	@Override
	public boolean isGoal() {
		// loop through topIndices
		for (int i = 0; i < topIndices.length; i++) {
			if (topIndices[i] >= 0) {	// if there is still card in stack
				return false;
			}
		}
		return true;
	}

	@Override
	public ArrayList<SearchNode> expand() {
		ArrayList<SearchNode> children = new ArrayList<>();
		boolean[] chosen = new boolean[numSuits];
		
		for (int i = 0; i < numColumns; i++) {
			if (topIndices[i] < 0) {	// no card left
				continue;
			}
			int suit = columns.get(i).get(topIndices[i]);
			if (chosen[suit]) {
				continue;
			}
			chosen[suit] = true;
			SuitYourselfSoloNode child = (SuitYourselfSoloNode) childClone();
			for (int j = 0; j < numColumns; j++) {
				while (child.topIndices[j] >= 0 && columns.get(j).get(child.topIndices[j])) {
					
				}
			}
		}
		
		return children;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("\n");
		for (int i = 0; i < columns.size(); i++) {
			sb.append(i + " | ");
			for (int j = 0; j < columns.get(i).size(); j++) {
				sb.append(columns.get(i).get(j) + " ");
			}
			sb.append("\n");
		}
		return sb.toString();
	}
	
	public static void main(String[] args) {
		SuitYourselfSoloNode node = new SuitYourselfSoloNode(4, 3, 4, 2);
		System.out.println(node.toString());
	}
}
