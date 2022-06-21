
public class ShapeTest {

	public static void main(String[] args) {
		MyCircle c1 = new MyCircle(5.3);
		
		System.out.println("The circle's radius is: " + c1.getRadius());
		System.out.println("The circle's x position is: " + c1.getX());
		System.out.println("The circle's y position is: " + c1.getY());
		
		c1.setX(-3);
		System.out.println("The circle's x position is: " + c1.getX());
		
		if (c1 instanceof MyCircle) {
			System.out.println("c1 is MyCircle");
		}
		
		System.out.println(c1.equals(new MyShape()));
		System.out.println(new MyShape().equals(new MyCircle()));
		
		if (c1 instanceof MyShape) {
			System.out.println("c1 instance of MyShape");
		}
		
	}
	
	
	
}
