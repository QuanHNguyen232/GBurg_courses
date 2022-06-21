
import java.util.Scanner;

public class LogisticChaos {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.print("Logistic constant r? ");
		double r = in.nextDouble();
		int iter = 10;	// the number of iterations remaining
		double x = Math.random();
		
		// While loop syntax:
		// While (<condition>) {
		// 	<statement>
		// }	
		
		while (iter > 0)
		{
			System.out.println(x);
			x = r * x * (1 - x);
			--iter;
		}
		
		
		
		
		
		
		
		
		
		
		in.close();
	}

}
