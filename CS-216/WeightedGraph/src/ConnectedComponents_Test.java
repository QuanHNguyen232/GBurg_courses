import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Set;

import org.junit.jupiter.api.Test;

class ConnectedComponents_Test {

	@Test
	void testConstructor() {
		ConnectedComponents<Integer> scc = new ConnectedComponents<Integer>();
		assertTrue(scc.vertices.isEmpty());
	}

	@Test
	void testAdd() {
		ConnectedComponents<Integer> scc = new ConnectedComponents<Integer>();
		scc.add(2);
		scc.add(20);

		assertEquals(scc.vertices.keySet().size(), 2);
		assertTrue(scc.vertices.get(2) != null);
		assertTrue(scc.vertices.get(20) != null);
	}

	@Test
	void testFind() {
		ConnectedComponents<Integer> scc = new ConnectedComponents<Integer>();
		scc.add(2);
		scc.add(20);

		DSNode<Integer> curNode = scc.vertices.get(2);
		curNode.setParent(new DSNode<Integer>(1));

		assertEquals(scc.find(2), 1);	// since 1 is parent of 2	
		assertEquals(scc.find(20), 20);
		assertEquals(scc.find(0), null);
	}

	@Test
	void testUnion() {
		ConnectedComponents<Integer> scc = new ConnectedComponents<Integer>();
		scc.add(0);
		scc.add(1);
		scc.add(2);
		scc.add(3);
		scc.add(4);
		scc.add(5);
		Set<Integer> s =  scc.vertices.keySet();
		for (Integer val : s) {
			// every node should be the root of itself
			assertEquals( val, scc.find(val) );
		}
		// make structure
		scc.union(0, 1);
		scc.union(1, 2);
		scc.union(3, 4);
		scc.union(5, 4);
		scc.union(5, 5);
		
		assertEquals(scc.find(0), 1);
		assertEquals(scc.find(1), 1);
		assertEquals(scc.find(2), 1);
		assertEquals(scc.find(3), 4);
		assertEquals(scc.find(4), 4);
		assertEquals(scc.find(5), 4);

	}

}
