
public class Complex {
	
	// field
	private double real;
	private double imag;
	
	// constructor
	public Complex(double real, double imag) {
		this.real = real;
		this.imag = imag;
	}
	
	// getter
	public double real() {
		return this.real;
	}
	
	public double imag() {
		return this.imag;
	}
	
	// method
	
	// add
	public Complex add(Complex other) {
		double sumReal = this.real + other.real;
		double sumImag = this.imag + other.imag;
		return new Complex(sumReal, sumImag);
	}
	
	// subtract
	public Complex subtract(Complex other) {
		double subReal = this.real - other.real;
		double subImag = this.imag - other.imag;
		return new Complex(subReal, subImag);
	}
	
	//multiply
	public Complex multiply(Complex other) {
		double mulReal = (this.real * other.real) + (this.imag * other.imag)*(-1);
		double mulImag = (this.real * other.imag) + (this.imag * other.real);
		return new Complex(mulReal, mulImag);
	}

	
	// divide
	public Complex divide(Complex other) {
		double e = other.real*other.real + other.imag*other.imag;
		double divReal = ((this.real * other.real) + (this.imag * other.imag)) / e;
		double divImag = ((-1)*(this.real * other.imag) + (this.imag * other.real)) / e;
		return new Complex(divReal, divImag);
	}
	
	@Override
	public String toString() {
		return real + "+" + imag + "i";
	}

	
//	public static void main(String[] args) {
//		Complex a = new Complex(5, -6);
//		Complex b = new Complex(7, 3);
//		
//		System.out.println("a: " + a);
//		System.out.println("b: "+b);
//		
//		System.out.println(a.add(b));
//		System.out.println(a.subtract(b));
//		System.out.println(a.multiply(b));
//		System.out.println(a.divide(b));
//	}

}
