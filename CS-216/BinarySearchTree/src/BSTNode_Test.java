import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import static org.junit.Assert.*;

class BSTNode_Test {

	@Test
	void testConstructor_getNode() {
		Integer int1 = new Integer(2);
		BSTNode<Integer> node = new BSTNode<Integer>(int1);
		assertEquals("", node.getLeftNode(), null);
		assertEquals("", node.getRightNode(), null);
		assertEquals("", node.getData(), int1);
	}
	
	@Test
	void testSetNode() {
		Integer int1 = new Integer(2);
		BSTNode<Integer> node1 = new BSTNode<Integer>(int1);
		Integer int2 = new Integer(1);
		BSTNode<Integer> left= new BSTNode<Integer>(int2);
		Integer int3 = new Integer(3);
		BSTNode<Integer> right = new BSTNode<Integer>(int3);
		node1.setLeftNode(left);
		node1.setRightNode(right);
		
		assertEquals("", node1.getLeftNode().getData(), int2);
		assertEquals("", node1.getRightNode().getData(), int3);
	}
	
	@Test
	void testCompare() {
		Integer int1 = new Integer(2);
		BSTNode<Integer> node1 = new BSTNode<Integer>(int1);
		Integer int2 = new Integer(1);
		BSTNode<Integer> node2 = new BSTNode<Integer>(int2);
		Integer int3 = new Integer(3);
		BSTNode<Integer> node3 = new BSTNode<Integer>(int3);
		Integer int4 = new Integer(2);
		BSTNode<Integer> node4 = new BSTNode<Integer>(int4);

		assertEquals("", node1.compare(node2), 1);
		assertEquals("", node1.compare(node3), -1);
		assertEquals("", node1.compare(node4), 0);
	}
}
