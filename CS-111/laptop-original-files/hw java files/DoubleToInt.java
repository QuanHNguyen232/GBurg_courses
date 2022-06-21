
import java.util.Scanner;

public class DoubleToInt {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.print("Please enter a double value: ");
		double x = in.nextDouble();
		
		System.out.println("(int) " + x + " == " + (int)x);
		System.out.println("(int) Math.round(" + x + ") == " + (int) Math.round(x));
		System.out.println("(int) Math.floor(" + x + ") == " + (int) Math.floor(x));
		System.out.println("(int) Math.ceil(" + x + ") == " + (int) Math.ceil(x));
		
		

		
		
		in.close();
	}

}
