import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class DSNode_Test {

	@Test
	void testConstructor() {
		DSNode<Integer> node = new DSNode<Integer>(5);
		assertEquals(node.data.compareTo(5), 0);
		assertEquals(node.getHeight(), 0);
		assertEquals(node.getParent(), null);
	}
	
	@Test
	void testSetParent() {
		DSNode<Integer> node = new DSNode<Integer>(5);
		DSNode<Integer> node1 = new DSNode<Integer>(10);
		node.setParent(node1);
		assertEquals(node.getParent(), node1);
	}
	
	@Test
	void testGetData() {
		DSNode<Integer> node = new DSNode<Integer>(5);
		assertEquals(node.getData().compareTo(5), 0);
	}
	
	@Test
	void testGetHeight() {
		DSNode<Integer> node = new DSNode<Integer>(5);
		assertEquals(node.getHeight(), 0);
	}
	
	@Test
	void testGetParent() {
		DSNode<Integer> node = new DSNode<Integer>(5);
		assertEquals(node.getParent(), null);
	}
	
	@Test
	void testIncreaseHeight() {
		DSNode<Integer> node = new DSNode<Integer>(5);
		node.increaseHeight();
		node.increaseHeight();
		assertEquals(node.getHeight(), 2);
	}
}
