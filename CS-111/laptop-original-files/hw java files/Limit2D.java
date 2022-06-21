import java.util.Arrays;

public class Limit2D {

	public static double[][] value;
	
	public static void limit(double[][] data, double min, double max) {
		for (int i = 0; i < data.length; i++) {
			for (int j=0; j < data[i].length; j++) {
				if (data[i][j] < min)
					data[i][j] = min;
				if (data[i][j] > max)
					data[i][j] = max;
			}
		}
	}

	
//	public static void main(String[] args) {
//		double[][] data = new double[][] 
//				{{-2, -1, 0, 2, 4},
//				{-8, -6, -4, 6, 8}};
//		for (double[] ele : data) {
//			System.out.println(Arrays.toString(ele));
//		}
//
//		limit(data, -2, 4);
//		
//		System.out.println();
//		for (double[] ele : data) {
//			System.out.println(Arrays.toString(ele));
//		}
//
//	}

}
