
// MyCircle is a MyShape
// MyShape is a superclass of MyCircle
// MyCircle is a subclass of MyShape
// MyCircle inherits from MyShape
public class MyCircle extends MyShape {
	// field
	private double radius;
	
	// constructor
	public MyCircle() {}
	// = public MyCircle() {super();};
	
	public MyCircle(double radius) {
		this.radius = radius;
	}
	
	public MyCircle(double xCenter, double yCenter, double radius) {
//		this.x = x;
//		this.y = y;
		
		// use MyShape's constructor: public MyShape(double x, double y)
		// super must be the first in constructor
		super(xCenter, yCenter);
		this.radius = radius;
	}
	
	// method
	public double getRadius() {
		return radius;
	}

	public void setRadius(double radius) {
		this.radius = radius;
	}
	
	@Override
	public double getArea() {
		return Math.PI * this.radius* this.radius;
	}

	@Override
	public String toString() {
//		return "Circle with radius " + this.radius;
		
		// get result of superclass toString
		String result = super.toString().substring(0, super.toString().length() - 2);
		// append this circle's information
		return result + " Circle with radius " + this.radius;
	}
	
	
	public boolean equals(Object o) {
		if (o instanceof MyCircle) {
			MyCircle c = (MyCircle) o;
			return this.getRadius() == c.getRadius();
		}
		return false;
	}
	
	
	
	
	
	
//	public static void main(String[] args) {
//	}

}
