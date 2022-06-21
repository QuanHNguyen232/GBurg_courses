import java.util.Scanner;

public class EOFLoop { // EOF = end of file

	public static void main(String[] args) {
		Scanner in =  new Scanner(System.in); // Ctr + Shift + O to import package
		
		int sum = 0;
		
		while (in.hasNextDouble()) {
			sum += in.nextDouble();
		}
		System.out.println(sum);
		// Use Ctrl + D to end the file OR a char/String (non-double)
	}

}
