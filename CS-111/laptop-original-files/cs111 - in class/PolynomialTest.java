
/**
 * PolynomialTest - Test the Polynomial class.
 * @author Todd W. Neller
 */
public class PolynomialTest {

	/**
	 * Print the Polynomial object with a sample table of f(x) evaluations.
	 * @param p Polynomial to be tested
	 */
	public static void test(Polynomial p) {
		System.out.println(p);
		System.out.println("x\tf(x)");
		for (double x = -2.0; x <= 2.0; x += 1.0)
			System.out.println(x + "\t" + p.f(x));
	}
	
	/**
	 * Create and test Polynomial objects.
	 * @param args (unused)
	 */
	public static void main(String[] args) {
		Polynomial p0 = new Polynomial();
		test(p0);
		Polynomial p1 = new Polynomial(1, 2);
		test(p1);
		Polynomial p2 = new Polynomial(3, 5, 7);
		test(p2);
		Polynomial p = p1.add(p2);
		test(p);
		p = p1.subtract(p2);
		test(p);
		p = p1.multiply(p2);
		test(p);
	}

}
