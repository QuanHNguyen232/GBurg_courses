import java.util.Scanner;
import java.util.ArrayList;

public class ArrayList1 {

	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		
		ArrayList<Double> arrDouble = new ArrayList<Double>();
		
		double value = in.nextDouble();
		
		while (value >= 0) {
			arrDouble.add(value);
			value = in.nextDouble();
		}
		// Test
		System.out.println(arrDouble);
		
		// Sum
		double sum = 0;
		while (!arrDouble.isEmpty()) {
			sum += arrDouble.remove(0);
		}
		System.out.println("sum = " + sum);
		
		
		
		in.close();
	}

}
