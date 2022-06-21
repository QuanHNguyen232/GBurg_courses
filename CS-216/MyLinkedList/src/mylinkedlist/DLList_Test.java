package mylinkedlist;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import org.junit.jupiter.api.Test;

class DLList_Test {

	@Test
	void testConstructor() {
		DLList<Integer> list = new DLList<Integer>();
		assertTrue("check construct + traverse", list.traverse().equals(""));
	}
	
	@Test
	void testTraverse() {
		DLList<Integer> list = new DLList<Integer>();
		// empty
		assertTrue("check traverse", list.traverse().equals(""));
		
		// not empty
		list.add(1); list.add(2); list.add(3);
		assertTrue("traverse", list.traverse().equals("1 - 2 - 3 - "));
	}
	
	@Test
	void testReverse() {
		DLList<Integer> list = new DLList<Integer>();
		// empty
		assertTrue("check reverse", list.reverse().equals(""));

		// not empty
		list.add(1); list.add(2); list.add(3);
		assertTrue("traverse", list.reverse().equals("3 - 2 - 1 - "));
	}
	
	@Test
	void testRemove() {
		DLList<Integer> list = new DLList<Integer>();
		// empty
		assertFalse("check remove empty", list.remove(2));
		// 1 ele
		list.add(0);
		assertFalse("check remove 1 ele", list.remove(2));
		assertTrue("check remove 1 ele", list.remove(0));
		// head
		list.add(1); list.add(2); list.add(3); list.add(4); list.add(5); list.add(6);
		assertTrue("check remove head", list.remove(1));
		assertTrue("check remove midde", list.remove(5));
	}
	
	@Test
	void testSearch() {
		DLList<Integer> list = new DLList<Integer>();
		// emtpy
		assertEquals("check search", list.search(2), -1);
		
		// not empty
		list.add(0); list.add(1); list.add(2); list.add(3); list.add(4);
		assertEquals("check search", list.search(0), 0);
		assertEquals("check search", list.search(2), 2);
		assertEquals("check search", list.search(4), 4);
	}
}
