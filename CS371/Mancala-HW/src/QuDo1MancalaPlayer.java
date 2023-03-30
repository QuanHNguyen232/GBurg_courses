import java.util.ArrayList;
import java.util.Scanner;

/**
 * <code>HumanMancalaPlayer</code> - an agent relying entirely
 * upon human intelligence for decision making through a simple
 * text
 *
 * @author Quan & Doug
 */
public class QuDo1MancalaPlayer implements MancalaPlayer {
	public int chooseMove(MancalaNode node, long timeRemaining) {
		// TODO - WARNING: This is a simple time management effort 
		// to distribute search time over course of game.  
		// It under-utilizes time, so you should design better time management.
		final double DEPTH_FACTOR = 1.3;
		int depthLimit = (int) (DEPTH_FACTOR * Math.log((double) timeRemaining / piecesRemaining(node)));		
//		int depthLimit = (int) (DEPTH_FACTOR * Math.log((double) timeRemaining / a));
//		int depthLimit = (int) (timeRemaining/Math.log(timeRemaining*50000)) + 2;
		if (depthLimit < 1) depthLimit = 1;

		// Create a searcher.
//		MinimaxSearcher searcher = new MinimaxSearcher(depthLimit);
		QuDoAlphaBetaSearcher searcher = new QuDoAlphaBetaSearcher(depthLimit);

		// Create a new copy of the input node that uses Score-Difference heuristic evaluation function. 
//		ScoreDiffMancalaNode searchNode = new ScoreDiffMancalaNode(node);
//		QuDo1ScoreDiffMancalaNode searchNode = new QuDo1ScoreDiffMancalaNode(node);
		QuDo2ScoreDiffMancalaNode searchNode = new QuDo2ScoreDiffMancalaNode(node);

		searcher.eval(searchNode);
		int bestMove = searcher.getBestMove();
		
		return bestMove;
	}
	/**
	 * Returns the number of pieces not yet captured.
	 * @return int - uncaptured pieces
	 * @param node MancalaNode - node to check
	 */
	public int piecesRemaining(MancalaNode node) {
		int pieces = 0;
		for (int i = 0; i < 6; i++) pieces += node.state[i];
		for (int i = 7; i < 13; i++) pieces += node.state[i];
		return pieces;
	}
}








