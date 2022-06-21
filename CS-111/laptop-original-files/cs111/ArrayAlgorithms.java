import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class ArrayAlgorithms {

	public static void main(String[] args) {
		// 7.2.6 Processing Arrays
		
		// Initializing arrays with array literals
		int[] data = {3, 1, 4, 1, 5, 9, 2, 6, 5, 3};
		
		// Initializing arrays with input values
		int size = 10;
		data = new int[size];
		Scanner in = new Scanner(System.in);
//		for (int i = 0; i <data.length; i++) {
//			System.out.print("int? ");
//			data[i] =  in.nextInt();
//		}
		
		// Initializing arrays with random integers
		Random rand = new Random();
		for (int i = 0; i <data.length; i++) {
			data[i] = rand.nextInt(size);
		}
		
		// Displaying arrays
		System.out.println(Arrays.toString(data));
		String arrStr = Arrays.toString(data); 
		System.out.println(arrStr.substring(1, arrStr.length() - 1));
		
		for (int i = 0; i < data.length; i++) {
			System.out.print(data[i] + (i < data.length - 1 ? ", " : "\n"));
		}
		
		// Summing all elements
		int sum = 0;
		for (int datum : data) {	// for-each loop
			sum += datum;
		}
		System.out.println("Sum: " + sum);
		
		// Finding the largest element
		int largest = data[0];
		for (int i = 0; i < data.length; i++) {
			if (data[i] > largest) {
				largest = data[i];
			}
		}
		System.out.println("Largest: " + largest);
		
		// Finding the smallest index of the largest element
//		largest = data[0];
//		int largestIdx = 0;
//		for (int i = 0; i < data.length; i++) {
//			if (data[i] > largest) {
//				largest = data[i];
//				largestIdx = i;
//			}
//		}
//		System.out.println("Largest index: " + largestIdx);
		int largestIdx = 0;
		for (int i = 0; i < data.length; i++) {
			if (data[i] > data[largestIdx]) {
				largestIdx = i;
			}
		}
		System.out.println("Largest index: " + largestIdx);
		
		// Random shuffling ("Fisher-Yates shuffle" / "Knuth shuffle")
		for (int i = data.length - 1; i > 0; i--) {
			int j = rand.nextInt(i + 1);	// "i + 1" is the most common error
			int tmp = data[i];
			data[i] = data[j];
			data[j] = tmp;
		}
		System.out.println("Shuffle: " + Arrays.toString(data));
		
		// Shifting (rotating, actually) elements
		int tmp = data[0];
		for (int i = 0; i < data.length - 1; i++) {
			data[i] = data[i + 1];
		}
		data[data.length - 1] = tmp;
		System.out.println("Rotated down 1: " + Arrays.toString(data));
		
		// Bonus: Rotating with arraycopy
		int rotation = 3;
		int[] tmpArr = new int[rotation];
		System.arraycopy(data, 0, tmpArr, 0, rotation);
		System.arraycopy(data, rotation, data, 0, data.length - rotation);
		System.arraycopy(tmpArr, 0, data, data.length - rotation, rotation);
		System.out.printf("Rotated down %d: %s\n", rotation, Arrays.toString(data));
		
		// Simplify coding
		System.out.print("Please enter a rank (1 - 13): ");
		int rank = in.nextInt();
		String[] rankNames = {"", "ace", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten", "jack", "queen", "king"};
		System.out.println("Card rank: " + rankNames[rank]);		
		
		in.close();
	}

}
