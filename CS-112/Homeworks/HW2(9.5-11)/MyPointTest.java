
public class MyPointTest {

	public static void main(String[] args) {
		// Test constructor
		MyPoint p0 = new MyPoint();
		MyPoint p1 = new MyPoint(2.0, 2.0);
		MyPoint p2 = new MyPoint(3.0, 7.0);
		
		// Test getters
		System.out.println("p1's x = " + p1.getX());;
		System.out.println("p1's y = " + p1.getY());
		
		// Test distance
		System.out.println("distance p1 to (5,6) = " + p1.distance(3, 7));
		System.out.println("distance between p1 and p2: " + p1.distance(p2));
		System.out.println("distance p0 and p2: " + MyPoint.distance(p0, p2));
	}

}
