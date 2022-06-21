import java.util.Arrays;

public class RecursionFun {

	public static void main(String[] args) {
		/*
		 * Recursion - 
		 * *a method directly/indirectly causes itself to be called
		 * *solving a problem in terms of (1) simplest "base" cases, 
		 *  and (2) more general "recursive" cases where one assumes that your solution works for all smaller/simpler cases,
		 *  and one uses solutions through recursive calls to form the solution to the current case 
		 */
		
		// factorial
		for (int i = 0; i <= 5; i++) {
			System.out.printf("%d! = %d\n", i, factorial(i));
		}
		
		
		// Fibonacci sequence
		for (int i = 0; i <= 10; i++) {
			System.out.printf("fib(%d) = %d\n", i, fib(i));
		}
		
		
		// Tower of Hanoi puzzle
		for (int i = 1; i <= 3; i++) {
			System.out.println("Tower of Hanoi size " + i + " solution:");
			moveHanoiStack(i, 0, 2, 1);
		}
		
		
		// Recursive binary search
		int size = 20;
		int[] data = new int[size];
		for (int i = 0; i < size; i++) {
			data[i] = (int) (size * Math.random());
		}
		Arrays.sort(data);
		System.out.println("data: " + Arrays.toString(data));
		
		for (int i = 0; i < size; i++) {
			System.out.printf("binarySearch(%d, data) --> %d\n", i, binarySearch(i, data));
		}
		
		
	}
	
	// Sometimes, the initial call doesn't have all of the parameter information needed for the recursion,
	// so we create an...
	public static int binarySearch(int target, int[] data) {
		return binarySearch(target, data, 0, data.length - 1);
	}
	
	// ... auxiliary/helper function (i.e. method)
	public static int binarySearch(int target, int[] data, int minIndex, int maxIndex) {
		if (minIndex > maxIndex) {	// base case - failure
			return -1;
		}
		int midIndex = (minIndex + maxIndex) / 2;
		if (data[midIndex] == target) {	// base case - success
			return midIndex;
		}
		else if (data[midIndex] > target) {	// recursive case - search lower
			return binarySearch(target, data, minIndex, midIndex - 1);
		}
		else {	// recursive case - search higher
			return binarySearch(target, data, midIndex + 1, maxIndex);
		}
	}
	
	public static int fib(int n) {
		if (n == 0) {	// base case 1
			return 0;
		}
		else if (n == 1) {	// base case 2
			return 1;
		}
		else {	// recursive step
			return fib(n - 1) + fib(n - 2);
		}
	}

	public static int factorial(int n) {
		if (n == 0) {	// base case
			return 1;
		}
		else {	// recursive step
			return n * factorial(n - 1);
		}
	}

	public static void moveHanoiStack(int disks, int fromPeg, int toPeg, int usingPeg) {
		if (disks == 1) {	// base case - move a single disk
			System.out.printf("%d --> %d\n", fromPeg, toPeg);
		}
		else {
			// move n-1 to usingPeg from fromPeg
			moveHanoiStack(disks - 1, fromPeg, usingPeg, toPeg);
			// move 1 to toPeg from fromPeg
			System.out.printf("%d --> %d\n", fromPeg, toPeg);
			// move n-1 to toPeg from using Peg
			moveHanoiStack(disks - 1, usingPeg, toPeg, fromPeg);
		}
	}
	
}
