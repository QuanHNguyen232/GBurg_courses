
public class Rectangle {

	// Field
	private final int MAXIMUM = 20;
	private int width = 1, height = 1;
	
	// constructor
	public Rectangle() {}
	public Rectangle(int width, int height) {
		this.width = (width >= 1 && width <= MAXIMUM) ? width : this.width;
		this.height = (height >= 1 && height <= MAXIMUM) ? height : this.height;
	}
	
	
	// method
	public int getWidth() {
		return width;
	}
	
	public void setWidth(int width) {
		this.width = (width >= 1 && width <= MAXIMUM) ? width : this.width;
	}
	
	public int getHeight() {
		return height;
	}
	
	public void setHeight(int height) {
		this.height = (height >= 1 && height <= MAXIMUM) ? height : this.height;
	}
	
	public int getArea() {
		return width * height;
	}
	
	public int getPerimeter() {
		return (width + height) * 2;
	}
	
	public void print() {
		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
//	public static void main(String[] args) {
//	}

}
