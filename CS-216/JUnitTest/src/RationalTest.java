import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class RationalTest {

	@Test
	void testConstructor() {
		Rational r = new Rational(3, 4);
		
		assertEquals("Correct numerator", r.getNumerator(), 3);
		assertEquals("Correct denominator", r.getDenominator(), 4);
	}
	
	@Test
	void testBadConstructor() {
//		Rational r = new Rational(2, 0);
		assertThrows(IllegalArgumentException.class, () -> {new Rational(2, 0);});
	}
	
	@Test
	void testToDouble() {
		Rational r = new Rational(3, 4);
		// compare if doubles are close enough
		assertEquals("Double value", r.doubleValue(), .75, .00001);
	}
	
	@Test
	void testEquals() {
		Rational r1 = new Rational(1, 10);
		Rational r2 = new Rational(10, 100);
		Rational r3 = new Rational(1, 100);
		assertEquals("Two equal rationals", r1, r2);
		assertNotEquals("Two different rationals", r1, r3);
		assertTrue("Equals with a value", r1.equals(0.1));
		assertFalse("Not equals with a value", r1.equals(0.5));
		assertFalse("Not equals to null", r1.equals(null));
	}
}
