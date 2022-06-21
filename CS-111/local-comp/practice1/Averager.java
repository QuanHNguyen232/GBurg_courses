import java.util.Scanner;

public class Averager {
	public int numTimes = 0;
	public double total = 0;
	public void add(double x) {
		numTimes++;
		total+=x;
	}
	public double getAverage() {
		return total / numTimes;
	}




//	public static void main(String[] args) {
//		Scanner in = new Scanner("8 9 8 9 8 9 8 9 8 9 8 9 8 9 ");
//		double x;
//		Averager avg = new Averager();
//		while (in.hasNextDouble()) {
//			x = in.nextDouble();
//			avg.add(x);
//		}
//		System.out.println(avg.getAverage());
//		in.close();
//	}

}
