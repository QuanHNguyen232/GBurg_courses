public class PigSolitaireSolver1 {
    int goal;
    int turns;
    double[][][] p;// score, turn-left, turn-total
    boolean[][][] roll;
    boolean[][][] computed; //this one just tracks if we already have a state
    
    PigSolitaireSolver1(int goal, int turns) {
        //k is goal because the turn total will at max = goal
    	this.goal = goal;
        this.turns = turns;
        p = new double[goal][turns][goal];	
        roll = new boolean[goal][turns][goal];
        computed = new boolean[goal][turns][goal];
        
        //for each dimension of the state space, 
		for (int i = 0; i < goal; i++) 
			for (int j = 0; j < turns; j++) 
				for (int k = 0; i + k < goal; k++) 
					pWin(i, j, k); //find each scenario's probability of winning
    }

    //for each state
    public double pWin(int i, int j, int k) {
    	//check if loss/win first
    	if (j >= turns)
    		return 0.0; //lose
    	if (i + k >= goal)
            return 1.0; //win
    
    	//if we have it, return it, else figure it out
    	//with the wonderful joy of recursion
    	//quan can you double check this part
    	if(computed[i][j][k])
    		return p[i][j][k];
        
    	//check probabilities for rolling
    	double pRoll = pWin(i, j + 1, 0); //if we roll a 1, j increases a turn and k is reset to zero
    	//then for the "successful" rolls 2-6
    	for(int roll = 2; roll < 7; roll++)
    		pRoll = pWin(i,j,k + roll);
    	pRoll = pRoll / 6.0; //average it out
    	
    	//if we hold, add the turn total to score, increase turn, turn total is reset
    	double pHold = pWin(i + k,j + 1, 0);
    	
    	//finally, pick the better of the two
    	if (pRoll > pHold) {
    		roll[i][j][k] = true;
    		p[i][j][k] = pRoll;
    	}
    	else {
    		roll[i][j][k] = false;
    		p[i][j][k] = pHold;
    	}
    	//and don't forget to tell the computer we've solved it now
    	computed[i][j][k] = true;
		return p[i][j][k];
    }
    	
    //just returns what's already been calculated
    public boolean shouldRoll(int i, int j, int k) {
    	return roll[i][j][k];
    }

    //this and the main are just tester functions
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
        new PigSolitaireSolver1(100, 50).outputHoldValues();
    }
}
