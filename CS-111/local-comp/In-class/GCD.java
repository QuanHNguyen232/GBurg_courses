import java.util.Scanner;

public class GCD {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.print("Integer a? ");
		int a = in.nextInt();
		System.out.print("Integer b? ");
		int b = in.nextInt();
		
				
		System.out.println("Greatest common divisor of a and b: " + gcd(a, b));
		
		
		in.close();
	}
	
	public static int gcd(int a, int b) {
		int tmp = a + b;
		a = Math.max(a, b);
		b = tmp - a;
		
		while (true) {
			
			tmp = a;
			
			a = b;

			b = tmp % a;

			if (b == 0) {
				break;
			}

		}
		return a;
	}
	
}
