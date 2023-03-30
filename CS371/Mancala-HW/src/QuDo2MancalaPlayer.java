import java.util.ArrayList;
import java.util.Scanner;

/**
 * <code>HumanMancalaPlayer</code> - an agent relying entirely
 * upon human intelligence for decision making through a simple
 * text
 *
 * @author Quan & Doug
 */
public class QuDo2MancalaPlayer implements MancalaPlayer {
	public int chooseMove(MancalaNode node, long timeRemaining) {
		// TODO - WARNING: This is a simple time management effort 
		// to distribute search time over course of game.  
		// It under-utilizes time, so you should design better time management.
		final double DEPTH_FACTOR = 1.3;
		int depthLimit = 1;
//		int depthLimit = (int) (timeRemaining/Math.log(timeRemaining*50000)) + 2;
		if (depthLimit < 1) depthLimit = 1;

		// Create a searcher.
//		MinimaxSearcher searcher = new MinimaxSearcher(depthLimit);
		QuDoAlphaBetaSearcher searcher = new QuDoAlphaBetaSearcher(depthLimit);

		// Create a new copy of the input node that uses Score-Difference heuristic evaluation function. 
//		ScoreDiffMancalaNode searchNode = new ScoreDiffMancalaNode(node);
//		QuDo1ScoreDiffMancalaNode searchNode = new QuDo1ScoreDiffMancalaNode(node);
		QuDo2ScoreDiffMancalaNode searchNode = new QuDo2ScoreDiffMancalaNode(node);

		
		// NEW part
		int bestMove = 0;
		double a = 2.2;
		double p = piecesRemaining(node);
		double c = 12;
		double expectedBranch = 4;
		double timeBudget = c * (timeRemaining / (p/2*a));
		Stopwatch clock = new Stopwatch();
		clock.start();
		depthLimit = 2;
		do {
			searcher = new QuDoAlphaBetaSearcher(depthLimit);
			searcher.eval(searchNode);
			bestMove = searcher.getBestMove();	// assume that the deeper we search, the better result
			depthLimit++;
		}
		while (clock.lap() * expectedBranch < timeBudget);
		clock.stop();
		clock.reset();
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








