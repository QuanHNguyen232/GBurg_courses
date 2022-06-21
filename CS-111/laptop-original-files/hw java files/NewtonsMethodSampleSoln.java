public class NewtonsMethodSampleSoln { // https://en.wikipedia.org/wiki/Newton%27s_method

	static final double EPS = 1e-12; // small value
	
	public static double f(double x) {
//		return x * x * x - 2 * x; // + 2 for nonconvergence at 0, 1
//		return (x - 1.5e3) * (x + 2.3) * (x - 0.00001234) * (x + 5.678e2);
		return 24.1729 - 1.9589e6*x - 853844*x*x - 929.9*x*x*x + x*x*x*x; // same as previous, with roots obscured
	}
	
	public static double fPrime(double x) {
//		return 3 * x * x - 2;
		 return fPrimeApprox(x, EPS);
	}
	
	public static double fPrimeApprox(double x, double h) { // central difference https://en.wikipedia.org/wiki/Newton%27s_method
		return (f(x + h / 2) - f(x - h / 2)) / h; 
	}
	
	public static double newton(double initX) {
		double x = initX;
		final int MAX_ITER = 100000;
		int numIter = 0;
		while (!Double.isInfinite(x) && !Double.isNaN(x) && Math.abs(f(x)) > EPS) {
			x -= f(x) / fPrime(x);
			if (++numIter == MAX_ITER) {
//				System.out.printf("Warning: stopped after %d iterations at x = %g\n", MAX_ITER, initX);
				return x;
			}
		} 
		return x;
	}
	
	public static void findRoots() {
		for (double e = -4.0; e <= 4.0; e += 0.5) {
			double initX = Math.pow(10, e);
			System.out.printf("%g --> %g\n", initX, newton(initX));
			System.out.printf("%g --> %g\n", -initX, newton(-initX));
		}
	}
	
	public static void main(String[] args) {
		findRoots();
	}

}
