import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;

class AVL_Node_Test {

	@Test
	void testHeight() {
		AVL_Node<Integer> node0 = new AVL_Node<Integer>(0);
		AVL_Node<Integer> node_1 = new AVL_Node<Integer>(-1);
		AVL_Node<Integer> node2 = new AVL_Node<Integer>(2);
		AVL_Node<Integer> node1 = new AVL_Node<Integer>(1);
		
		node0.setLeftNode(node_1);
		node0.setRightNode(node2);
		node2.setLeftNode(node1);
		
		// update bottom up
		node1.updateHeight();
		node2.updateHeight();
		node_1.updateHeight();
		node0.updateHeight();
		
		assertEquals(2, node0.getHeight());
		assertEquals(0, node_1.getHeight());
		assertEquals(1, node2.getHeight());
		assertEquals(0, node1.getHeight());
	}
	
	@Test
	void testGetData() {
		AVL_Node<Integer> node = new AVL_Node<Integer>(5);
		assertEquals(node.getData().compareTo(5), 0);
	}
	
	@Test
	void testBalance() {
		AVL_Node<Integer> node2 = new AVL_Node<Integer>(2);
		AVL_Node<Integer> node0 = new AVL_Node<Integer>(0);
		AVL_Node<Integer> node5 = new AVL_Node<Integer>(5);
		AVL_Node<Integer> node7 = new AVL_Node<Integer>(7);
		
		node5.setLeftNode(node2);
		node2.setLeftNode(node0);
		
		// update bottom up
		node0.updateHeight();
		node2.updateHeight();
		node5.updateHeight();
		
		// check
		assertFalse(node5.balanced());
		
		
		node5.setRightNode(node7);
		node7.updateHeight();
		node5.updateHeight();
		assertTrue(node5.balanced());
	}
	
	@Test
	void testBalFactor() {
		AVL_Node<Integer> node2 = new AVL_Node<Integer>(2);
		AVL_Node<Integer> node0 = new AVL_Node<Integer>(0);
		AVL_Node<Integer> node5 = new AVL_Node<Integer>(5);
		AVL_Node<Integer> node7 = new AVL_Node<Integer>(7);
		
		node5.setRightNode(node7);
		node5.setLeftNode(node2);
		node2.setLeftNode(node0);
		
		// update bottom up
		node0.updateHeight();
		node2.updateHeight();
		node7.updateHeight();
		node5.updateHeight();
		
		assertEquals(-1, node5.balFactor());
		assertEquals(0, node7.balFactor());
	}
	
	@Test
	void testRotateLeft() {
		AVL_Node<Integer> node0 = new AVL_Node<Integer>(0);
		AVL_Node<Integer> node_1 = new AVL_Node<Integer>(-1);
		AVL_Node<Integer> node2 = new AVL_Node<Integer>(2);
		AVL_Node<Integer> node1 = new AVL_Node<Integer>(1);
		
		node0.setLeftNode(node_1);
		node0.setRightNode(node2);
		node2.setLeftNode(node1);
		
		// update bottom up
		node1.updateHeight();
		node2.updateHeight();
		node_1.updateHeight();
		node0.updateHeight();
		
		// rotate
		AVL_Node<Integer> rotateNode = node0.rotateLeft();	// rotateNode = node2
		assertEquals(rotateNode.compareTo(node2), 0);
		assertEquals(2, node2.getHeight());
		assertEquals(1, node0.getHeight());
		assertEquals(0, node_1.getHeight());
		assertEquals(0, node1.getHeight());
		
		// case: node.left == null
		node_1 = new AVL_Node<Integer>(-1);
		node2 = new AVL_Node<Integer>(2);
		node1 = new AVL_Node<Integer>(1);
		
		node2.setLeftNode(node1);
		node1.setLeftNode(node_1);
		
		rotateNode = node2.rotateLeft();
		assertEquals(rotateNode.compareTo(node2), 0);
	}

	@Test
	void testRotateRight() {
		AVL_Node<Integer> node2 = new AVL_Node<Integer>(2);
		AVL_Node<Integer> node0 = new AVL_Node<Integer>(0);
		AVL_Node<Integer> node5 = new AVL_Node<Integer>(5);
		AVL_Node<Integer> node7 = new AVL_Node<Integer>(7);
		
		node5.setRightNode(node7);
		node5.setLeftNode(node2);
		node2.setLeftNode(node0);
		
		// update bottom up
		node0.updateHeight();
		node2.updateHeight();
		node7.updateHeight();
		node5.updateHeight();
		
		// rotate
		AVL_Node<Integer> rotateNode = node5.rotateRight();
		assertEquals(rotateNode.compareTo(node2), 0);
		assertEquals(0, node0.getHeight());
		assertEquals(0, node7.getHeight());
		assertEquals(1, node5.getHeight());
		assertEquals(2, node2.getHeight());
		
		// case: node.left == null
		node2 = new AVL_Node<Integer>(2);
		node5 = new AVL_Node<Integer>(5);
		node7 = new AVL_Node<Integer>(7);
		
		node2.setRightNode(node5);
		node5.setLeftNode(node7);
		
		rotateNode = node2.rotateRight();
		assertEquals(rotateNode.compareTo(node2), 0);
	}
	
	
}
