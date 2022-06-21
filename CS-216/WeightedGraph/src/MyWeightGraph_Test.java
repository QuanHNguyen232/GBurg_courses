import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.LinkedList;

import org.junit.jupiter.api.Test;

class MyWeightGraph_Test {

	@Test
	void testConstructor() {
		MyWeightGraph<Integer> graph = new MyWeightGraph<Integer>();
		assertTrue(graph.vertices.isEmpty());
		assertTrue(graph.distances.isEmpty());
		assertTrue(graph.previous.isEmpty());
		assertTrue(graph.edges.isEmpty());
	}
	
	@Test
	void testAddVertex() {
		MyWeightGraph<Integer> graph = new MyWeightGraph<Integer>();
		assertTrue(graph.addVertex(0));
		assertTrue(graph.vertices.get(0).isEmpty());
		assertFalse(graph.addVertex(0));
	}
	
	@Test
	void testAddEdge() {
		MyWeightGraph<Integer> graph = new MyWeightGraph<Integer>();
		graph.addVertex(-5);
		graph.addVertex(5);
		
		assertFalse(graph.addEdge(5, 6, 1));
		assertFalse(graph.addEdge(6, -5, 1));
		
		assertTrue(graph.addEdge(5, -5, 1));
	}
	
	@Test
	void testReset() {
		MyWeightGraph<Integer> graph = new MyWeightGraph<Integer>();
		graph.start = 0;
		
		graph.addVertex(-5);
		graph.addVertex(5);
		
		graph.distances.put(-5, 1);
		graph.previous.put(5, 50);
		
		graph.reset();
		assertEquals(graph.start, null);
		assertEquals(graph.distances.get(-5).compareTo(Integer.MAX_VALUE), 0);
		assertEquals(graph.previous.get(5), null);
	}
	
	@Test
	void testSort() {
		MyWeightGraph<Integer> graph = new MyWeightGraph<Integer>();
		graph.addVertex(-5);
		graph.addVertex(5);
		graph.addVertex(-10);
		graph.addVertex(10);
		graph.addVertex(-1);
		graph.addVertex(1);
		
		graph.addEdge(5, -5, 1);
		graph.addEdge(1, -1, 3);
		graph.addEdge(10, -10, 2);
		
		graph.sortEdges();
		
		ArrayList<Edge<Integer>> edgeList = graph.edges;
		int val = 1;
		for (Edge<Integer> e : edgeList) {
			assertEquals(e.getWeight().compareTo(val), 0);
			val++;
		}
	}
	
	@Test
	void testKruskal() {
		MyWeightGraph<Integer> graph = new MyWeightGraph<Integer>();
		for (int i = 0; i < 4; i++) {
			graph.addVertex(i);
		}
		graph.addEdge(0, 1, 1);
		graph.addEdge(0, 2, 2);
		graph.addEdge(0, 3, 5);
		graph.addEdge(1, 2, 3);
		graph.addEdge(1, 3, 4);
		graph.addEdge(2, 3, 5);
		MyWeightGraph<Integer> Kgraph = graph.kruskal();
		assertEquals(3, Kgraph.edges.size());
		assertFalse(Kgraph.addEdge(0, 1, 1));
		assertFalse(Kgraph.addEdge(0, 2, 1));
		assertFalse(Kgraph.addEdge(1, 3, 1));
	}
	
	@Test
	void testBFS() {
		MyWeightGraph<String> graph = new MyWeightGraph<String>();
		graph.addVertex("A");
		graph.addVertex("B");
		graph.addVertex("C");
		graph.addVertex("D");
		graph.addVertex("E");
		graph.addVertex("F");
		graph.addVertex("G");
		
		graph.addEdge("A", "B", 1);
		graph.addEdge("A", "C", 1);
		graph.addEdge("A", "D", 1);
		graph.addEdge("C", "E", 1);
		graph.addEdge("C", "F", 1);
		graph.addEdge("D", "G", 1);
		graph.addEdge("G", "F", 1);
		
		graph.bfs("A");
		
		assertEquals(graph.distances.get("A"), 0);
		assertEquals(graph.distances.get("B"), 1);
		assertEquals(graph.distances.get("C"), 1);
		assertEquals(graph.distances.get("D"), 1);
		assertEquals(graph.distances.get("E"), 2);
		assertEquals(graph.distances.get("F"), 2);
		assertEquals(graph.distances.get("G"), 2);
		
	}
	
	@Test
	void testGetPath() {
		MyWeightGraph<String> graph = new MyWeightGraph<String>();
		graph.addVertex("A");
		graph.addVertex("B");
		graph.addVertex("C");
		graph.addVertex("D");
		graph.addVertex("E");
		graph.addVertex("F");
		graph.addVertex("G");
		graph.addVertex("H");
		
		graph.addEdge("A", "B", 1);
		graph.addEdge("A", "C", 1);
		graph.addEdge("A", "D", 1);
		graph.addEdge("C", "E", 1);
		graph.addEdge("C", "F", 1);
		graph.addEdge("D", "G", 1);
		graph.addEdge("G", "F", 1);
		graph.addEdge("G", "H", 1);
		
		graph.bfs("A");
		
		LinkedList<String> path = graph.getPath("H");
		assertEquals(path.get(0).compareTo("H"), 0);
		assertEquals(path.get(1).compareTo("G"), 0);
		assertEquals(path.get(2).compareTo("D"), 0);
		assertEquals(path.get(3).compareTo("A"), 0);

	}
}
