import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Random;

import org.junit.jupiter.api.Test;

class myHashTable_Test {

	@Test
	void testResize() {
		myHashTable<Integer> hash = new myHashTable<Integer>();
		// test default
		assertEquals(128, hash.size());
		
		hash.resizeTable(256);
		assertEquals(256, hash.size());
		
		// test NOT empty
		myHashTable<Integer> hash1 = new myHashTable<Integer>();
		for (int i = 0; i < 100; i++) {
			hash1.add(i);			
		}
		hash1.resizeTable(128*3);
		assertEquals(128*3, hash1.size());
		
		// check compress
		myHashTable<Integer> hash2 = new myHashTable<Integer>();
		hash2.resizeTable(256);
		for (int i = 0; i < 66; i++) {
			hash2.add(i);			
		}
		assertEquals(256, hash2.size());
		for (int i = 0; i < 10; i++) {
			hash2.delete(i);
		}
		assertEquals(128, hash2.size());
	}

	@Test
	void testTraverse() {
		myHashTable<Integer> hash = new myHashTable<Integer>();
		ArrayList<Integer> list = new ArrayList<Integer>();
		// empty
		ArrayList<Integer> hashList0 = hash.traverse();
		assertEquals(0, hashList0.size());
		// initialize
		for (int i = 0; i < 10; i++) {
			Integer a = new Integer(i);
			hash.add(a);
			list.add(a);
		}
		Integer a = new Integer(5);
		hash.add(a);
		list.add(a);
		
		ArrayList<Integer> hashList = hash.traverse();
		// check
		for (int i = 0; i < 10; i++) {
			Integer a1 = list.get(i);
			assertEquals(a1, hashList.get(i));
		}
	}
	
	@Test
	void testDelete() {
		myHashTable<Integer> hash = new myHashTable<Integer>();
		Random rand = new Random(0);
		for (int i = 0; i < 20; i++) {
			int a = rand.nextInt(10);
			hash.add(a);
		}
		hash.add(128);
		hash.add(128*2);
		hash.add(128*3);
		assertFalse(hash.delete(-1));
		assertTrue(hash.delete(128*2));
		assertTrue(hash.delete(0));
		assertTrue(hash.delete(5));
		// in hash: [0, 128, 256, 384, 1, 2, 3, 4, 5, 7, 8, 9]
		// added: [0, 8, 9, 7, 5, 3, 1, 1, 9, 4, 7, 7, 3, 2, 5, 4, 4, 5, 1, 0, 128, 256, 384]

	}
	
	@Test
	void testSearch() {
		myHashTable<Integer> hash = new myHashTable<Integer>();
		Random rand = new Random(0);
		for (int i = 0; i < 20; i++) {
			int a = rand.nextInt(10);
			hash.add(a);
		}
		assertTrue(hash.search(9));	// in hash
		assertFalse(hash.search(-1));	// not in hash
		// added:	[0, 8, 9, 7, 5, 3, 1, 1, 9, 4, 7, 7, 3, 2, 5, 4, 4, 5, 1, 0]
		// in hash:	[0, 1, 2, 3, 4, 5, 7, 8, 9]
	}
	
	@Test
	void testMaxDepth() {
		myHashTable<Integer> hash = new myHashTable<Integer>();
		// buckets are empty
		assertEquals(0, hash.maxDepth());
		// buckets have at least 1 element
		Random rand = new Random(0);
		for (int i = 0; i < 20; i++) {
			int a = rand.nextInt(10);
			hash.add(a);
		}
		assertEquals(1, hash.maxDepth());
		hash.add(128);	// hashCode = 0
		hash.add(128*2);	// hashCode = 0
		hash.add(128*3);	// hashCode = 0
		// added:	[0, 8, 9, 7, 5, 3, 1, 1, 9, 4, 7, 7, 3, 2, 5, 4, 4, 5, 1, 0, 128, 256, 384]
		// in hash:	[0, 128, 256, 384, 1, 2, 3, 4, 5, 7, 8, 9]
		assertEquals(4, hash.maxDepth());
	}
	
	@Test
	void testAvgDepth() {
		myHashTable<Integer> hash = new myHashTable<Integer>();
		Random rand = new Random(0);
		for (int i = 0; i < 20; i++) {
			int a = rand.nextInt(10);
			hash.add(a);
		}
		hash.add(128);	// hashCode = 0
		hash.add(128*2);	// hashCode = 0
		hash.add(128*3);	// hashCode = 0
		// index 0 has 4 elements (1+2+3+4 = 10), index 1->8 each has 1 element (1*8=8), index 9-127 each has 0 element
		assertEquals((10 + 1*8 + 0*119)/128.0, hash.avgDepth(), 0.000001);
		// in hash: [0, 128, 256, 384, 1, 2, 3, 4, 5, 7, 8, 9]
		// added: [0, 8, 9, 7, 5, 3, 1, 1, 9, 4, 7, 7, 3, 2, 5, 4, 4, 5, 1, 0, 128, 256, 384]
	}
	
	@Test
	void testEmptyBucket() {
		myHashTable<Integer> hash = new myHashTable<Integer>();
		Random rand = new Random(0);
		for (int i = 0; i < 20; i++) {
			int a = rand.nextInt(10);
			hash.add(a);
		}
		hash.add(128);
		hash.add(128*2);
		hash.add(128*3);
		// total buckets used: from index 0-9 = 9 buckets => 128-9 buckets are empty
		assertEquals((128-9)/128.0, hash.emptyBuckets(), 0.000001);
		// in hash: [0, 128, 256, 384, 1, 2, 3, 4, 5, 7, 8, 9]
		// added: [0, 8, 9, 7, 5, 3, 1, 1, 9, 4, 7, 7, 3, 2, 5, 4, 4, 5, 1, 0, 128, 256, 384]
	}
	
	@Test
	void testKey() {
		myHashTable<Integer> hash = new myHashTable<Integer>();
		Random rand = new Random(0);
		for (int i = 0; i < 20; i++) {
			int a = rand.nextInt(10);
			hash.add(a);
		}
		hash.add(128);
		hash.add(128*2);
		hash.add(128*3);
		// total keys = 9 (index 0-9) + 3 (items in bucket index0) = 12
		assertEquals(12, hash.keys());
		// in hash: [0, 128, 256, 384, 1, 2, 3, 4, 5, 7, 8, 9]
		// added: [0, 8, 9, 7, 5, 3, 1, 1, 9, 4, 7, 7, 3, 2, 5, 4, 4, 5, 1, 0, 128, 256, 384]
	}
}
