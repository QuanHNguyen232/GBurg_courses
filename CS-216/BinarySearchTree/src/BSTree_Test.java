import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Collections;

import org.junit.jupiter.api.Test;

class BSTree_Test {

	@Test
	void testInsert() {
		BSTree<Integer> tree = new BSTree<Integer>();
		
		Integer int1 = new Integer(1);
		Integer int3 = new Integer(3);
		Integer int2 = new Integer(2);
		
		tree.insert(int1);
		tree.insert(int3);
		tree.insert(int2);
		
		assertEquals("", tree.getHead().getData(), int1);
//		assertEquals("", tree.getHead().getLeftNode().getData(), null);
		assertEquals("", tree.getHead().getRightNode().getData(), int3);
		
		assertEquals("", tree.getHead().getRightNode().getLeftNode().getData(), int2);
//		assertEquals("", tree.getHead().getRightNode().getRightNode().getData(), null);
	}
	
	@Test
	void testInOrder() {
		BSTree<Integer> tree = new BSTree<Integer>();
		// case empty
		ArrayList<Integer> arrTest0 = tree.inOrder();
		assertTrue("", arrTest0 == null);
		
		// case NOT empty
		ArrayList<Integer> arr = new ArrayList<Integer>();
		for (int i = 0; i < 10; i++) {
			arr.add(i);
		}
		// copy
		ArrayList<Integer> arrTest = (ArrayList<Integer>) arr.clone();
		// shuffle
		Collections.shuffle(arrTest);
		// add to BSTree
		for (int i = 0; i < arrTest.size(); i++) {
			tree.insert(arrTest.get(i));
		}
		// inOrder
		arrTest = tree.inOrder();
		// check (compare b/w arr, original, and arrTest, result of InOrder)
		for (int i = 0; i < arrTest.size(); i++) {
			assertEquals("check in order", arrTest.get(i), arr.get(i));
		}
	}
	
	@Test
	void testCheckWeightBalance() {
		// check unbalanced and balanced in testBadWeightBalance()
		BSTree<Integer> tree = new BSTree<Integer>();
		// case empty tree
		assertFalse("", tree.checkWeightBalance(tree.getHead()));
		// case node is null
		assertFalse("", tree.checkWeightBalance(null));
		// case tree has 1 node
		tree.insert(2);		
		assertTrue("", tree.checkWeightBalance(tree.getHead()));
	}
	
	@Test
	void testSearch() {
		BSTree<Integer> tree = new BSTree<Integer>();
		Integer int1 = new Integer(0);
		Integer int2 = new Integer(2);
		Integer int3 = new Integer(8);
		tree.insert(2);
		tree.insert(1);
		tree.insert(10);
		tree.insert(4);
		tree.insert(3);
		tree.insert(7);
		tree.insert(5);
		tree.insert(6);
		tree.insert(9);
		tree.insert(8);
		assertEquals("", tree.search(int1), null);
		assertEquals("", tree.search(int2), int2);
		assertEquals("", tree.search(int3), int3);
	}
	
	@Test
	void testBadWeightBalance() {
		BSTree<Integer> tree = new BSTree<Integer>();
		// initialize unbalanced tree
		tree.insert(2);
		tree.insert(1);
		tree.insert(10);
		tree.insert(4);
		tree.insert(3);
		tree.insert(7);
		tree.insert(5);
		tree.insert(6);
		tree.insert(9);
		tree.insert(8);
		// check unbalanced tree
		assertFalse("", tree.checkWeightBalance(tree.getHead()));
		// use badWeightBalance to create balanced tree
		tree.badWeightBalance();
		// check if tree is balance
		assertTrue("", tree.checkWeightBalance(tree.getHead()));
	}
	
