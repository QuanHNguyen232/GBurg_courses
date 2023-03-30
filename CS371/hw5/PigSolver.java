public class PigSolver {
    int goal;
    double epsilon;
    static double[][][] p;
    boolean[][][] roll;

    PigSolver(int goal, double epsilon) {
        this.goal = goal;
        this.epsilon = epsilon;
        p = new double[goal][goal][goal];
        roll = new boolean[goal][goal][goal];

        valueIterate();
    }

    void valueIterate() {
    	double maxChange;
    	do {
    		maxChange = 0.0;
    		for (int i = 0; i < goal; i++) { // for all i
    			for (int j = 0; j < goal; j++) { // for all j
    				for (int k = 0; k < goal - i; k++) { // for all k
    					double oldProb = p[i][j][k];
    					
    					double pRoll = 1.0 - pWin(j, i, 0);
    					for (int roll=2; roll<=6; roll++)
    						pRoll += pWin(i, j, k + roll);
    					pRoll /= 6.0;
    					double pHold = 1.0 - pWin(j, i + k, 0);
    					p[i][j][k] = Math.max(pRoll, pHold);
    					roll[i][j][k] = pRoll > pHold;
    					double change = Math.abs(p[i][j][k] - oldProb);
    					maxChange = Math.max(maxChange, change);
    				}
    			}
    		}
    	} while (maxChange >= epsilon);
    }
    public boolean shouldRoll(int i, int j, int k) {
    	return roll[i][j][k];
    }

    public double pWin(int i, int j, int k) { 
        if (i + k >= goal)
            return 1.0;
        else if (j >= goal)
            return 0.0;
        else return p[i][j][k];
    }

    public void outputHoldValues() {
        for (int i = 0; i < goal; i++) {
            for (int j = 0; j < goal; j++) {
                int k = 0;
                while (k < goal - i && roll[i][j][k])
                    k++;    
                System.out.print(k + " ");
//                System.out.printf("%3d", k);
            }
            System.out.println();
        }
    }

    public static void main(String[] args){
        new PigSolver(100, 1e-9).outputHoldValues();
//        double winProb = 0;
//        int count = 0;
//        int goal = 100;
//        for (int i = 0; i < goal; i++) {
//            for (int j = 0; j < goal; j++) {
//            	for (int k = 0; k < goal - i; k++) {
//            		winProb += p[i][j][k];
//            		count++;
//            	}
//            }
//        }
//        System.out.println(winProb/count);
    }
}
