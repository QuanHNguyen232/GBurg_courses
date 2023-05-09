public class TwoDicePigSolver {
    int goal;
    double epsilon;
    static double[][][] p;
    boolean[][][] flip;

    TwoDicePigSolver(int goal, double epsilon) {
        this.goal = goal;
        this.epsilon = epsilon;
        p = new double[goal][goal][goal];
        flip = new boolean[goal][goal][goal];

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
    					
    					double pRoll= 0.0;
    					for (int roll1=1; roll1<=6; roll1++) {
    						for (int roll2=1; roll2<=6; roll2++) {
    							if (roll1 == 1 && roll2 == 1)
    								pRoll += 1.0 - pWin(j, 0, 0);
    							else if (roll1 == 1 || roll2 == 1)
    								pRoll += 1.0 -  pWin(j, i, 0);
    							else
    								pRoll += pWin(i, j, k + roll1 + roll2);
    						}
    					}
    					pRoll /= 36.0;

    					double pHold = 1.0 - pWin(j, i + k, 0);
    					p[i][j][k] = Math.max(pRoll, pHold);
    					flip[i][j][k] = pRoll > pHold;
    					double change = Math.abs(p[i][j][k] - oldProb);
    					maxChange = Math.max(maxChange, change);
    				}
    			}
    		}
    	} while (maxChange >= epsilon);
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
                while (k < goal - i && flip[i][j][k])
                    k++;    
                System.out.print(k + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args){
        new TwoDicePigSolver(100, 1e-9).outputHoldValues();
        
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
