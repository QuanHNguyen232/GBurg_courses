package mylinkedlist;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class SLList_Test {

	@Test
	void testConstructor() {
		SLList<Integer> list = new SLList<Integer>();
		assertTrue("check construct + traverse", list.traverse().equals(""));
	}
	
	@Test
	void testTraverse() {
		SLList<Integer> list = new SLList<Integer>();
		assertTrue("check traverse", list.traverse().equals(""));
		list.add(1);
		assertTrue("check traverse", list.traverse().equals("1 - "));
		list.add(2);
		assertTrue("check traverse", list.traverse().equals("1 - 2 - "));
		list.add(3);
		assertTrue("check traverse", list.traverse().equals("1 - 2 - 3 - "));
	}
	
	@Test
	void testReverse() {
		SLList<Integer> list = new SLList<Integer>();
		assertTrue("check reverse", list.reverse().equals(""));
		list.add(1);
		assertTrue("check reverse", list.reverse().equals("1"));
		list.add(2);
		assertTrue("check reverse", list.reverse().equals("2 - 1"));
		list.add(3);
		assertTrue("check reverse", list.reverse().equals("3 - 2 - 1"));
	}
	
	@Test
	void testRemove_ver2() {
		SLList<Integer> list = new SLList<Integer>();
		assertFalse("check remove empty", list.remove_ver2(2));
		list.add(1);
		assertFalse("check remove 1 ele", list.remove_ver2(0));
		assertTrue("check remove", list.remove_ver2(1));
		
		list.add(2); list.add(3); list.add(4); list.add(5); list.add(6); list.add(7);
		assertTrue("check remove head", list.remove_ver2(2));
		assertFalse("check remove", list.remove_ver2(0));
		assertTrue("check remove", list.remove_ver2(6));
	}
	
	@Test
	void testSearch() {
		SLList<Integer> list = new SLList<Integer>();
		assertEquals("check search", list.search(2), -1);
		list.add(0);
		list.add(1);
		list.add(2);
		list.add(3);
		assertEquals("check search", list.search(2), 2);
	}
}
