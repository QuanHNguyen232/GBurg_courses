import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Random;

import org.junit.jupiter.api.Test;
import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

class MinPriorityQueue_Test {

	@Test
	void testIsEmpty() {
		MinPriorityQueue<Integer> pq = new MinPriorityQueue<Integer>();
		assertTrue("", pq.isEmpty());
		pq.insert(1);
		assertFalse("", pq.isEmpty());
	}
	
	@Test
	void testInsert_DeleteMin() {
		MinPriorityQueue<Integer> pq = new MinPriorityQueue<Integer>();
		assertEquals("", pq.deleteMin(), null);
		Integer a = new Integer(0);
		Integer b = new Integer(1);
		Integer c = new Integer(3);
		Integer d = new Integer(4);
		Integer e = new Integer(10);
		Integer f = new Integer(5);
		Integer g = new Integer(15);
		Integer[] checkList = {a, b, c, d, e, f, g};
		Integer[] int_list = {b, d, c, a, e, f, g};
		for (Integer i : int_list) {
			pq.insert(i);
		}
		// check
		for (int i = 0; i < int_list.length; i++) {
			assertEquals("", pq.deleteMin(), checkList[i]);
		}
//		Integer i = new Integer(-1);
//		assertEquals("check delete", pq.deleteMin(), i);
//		Integer i1 = new Integer(0);
//		assertEquals("check delete", pq.deleteMin(), i1);
	}
	
	@Test
	void testChangeKey() {
		MinPriorityQueue<Integer> pq = new MinPriorityQueue<Integer>();
		Random rand = new Random(13);
		int size = 11;
		Integer[] list = new Integer[size];
		for (int i=0; i< size; i++) {
			Integer val = rand.nextInt(size);
			list[i] = val;
			pq.insert(val);
		}
		// bubble DOWN
		// [0, 0, 1, 1, 0, 2, 4, 4, 1, 1, 2]
		assertTrue("", pq.changeKey(2, 10));	// [0, 0, 10, 1, 0, 2, 4, 4, 1, 1, 2] -> [0, 0, 2, 1, 0, 10, 4, 4, 1, 1, 2]
		for (int i = 0; i < 5; i++) {
			pq.deleteMin();
		}
		Integer checkVal = pq.deleteMin();
		assertEquals("", list[5], checkVal);
		
		// bubble UP
		MinPriorityQueue<Integer> pq1 = new MinPriorityQueue<Integer>();
		Integer[] l = new Integer[size];
		for (int i=0; i< size; i++) {
			Integer val = rand.nextInt(size);
			l[i] = val;
			pq1.insert(val);
		}
		Integer z = new Integer(-1);
		assertTrue("", pq1.changeKey(9, z));
		assertEquals("", z, pq1.deleteMin());
	}
	
	
}
