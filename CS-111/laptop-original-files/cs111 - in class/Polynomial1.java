
public class Polynomial1 {

	double[] coeffs;

	public Polynomial1(double... coeffs) {
		this.coeffs = coeffs;
	}

	public Polynomial1() {
		coeffs = new double[1];
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(coeffs[0]);
		for (int i = 1; i < coeffs.length; i++) {
			sb.append(" + " + coeffs[i] + "*x^" + i);
		}
		return sb.toString();
	}

	public double f(double x) {
		double sum = 0;
		double term = 1;
		for (int i = 0; i < coeffs.length; i++) {
			sum += (coeffs[i] * term);
			term *= x;	// term = Math.pow(x, i);
		}
		return sum;
	}

	public Polynomial1 add(Polynomial1 other) {
		double[] newCoeffs = new double[Math.max(coeffs.length, other.coeffs.length)];
		for (int i = 0; i < coeffs.length; i++) {
			newCoeffs[i] = coeffs[i];
		}
		for (int i = 0; i < other.coeffs.length; i++) {
			newCoeffs[i] = other.coeffs[i];
		}

		return null;
	}
	
}
