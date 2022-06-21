
import java.util.Scanner;

public class ContinuedFraction {

	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		System.out.print("Please enter a real number: ");
		double x = in.nextDouble();
		// x = Math.PI;
		// x = Math.E;
		// x = (1 + Math.sqrt(5)) / 2; (Golden Ratio)
		// x = Math.sqrt(5);
		
		
		
		int i = (int) x;
		System.out.print("[" + i + "; ");
		x -= i;
		x = 1 / x;
		
		i = (int) x;
		System.out.print(i + "; ");
		x -= i;
		x = 1 / x;
		i = (int) x;
		System.out.print(i + "; ");
		x -= i;
		x = 1 / x;
		i = (int) x;
		System.out.print(i + "; ");
		x -= i;
		x = 1 / x;
		i = (int) x;
		System.out.print(i + "; ");
		x -= i;
		x = 1 / x;
		i = (int) x;
		System.out.print(i + "; ");
		x -= i;
		x = 1 / x;
		i = (int) x;
		System.out.print(i + "; ");
		x -= i;
		x = 1 / x;
		i = (int) x;
		System.out.print(i + "; ");
		x -= i;
		x = 1 / x;
		i = (int) x;
		System.out.print(i + "; ");
		x -= i;
		x = 1 / x;
		i = (int) x;
		System.out.print(i + "; ");
		x -= i;
		x = 1 / x;
		
		System.out.println("...]");
		
		
		in.close();
	}

}
