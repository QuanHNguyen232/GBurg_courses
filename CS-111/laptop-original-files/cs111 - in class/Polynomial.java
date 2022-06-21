
/**
 * Polynomial - a simple, immutable polynomial class for illustrating object-oriented design
 * @author Todd W. Neller
 *
 */
public class Polynomial {

	/**
	 * Polynomial coefficients with coeffs[i] being the coefficient for x^i.  Since x^0 == 1, 
	 * coeffs[0] is the y-intercept.
	 */
	private double[] coeffs;
	
	/**
	 * Constructor taking var args coefficients for the polynomial. 
	 * @param coeffs polynomial coefficients with coeffs[i] being the coefficient for x^i.  Since x^0 == 1, coeffs[0] is the y-intercept.
	 */
	public Polynomial(double... coeffs) {
		this.coeffs = coeffs.length == 0 ? new double[1] : coeffs;
	}
	
	/**
	 * Function evaluation for the polynomial given input x.
	 * @param x input value for polynomial evaluation.
	 * @return value of polynomial at x
	 */
	public double f(double x) {
		double sum = 0;
		double term = 1;
		for (int i = 0; i < coeffs.length; i++) {
			sum += coeffs[i] * term;
			term *= x;
		}
		return sum;
	}
	
	/**
	 * String representation of polynomial.  For coefficients {1, 2, 3}, the representation would
	 * be "1.0 + 2.0*x^1 + 3.0*x^2".
	 */
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(coeffs[0]);
		for (int i = 1; i < coeffs.length; i++)
			sb.append(" + " + coeffs[i] + "*x^" + i);
		return sb.toString();
	}

	/**
	 * Create and return a new Polynomial that is the sum of this and the other.
	 * @param other - other polynomial
	 * @return Polynomial that is the sum of this and the other
	 */
	public Polynomial add(Polynomial other) {
		double[] newCoeffs = new double[Math.max(coeffs.length, other.coeffs.length)];
		for (int i = 0; i < coeffs.length; i++)
			newCoeffs[i] = coeffs[i];
		for (int i = 0; i < other.coeffs.length; i++)
			newCoeffs[i] += other.coeffs[i];
		return new Polynomial(newCoeffs);
	}
	
	/**
	 * Create and return a new Polynomial that is the difference of this and the other.
	 * @param other - other polynomial
	 * @return Polynomial that is the difference of this and the other
	 */
	public Polynomial subtract(Polynomial other) {
		double[] newCoeffs = new double[Math.max(coeffs.length, other.coeffs.length)];
		for (int i = 0; i < coeffs.length; i++)
			newCoeffs[i] = coeffs[i];
		for (int i = 0; i < other.coeffs.length; i++)
			newCoeffs[i] -= other.coeffs[i];
		return new Polynomial(newCoeffs);
	}
	
	/**
	 * Create and return a new Polynomial that is the product of this and the other.
	 * @param other - other polynomial
	 * @return Polynomial that is the product of this and the other
	 */
	public Polynomial multiply(Polynomial other) {
		double[] newCoeffs = new double[coeffs.length + other.coeffs.length - 1];
		for (int i = 0; i < coeffs.length; i++)
			for (int j = 0; j < other.coeffs.length; j++)
				newCoeffs[i + j] += coeffs[i] * other.coeffs[j];
		return new Polynomial(newCoeffs);
	}

}
