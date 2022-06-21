
public class DataTest {
	
	public static void processData(double[] data) {
		for(int i = 0; i < data.length; i++) {
			double orig = data[i];
			data[i] += 5;
			data[i] = 4*data[i] -6;
			data[i] = data[i]/2;
			data[i] -= 2*orig;
		}
	}
	
	public static void printData(double[] data) {
		System.out.print("[");
		for(double number : data) {
			System.out.printf("%.2f; ", number);
		}
		System.out.println("]");
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("hello");
		System.out.printf("%s\n", "world");
		
		// make data
		// double[] data1 = new double[2];
		double[] data = {1.2, 5.6, -12, -27};
		
		// print
		printData(data);
		
		//process
		processData(data);
		
		// print again
		printData(data);
		
	}
	
}
