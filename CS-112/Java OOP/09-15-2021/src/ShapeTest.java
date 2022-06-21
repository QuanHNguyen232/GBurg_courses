
public class ShapeTest {

	public static void main(String[] args) {
		MyCircle c1 = new MyCircle(5.3);
		
		System.out.println("The circle's radius is: " + c1.getRadius());
		System.out.println("The circle's x position is: " + c1.getX());
		System.out.println("The circle's y position is: " + c1.getY());
		
		c1.setX(-3);
		System.out.println("The circle's x position is: " + c1.getX());
		
		System.out.printf("The circle's area is %f\n", c1.getArea());
		
		System.out.println(c1);
		System.out.println(c1.toString());
		
		MyCircle c2 = c1; // also have same reference
		System.out.println(c2);
	}

}
