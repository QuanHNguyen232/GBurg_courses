import java.util.Scanner;

public class Ch2Fun {	// class names: uppercase CamelCase

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		// Control + Shift + o to manage imports -> import java.util.Scanner on the top
		
		System.out.print("First positive integer: ");
		int first = in.nextInt();	// variable names: lowercase camelCase
		// Primitive (a.k.a fundamental) numeric datatypes:
		// byte (8 bits), short (16), int (32), long (64)
		// float (32), double (64)
		// nybble = 4 bits
		
		System.out.print("Second positive integer: ");
		int second = in.nextInt();
		int third = first + second;
		double ratio = (double) third / second;
		System.out.println(third + " ratio " + ratio);	// string concatenation
		
		first = second;
		second = third;
		third = first + second;
		ratio = (double) third / second;
		System.out.println(third + " ratio " + ratio);		
		first = second;
		second = third;
		third = first + second;
		ratio = (double) third / second;
		System.out.println(third + " ratio " + ratio);	// string concatenation
		first = second;
		second = third;
		third = first + second;
		ratio = (double) third / second;
		System.out.println(third + " ratio " + ratio);	// string concatenation		
		first = second;
		second = third;
		third = first + second;
		ratio = (double) third / second;
		System.out.println(third + " ratio " + ratio);	// string concatenation		
		first = second;
		second = third;
		third = first + second;
		ratio = (double) third / second;
		System.out.println(third + " ratio " + ratio);	// string concatenation		
		first = second;
		second = third;
		third = first + second;
		ratio = (double) third / second;
		System.out.println(third + " ratio " + ratio);	// string concatenation		
		first = second;
		second = third;
		third = first + second;
		ratio = (double) third / second;
		System.out.println(third + " ratio " + ratio);	// string concatenation		
		first = second;
		second = third;
		third = first + second;
		ratio = (double) third / second;
		System.out.println(third + " ratio " + ratio);	// string concatenation
		first = second;
		second = third;
		third = first + second;
		ratio = (double) third / second;
		System.out.println(third + " ratio " + ratio);	// string concatenation
		
		// Golden Ratio
		final double PHI = (1 + Math.sqrt(5)) /2;	// final naming convention UPPERCASE_WITH_UNDERSCORES
		System.out.println("phi = " + PHI);
		
		// Continue fraction:
		System.out.print("Please enter a real number: ");
		double x = in.nextDouble();
		x = Math.pow(x, -1) + 1;	// or "1.0 / x + 1"
		System.out.println("reciprocal + 1: " + x);
		
		x = Math.pow(x, -1) + 1;
		System.out.println("reciprocal + 1: " + x);
		x = Math.pow(x, -1) + 1;
		System.out.println("reciprocal + 1: " + x);
		x = Math.pow(x, -1) + 1;
		System.out.println("reciprocal + 1: " + x);
		x = Math.pow(x, -1) + 1;
		System.out.println("reciprocal + 1: " + x);
		x = Math.pow(x, -1) + 1;
		System.out.println("reciprocal + 1: " + x);
		x = Math.pow(x, -1) + 1;
		System.out.println("reciprocal + 1: " + x);
		x = Math.pow(x, -1) + 1;
		System.out.println("reciprocal + 1: " + x);
		x = Math.pow(x, -1) + 1;
		System.out.println("reciprocal + 1: " + x);
		x = Math.pow(x, -1) + 1;
		System.out.println("reciprocal + 1: " + x);
		
		System.out.println(42);
		System.out.println(0b101010);	// binary - leading "0b" or "0B"
		System.out.println(052);	// octal - leading "0"
		System.out.println(0x2a);	// hexadecimal - leading "0x" or "0X"
		
		// When including a decimal point, literals are assumed to be doubles (64 bits) 
		System.out.println(1.0 / 3.0);
		// Adding 'd' or 'D' designates a double (and makes no difference)
		System.out.println(1.0d / 3.0D);
		// Adding "f" or "F" designates a float (32 bits)
		System.out.println(1.0f / 3.0F);
		
		
		// Scientific notation: replace "x10^" with "e" or "E"	
		System.out.println(1e-14 / 3e-14);
		System.out.println(1e10 / 3e+10);
		System.out.println(1e5 / 3e-5);
		
		// Basic operator precedence is as you've learned (PEMDAS)
		// You'll learn precedence rules for other operators in Ch. 3.
		System.out.println(2 + 3 * 4);
		System.out.println(2 + (3 * 4));
		System.out.println((2 + 3) * 4);
		
		// Division between two ints is integer division:
		System.out.println(5 / 3);
		// If either value is a floating point value, floating point division takes place
		System.out.println(5.0 / 3);
		System.out.println(5 / 3.0);
		System.out.println(5.0 / 3.0);
		
		// Integer remainder: %
		int dividend = 5;
		int divisor = 3;
		int quotient = dividend / divisor;
		int remainder = dividend % divisor;
		System.out.println(dividend + " / " + divisor + " = " + quotient + " remainder " + remainder);
		
		// Note what we get with negative numbers:
		dividend = -5;
		divisor = 3;
		quotient = dividend / divisor;
		remainder = dividend % divisor;
		System.out.println(dividend + " / " + divisor + " = " + quotient + " remainder " + remainder);
		
		dividend = 5;
		divisor = -3;
		quotient = dividend / divisor;
		remainder = dividend % divisor;
		System.out.println(dividend + " / " + divisor + " = " + quotient + " remainder " + remainder);
		// quotient * divisor + remainder = dividend
		// Note: Don't assume that remainders are nonnegative
		
		// Augmented assignment operators:
		int a = 42;
		System.out.println(a);
		a /= 2;
		System.out.println(a);
		a *= 3;
		System.out.println(a);
		a += 1;
		System.out.println(a);
		a -= 22;
		System.out.println(a);
		a++;	// postincrement
		System.out.println(a);
		++a;	// preincrement
		System.out.println(a);
		a--;	// postdecrement
		System.out.println(a);
		--a;	// predecrement
		System.out.println(a);
		// Watch the different behaviors when used in expressions:
		System.out.println(a++);	// print a first, then +1
		System.out.println(++a);	// +1 then print a (= a+1)
		System.out.println(a--);
		System.out.println(--a);
		
		// Binary operations between two different numeric types automatically converts to the greatest precision of the types
		// One can also "cast" a numeric type to another numeric type br preceding the value with the desired type parenthesized:
		System.out.println((int) 1.7);
		System.out.println((int) -1.7);
		System.out.println((double) 1 / 3);
		
		// Integer casting (truncation) is_not_the same as rounding, floor, or ceiling (see text section 4.2.3)
		
		
		// Part 3
		
		// Common pitfalls:
		// Error: Undeclared, uninitialized, or unused variables
		// Error: Integer overflow/underflow
		System.out.println(2000000000);
		System.out.println(2000000000 + 2000000000);
		System.out.println(-2000000000 + -2000000000);
		
		// Error: Roundoff error
		System.out.println(1.0 - .9);
		
		// Error: Unintended integer division (see above)
		
		// Redundant input objects
		// Scanner in2 = new Scanner(System.in);
		// Make 1 and _only_ one Scanner if possible and reuse
		
		// Software development process
		// Waterfall model (linear)
		// Spiral model (cyclic, interactive)
		
		
		
		
		
		
		
		
		
		in.close();

	}

}
