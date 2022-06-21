
public class Rational {

	
	private int num;
	private int denom;
	
	public Rational(int n, int d) {
		if(d == 0)
			throw new IllegalArgumentException("Denominator cannot be 0");
		
		this.num = n;
		this.denom = d;
	}
	
	public int getNumerator() {
		return num;
	}
	
	public int getDenominator() {
		return denom;
	}
	
	public double doubleValue() {
		return num/(double)denom;
	}
	
	public String toString() {
		return String.format("%d/%d", num, denom);
	}
	
	@Override
	public boolean equals(Object o) {
		if(o != null && o instanceof Rational) {
			Rational r = (Rational)o;
			//about equal?
			return Math.abs(doubleValue() - r.doubleValue()) < 0.00001;
		}
		else if (o instanceof Number){
			Number n = (Number)o;
			return Math.abs(doubleValue() - n.doubleValue()) < 0.00001;
			
		}
		else {
			return false;
		}
	}
	
}