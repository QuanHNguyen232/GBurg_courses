import java.math.BigInteger;
import java.util.Arrays;

public class Polymorphism1 {

	public static void main(String[] args) {
		// array can store Integer, Double, BigInteger etc.
		Number[] numbers =  new Number[4];
		
		numbers[0] = 5;	// autoboxing: create an Integer with value 5
		numbers[1] = 3.2; // Double object
		numbers[2] = new BigInteger("99999999999999999999999999999");
		numbers[3] = Integer.valueOf(12);	// create an Integer object
		
		for (int i = 0; i < numbers.length; i++) {
			System.out.print("num = " + numbers[i] + "\n");
			System.out.println(" double = " + numbers[i].doubleValue());
			
			// BigInteger has a bitlength method
//			System.out.println(numbers[i].bitLength());
			
			// check if this is a BigInteger object
			if (numbers[i] instanceof BigInteger) {
				BigInteger bigInt = (BigInteger) numbers[i];
				System.out.println("  bitLength: " + bigInt.bitLength());
			}
		}
		
		
		
	}

}
