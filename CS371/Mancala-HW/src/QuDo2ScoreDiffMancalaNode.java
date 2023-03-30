import java.util.ArrayList;

/**
 * An extension of MancalaNode with a simple, score-difference utility evaluation function.
 */
public class QuDo2ScoreDiffMancalaNode extends MancalaNode {

	/**
	 * See corresponding <code>MancalaNode</code> standard constructor documentation.
	 */
	public QuDo2ScoreDiffMancalaNode() {
		super();
	}

	/**
	 * See corresponding <code>MancalaNode</code> copy constructor documentation.
	 * @param node node to be copied
	 */
	public QuDo2ScoreDiffMancalaNode(MancalaNode node) {
		super(node);
	}

	/**
	 * See corresponding <code>MancalaNode</code> FairKalah constructor documentation.
	 * @param stateIndex FairKalah initial state index 
	 */
	public QuDo2ScoreDiffMancalaNode(int stateIndex) {
		super(stateIndex);
	}

	public double utility() {
		// TODO choose a utility function
		double score = 0;
		double[] weights = {4, 4, 0, 0, 0, 0, 0};
		for (int i=0; i<weights.length; i++) {
			double w = weights[i];
			if (w == 0) continue;	// to avoid number of function calls
			else if (i == 0) {score += w*getMaxMinScore();}
			else if (i == 1) {score += w*getBoardDiffScore();}
			else if (i == 2) {score += w*getFreeMoveDiffScore();}
			else if (i == 3) {score += w*getFreeMoveScore();}
			else if (i == 4) {score += w*getCapturesScore();}
			else if (i == 5) {score += w*getScoringScore();}
			else if (i == 6) {score += w*getNotStarveScore();}
		}
		return score;
	}
// RESULTS (not time --> time=default)
//	{4, 4, 0, 0, 0, 0, 0}: (win 10:0 - pts = 355:125) against simplePlayer
//	{4, 4, 0, 0, 0, 0, 0}: (win 10:0 - pts = 355:125) against simplePlayer (getBoardDiffScore includes Pit stones)
//	{8, 8, 0, 0, 0, 0, 0}: (win 10:0 - pts = 355:125) against simplePlayer
//	{4, 4, 0, 0, 0, 0, 0}: (win 10:0 - pts = 260:220) against simplePlayer factor=2.3
//	{4, 4, 0, 0, 0, 0, 0}: (win 10:0 - pts = 265:215) against simplePlayer factor=1.6
//	{4, 4, 0, 0, 0, 0, 0}: (win 10:0 - pts = 320:160) against simplePlayer factor=1.45
//	{4, 4, 0, 0, 0, 0, 0}: (win 10:0 - pts = 310:170) against simplePlayer - time=(int) (timeRemaining/10000.0) + 2
//	{4, 4, 0, 0, 0, 0, 0}: (win 5:5 - pts = 300:180) against simplePlayer - time=(int) (DEPTH_FACTOR * Math.log((double) timeRemaining / avgPerTurn));

//	NEW TIME MANAGEMENT
//	int bestMove=0;
//	double a = 2.2;
//	double p = piecesRemaining(node);
//	double c = 5;
//	double expectedBranch = 4;
//	double timeBudget = c * (timeRemaining / (p/2*a));
//	Stopwatch clock = new Stopwatch();
//	clock.start();
//	depthLimit = 2;
//	do {
//		searcher = new QuDoAlphaBetaSearcher(depthLimit);
//		searcher.eval(searchNode);
//		bestMove = searcher.getBestMove();
//		depthLimit++;
//	}
//	while (clock.lap() * expectedBranch < timeBudget);
//	{4, 4, 0, 0, 0, 0, 0}: (win 2:0 - pts = 61:35) against simplePlayer - time= (see above w/ c=5)	
//	{4, 4, 0, 0, 0, 0, 0}: (win 2:0 - pts = 55:41) against simplePlayer - time= (see above w/ c=8)
//	{4, 4, 0, 0, 0, 0, 0}: (win 2:0 - pts = 52:44) against simplePlayer - time= (see above w/ c=12)
//	{4, 4, 0, 0, 0, 0, 0}: (win 2:0 - pts = 58:38) against QuDo1 (original time) - time= (see above w/ c=12)
	
//	{8, 6, 0, 0, 0, 0, 0}: (win 10:0 - pts = 315:165) against simplePlayer
//	{4, 8, 0, 0, 0, 0, 0}: (win 0:10 - pts = 185:295) against simplePlayer
//	{4, 4, 4, 0, 0, 0, 0}: (draw 5:5 - pts = 300:180) against simplePlayer
//	{4, 0, 4, 0, 0, 0, 0}: (win 10:0 - pts = 270:210) against simplePlayer
//	{4, 0, 8, 0, 0, 0, 0}: (draw 5:5 - pts = 245:235) against simplePlayer
//	{0, 8, 0, 0, 0, 0, 0} and {0, 2*8, 0, 0, 0, 0}: (lose 0:10 - pts = 130:350) against simplePlayer
//	{0, 0, 0, 4, 4, 0, 6}: (lose 0:10 - pts = 155:325) against simplePlayer
//	{4, 0, 0, 4, 4, 0, 6}: (draw 5:5 - pts = 215:265) against simplePlayer
//	{4, 4, 0, 4, 4, 0, 6}: (lose 0:5 - pts = 230:250) against simplePlayer
//	{4, 8, 0, 4, 4, 0, 6}: (draw 5:5 - pts = 235:245) against simplePlayer
//	{8, 8, 0, 0, 0, 4, 6}: (draw 5:5 - pts = 225:255) against simplePlayer
//	{0, 0, 10, 0, 0, 0, 0}: (lose 0:10 - pts = 140:340) against simplePlayer
	
