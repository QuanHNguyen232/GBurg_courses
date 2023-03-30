public class RecursiveDepthFirstSearcher extends Searcher {

	RecursiveDepthFirstSearcher() {
		nodeCount = 0; //here as to avoid resetting on recursion
	}
	
	@Override
	public boolean search(SearchNode node) {
		//base cases: 
		//1 - we found it, isGoalNode
		//2 - we didn't find it, expand and call search on children
		//count the node first
		nodeCount++;
		if (node.isGoal()) {
			goalNode = node;
			return true;
		}
		//if there's no children for the node, this loop should not execute
		for (SearchNode child : node.expand()) {
			if (search(child))
				return true;    //looks odd, but apparently needed to pass the "true" state up the chain
		}
		return false; //nope, it ain't there.
	}

}
//
//public class RecursiveDepthFirstSearcher extends Searcher {
//		
//	@Override
//	public boolean search(SearchNode node) {
//		nodeCount = 0;
//		dfs(node);
//		return goalNode==null ? false : true;
//	}
//	
//	public void dfs(SearchNode currNode) {
//		if (currNode.isGoal()) {
//			goalNode = currNode;
//		}
//		else {
//			for (SearchNode child : currNode.expand()) {
//				nodeCount++;
//				dfs(child);
//			}
//		}
//	}
//}
