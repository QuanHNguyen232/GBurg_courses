/**
 * MinimaxSearcher.java - a depth-limited minimax searcher
 * without alpha-beta pruning
 *
 * @author (anonymous)
 */

import java.util.ArrayList;

public class QuDoAlphaBetaSearcher implements GameTreeSearcher {

	private int depthLimit;
	private int nodeCount;
	private int bestMove = GameNode.UNDEFINED_MOVE;

	public QuDoAlphaBetaSearcher(int depthLimit) {
		this.depthLimit = depthLimit;
	}

	public double eval(GameNode node) 
	{
		nodeCount = 0;
		//		Initially, alpha is negative infinity and beta is positive infinity:
		//		both players start with their worst possible score.
		return alphaBetaEval(node, Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY, depthLimit);
	}

	public double alphaBetaEval(GameNode node, double alpha, double beta, int depthLeft) {
		int localBestMove = GameNode.UNDEFINED_MOVE;
		boolean maximizing = (node.getPlayer() == GameNode.MAX);
		//		double bestUtility = 
		//				maximizing ? Double.NEGATIVE_INFINITY : Double.POSITIVE_INFINITY;
		nodeCount++;

		// Return utility if game over or depth limit reached
		if (node.gameOver() || depthLeft == 0)
			return node.utility();

		// Otherwise, generate children
		ArrayList<GameNode> children = node.expand();

		// Evaluate the depth-limited minimax value for each
		// child, keeping track of the best
		for (GameNode child : children) {
			double childUtility = alphaBetaEval(child, alpha, beta, depthLeft - 1);

			if (maximizing && childUtility > alpha) { //here we have gone down the tree, and if maximizing has better move...
				//if it's the best we've seen, we update our alpha
				alpha = childUtility;
				localBestMove = child.prevMove;
				if (alpha >= beta) { //ignore any node where we already know it won't progress anywhere
					break;
				}
			}
			if (!maximizing && childUtility < beta) {
				beta = childUtility;
				localBestMove = child.prevMove;
				if (alpha >= beta) {
					break;
				}
			}
		}

		// Before returning utility, assign local best move to
		// instance variable.  The last value assigned in the
		// recursive evaluation will be the best move from the
		// root node.
		
		//I didn't touch bestmove, but did away with bestUtility
		bestMove = localBestMove;
		return (maximizing) ? alpha : beta;
	}

	public int getBestMove() 
	{
		return bestMove;
	}

	public int getNodeCount() 
	{
		return nodeCount;
	}

//	public static void main(String[] args) {
//
//	}
}
