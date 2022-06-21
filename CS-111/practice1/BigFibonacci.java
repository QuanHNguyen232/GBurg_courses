import java.math.BigInteger;

public class BigFibonacci {

	public static BigInteger num0 = BigInteger.ONE;
	public static BigInteger num1 = BigInteger.ONE;
	public static BigInteger num2;

	public BigFibonacci() {	
	}

	public static BigInteger fib(int n) {
		if (n < 0) {
			return null;
		}
		else if (n == 0) {
			return num0;
		}
		else if (n == 1) {
			return num1;
		}
		else {
			for (int i = 2; i <= n; i++) {
				num2 = num0.add(num1);
				num0 = num1;
				num1 = num2;
			}
			return num2;
		}
	}


//	public static void main(String[] args) {
//		int n = 4;
//		System.out.println(fib(n));
//	}

}
