
public class MyPoint {
	
	// field
	private double x = 0, y = 0;
	
	
	// constructor
	public MyPoint() {}
	public MyPoint(double x, double y) {
		this.x = x;
		this.y = y;
	}
	
	
	// method
	public double getX() {
		return x;
	}

	public double getY() {
		return y;
	}

	public double distance(MyPoint other) {
		return Math.sqrt(Math.pow(other.x - this.x, 2) + Math.pow(other.y - this.y, 2));
	}

	public double distance(double a, double b) {
		return this.distance(new MyPoint(a, b));
	}

	public static double distance(MyPoint p1, MyPoint p2) {
		return p1.distance(p2);
	}
	
	
	
	
	
//	public static void main(String[] args) {
//	}

}
