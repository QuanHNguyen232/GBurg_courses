import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class Edge_Test {

	@Test
	void testConstructor() {
		Edge<String> e = new Edge<String>("a", "b", 5);
		
		assertTrue(e.vertex1.equals("a"));
		assertTrue(e.vertex2.equals("b"));
		assertEquals(e.weight, 5);
	}

	@Test
	void testGetVertex1() {
		Edge<String> e = new Edge<String>("a", "b", 5);
		assertTrue(e.getVertex1().equals("a"));
	}
	
	@Test
	void testGetVertex2() {
		Edge<String> e = new Edge<String>("a", "b", 5);
		assertTrue(e.getVertex2().equals("b"));
	}
	
	@Test
	void testGetWeight() {
		Edge<String> e = new Edge<String>("a", "b", 5);
		assertEquals(e.getWeight(), 5);
	}
	
	@Test
	void testCompareTo() {
		Edge<String> e1 = new Edge<String>("a", "b", 5);
		Edge<String> e2 = new Edge<String>("c", "d", 7);
		assertEquals(e1.compareTo(e2), -1);
	}
}
