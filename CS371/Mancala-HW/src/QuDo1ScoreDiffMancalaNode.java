import java.util.ArrayList;

/**
 * An extension of MancalaNode with a simple, score-difference utility evaluation function.
 * @author Todd W. Neller
 */
public class QuDo1ScoreDiffMancalaNode extends MancalaNode {

	/**
	 * See corresponding <code>MancalaNode</code> standard constructor documentation.
	 */
	public QuDo1ScoreDiffMancalaNode() {
		super();
	}

	/**
	 * See corresponding <code>MancalaNode</code> copy constructor documentation.
	 * @param node node to be copied
	 */
	public QuDo1ScoreDiffMancalaNode(MancalaNode node) {
		super(node);
	}

	/**
	 * See corresponding <code>MancalaNode</code> FairKalah constructor documentation.
	 * @param stateIndex FairKalah initial state index 
	 */
	public QuDo1ScoreDiffMancalaNode(int stateIndex) {
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
