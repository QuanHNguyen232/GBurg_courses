import java.math.BigInteger;

public class Polymorphism {

	public static void main(String[] args) {
		// array can store Integer, Double, BigInteger etc.
		Number[] numbers =  new Number[4];
		
		numbers[0] = 5;	// autoboxing: create an Integer with value 5
		numbers[1] = 3.2; // Double object
		numbers[2] = new BigInteger("999999999999999999999");
		numbers[3] = Integer.valueOf(12);	// create an Integer object
		
		for (Number n : numbers) {
			System.out.print("num = " + n);
			System.out.println("; double = " + n.doubleValue());
		}
	}

}
