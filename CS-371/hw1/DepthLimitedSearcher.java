import java.util.Stack;

/**
 * DepthFirstSearcher.java - a simple iterative implementation of
 * depth-first search.
 *
 * @author Todd Neller
 * @version 1.1
 *

Copyright (C) 2006 Todd Neller

This program is free software; you can redistribute it and/or
modify it under the terms of the GNU General Public License
as published by the Free Software Foundation; either version 2
of the License, or (at your option) any later version.

This program is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
GNU General Public License for more details.

Information about the GNU General Public License is available online at:
  http://www.gnu.org/licenses/
To receive a copy of the GNU General Public License, write to the Free
Software Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA
02111-1307, USA.

 */

public class DepthLimitedSearcher extends Searcher {

	static int depthLimit;

	public DepthLimitedSearcher(int maxValue) {
		depthLimit= maxValue;
	}

	/**
	 * <code>search</code> - given an initial node, perform
	 * depth-first search (DFS).  This particular implementation of
	 * DFS is iterative.
	 *
	 * @param rootNode a <code>SearchNode</code> value - the initial node
	 * @return a <code>boolean</code> value - whether or not goal node
	 * was found */
	public boolean search(SearchNode rootNode) {
		// IMPLEMENT:

		// Initialize search variables.
		Stack<SearchNode> stack = new Stack<>();
		stack.push(rootNode);
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
				return true;
			}
			// Otherwise, expand the node and push each of its
			// children into the stack.
			//UNLESS IT'S AT THE LIMIT
			if (node.depth != depthLimit) {
				for (SearchNode child : node.expand()) {
					stack.push(child);
				}
			}	
		}

	}

}// DepthFirstSearcher
//import java.util.LinkedList;
//
//public class DepthLimitedSearcher extends Searcher {
//	private int limitDepth;
//	
//	public DepthLimitedSearcher(int limitDepth) {
//		this.limitDepth = limitDepth;
//	}
//	
//	public boolean search(SearchNode rootNode) {
//		// IMPLEMENT:
//
//		// Initialize search variables.
//		LinkedList<SearchNode> stack = new LinkedList<SearchNode>();
//		LinkedList<Integer> depthStack = new LinkedList<Integer>();
//		stack.add(rootNode);
//		depthStack.add(0);
//		nodeCount = 0;
//
//		// Main search loop.
//		while (true) {
//
//			// If the search stack is empty, return with failure
//			// (false).
//			if (stack.isEmpty()) {
//				return false;
//			}
//
//			// Otherwise pop the next search node from the top of
//			// the stack.
//			SearchNode node = stack.pop();
//			int currDepth = depthStack.pop();
//			nodeCount++;
//
//			// If the search node is a goal node, store it and return
//			// with success (true).
//			if (node.isGoal()) {
//				goalNode = node;
//				System.out.println("DepthLimitedSearcher\t"
//						+ "Depth = "+ currDepth + "\tLimit = "+this.limitDepth);
//				return true;
//			}
//
//			// Otherwise, expand the node and push each of its
//			// children into the stack.
//			for (SearchNode child : node.expand()) {
//				if (currDepth < this.limitDepth) {
//					// original
////					stack.push(child);
////					depthStack.push(currDepth+1);
//					
//					// repeated prevention
//					if (node.parent!=null){
//						if (!node.parent.equals(child)) {
//							stack.push(child);
//							depthStack.push(currDepth+1);
//						}
//					}
//					else
//					{
//						stack.push(child);
//						depthStack.push(currDepth+1);
//					}
//					
//				}
//			}
//
//		}
//
//	}
//}
