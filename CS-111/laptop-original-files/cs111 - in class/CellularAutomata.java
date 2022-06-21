
public class CellularAutomata {
	
	public static int[] rule = {0, 1, 1, 1, 1, 0, 0, 0};
	public static final int SIZE = 120, NUM_LINES= 400;	// declared as a method to use in other methods. if declared in main method, it can't used in others
	
	
	public static void printState(int[] state) {
		for (int i = 0; i < SIZE; i++) {
			System.out.print(state[i] == 0 ? " " : "#");
		}
		System.out.println();
	}


	public static int[] getNextState(int[] state) {
		int[] nextState = new int[SIZE];
		for (int i = 0; i < SIZE; i++) {
			int iPrev = (i == 0) ? SIZE - 1 : i - 1;
			int iNext = (i == SIZE - 1) ? 0 : i + 1;
			int ruleIndex = 4 * state[iPrev] + 2 * state[i] + 1 * state[iNext];
			nextState[i] = rule[ruleIndex];
		}
		return nextState;
	}


	public static void main(String[] args) {
		// Create initial state
		int[] state = new int[SIZE];	// all values initially 0
		state[SIZE / 2] = 1;
		
		// For a given number of lines
		for (int i = 0; i < NUM_LINES; i++) {
			// print the current state
			printState(state);
			// change the current state
			state = getNextState(state);
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
