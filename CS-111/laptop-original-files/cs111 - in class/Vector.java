import java.util.Arrays;

public class Vector {

	public Vector(double... x) {
		
	}

	public Vector(Vector v) {
		
	}
	
	private static int[] makeArray(int... data) {		
		return data;
	}
	
//	@Override
//	public String toString() {
//		return Arrays.toString();
//	}

	public static void main(String[] args) {
		Vector x = new Vector(1.1, 1.2);
		Vector a = new Vector(x);
		
	}

}
