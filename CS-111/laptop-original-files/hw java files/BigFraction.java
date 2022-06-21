import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;

public class BigFraction {
	// Fields
	public static final BigFraction ONE = new BigFraction(1, 1);
	public static final BigFraction ZERO = new BigFraction(0, 1);
	private BigInteger numerator;
	private BigInteger denominator;
	
	
	// Constructors
	public BigFraction(long numerator, long denominator) {
		BigInteger num = BigInteger.valueOf(numerator);
		BigInteger den = BigInteger.valueOf(denominator);
		BigInteger gcd = num.gcd(den);
		this.numerator = num.divide(gcd);
		this.denominator = den.divide(gcd);
		if (den.compareTo(BigInteger.ZERO) < 0) {
			this.numerator = this.numerator.multiply(new BigInteger("-1"));
			this.denominator = this.denominator.multiply(new BigInteger("-1"));
		}
	}
	
	public BigFraction(String s) {
		BigInteger num =  new BigInteger(s.substring(0, s.indexOf("/")));
		BigInteger den = new BigInteger(s.substring(s.indexOf("/") + 1, s.length()));
		BigInteger gcd = num.gcd(den);
		this.numerator = num.divide(gcd);
		this.denominator = den.divide(gcd);
		if (den.compareTo(BigInteger.ZERO) < 0) {
			this.numerator = this.numerator.multiply(new BigInteger("-1"));
			this.denominator = this.denominator.multiply(new BigInteger("-1"));
		}
	}
	
	public BigFraction(BigInteger numerator, BigInteger denominator) {
		BigInteger gcd = numerator.gcd(denominator);
		this.numerator = numerator.divide(gcd);
		this.denominator = denominator.divide(gcd);
		if (denominator.compareTo(BigInteger.ZERO) < 0) {
			this.numerator = this.numerator.multiply(new BigInteger("-1"));
			this.denominator = this.denominator.multiply(new BigInteger("-1"));
		}
	}
	
	public BigFraction(BigFraction f) {
		BigInteger num = f.numerator;
		BigInteger den = f.denominator;
		BigInteger gcd = num.gcd(den);
		this.numerator = num.divide(gcd);
		this.denominator = den.divide(gcd);
		if (den.compareTo(BigInteger.ZERO) < 0) {
			this.numerator = this.numerator.multiply(new BigInteger("-1"));
			this.denominator = this.denominator.multiply(new BigInteger("-1"));
		}
	}
	
	
	// Methods
	
	public BigInteger getNum() {
		return this.numerator;
	}
	
	public BigInteger getDen() {
		return this.denominator;
	}

	@Override
	public String toString() {
		return this.numerator + "/" + this.denominator;
	}
	
	public BigDecimal asBigDecimal(int scale, RoundingMode roundingMode) {
		BigDecimal numerator = new BigDecimal(this.numerator);
		BigDecimal denominator = new BigDecimal(this.denominator);
		return numerator.divide(denominator, scale, roundingMode);
	}
	
	public BigFraction negate() {
		BigInteger num = this.numerator.negate();
		BigFraction newFrac = new BigFraction(num, this.denominator);
		return newFrac;
	}
	
	public BigFraction add(BigFraction b) {
		BigInteger num = (this.numerator.multiply(b.denominator)).add(b.numerator.multiply(this.denominator));
		BigInteger den = this.denominator.multiply(b.denominator);
		BigFraction newFrac = new BigFraction(num, den);
		return newFrac;
	}
	
	public BigFraction subtract(BigFraction b) {
		BigInteger num = (this.numerator.multiply(b.denominator)).subtract(b.numerator.multiply(this.denominator));
		BigInteger den = this.denominator.multiply(b.denominator);
		BigFraction newFrac = new BigFraction(num, den);
		return newFrac;
	}
	
	public BigFraction multiply(BigFraction b) {
		BigInteger num = this.numerator.multiply(b.numerator);
		BigInteger den = this.denominator.multiply(b.denominator);
		BigFraction newFrac = new BigFraction(num, den);
		return newFrac;
	}
	
	public BigFraction divide(BigFraction b) {
		BigInteger num = this.numerator.multiply(b.denominator);
		BigInteger den = this.denominator.multiply(b.numerator);
		BigFraction newFrac = new BigFraction(num, den);
		return newFrac;
	}


	
//	public static void main(String[] args) {
//		BigInteger a = new BigInteger("2");
//		BigInteger b = new BigInteger("-8");
//		
//		BigInteger a1 = new BigInteger("2");
//		BigInteger b1 = new BigInteger("-8");
//		
//		BigFraction c = new BigFraction(2, -4);
//		BigFraction c1 = new BigFraction("2/-4");
//		System.out.println(c);
//		System.out.println(c1);
//	}

}
