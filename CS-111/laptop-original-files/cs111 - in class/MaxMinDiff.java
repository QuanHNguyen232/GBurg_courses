
public class MaxMinDiff {
	
	public static int getMaxMinDiff(int[][] a) {
		if (a==null || a.length == 0) {
			return 0;
		}
		int min = a[0][0];
		int max = a[0][0];
		for (int[] row : a) {
			for (int col : row) {
				min = min > col ? col : min;
				max = max < col ? col : max;
			}
		}
		System.out.println("max: " + max + "; min: " + min);
		return max - min;
	}

	
	public static void main(String[] args) {
		int[][] a = {{-2, 3, -4}, {1, 5, 2}};
		System.out.println(getMaxMinDiff(a));
	}

}
