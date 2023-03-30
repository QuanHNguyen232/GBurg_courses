public class PigSolitaireSolver {
    int goal;
    int turns;
    double[][][] p;
    boolean[][][] roll;
    boolean[][][] isComputed;
    
    public PigSolitaireSolver(int goal, int turns) {
    	this.goal = goal;
    	this.turns = turns;
    	p = new double[goal][turns][goal];	// score, turn-left, turn-total
        roll = new boolean[goal][turns][goal];
        isComputed = new boolean[goal][turns][goal];
        
        for (int i = 0; i < goal; i++)
    		for (int j = 0; j < turns; j++)
    			for (int k = 0; k < goal - i; k++)
    				pWin(i, j, k);
    }
    
    public boolean shouldRoll(int i, int j, int k) {
    	return roll[i][j][k];
    }
    
    public double pWin(int i, int j, int k) {
    	if (j >= turns)
    		return 0.0;
    	else if (i + k >= goal)
            return 1.0;
        else if (isComputed[i][j][k])
        	return p[i][j][k];
        else {
        	double pRoll = pWin(i, j+1, 0);
    		for (int roll=2; roll<=6; roll++)
    			pRoll += pWin(i, j, k + roll);
    		pRoll /= 6.0;
    		double pHold = pWin(i+k, j+1, 0);
    		p[i][j][k] = Math.max(pRoll, pHold);
    		roll[i][j][k] = pRoll > pHold;
    		isComputed[i][j][k] = true;
        	return p[i][j][k];
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

    public static void main(String[] args){
        new PigSolitaireSolver(100, 50).outputHoldValues();
    }
}
