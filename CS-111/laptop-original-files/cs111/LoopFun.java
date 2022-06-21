import java.util.Scanner;

public class LoopFun {

	public static void main(String[] args) {
		
		// While loop
		// 1 2 3 4 5 6 7  8 9 10
		int count = 1;
		while (count <=  10) {
			System.out.print(count + " ");
			count++;
		}
		System.out.println();	// create a line after the print

		// 10 9 8 7 6 5 4 3 2 1
		count = 10;
		while (count > 0) {
			System.out.print(count + " ");
			count--;
		}
		System.out.println();
		
		// 5 10 15 20 25
		count = 5;							// count = 1;
		while (count <= 25) {				// while (count <= 5) {
			System.out.print(count + " ");	//		System.out.print(count * 5 + " ");
			count += 5;						//		count++;
		}									// }
		System.out.println();
		
		// 1 2 4 8 16 32 64
		count = 1;							// count = 0;
		while (count <= 64) {				// while (count <= 6) {
			System.out.print(count + " ");	//		System.out.print(Math.round(Math.pow(2, count)) + " ");
			count *= 2;						//		count++;
		}									// }
		System.out.println();
		
		// 1.0 0.5 0.25 0.125
		count = 1;									// count = 1;
		while (count <= 8) {						// while (count <= 4) {
			System.out.print((1.0 / count) + " ");	//		System.out.print(2.0 / (Math.pow(2, count)) + " ");
			count *= 2;								//		count++;
		}											// }
		System.out.println();

		// 1 2 6 24 120
		count = 1;								// count = 1;
		int product = 1;						// int num = 1;
		while (count <= 5) {					// while (count <= 5) {
			product *= count;					//		System.out.print(num + " ");
			System.out.print(product + " ");	//		count++;
			count++;							//		num *= count;
		}										// }
		System.out.println();
		
		// 1 1 2 3 5 8 13 21 34				// count = 0;
		int first = 1;						// int num = 1;
		int second = 1;						// int num1 = 1;
		int third =  0;						// int temp = 0;
		while (first <= 34) {				// System.out.print(1 + " ");
			System.out.print(first + " ");	// while (count <= 7) {
			third = first + second;			//		System.out.print(num + " ");
			first = second;					//		temp = num;
			second = third;					//		num += num1;
		}									//		num1 = temp;
		System.out.println();				//		count++;
		
		
		
		// Do-while loop
		Scanner in = new Scanner(System.in);
		String response;
		do {
			System.out.print("Are we there yet (y/n)? ");
			response = in.nextLine().trim().toLowerCase();
		} while (response.charAt(0) != 'y');	// while the user hasn't answered in the affirmative
		
		
		
		// For loop
		String s = "Hello, world!";
		for (int i = 0; i < s.length(); i++) {
			System.out.print((int) s.charAt(i) + " ");
		}
		System.out.println();
		
		// 1 2 3 4 5 6 7  8 9 10
		for (count = 1; count <= 10; count++) {
			System.out.print(count + " ");
		}
		System.out.println();

		// 10 9 8 7 6 5 4 3 2 1
		for (count = 10; count > 0; count--) {
			System.out.print(count + " ");
		}
		System.out.println();
		
		// 5 10 15 20 25
		for (count = 5; count <= 25; count += 5) {
			System.out.print(count + " ");
		}
		System.out.println();
		
		// 1 2 4 8 16 32 64
		for (count = 1; count <= 64; count *= 2) {
			System.out.print(count + " ");
		}
		System.out.println();
		
		// 1.0 0.5 0.25 0.125
		for (count = 1; count <= 8; count *= 2) {
			System.out.print((1.0 / count) + " ");
		}
		System.out.println();

		// 1 2 6 24 120
		for (count = 1,	product = 1; count <= 5; count++, product *= count) {
			System.out.print(product + " ");
		}
		System.out.println();
		
		
		// Loop choice:
		// Counter-controlled loop? --> for
		// At least one iteration required? --> do-while
		// Otherwise --> while
		
		
		// Nested loop:
		
		// Multiplication table 1-9
/*
 1  2  3  4  5  6  7  8  9
 2  4  6  8 10 12 14 16 18
 ...
 9 18 27 36 45 54 63 72 81
 */
		// for each row
		for (int row = 1; row <= 9; row++) {
			// for each column
			for (int col = 1; col <= 9; col++) {
				System.out.printf("%2d ", row*col);
			}
			System.out.println();
		}
		
		// Algorithmic thinking process:
		// Is the next thing I want to do a single step? --> statement
		// Is the next thing I want to do conditional? --> decision
		// Is the next thing I want to do repetitive? --> loop
		
		
		// 5-by-5 plus/minus patterns
/*
 --+--
 --+--
 +++++
 --+--
 --+--
 */
		for (int r = 0; r < 5; r++) {
			for (int c = 0; c < 5; c++) {
				System.out.print((r == 2 || c == 2) ? '+' : '-');
			}
			System.out.println();
		}
		
		System.out.println();
/*
 -----
 +++++
 +++++
 -----
 -----
 */
		for (int r = 0; r < 5; r++) {
			for (int c = 0; c < 5; c++) {
				System.out.print((r == 1 || r == 2) ? '+' : '-');
			}
			System.out.println();
		}
		
		System.out.println();
/*
 -+++-
 -+++-
 -+++-
 -+++-
 -+++-
 */
		for (int r = 0; r < 5; r++) {
			for (int c = 0; c < 5; c++) {
				System.out.print((c >= 1 && c <=3) ? '+' : '-');
			}
			System.out.println();
		}
		
		System.out.println();
/*
 +----
 ++---
 +++--
 ++++-
 +++++
 */
		for (int r = 0; r < 5; r++) {
			for (int c = 0; c < 5; c++) {
				System.out.print((c <= r) ? '+' : '-');
			}
			System.out.println();
		}
		
		System.out.println();
/*
 ----+
 ---++
 --+++
 -++++
 +++++
 */
		for (int r = 0; r < 5; r++) {
			for (int c = 0; c < 5; c++) {
				System.out.print(( c <= 3-r ) ? '-' : '+');
			}
			System.out.println();
		}
		
		System.out.println();
/*
 +-+-+
 -+-+-
 +-+-+
 -+-+-
 +-+-+
 */
		for (int r = 0; r < 5; r++) {
			for (int c = 0; c < 5; c++) {
				System.out.print( (r%2==1) ? (c%2==1? '+':'-') : (c%2==0? '+':'-'));
			}
			System.out.println();
		}
		
		System.out.println();
/*
 --+--
 -+++-
 +++++
 -+++-
 --+--
 */
		for (int r = 0; r < 5; r++) {
			for (int c = 0; c < 5; c++) {
				System.out.print( (Math.abs(r-2) == 2 && Math.abs(c-2) == 0) ||
						(Math.abs(r-2) ==1 && Math.abs(c-2) <=1) ||
						(Math.abs(r-2) == 0 && Math.abs(c-2) <= 2) ? '+' : '-' );
			}
			System.out.println();
		}
		
		
		
		// break, continue
		while (true) {
			System.out.print("[b]reak/[c]ontinue? ");
			response = in.nextLine().trim().toLowerCase();
			if (response.startsWith("b")) {
				break;
			}
			else if (response.startsWith("c")) {
				continue;
			}
			System.out.println("End of iteration");
		}
		System.out.println("After loop");
		
		
		// Enhanced For loop
		String[] cars = {"Volvo", "BMW", "Ford", "Mazda"};
		for (String i : cars) {
		  System.out.println(i);
		}
		
		in.close();
	}

}
