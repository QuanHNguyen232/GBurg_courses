
public class Axis {
	
	// fields
	private double maxLength=10;
	private double minDivision = 0.5;
	private String title, unit;
	
	
	// constructors
	public Axis() {};
	public Axis(String s, String u, double length, double division) {
		this.title = s;
		this.unit = u;
		this.maxLength = length;
		this.minDivision = division;
	}
	
	
	
	// methods
	public double getMaxLength() {
		return maxLength;
	}
	public void setMaxLength(double maxLength) {
		this.maxLength = maxLength > 0 ? maxLength : this.maxLength;
	}
	public double getMinDivision() {
		return minDivision;
	}
	public void setMinDivision(double minDivision) {
		this.minDivision = minDivision > 0 && minDivision < maxLength ? minDivision : this.minDivision ;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	};
	
	
	
	
//	public static void main(String[] args) {
//	}

}
