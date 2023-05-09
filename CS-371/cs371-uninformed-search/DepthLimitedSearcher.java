import java.util.Stack;

//public class DepthLimitedSearcher extends Searcher {
//
//	static int depthLimit;
//
//	public DepthLimitedSearcher(int maxValue) {
//		depthLimit= maxValue;
//	}
//
//	public boolean search(SearchNode rootNode) {
//		// IMPLEMENT:
//
//		// Initialize search variables.
//		Stack<SearchNode> stack = new Stack<>();
//		stack.push(rootNode);
//		nodeCount = 0;
//		// Main search loop.
//		while (true) {
//
//			// If the search stack is empty, return with failure
//			// (false).
//			if (stack.isEmpty()) {
//				return false;
//			}
//			// Otherwise pop the next search node from the top of
//			// the stack.
//			SearchNode node = stack.pop();
//			nodeCount++;
//			// If the search node is a goal node, store it and return
//			// with success (true).
//			if (node.isGoal()) {
//				goalNode = node;
//				return true;
//			}
//			// Otherwise, expand the node and push each of its
//			// children into the stack.
//			//UNLESS IT'S AT THE LIMIT
//			if (node.depth != depthLimit) {
//				for (SearchNode child : node.expand()) {
//					stack.push(child);
//				}
//			}	
//		}
//
//	}
//
//}// DepthFirstSearcher

import java.util.LinkedList;

public class DepthLimitedSearcher extends Searcher {
	public int limitDepth;
	
	public DepthLimitedSearcher(int limitDepth) {
		this.limitDepth = limitDepth;
	}
	
	public boolean search(SearchNode rootNode) {
		// Initialize search variables.
		LinkedList<SearchNode> stack = new LinkedList<SearchNode>();
		stack.add(rootNode);
		nodeCount = 0;

		// Main search loop.
		while (true) {

			// If the search stack is empty, return with failure
			// (false).
			if (stack.isEmpty()) {
				return false;
			}

			// Otherwise pop the next search node from the top of
			// the stack.
			SearchNode node = stack.pop();
			nodeCount++;

			// If the search node is a goal node, store it and return
			// with success (true).
			if (node.isGoal()) {
				goalNode = node;
				System.out.println("DepthLimitedSearcher\t"
						+ "Depth = "+ node.depth + "\tLimit = "+this.limitDepth);
				return true;
			}

			// Otherwise, expand the node and push each of its
			// children into the stack.
			for (SearchNode child : node.expand()) {
				if (child.depth <= this.limitDepth) {	// swap from "<" to "<=" ----> solve error when submit hw
//					// original
					stack.push(child);
				
//					
//					// repeated prevention
////					if (node.parent!=null){
////						if (!node.parent.equals(child)) {
////							stack.push(child);
////							depthStack.push(currDepth+1);
////						}
////					}
////					else
////					{
////						stack.push(child);
////						depthStack.push(currDepth+1);
////					}
				}
			}

		}

	}
}
