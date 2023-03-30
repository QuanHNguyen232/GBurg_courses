
public class RecursiveDepthFirstSearcher extends Searcher {

	@Override
	public boolean search(SearchNode node) {
		goalNode = dfs(node);
		return goalNode==null ? false : true;
	}

	public SearchNode dfs(SearchNode currNode) {
		nodeCount+=1;	// move "nodeCount++;" from inside else{ for{} } to this line ----> solve error when submit hw
		if (currNode.isGoal()) {
			return currNode;
		}
		for (SearchNode child : currNode.expand()) {
			SearchNode tmp = dfs(child);
			if (tmp!=null) {
				return tmp;
			}
		}
		return null;
	}
}

/*
 * Have no idea why this causes error in couting nodes
 */
//public class RecursiveDepthFirstSearcher extends Searcher {
//	public int[] count = {0};
//	@Override
//	public boolean search(SearchNode node) {
//		dfs(node);
//		return goalNode==null ? false : true;
//	}
//
//	public void dfs(SearchNode currNode) {
//		nodeCount+=1;	// move "nodeCount++;" from inside else{ for{} } to this line ----> solve error when submit hw
//		if (currNode.isGoal()) {
//			goalNode = currNode;
//			return;
//		}
//		for (SearchNode child : currNode.expand()) {
//			dfs(child);
//		}
//	}
//}
