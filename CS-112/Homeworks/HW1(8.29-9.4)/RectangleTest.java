
public class RectangleTest {

	public static void main(String[] args) {
		// Test default rectangle
		Rectangle r1 = new Rectangle();
		// Test other rectangles
		Rectangle r2 = new Rectangle(10, 3);
				
		// Test getArea and getPerimeter
		System.out.printf("Test getArea and getPerimeter: r2: area: %d; \t perimeter: %d\n", r2.getArea(), r2.getPerimeter());
		
		// Test print
		System.out.print("Test print:\n");
		r2.print();
		
		// Test normal setters and getters
		r1.setHeight(2);
		r1.setWidth(5);
		System.out.printf("Test normal setters and getters: new r1: (width; height) = (%d; %d)\n", r1.getWidth(), r1.getHeight());
		
		// Test abnormal setters and getters
		r1.setHeight(22);
		r1.setWidth(0);
		System.out.printf("Test abnormal setters and getters abnormal r1: (width; height) = (%d; %d)\n", r1.getWidth(), r1.getHeight());
	}

}
