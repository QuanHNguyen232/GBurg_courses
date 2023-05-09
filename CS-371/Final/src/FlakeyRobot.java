import java.util.Arrays;

public class FlakeyRobot {
	int size;
    double p;
    int currState;
    public final double EPS = 1e-14;
    public final int RIGHT_STEP = 1, LEFT_STEP = -1;
    public double[] V;

    public FlakeyRobot(int size, double p, int currState) {
        this.size = size;
        this.p = p;
        this.currState = currState;
        this.V = new double[size + 1];
        
        valueIterate();
    }

    public void valueIterate() {
    	double maxChange;
    	do {
    		maxChange = 0.0;
    		for (int i = 1; i <= this.size; i++) { // for all i
    			double newV1 = 0;	// move left
    			double newV2 = 0;	// move right
    			newV1 = (i + LEFT_STEP == 0) ? newV1 - 1 : newV1 - (-V[i + LEFT_STEP] + 1);
    			newV2 = (i + RIGHT_STEP > this.size) ? newV2 - (-V[i] + 1) : newV2 - (-V[i + RIGHT_STEP] + 1);
    			
    			double newV = newV1*(1-this.p) + newV2*p;
    			double change = Math.abs(V[i] - newV);
				V[i] = newV;
				maxChange = Math.max(maxChange, change); 
    		}
    		
    	} while (maxChange >= EPS);
    }
    
	@Override
	public String toString() {
		return "Result: " + Arrays.toString(this.V) + "\n at state=" + this.currState + " is [" + this.V[this.currState] + "]";
	}

	public static void main(String[] args) {
		int size = 20;
		double p = 0.25;
		int currState = 5;
		
		FlakeyRobot robot = new FlakeyRobot(size, p, currState);
		System.out.println(robot);
	}

}
