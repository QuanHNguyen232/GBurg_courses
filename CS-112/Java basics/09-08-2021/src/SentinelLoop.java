import java.util.Scanner;

public class SentinelLoop {

	public static void main(String[] args) {
		Scanner in =  new Scanner(System.in); // Ctr + Shift + O to import package
		
		double value = in.nextDouble();
		double sum = 0;
		
		while (value >= 0) {
			sum += value;
			value = in.nextDouble();
		}
		System.out.println(sum);
		
		
		in.close();
	}

}
