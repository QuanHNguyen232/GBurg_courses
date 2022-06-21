import java.math.RoundingMode;
import java.util.Random;

public class PigMath {
	
	// Constructor
	public PigMath() {
	}
	
	
	public static BigFraction probabilityOfRolling(int target) {
		BigFraction[] p = new BigFraction[target + 6];
		
		for (int i = target; i < target + 6; i++) {
			p[i] = BigFraction.ONE; 
		}
		// loops for (1) initializing your p values
//		Random rand = new Random();
//		int turnTotal = 0, roll;
//		
//		// Loop until turnTotal at least reaches target
//		while (turnTotal < target) {
//			turnTotal = 0;
//			while (turnTotal < target) {
//				roll = rand.nextInt(6) + 1;
//				if (roll == 1) {
//					break;
//				}
//				turnTotal += roll;
//			}
//			p[turnTotal] = turnTotal < target ? BigFraction.ZERO : BigFraction.ONE;
//		}
		
		// (2) iterating down through the turn totals
		
		
		// (3) iterating through the roll numbers 2-6 for each turn total.
		for (int t = target - 1; t >= 0; t--) {
			BigFraction num6 = new BigFraction(6, 1);
			p[t] = p[t+2].divide(num6).add(p[t+3].divide(num6)).add(p[t+4].divide(num6)).add(p[t+5].divide(num6)).add(p[t+6].divide(num6));
		}
		
		
		return p[0];
	}

	/**
	 * Test probabilityOfRolling(100). The result should be "The probability in Pig of rolling at least 100 on a single turn is approximately 0.010197 and exactly 2060507550845146798433160823128452341/202070319366191015160784900114134073344."
	 * @param args (unused)
	 */
	public static void main(String[] args) {
		int target = 100;
		BigFraction frac = probabilityOfRolling(target);
//		System.out.printf("The probability in Pig of rolling at least %d on a single turn is approximately %f and exactly %s.\n", target, frac.asBigDecimal(6, BigDecimal.ROUND_HALF_UP).doubleValue(), frac);
		System.out.printf("The probability in Pig of rolling at least %d on a single turn is approximately %f and exactly %s.\n", target, frac.asBigDecimal(6, RoundingMode.HALF_UP).doubleValue(), frac);
	}

}
