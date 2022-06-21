
public class NumericTypes {

	public static void main(String[] args) {
		
		int x = -15;
		printValue(x);
		
		int n = 0xFFFFFFF1;	// hexadecimal
		printValue(n);
		
		System.out.printf("are they equal? %B\n", x==n);	// B or b
		
		int o = 037777777761;
		printValue(o);
		
		int max = Integer.MAX_VALUE;
		printValue(max);
		
		int min = Integer.MIN_VALUE;
		printValue(min);
		
		max = Integer.MAX_VALUE + 1;
		printValue(max);
		
		for (int i = Integer.MIN_VALUE; i < Integer.MAX_VALUE; i++) {	// if <=, max + 1 = min, so loop never stops
			
		}
		
	}

	public static void printValue(int x) {

		System.out.printf("dec: %d\n", x);
		System.out.printf("hex: %X\n", x);	// X or x
		System.out.printf("oct: %o\n", x);	// only o, but O
		System.out.println();
	}
	
}
