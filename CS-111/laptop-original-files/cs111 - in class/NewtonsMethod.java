//import java.util.Random;

public class NewtonsMethod {


	public static double f(double x) {
		return (Math.pow(x, 3)- 2*x);
	}

	public static double fPrime(double x) {
		double h = 1e-9;
		return ( f(x + h/2e-9) - f(x - h/2e-9) );

	}

	public static double newton(double initx) {
		// initialize x
		double x = initx;

		// while x is finite
		// and abs of f(x) > some very small number
		while (Math.abs(f(x)) >= 1e-9) {
			x = x - f(x)/fPrime(x);
		}

		// update x according to newton's method
		return x;
	}



	public static void main(String[] args) {

//		System.out.println(f(1));
//		System.out.println(fPrime(1));
		System.out.println(newton(1));













	}

}
