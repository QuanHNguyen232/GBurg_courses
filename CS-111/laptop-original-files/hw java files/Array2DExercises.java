import java.util.Arrays;
import java.util.Random;

public class Array2DExercises {

	public static void main(String[] args) {
		// Generate and print test array
		int rows = 4, cols = 5, min = -5, max = 5, numValues = (max - min + 1);
		Random random = new Random(); // add a seed in the constructor for repeatable behavior
		int[][] a = new int[rows][cols];
		for (int r = 0; r < rows; r++)
			for (int c = 0; c < cols; c++)
				a[r][c] = min + random.nextInt(numValues);
		System.out.println("int[][] a:");
		for (int[] row : a) {
			for (int i : row)
				System.out.printf("%2d ", i);
			System.out.println();
		}
		
		// Test value counts
		int[] testValues = {min - 1, min, 0, max, max + 1};
		for (int value : testValues)
			System.out.printf("valueCount(a, %d) --> %d\n", value, valueCount​(a, value));

		// Test column maxima
		System.out.printf("columnMax(a) --> %s\n", Arrays.toString(columnMax​(a)));

		// Test value find
		int[] retVal = null;
		for (int value : testValues) 
			System.out.printf("find(a, %d) --> %s\n", value, 
					((retVal = find​(a, value)) == null) ? "null" : Arrays.toString(retVal));

	}
	
	public static int[] columnMax​(int[][] a) {
		int[] maxValue = new int[a[0].length];
		for (int col = 0; col < a[0].length; col++) {
			maxValue[col] = a[0][col];
			for (int row = 0; row < a.length; row++) {
				if (maxValue[col] < a[row][col]) {
					maxValue[col] = a[row][col];
				}
			}
		}
		return maxValue;
	}
	
	public static int[]	find​(int[][] a, int value) {
		for (int row = 0; row < a.length; row++) {
			for (int col = 0; col < a[0].length; col++) {
				if (a[row][col] == value) {
					return new int[] {row, col};
				}
			}
		}
		return null;
	}
	
	public static int valueCount​(int[][] a, int value) {
		int count = 0;
		for (int row = 0; row < a.length; row++) {
			for (int col = 0; col < a[0].length; col++) {
				if (a[row][col] == value) {
					count++;
				}
			}
		}
		return count;
	}
	
}
