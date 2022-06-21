import java.util.Arrays;
import java.util.Scanner;

public class MyPath {
	
	// field
	private MyPoint[] path;
	
	
	
	// constructor
	public MyPath(int n) {
		this.path = new MyPoint[n];
	}


	// method
	
	// getters
	public MyPoint[] getPath() {
		return this.path.clone(); // use clone to protect our Array
	}
	public MyPoint getPoint(int index) {
		if (index < this.path.length) {
			return this.path[index];
		}
		return null;
	}
	
	// setters
	public void setPath1(int index, MyPoint point) {
		this.path[index] = point;
	}
	public void setPath2(int index, double x, double y) {
		this.path[index] = new MyPoint(x, y);
	}
	public void setPath3(MyPoint[] new_path) {
		this.path = new_path.clone();
	}
	
	// Length
	public double length() {
		double sum = 0;
		for (int i = 1; i < path.length; i++) {
			sum += this.path[i-1].distance(this.path[i]);
		}
		return sum;
	}
	
	
	
//	// MyPath Test
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int length = in.nextInt();
		MyPath path1 = new MyPath(length);
		
		for(int i = 0; i < length; i++) {
			double x = in.nextDouble(), y = in.nextDouble();
			path1.path[i] = new MyPoint(x, y);
		}
		
		// Test getters
		System.out.println(Arrays.toString(path1.getPath()));
		
		for (int i = 0; i < length; i++) {
			System.out.printf("x{%d}: %.2f\t y{%d}: %.2f\n", i, path1.path[i].getX(), i, path1.path[i].getY());
		}
		
		System.out.println("length: " + path1.length());
		
		// test setPath2
		path1.setPath2(2, 15, 9);
		for (int i = 0; i < length; i++) {
			System.out.printf("x{%d}: %.2f\t y{%d}: %.2f\n", i, path1.path[i].getX(), i, path1.path[i].getY());
		}
		
		// Test setPath1
		path1.setPath1(0, new MyPoint(1, 1));
		for (int i = 0; i < length; i++) {
			System.out.printf("x{%d}: %.2f\t y{%d}: %.2f\n", i, path1.path[i].getX(), i, path1.path[i].getY());
		}
		
		in.close();
	}

}
