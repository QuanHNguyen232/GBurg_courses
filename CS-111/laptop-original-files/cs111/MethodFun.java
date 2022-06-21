import java.util.Scanner;

public class MethodFun {
	
	// Method syntax:
	// <modifiers> <return type> <method name> (list of parameter declarations)
	// {code block}
	
	// modifiers:
	// - access specifiers (e.g. public, private)
	// - "static" - associated with the class (e.g. Method Fun)
	
	// return type:
	// - "void" - no return value
	// - the type of a value that is returned by the method to the method "caller"
	
	// Method signature: <method name> (list of parameter declarations)
	// - method name - lowercase camelCase 
	// - "(formal) parameters" - comma-separated pairs of type and varName 
	
	public static void repeatLine(String s, int numReps) {
//		if (s.equals("*")) {
//			throw new RuntimeException();
//		}
		for (int i = 0; i < numReps; i++) {
			System.out.print(s);
		}
		System.out.println();
//		return;
	}
	
	public static void sineWave(double init, double max, double step, int maxChars) {
		for (double x = init; x <= max; x += step) {
			repeatLine("*", (int) ((Math.sin(x) + 1) * maxChars / 2));
		}
	}
	
	public static char rot13(char c) {
//		if (c == '*') {
//			throw new RuntimeException();	// demonstration of printing stack frames
//		}
		if (Character.isLetter(c)) {
			// >= 'n': subtract 13
			// < 'n': add 13
			return (char) (Character.toLowerCase(c) >= 'n' ? c - 13 : c + 13);
		}
		return c;	// non-letter default: no change
	}
	
	public static String rot13(String s) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < s.length(); i++) {
			sb.append(rot13(s.charAt(i)));
		}
		return sb.toString();
	}
	
	public static void rot13Message(Scanner in) {
		StringBuilder sb = new StringBuilder();
		System.out.println("Enter your message, terminating with it a blank line: ");
		String line = in.nextLine();
		while (line.length()>0) {
			sb.append(rot13(line));
			sb.append("\n");
			line = in.nextLine();
		}
		System.out.println(sb.toString());
	}
	
	
	
	public static void main(String[] args) {
		// Method:
		// - a chunk of reusable code
		// - 0 or more input "parameters"
		// - 0 or 1 output "return value" (other languages allow more)
		// - a.k.a function, (sub)routine, subprogram, callable unit, etc.
		
		int lineMax = 60;
		// Method call: <method name> ( <expr>, <expr>, ...)
		repeatLine("-", lineMax);	// "-" and lineMax are "arguments"
		repeatLine("==", lineMax/2);	// can have expression as an argument
		
		sineWave(0, 4 * Math.PI, .2, lineMax);
		
		
		// Rotate-13  (ROT13) Cipher
		System.out.println(rot13('a'));
		System.out.println(rot13("This is a test."));
		System.out.println(rot13(rot13("This is a test.")));
		Scanner in = new Scanner(System.in);
		rot13Message(in);
		rot13Message(in);
		
		in.close();
		
		
		// bottom-up development: Solve problems from simple to compound
		// top-down development: Solve problems from complex/compound to simple
		// top-down disadvantage: harder to incrementally test
		
		
		// Hog Analysis
		// Turn:
		//	Roll as many dice at once as desired
		//	- if any 1 (Hog) is rolled, the player scores nothing
		//	- if no 1s are rolled, the player scores the sum
		//	(only one roll per turn)
		// Hog = Pig + constraint that player declared the number of rolls on their turn at the beginning of the turn
		
		// - create int getRandInt (int min, int max) using Math.random()
//		for (int i = 0; i < 100; i++) {
//			System.out.println(getRandInt(1, 6));
//		}
		// test-driven development - write tests first, then code
		
		// - create int getHogTurnScore(int numRolls)
//		for (int i = 0; i < 100; i++) {
//			System.out.println(getHogTurnScore(3));
//		}
		// - create double getAverageHogTurnScore(int numRolls, int numTrials)
		System.out.println(getAverageHogTurnScore(3, 10000000));
		// - create loop to print a table with average score expectations for different values of numRolls
		int numTrials = 1000000;
		System.out.println("Rolls\tAverage Turn Score");
		for (int numRolls = 1; numRolls <= 10; numRolls++) {
			System.out.printf("%2d\t%f\n", numRolls, getAverageHogTurnScore(numRolls, numTrials));
		// bottom-up, iterative/stepwise refinement
		}
		
		
		
	}

	public static double getAverageHogTurnScore(int numRolls, int numTrials) {
		double average = 0;
		for (int i = 0; i < numTrials; i++) {
			average += getHogTurnScore(numRolls);
		}
		average /= numTrials;
		return average;
	}

	public static int getHogTurnScore(int numRolls) {
		int turnTotal = 0;
		for (int i = 0; i < numRolls; i++) {
			int roll = getRandInt(1, 6);
			if (roll == 1) {
				return 0;
			}
			turnTotal += roll;
		}
		return turnTotal;
	}

	public static int getRandInt(int min, int max) {
		return min + (int) (Math.random() * (max - min + 1));
	}

}
