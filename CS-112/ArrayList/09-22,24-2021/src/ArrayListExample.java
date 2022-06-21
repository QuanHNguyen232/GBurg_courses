import java.util.ArrayList;
import java.util.Scanner;

public class ArrayListExample {

	
	public static double sum(ArrayList<Double> list) {
		double sum = 0;
		for(int i = 0; i < list.size(); i++) {
			sum += list.get(i);
		}
		return sum;
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		ArrayList<Double> numbers = new ArrayList<Double>();
		
		System.out.print("Enter positive numbers, enter a negative to quit: ");
		
		double d = 0;
		
		while( (d = in.nextDouble()) >= 0) {
			numbers.add(d);
		}
		
		double sum = sum(numbers);
		System.out.printf("The sum of %s is %f\n", numbers, sum);
		
	}

}