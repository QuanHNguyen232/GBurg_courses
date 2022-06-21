import java.util.Scanner;

public class ReadData {

	public static void main(String[] args) {
		Scanner in =  new Scanner(System.in); // Ctr + Shift + O to import package
		
		
		System.out.print("num: ");
		int num = in.nextInt();
		double[] sum = new double[num];
		
		for (int i=0; i<num; i++) {
			double value = in.nextDouble();
			while (value > 0) {
				sum[i] += value;
				value = in.nextDouble();
			}
		}
		
		
		
		
		for (double d : sum) {
			System.out.println(d);
		}
		in.close();
	}

}
