import java.util.ArrayList;
import java.util.Arrays;

public class ReversePerfectShuffleNode extends SearchNode {
	public int[] deck;
	public static final int DECK_SIZE = 52;
	
	public ReversePerfectShuffleNode() {
		deck = new int[DECK_SIZE];
		for (int i=0; i < DECK_SIZE; i++) {
			deck[i] = i;
		}
	}
	
	/**
	 * <code>isGoal</code> - test whether or not the current node is a
	 * goal node.
	 *
	 * @return a <code>boolean</code> value - whether or not the
	 * current node is a goal node */
	@Override
	public boolean isGoal() {
		/* isGoal() specification:
		 * The goal of this SearchNode is to find a means of working the secretly stacked four top cards (e.g. Aces)
		 * 	into the 5th, 10th, 15th, and 20th positions of the deck.
		 *
		 * Then the performer can, after performing such a sequence of reverse perfect in- and/or out-shuffles,
		 * 	deal five five-card Poker hands (the 5th being dealt to the dealer),
		 * 	and reveal these same four cards in the dealer's hand.
		 * 
		 */
		return 0==this.deck[4] && 1==this.deck[9] && 2==this.deck[14] && 3==this.deck[19];
	}

	/**
	 * <code>expand</code> - return a (possibly empty) ArrayList of this
	 * node's children.  A new child is created by calling
	 * <code>childClone</code> and appropriately modifying the state
	 * of the returned node.
	 *
	 * @return an <code>ArrayList</code> of SearchNodes that are children
	 * of this node */
	@Override
	public ArrayList<SearchNode> expand() {
		ArrayList<SearchNode> children = new ArrayList<>();
		
		// out-shuffle
		ReversePerfectShuffleNode childOut = (ReversePerfectShuffleNode) childClone();
		shuffle2(childOut, true);
		
		// in-shuffle
		ReversePerfectShuffleNode childIn = (ReversePerfectShuffleNode) childClone();
		shuffle2(childIn, false);
		
		children.add(childOut);
		children.add(childIn);
		return children;
	}
	
	// this is based on website search
	private void shuffle1(ReversePerfectShuffleNode child, boolean isOut) {
		int[] tmp = child.deck.clone();
		int startIdx = 0;
		int midIdx = DECK_SIZE/2;	// should be 26
		for (int i=0; i<child.deck.length; i+=2) {
			if (isOut) {
				child.deck[i] = tmp[startIdx];
				child.deck[i+1] = tmp[midIdx];
			}
			else {
				child.deck[i] = tmp[midIdx];
				child.deck[i+1] = tmp[startIdx];
			}
			startIdx++;
			midIdx++;
		}
	}
	
	// this is based on Prof. Neller's example
	private void shuffle2(ReversePerfectShuffleNode child, boolean isOut) {
		int[] tmp = child.deck.clone();
		int idx = isOut ? 0 : 1;
		for (int i=0; i<child.deck.length; i++) {
			if (isOut) {
				if (idx>=DECK_SIZE) {idx=1;}
				child.deck[i] = tmp[idx];
				idx+=2;
			}
			else {
				if (idx>=DECK_SIZE) {idx=0;}
				child.deck[i] = tmp[idx];
				idx+=2;
			}
		}
	}

	
	@Override
	public ReversePerfectShuffleNode clone() {
		ReversePerfectShuffleNode copy = (ReversePerfectShuffleNode) super.clone();
		copy.deck = new int[DECK_SIZE];
		// do deep clone
		for (int i=0; i<this.deck.length; i++) {
			copy.deck[i] = this.deck[i];
		}
		return copy;
	}
	
	@Override
	public String toString() {
		return Arrays.toString(deck).replace("[", "").replace("]", "");
	}

	public static void main(String[] args) {
		Searcher searcher = new BreadthFirstSearcher();
		ReversePerfectShuffleNode root = new ReversePerfectShuffleNode();
		
		if (searcher.search(root)) {
			searcher.printGoalPath();
		}
		else {
			// unsuccessful search
			System.out.println("Goal node not found in " 
					+ searcher.getNodeCount() + " nodes.");
		}
//		System.out.println(root);
//		ArrayList<SearchNode> arr = root.expand();
//		System.out.println(arr.get(0));
////		System.out.println(arr.get(1));
//		
//		ReversePerfectShuffleNode childOut = (ReversePerfectShuffleNode) arr.get(0);
//		ArrayList<SearchNode> arr1 = childOut.expand();
//		System.out.println(arr1.get(1));
	}

}
