

public class PigSolitaireSolverSample {
	int goal, turns;
	double[][][] p; // current score - completed  turns - current turn total
	boolean[][][] computed;
	boolean[][][] roll;

	public PigSolitaireSolverSample(int goal, int turns) {
		this.goal = goal;
		this.turns = turns;
		computed = new boolean[goal][turns][goal];
		p = new double[goal][turns][goal];
		roll = new boolean[goal][turns][goal];

		computeWinProb();
	}

	private void computeWinProb() {
		for (int i = 0; i < goal; i++) // for all score
			for (int j = 0; j < turns; j++) // for all turn possible
				for (int k = 0; i + k < goal; k++) // for all turn total
					pWin(i, j, k);

	}

	// probability of winning in the current state with optimal play
	public double pWin(int i, int j, int k) {
		if (i + k >= goal) // win
			return 1.0;
		if (j >= this.turns) // lose
			return 0.0;
		if (computed[i][j][k])
			return p[i][j][k];

		// Recursively compute p[i][j][k]
		if (computed[i][j][k]) return p[i][j][k];
		
		computeP(i, j, k);
		return p[i][j][k];
	}

	private void computeP(int i, int j, int k) {

		// Compute the probability of winning with a roll
		double pRoll = pWin(i, j + 1, 0);
		for (int roll = 2; roll <= 6; roll++)
			pRoll += pWin(i, j, k + roll);
		pRoll /= 6.0;

		// Compute the probability of winning with a hold
		double pHold = pWin(i + k, j + 1, 0);

		// Optimal play chooses the action with the greater win probability
		roll[i][j][k] = pRoll > pHold;
		if (roll[i][j][k])
			p[i][j][k] = pRoll;
		else
			p[i][j][k] = pHold;
		computed[i][j][k] = true;

	}

	// Return whether or not an optimal player should roll given the current score
	public boolean shouldRoll(int i, int j, int k) {
		return roll[i][j][k];
	}

	public void summarize() {
		System.out.println("p[0][0][0] = " + p[0][0][0]);
		System.out.println();
		System.out.println("i\tj\tPolicy changes at k =");
		for (int i = 0; i < goal; i++) // for all i
			for (int j = 0; j < turns; j++) { // for all j
				int k = 0;
				System.out.print(i + "\t" + j + "\t" + (roll[i][j][k] ? "roll " : "hold "));
				for (k = 1; k < 6; k++) // for all valid turn total
					if (roll[i][j][k] != roll[i][j][k - 1])
						System.out.print(k + " " + (roll[i][j][k] ? "roll " : "hold "));
				System.out.println();
			}
	}
	public void outputHoldValues() {
        for (int i = 0; i < goal; i++) {
            for (int j = 0; j < turns; j++) {
                int k = 0;
                while (k < goal - i && roll[i][j][k])
                    k++;    
                System.out.print(k + " ");
//                System.out.printf("%3d ", k);
            }
            System.out.println();
        }
    }
	public static void main(String[] args) {
		 new PigSolitaireSolverSample(100, 50).outputHoldValues();

	}

}
