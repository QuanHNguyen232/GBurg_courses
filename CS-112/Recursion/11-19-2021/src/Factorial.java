import java.util.Scanner;

public class Factorial {

	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		
		// Find Factorial
//		System.out.print("Enter a positive integer: ");
//		int n = in.nextInt();
//		
//		System.out.printf("%d! = %d\n", n, factorial(n));
		
		// Find GCD
//		System.out.print("Enter 2 numbers: ");
//		int x = in.nextInt();
//		int y = in.nextInt();
//		System.out.printf("gcd(%d, %d) is %d\n", x, y, gcd(x, y));
		
		// Find Fibonacci
		System.out.print("Enter a positive integer: ");
		int n = in.nextInt();

		System.out.printf("fib(%d) = %d\n", n, fib(n));
		
		
		
		in.close();
	}
	
	public static int fib(int n) {
		// base case
		if (n == 0) {	// or n==1 return 1
			return 0;
		}
		if (n==1) {
			return 1;
		}
		return fib(n-1)+fib(n-2);
	}
	
	public static int gcd(int x, int y) {
		// base case
		if (y == 0) {
			return x;
		}
		return gcd(y, x%y);
	}
	
	public static long factorial(long n) {
		// base case
		if (n == 0) {
			return 1;	// 0! = 1
		}
		return n*factorial(n-1);
	}
	
}

/*
how it works: call stack
fac with n=8
fac with n=9
fac with n=10
main with n=10

then when excecute:
-eliminate: fac with n=8
-fac with n=9 return values of n*(fac with n=8)


*/
