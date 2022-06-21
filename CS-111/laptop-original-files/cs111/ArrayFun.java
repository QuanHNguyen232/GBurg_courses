import java.util.Arrays;

public class ArrayFun {

	public static void main(String[] args) {
		// Solution to the String[] args:
		// whitespace-seperated command line arguments
		for (int i = 0; i < args.length; i++) {
			System.out.printf("args[%d] == \"%s\"\n", i, args[i]);
		}
	
		// Array variable hold_references_ to their array objects
		int[] a1 = {1, 2, 3, 4};
		int[] a2 = null;
		a2 = a1;
		a2[0] = 7;	// a2, a1 point to only 1 array
		System.out.println("a1: " + Arrays.toString(a1));
		System.out.println("a2: " + Arrays.toString(a2));
	
		// copy arrays
		a2 = new int[10];
		System.arraycopy(a1, 1, a2, 6, 2);	// way 1
		System.out.println("a1: " + Arrays.toString(a1));
		System.out.println("a2: " + Arrays.toString(a2));
	
		a2 = a1.clone();	// way 2
		a1[0] = 1;
		System.out.println("a1: " + Arrays.toString(a1));
		System.out.println("a2: " + Arrays.toString(a2));
	
		// var args - variable length arguments (must be last parameters)
		System.out.println(Arrays.toString(makeArray(1, 2, 3)));
		showArray("my data:", 1, 2, 3, 4);
	
	
		// A 2D array is just an array of arrays
		double[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}; 
		System.out.println(matrix);
		print2Darray(matrix);
		double[][] matrix2 = new double[3][3];
		print2Darray(matrix2);
		
		
		// ragged arrays - different numbers of columns in different rows
		double[][] ragged = {{1}, {2, 3}};
		print2Darray(ragged);
		double[][] ragged2 = ragged;
		ragged2[1][0] = 42;
		print2Darray(ragged);
		print2Darray(ragged2);
		double[][] ragged3 = deepCopy(ragged);
		ragged3[0][0] = -1;
		print2Darray(ragged);
		print2Darray(ragged3);
	
	}

	// pass and return arrays
	private static void showArray(String label, int... data) {
		System.out.println(label + " " + Arrays.toString(data));
	}

	private static int[] makeArray(int... data) {		
		return data;
	}

	private static double[][] deepCopy(double[][] a) {
		double[][] copy = new double[a.length][];
		for (int row = 0; row < copy.length; row++) {
			copy[row] = a[row].clone();
		}
		
		
		return copy;
	}

	private static void print2Darray(double[][] matrix) {
		// for each row
		for (int row = 0; row < matrix.length; row++) {
			// for each column
			for (int col = 0; col < matrix[row].length; col++) {
				// print matrix entry
				System.out.print(matrix[row][col] + (col < matrix[row].length - 1 ? " " : "\n"));
			}
		}	
	}

}
