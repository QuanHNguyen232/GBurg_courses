
public class Position {
	
	// fields
	private double x, y;
	
	// constructors
	/**
	 * @param x
	 * @param y
	 */
	public Position(double x, double y) {
		this.x = x;
		this.y = y;
	}


	// methods
	
	@Override
	public String toString() {
//		return "(" + x + ", " + y + ")";
		return String.format("(%g, %g)", x, y);
	}
	
	/**
	 * @return the x
	 */
	public double getX() {
		return x;
	}

	/**
	 * @param x the x to set
	 */
	public void setX(double x) {
		this.x = x;
	}

	/**
	 * @return the y
	 */
	public double getY() {
		return y;
	}


	/**
	 * @param y the y to set
	 */
	public void setY(double y) {
		this.y = y;
	}

	public void add(double xChange, double yChange) {
		this.x += xChange;
		this.y += yChange;
	}
	
	
	
	
	
//	public static void main(String[] args) {
//	
//	}


	

}
