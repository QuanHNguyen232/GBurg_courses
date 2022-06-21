import java.util.Scanner;

public class Divisors {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.print("Largest integer? ");
		int num = in.nextInt();
		for (int i = 1; i <= num; i++) {
			System.out.print(i + ": ");

			for (int j = 1; j <= i; j++) {
				if (i%j ==0) {
					System.out.print(j + (j == i ? "" : " "));
				}
			}
			
			System.out.println();
		}


		in.close();
	}

}
