import java.util.Random;

public class LogicalOperatorFun {

	public static void main(String[] args) {
		Random random = new Random();
		int roll1 = 1 + random.nextInt(6);
		int roll2 = 1 + random.nextInt(6);
		System.out.println("roll 1 = " + roll1);
		System.out.println("roll 2 = " + roll2);
		boolean isEven1 = (roll1 % 2 == 0);	// roll1 even
		boolean isEven2 = (roll2 % 2 == 0);	// roll2 even
		System.out.println("Is roll 1 even? " + isEven1);
		System.out.println("Is roll 2 even? " + isEven2);
		System.out.println("Is roll 1 odd? " + !isEven1);
		System.out.println("Are both even? " + (isEven1 && isEven2));
		System.out.println("Is at least one even? " + (isEven1 || isEven2));
		System.out.println("Is one even and one odd? " + (isEven1 ^ isEven2));
		System.out.println("If 1s are wild, do we have a pair? " + (roll1 == roll2 || roll1 == 1 || roll2 == 1));
		
		
		// Conditional expression syntax:
		// <boolean-expression> ? <true-expression> : <false-expression>
		// A.k.a "ternary operator", "selection operator", "if-else expression"
		System.out.println(isEven1 ? "even" : "odd");
		if (isEven1) {
			System.out.println("even");
		}
		else {
			System.out.println("odd");
		}
		
		
		System.out.println("Roll 1 is " + (isEven1 ? "even" : "odd") 
				+ " and roll 2 is " + (isEven2 ? "even" : "odd") + ".");
		System.out.print("Roll 1 is ");
		if (isEven1) {
			System.out.print("even");
		}
		else {
			System.out.print("odd");
		}
		
		System.out.print(" and roll 2 is ");
		if (isEven2) {
			System.out.print("even");
		}
		else {
			System.out.print("odd");
		}
		System.out.println(".");
		
		
		
	}

}
