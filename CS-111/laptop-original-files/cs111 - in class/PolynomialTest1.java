
public class PolynomialTest1 {

	public static void main(String[] args) {
		Polynomial1 p0 = new Polynomial1();
		test(p0);
		Polynomial1 p1 = new Polynomial1(1.0, 2.0);
		test(p1);
		Polynomial1 p2 = new Polynomial1(3, 5, 7);
		test(p2);
		Polynomial1 p = p1.add(p2);
	}

	private static void test(Polynomial1 p) {
		System.out.println(p);
		for (double x = -2.0; x <= 2.0; x += 1) {
			System.out.println(x + "\t" + p.f(x));
		}
	}

}
