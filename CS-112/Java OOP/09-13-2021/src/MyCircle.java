
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
	
	
	
	
	
	
	
	
	
	
	
//	public static void main(String[] args) {
//	}

}
