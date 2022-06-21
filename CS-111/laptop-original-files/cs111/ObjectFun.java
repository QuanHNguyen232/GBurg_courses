import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.util.Random;
import java.util.Stack;

public class ObjectFun {

	public static void main(String[] args) {
		// Illustration of Stack class, auto-(un)boxing, and a stochastic test harness
		
		Random random = new Random(3);
		Stack<Integer> stack = new Stack<>();
		int numOps = 20;
		for (int i = 0; i < numOps; i++) {
			int op = random.nextInt(3);
			if (op == 0) {	// push
				int n = random.nextInt(numOps);
				System.out.println("push(" + n + ")");
				stack.push(n);	// auto-boxing
			}
			else if (op == 1) {	// pop
				if (stack.isEmpty()) {	// isEmpty
					i--;
					continue;
				}
				int n = stack.pop();	// auto-unboxing
				System.out.println("pop() --> " + n);
			}
			else {	// peek
				if (stack.isEmpty()) {	// isEmpty
					i--;
					continue;
				}
				System.out.println("peek() --> " + stack.peek());
			}
			System.out.println(stack.isEmpty() ? "(empty stack)" : "size: " + stack.size() + " stack: " + stack);	// size, toString
		}
		
		
		// BigInteger
		
		// Computing large factorials using int?
//		int n = 0;
//		int fact = 1;
//		while (n <= 100) {
//			System.out.printf("%3d! = %d?\n", n, fact);
//			fact *= ++n;
//		}
		
		// Computing large factorials using BigInteger (class):
		BigInteger n = BigInteger.ZERO;
		BigInteger fact = BigInteger.ONE;
		BigInteger oneHundred = new BigInteger("100");
		while (n.compareTo(oneHundred) <= 0) {
			System.out.printf("%s! = %s\n", n, fact);
			n = n.add(BigInteger.ONE);	// BigInteger is _immutable_
			fact = fact.multiply(n);
		}
		
		
		
		// BigDecimal
		
		// Computing phi, the golden ratio, with the repeated fraction method...
		// ... using doubles:
//		double phi = 2;
//		for (int i = 0; i < 40; i++) {
//			phi = 1.0 / phi;
//			phi++;
//			System.out.println(phi);
//		}
//		System.out.println("To double precision:: " + ((1 + Math.sqrt(5)) / 2));
		
		// ... using BigDecimal:
		
		// BigDecimal is similar to BigInteger except that one must take great care with division
		// e.g.:
//		System.out.println(BigDecimal.ONE.divide(new BigDecimal(3)));
		// java.lang.ArithmeticException: Non-terminating decimal expansion; no exact representable decimal result.
//		System.out.println(BigDecimal.ONE.divide(new BigDecimal(3), 5, BigDecimal.ROUND_HALF_UP));
		
		int scale = 1000;
		int extraScale = 10;	// extra digits of precision to assure convergence to lesser digits
		BigDecimal phi = new BigDecimal(2);
		int numIter = 0;
		while (true) {
			numIter++;
			BigDecimal prevPhi = phi;
			phi = BigDecimal.ONE.divide(phi, scale + extraScale, RoundingMode.HALF_UP);
			phi = phi.add(BigDecimal.ONE);
			if (phi.equals(prevPhi)) {
				break;
			}
		}
		phi = phi.divide(BigDecimal.ONE, scale, RoundingMode.FLOOR);	// BigDecimal.ROUND_FLOOR
		System.out.printf("After %d iterations, phi to %d digits:\n", numIter, scale);
		System.out.println(phi);


		
	}

}
