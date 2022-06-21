import java.util.Scanner;

public class Collatz {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		System.out.print("Initial positive integer: ");
		int num = in.nextInt();
		
		while (true) {
			System.out.print(num);
			if (num == 1) {
				break;
			}
			else if (num%2 == 0) {
				num /= 2.0;
			}
			else {
				num = (num*3) + 1;
			}
			System.out.print(" ");
		}
		System.out.println();
		
		
		
		in.close();
	}

}
