
public class MaxMinDiff {

	// constructor
	public MaxMinDiff() {
	}
	
	public static int getMaxMinDiff(int[][] a) {
		if (a==null) {
			return 0;
		}
		int min=a[0][0];
		int max=a[0][0];
		for (int row = 0; row < a.length; row++) {
			for (int col = 0; col < a[0].length; col++) {
				min = min > a[row][col] ? a[row][col] : min;
				max = max < a[row][col] ? a[row][col] : max;
			}
		}
		System.out.println("max: " + max + "; min: " + min);
		return max - min;
	}

	
	public static void main(String[] args) {
		int[][] a = {{}, {1}};
		System.out.println(getMaxMinDiff(a));
	}

}
