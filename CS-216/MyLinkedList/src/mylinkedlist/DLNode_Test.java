package mylinkedlist;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.Assert.*;

import org.junit.jupiter.api.Test;

class DLNode_Test {

	@Test
	void test_Constructor_Getters() {
		DLNode<Integer> node = new DLNode<Integer>(2);
		
		assertEquals(node.getData(), 2, "correct data");
		assertEquals(node.getNext(), null, "correct get next item");
		assertEquals(node.getPrev(), null, "correct get prev item");
	}
	
	@Test
	void test_SetNext() {
		DLNode<Integer> node = new DLNode<Integer>(2);
		DLNode<Integer> node1 = new DLNode<Integer>(3);
		node.setNext(node1);
		assertEquals(node.getNext(), node1, "correct set next item");
	}
	
	@Test
	void test_SetPrev() {
		DLNode<Integer> node = new DLNode<Integer>(2);
		DLNode<Integer> node1 = new DLNode<Integer>(3);
		node.setPrev(node1);
		assertEquals(node.getPrev(), node1, "correct set prev item");
	}
	
}