	public double getMaxMinScore() {
		return state[MAX_SCORE_PIT] - state[MIN_SCORE_PIT];
	}
	
	public double getBoardDiffScore() {
		double scoreMax = 0;
		double scoreMin = 0;
		for (int i=0; i<6; i++) scoreMax += state[i];
		for (int i=7; i<13; i++) scoreMin += state[i];
		return scoreMax - scoreMin;
	}
	
	public double getFreeMoveDiffScore() {
		double scoreMax = 0;
		double scoreMin = 0;
		for (int i=0; i<6; i++) {
			if (i+state[i] == MAX_SCORE_PIT) {scoreMax+=state[i];}
		}
		for (int i=7; i<13; i++) {
			if (i+state[i] == MIN_SCORE_PIT) {scoreMin+=state[i];}
		}
		return scoreMax - scoreMin;
	}
	
	public double getFreeMoveScore() {
		double score = 0;
		ArrayList<Integer> legalMoves = getLegalMoves();
		for(int move : legalMoves) {
			int numPiece = state[move];
			int condition = player == MAX ? MAX_SCORE_PIT : MIN_SCORE_PIT;
			if (move + numPiece == condition) {
				score++;
			}
		}
		return score;
	}
	
	public double getCapturesScore() {
		double score = 0;
		ArrayList<Integer> legalMoves = getLegalMoves();
		for(int currPit : legalMoves) {
			int numPiece = state[currPit];
			int finalPit = currPit + numPiece;
			boolean isMaxPlayer = player == MAX;
			if (isMaxPlayer) {
				if (finalPit > MAX_SCORE_PIT) {
					continue;
				}
			}
			else {
				if (finalPit > MIN_SCORE_PIT) {
					continue;
				}
			}
			int oppPit = (isMaxPlayer) ? (MAX_SCORE_PIT - finalPit)*2 : (finalPit - MAX_SCORE_PIT)*2;
			if (state[finalPit] == 0 && state[oppPit] > 0) {
				score++;
			}
		}
		return score;
	}
	
	public double getScoringScore() {
		double score = 0;
		ArrayList<Integer> legalMoves = getLegalMoves();
		for(int idx : legalMoves) {
			int numPiece = state[idx];
			int condition = player == MAX ? MAX_SCORE_PIT : MIN_SCORE_PIT;
			if (idx + numPiece >= condition) {	// state[0] ... state[6] (MAX) and state[7] ... state[13] (MIN)
				score++;
			}
		}
		return score;
	}
	
	public double getNotStarveScore() {
		double score = 0;
		ArrayList<Integer> legalMoves = getLegalMoves();
		score += legalMoves.size();
		return score;
	}
	
}
