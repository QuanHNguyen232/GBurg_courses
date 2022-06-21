package mylinkedlist;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.Assert.*;

import org.junit.jupiter.api.Test;

class SLNode_Test {

	@Test
	void test_Constructor_Getters() {
		SLNode<Integer> node = new SLNode<Integer>(2);
		
		assertEquals(node.getData(), 2, "correct data");
		assertEquals(node.getNext(), null, "correct get next item");
	}
	
	@Test
	void test_Set() {
		SLNode<Integer> node = new SLNode<Integer>(2);
		SLNode<Integer> node1 = new SLNode<Integer>(3);
		node.setNext(node1);
		assertEquals(node.getNext(), node1, "correct set next item");
	}
}
