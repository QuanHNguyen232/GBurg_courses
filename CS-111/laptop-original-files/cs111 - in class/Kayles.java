import java.util.Scanner;

public class Kayles { // https://en.wikipedia.org/wiki/Kayles
	
	public static Scanner in = new Scanner(System.in);
	public static boolean[] hasPin; // array indicating whether there is still a pin standing at the given position
	public static int player; // current player
	
	/**
	 * Initialize the game.
	 */
	private static void initialize() {
		// Print intro text
		System.out.println("The Game of Kayles (Random Initialization)");
		System.out.println("Each turn, knock down one or two adjacent pins.");
		// Prompt user for game specification
		System.out.print("How many pins (1-99)? ");
		int numPins = in.nextInt();
		System.out.print("Probability of pin standing? ");
		double probStanding = in.nextDouble();
		// Initialize game state
		hasPin = new boolean[numPins];
		for (int i = 0; i < numPins; i++)
			hasPin[i] = Math.random() < probStanding;
	}
	
	/**
	 * Return whether or not the game is over.
	 * @return whether or not there is still a legal move, that is, at least one pin standing
	 */
	private static boolean isGameOver() {
		for (boolean pinStanding : hasPin)
			if (pinStanding)
				return false;
		return true;
	}

	/**
	 * Attempt to take a turn.  If the user input is an illegal move, return false.
	 * @return whether or not a legal play was made
	 */
	private static boolean takePlayerTurn() {
		// Print game state
		System.out.printf("It is Player %d's turn.\n", player);
		printKayles();
		// Choose leftmost pin to knock down
		System.out.print("Leftmost pin to knock down? ");
		int i = in.nextInt();
		if (i < 0 || i >= hasPin.length || !hasPin[i])
			return false;
		// See if there's a second pin to be knocked down
		int nextPin = 0;
		if (i < hasPin.length - 1 && hasPin[i + 1]) {
			System.out.print("Knock down next pin to the right (1 for yes, 0 for no)? ");
			nextPin = in.nextInt();
			if (nextPin < 0 || nextPin > 1)
				return false;
		}
		// Make move.
		hasPin[i] = false;
		if (nextPin == 1)
			hasPin[i + 1] = false;
		return true;
	}

	/**
	 * Print the state of the Kayles game.
	 */
	private static void printKayles() {
		// Print pins
		for (boolean pin : hasPin)
			System.out.print(pin ? '|' : ' ');
		System.out.println();
		// Print indices (up to 99)
		if (hasPin.length >= 10) { // print 10s place of indices
			for (int i = 0; i < hasPin.length; i++)
				System.out.print(i >= 10 ? "" + i / 10 : " ");
			System.out.println();
		}
		for (int i = 0; i < hasPin.length; i++) // print 1s place of indices
			System.out.print(i % 10);
		System.out.println();
	}

	public static void main(String[] args) {
		initialize();
		player = 1;
		while (!isGameOver()) {
			while (!takePlayerTurn());
			player = player == 1 ? 2 : 1;
		}
		System.out.printf("Player %d wins!\n", player == 1 ? 2 : 1);
		in.close();
	}
}
