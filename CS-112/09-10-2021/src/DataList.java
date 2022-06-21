public class DataList {
	
	public static final int MAX_VALUES = 10;
	
	// fields
	private double[] data;
	private int used;
	
	// constructor
	public DataList() {
		data = new double[MAX_VALUES];
		used = 0;
	}
	
	// method
	public void addValue(double value) {
		// check if there is room
		if (used < MAX_VALUES) {
			data[used] = value;
			used++;
		}
		
		// error condition ?
		
	}
	
	public double getSum() {
		double result = 0;
		for (int i = 0; i < used; i++) {
			result += data[i];
		}
		return result;
	}
	
	
	
	
	
	
	
	
//	public static void main(String[] args) {
//	}

}