	@Test
	void testHeight() {
		BSTree<Integer> tree = new BSTree<Integer>();
		// case EMPTY tree
		assertEquals(tree.height(tree.getHead(), 0), -1);
		// case not empty
		// case left subtree <= right subtree
		tree.insert(2);tree.insert(1);tree.insert(10);tree.insert(4);tree.insert(3);
		tree.insert(7);tree.insert(5);tree.insert(6);tree.insert(9);tree.insert(8);
		assertEquals(tree.height(tree.getHead(), 0), 5);
		// case left subtree > right subtree
		BSTree<Integer> tree1 = new BSTree<Integer>();
		tree1.insert(5);tree1.insert(1);tree1.insert(0);tree1.insert(3);tree1.insert(-1);
		assertEquals(tree1.height(tree1.getHead(), 0), 3);

	}
	
	@Test
	void testRemove() {
		BSTree<Integer> tree = new BSTree<Integer>();
		// case: null
		assertFalse("", tree.remove(0));
		
		// case: LEAF
		// sub_case: root
		tree.insert(5);
		assertTrue("", tree.remove(5));
		assertEquals("", tree.getHead(), null);
		// sub_case: left
		Integer a = new Integer(5);
		tree.insert(a);tree.insert(0);
		assertTrue("", tree.remove(0));
		assertEquals("", tree.getHead().getLeftNode(), null);
		// sub_case: right
		tree.insert(10);
		assertTrue("", tree.remove(10));
		assertEquals("", tree.getHead().getRightNode(), null);
		
		// case: 1 child LEFT
		BSTree<Integer> tree1 = new BSTree<Integer>();
		// sub_case: root
		tree1.insert(0);	// root
		Integer int1 = new Integer(-5);
		tree1.insert(int1);tree1.insert(-3);tree1.insert(-10);
		assertTrue("", tree1.remove(0));	// root = -5
		// sub_case: left
		BSTree<Integer> tree2 = new BSTree<Integer>();
		Integer b = new Integer(-10);
		tree2.insert(0);tree2.insert(-5);tree2.insert(b);
		assertTrue("", tree2.remove(-5));
		assertEquals("", tree2.getHead().getLeftNode().getData(), b);
		// sub_case: right
		BSTree<Integer> tree3 = new BSTree<Integer>();
		Integer c = new Integer(3);
		tree3.insert(0);tree3.insert(5);tree3.insert(c);
		assertTrue("", tree3.remove(5));
		assertEquals("", tree3.getHead().getRightNode().getData(), c);
		
		// case: 1 child RIGHT
		BSTree<Integer> tree4 = new BSTree<Integer>();
		// sub_case: root
		tree4.insert(0);tree4.insert(5);tree4.insert(2);tree4.insert(6);
		assertTrue("", tree4.remove(0));
		// sub_case: left
		BSTree<Integer> tree5 = new BSTree<Integer>();
		Integer d = new Integer(-3);
		tree5.insert(0);tree5.insert(-5);tree5.insert(d);tree5.insert(-4);
		assertTrue("", tree5.remove(-5));
		assertEquals("", tree5.getHead().getLeftNode().getData(), d);
		// sub_tree: right
		BSTree<Integer> tree6 = new BSTree<Integer>();
		Integer e = new Integer(10);
		tree6.insert(0);tree6.insert(5);tree6.insert(e);tree6.insert(7);tree6.insert(11);
		assertTrue("", tree6.remove(5));
		assertEquals("", tree6.getHead().getRightNode().getData(), e);
		
		// case: 2 CHILDREN
		// sub_case: root
		BSTree<Integer> tree7 = new BSTree<Integer>();
		tree7.insert(0);tree7.insert(-5);tree7.insert(5);tree7.insert(-3);
		assertTrue("", tree7.remove(0));
		// sub_case: NOT root
		BSTree<Integer> tree8 = new BSTree<Integer>();
		Integer f = new Integer(-7);
		Integer g = new Integer(4);
		tree8.insert(0);tree8.insert(-5);tree8.insert(-3);tree8.insert(-10);tree8.insert(-15);tree8.insert(f);
		tree8.insert(5);tree8.insert(10);tree8.insert(2);tree8.insert(1);tree8.insert(3);tree8.insert(g);
		assertTrue("", tree8.remove(-5));
		assertEquals("", tree8.getHead().getLeftNode().getData(), f);
		assertTrue("", tree8.remove(5));
		assertEquals("", tree8.getHead().getRightNode().getData(), g);
	}

	
}
