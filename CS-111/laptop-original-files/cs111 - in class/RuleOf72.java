
import java.util.Scanner;

public class RuleOf72 {

	public static void main(String[] args) {
		// 1. Specification
		
/*
The program must ask the user for their annual percentage rate of increase.
The program will the compute and print the Rule of 72 estimated years to double an investment (yearsEst),
and the exact number of years (yearsExact),
and the ratio of the estimate to the exact value.
 */
		
		// 2. System Analysis
		
/*
yearsEst = 72 / rate
growth exponent g = (1 + rate) / 100
g^yearsExact = 2, so log(g^yearsExact) = log(2),
so yearsExact * log(g) = log(2)
so yearsExact = log(2) / log(g)
ratio = yearsEst / yearsExact
 */
		
		// 3. System Design
		// See comments below
		
		// 4. Implementation
		
		// 5. Testing
		// (Correct integer pct to be a double)
		
		// Ask the user for their annual percentage rate of increase
		System.out.print("Percentage rate of increase? ");
		Scanner in = new Scanner(System.in);
		double pct = in.nextDouble();
		
		
		// Compute and print
		// ... the Rule of 72 estimated years to double an investment (yearsEst)
		double yearsEst = 72 / pct;		// rename : Refactor + rename
		System.out.println("Rule of 72 estimated years to double: " + yearsEst);
		
		
		// ... the exact number of years (yearsExact)
		double g = 1 + pct / 100;
		double yearsExact = Math.log(2) / Math.log(g);
		System.out.println("Exact years to double: " + yearsExact);

		
		// ... the ratio of the estimate to the exact value
		double ratio = yearsEst / yearsExact;
		System.out.println("Ratio of estimated to exact value: " + ratio);

		
		
		in.close();
	}

}
