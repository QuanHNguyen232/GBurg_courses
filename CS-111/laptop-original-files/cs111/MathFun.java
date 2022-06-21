import java.util.Scanner;

public class MathFun {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.print("Degrees? ");
		double deg = in.nextDouble();
		double rad = deg * Math.PI / 180;
		rad = Math.toRadians(deg);
		System.out.println("Radians rad = " + rad);
		System.out.println("sin(rad) = " + Math.sin(rad));
		System.out.println("cos(rad) = " + Math.cos(rad));
		System.out.println("tan(rad) = " + Math.tan(rad));
		
		System.out.println("asin(sin(rad)) = " + Math.asin(Math.sin(rad)));
		System.out.println("acos(cos(rad)) = " + Math.acos(Math.cos(rad)));
		System.out.println("atan(tan(rad)) = " + Math.atan(Math.tan(rad)));
		System.out.println("degree = " + Math.toDegrees(rad));
		
		
		// Exponential methods
		double x = 123.456;
		System.out.println(Math.log(x));
		System.out.println(Math.exp(Math.log(x)));
		System.out.println(Math.log10(x));
		System.out.println(Math.pow(10, Math.log10(x)));
		System.out.println(Math.sqrt(x));
		System.out.println(Math.pow(Math.sqrt(x), 2));
		
		
		// Double to in conversion: (int), round, floor, ceiling
		System.out.print("Double value x? ");
		x = in.nextDouble();
		System.out.println("(int) x: " + (int) x);
		System.out.println("round x: " + (int) Math.round(x));	// no (int) -> still in double with .0
		System.out.println("floor x: " + (int) Math.floor(x));
		System.out.println("ceiling x: " + (int) Math.ceil(x));
		
		
		// Max, min, abs
		System.out.println(Math.max(42, x));
		System.out.println(Math.min(42, x));
		System.out.println(Math.abs(x));
		
		
		// Constants
		System.out.println(Math.PI);
		System.out.println(Math.E);
		
		
		
		
		
		in.close();
	}

}
