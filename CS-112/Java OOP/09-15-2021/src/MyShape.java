
public class MyShape {
	
	// field
	private double x, y;
	
	// constructor
	public MyShape() {}
	
	public MyShape(double x, double y) {
		this.x = x;
		this.y = y;
	}

		
	// method
	
	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}
	
	// for now, return 0
	public double getArea() {
		return 0;
	}

	@Override
	public String toString() {
		return String.format("Shape at (%.2f, %.2f)\n", this.x, this.y);
	}
	
	
	public boolean equals(Object o) {
		if (o instanceof MyShape) {
			MyShape o1 = (MyShape) o;
			return this.getArea() == o1.getArea();
		}
		return false;
	}
	
	
	
	
	
	
	
	
//	public static void main(String[] args) {
//	}

}
