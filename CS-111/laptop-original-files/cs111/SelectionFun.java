import java.util.Scanner;	// import = ctrl + shift + o

public class SelectionFun {

	public static void main(String[] args) {
		// The type Boolean has two values: true and false.
		Scanner in = new Scanner(System.in);
		System.out.print("Please enter a boolean (true/false) value: ");
		boolean isFun = in.nextBoolean();
		System.out.println("You entered: " + isFun);
		
		
		// Relational operators
		// < less than
		// <= less than or equal to
		// > greater than
		// >= greater than or equal to
		// == equal to
		// != not equal to
		
		System.out.print("Integer a? ");
		int a = in.nextInt();
		System.out.print("Integer b? ");
		int b = in.nextInt();
		System.out.println(a > b);
		
		boolean isGreaterThan = a > b;
		System.out.println(isGreaterThan);
		boolean boolVal = true;
		System.out.println(boolVal);
		
		// Good, descriptive boolean variable names often start with is/has,
		// e.g. isLegalInput, isGameOver, hasDuplicates.
		
		
		
		// if Statements
		if (a > b) {
			System.out.println("a is greater than b.");
		}
		if (a > 0) {
			System.out.println("a is positive.");
			System.out.println("I'm positive.");
		}
		
		
		/* General if-statement syntax:
		if (<Condition>)
 			<Statement> 		
 		
 		This is equivalent and encouraged to avoid pitfalls:
 		if (<Condition>) {
 			<Statement>
 		}
		 */
		// Exercise: Create an if statement that, when b is negative, prints "b is negative. Don't be negative." 
		if (b < 0) {
			System.out.println("b is negative. Don't be negative.");
		}
		
		
		
		// Either-or, 2-case if-else Statement
		if (a > 0) {
			System.out.println("a is positive.");
		}
		else {
			System.out.println("a is not positive.");
		}
		
		/* General if-statement syntax:
		if (<Condition>)
 			<Statement> 		
 		else
 			<Statement>
 		
 		This is equivalent and encouraged to avoid pitfalls:
 		if (<Condition>) {
 			<Statement>
 		}
 		else {
 			<Statement>
 		}
		 */
		// Exercise: Create an if-else statement that will compare a to b
		// and print "a is greater than b."
		// or "a is not greater than b."
		if (a > b) {
			System.out.println("a is greater than b.");
		}
		else {
			System.out.println("a is not greater than b.");
		}
		
		
		
		// Nested if statement:
		if (a > b) {
			System.out.println("a is greater than b.");
		}
		else if (a == b) {
			System.out.println("a is equal to b.");
		}
		else {	// a < b
			System.out.println("a is less than b.");
		}
		
		// Exercise: Create an if-else chain that appropriately prints out "positive", "negative", or "zero" on the value of a.
		if (a > 0) {
			System.out.println("positive");
		}
		else if (a == 0) {
			System.out.println("zero");
		}
		else {
			System.out.println("negative");
		}
		
		
		// Common error: missing braces
		if (a > 0)
			System.out.println("a is a positive.");
		System.out.println("I'm positive that a is positive.");
		
		// Remember that whitespace and indentation are ignored by Java.
		// They served to make things more readable by other programmers to make the program structure clear.
		// The above code is equivalent to:
		if (a > 0) {
			System.out.println("a is a positive.");
		}
		System.out.println("I'm positive that a is positive.");
		// But should have been written:
		if (a > 0) {
			System.out.println("a is a positive.");
			System.out.println("I'm positive that a is positive.");
		}
		
		
		
		// Common error: extra semicolon
//		if (a > a); {
//			System.out.println("This should never print.");
//		}
		// This is equivalent to:
//		if (a > a) {};
//		{
//			System.out.println("This should never print.");
//		}
		// What we want:
		if (a > a) {
			System.out.println("This should never print.");
		}
		
		
		// Bad style:
		if (boolVal == true) {
			System.out.println("boolval is true.");
		}
		// Good style: eliminate all extraneous "== true"
		if (boolVal) {
			System.out.println("boolval is true.");
		}
		
		
		// The Dangling-Else Problem
		if (a > 0)
			if (b > 0)
				System.out.println("both positive");
		else
			System.out.println("a is not positive");
		
		// is equivalent to:
		if (a > 0) {
			if (b > 0) {
				System.out.println("both positive");
			}
			else {
				System.out.println("a is not positive");
			}
		}
		// An "else" is associated with the most recent non-nested "if" that doesn't already have an associated "else".
		// What was intended:
		if (a > 0) {
			if (b > 0) {
				System.out.println("both positive");
			}
		}
		else {
			System.out.println("a is not positive");
		}

		
		// Common error: testing equality with floating point numbers without taking into account approximation errors
		double x = 0.7;
		double y = 1.0  - 0.1 - 0.1 - 0.1;
		if (x == y) {
			System.out.println("x == y");
		}
		else {
			System.out.println("x != y");
		}
		System.out.println("x = " + x);
		System.out.println("y = " + y);
		// Best practice: define an error tolerance called EPSILON or EPS 
		// and test whether or not the absolute difference of two floating point numbers is less than EPS
		double EPS = 1e-14;
		if (Math.abs(x - y) < EPS) {
			System.out.println("Close enough to be considered equal.");
		}
		
		
		// Is shorter code always better?
		int turnsTaken = 42;
//		boolean isPlayer1Turn = (turnsTaken % 2 == 0);
		
		// versus
//		boolean isPlayer1Turn = false;
//		if (turnsTaken % 2 == 0) {
//			isPlayer1Turn = true;
//		}
//		else {
//			isPlayer1Turn = false;
//		}
		
		// versus
		// It's player 1's turn if turnsTaken is even. 
		boolean isPlayer1Turn = (turnsTaken % 2 == 0);	// turnsTaken even
		System.out.println("isPlayer1Turn: " + isPlayer1Turn);
		
		
		// Bad style:
		if (a > 0) {
			System.out.println("a is positive");
			System.out.println("a = " + a);
		}
		else if (a == 0) {
			System.out.println("a is zero");
			System.out.println("a = " + a);
		}
		else {
			System.out.println("a is negative");
			System.out.println("a = " + a);
		}
		
		// (2*x + 3*x + 4*x) = (2 + 3 + 4)*x = 9*x
		// Good style: Factor out common code
		if (a > 0) {
			System.out.println("a is positive");
		}
		else if (a == 0) {
			System.out.println("a is zero");
		}
		else {
			System.out.println("a is negative");
		}
		System.out.println("a = " + a);

		
		
		
		in.close();
	}

}
