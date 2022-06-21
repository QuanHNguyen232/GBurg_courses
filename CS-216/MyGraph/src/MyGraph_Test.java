import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.junit.jupiter.api.Test;

class MyGraph_Test {

	@Test
	void testConstructor() {
		MyGraph<Integer> graph = new MyGraph<Integer>();
		assertEquals(graph.clock, 0);
		assertTrue(graph.vertices.isEmpty());
		assertTrue(graph.visited.isEmpty());
		assertTrue(graph.pre.isEmpty());
		assertTrue(graph.post.isEmpty());
		
		assertTrue(graph.isEmpty());
	}
	
	@Test
	void testAddVertex() {
		MyGraph<Integer> graph = new MyGraph<Integer>();
		graph.addVertex(10);
		assertTrue(graph.vertices.containsKey(10));
		assertTrue((graph.vertices.get(10) != null) && (graph.vertices.get(10).isEmpty()));
		
		assertTrue(graph.visited.containsKey(10));
		assertFalse(graph.visited.get(10));
		
		assertTrue(graph.pre.containsKey(10));
		assertEquals(graph.pre.get(10), -1);
		
		assertTrue(graph.post.containsKey(10));
		assertEquals(graph.post.get(10), -1);
		
		assertFalse(graph.isEmpty());
	}
	
	@Test
	void testAddEdge() {
		MyGraph<Integer> graph = new MyGraph<Integer>();
		Integer a = new Integer(10);
		Integer b = new Integer(-10);
		Integer c = new Integer(0);
		
		// add edge w/o vertex
		graph.addEdge(a, b, false);
		assertEquals(graph.vertices.get(a), null);
		
		// add edge w/ vertices in graph
		graph.addVertex(a);
		
		// add edge w/ 1 vertex
		graph.addEdge(a, b, false);
		assertTrue(graph.vertices.get(a).isEmpty());
		
		graph.addVertex(b);
		graph.addVertex(c);
		
		graph.addEdge(a, b, false);
		assertEquals(graph.vertices.get(a).get(0), b);
		graph.addEdge(a, b, false);
		
		graph.addEdge(b, c, true);
		assertEquals(graph.vertices.get(b).get(0), c);
		assertEquals(graph.vertices.get(c).get(0), b);
	}
	
	@Test
	void testExplore_Previsit_Postvisit() {
		MyGraph<Integer> graph = new MyGraph<Integer>();
		Integer a = new Integer(10);
		Integer b = new Integer(-10);
		Integer c = new Integer(0);
		Integer d = new Integer(5);
		graph.addVertex(a);graph.addVertex(b);graph.addVertex(c);graph.addVertex(d);
		graph.addEdge(a, b, true);
		graph.addEdge(a, c, false);
		
		graph.explore(a);
		assertEquals(graph.pre.get(a), 0);
		assertEquals(graph.pre.get(b), 1);
		assertEquals(graph.pre.get(c), 3);
		
		assertEquals(graph.post.get(c), 4);
		assertEquals(graph.post.get(b), 2);
		assertEquals(graph.post.get(a), 5);
		
		assertEquals(graph.pre.get(d), -1);
		assertEquals(graph.post.get(d), -1);
		
		assertTrue(graph.visited.get(a));
		assertTrue(graph.visited.get(b));
		assertTrue(graph.visited.get(c));
		assertFalse(graph.visited.get(d));
	}
		
	@Test
	void testResetVisited_ResetClock() {
		MyGraph<Integer> graph = new MyGraph<Integer>();
		Integer a = new Integer(10);
		Integer b = new Integer(-10);
		Integer c = new Integer(0);
		Integer d = new Integer(5);
		graph.addVertex(a);graph.addVertex(b);graph.addVertex(c);graph.addVertex(d);
		graph.addEdge(a, b, true);
		graph.addEdge(a, c, false);
		
		graph.explore(a);
		
		graph.resetVisited();
		assertFalse(graph.visited.get(a));
		assertFalse(graph.visited.get(b));
		assertFalse(graph.visited.get(c));
		assertFalse(graph.visited.get(d));
		
		graph.resetClock();
		assertEquals(graph.clock, 0);
	}
	
	@Test
	void testHighPost() {
		MyGraph<Integer> graph = new MyGraph<Integer>();
		Integer a = new Integer(10);
		Integer b = new Integer(-10);
		Integer c = new Integer(0);
		Integer d = new Integer(5);
		graph.addVertex(a);graph.addVertex(b);graph.addVertex(c);graph.addVertex(d);
		graph.addEdge(a, b, true);
		graph.addEdge(a, c, false);
		
		graph.explore(a);
		
		Integer highestPost = graph.highPost();
		assertEquals(a, highestPost);
	}
	
	/**	Trim
	 *     _a      
	 *     / \         f
	 *    /   \|      /
	 *   c <-- b --> e
	 *        /
	 *       d
	 */
	@Test
	void testTrim() {
		MyGraph<Integer> graph = new MyGraph<Integer>();
		Integer a = new Integer(10);
		Integer b = new Integer(-10);
		Integer c = new Integer(2);
		Integer d = new Integer(-2);
		Integer e = new Integer(5);
		Integer f = new Integer(-5);
		graph.addVertex(a);graph.addVertex(b);graph.addVertex(c);graph.addVertex(d);graph.addVertex(e);graph.addVertex(f);
		graph.addEdge(a, b, false);	// GRAPH based on in-class example
		graph.addEdge(b, c, false);
		graph.addEdge(c, a, false);
		graph.addEdge(b, d, true);
		graph.addEdge(b, e, false);
		graph.addEdge(e, f, true);
		
		ArrayList<Integer> removeList = new ArrayList<Integer>();
		removeList.add(e);removeList.add(f);
		
		assertEquals(graph.vertices.get(b).size(), 3);
		
		graph = graph.trim(removeList);
		
		assertEquals(graph.vertices.get(b).size(), 2);

		Set<Integer> remainKeys =  graph.vertices.keySet();
		assertTrue(remainKeys.contains(a));
		assertTrue(remainKeys.contains(b));
		assertTrue(remainKeys.contains(c));
		assertTrue(remainKeys.contains(d));
		assertFalse(remainKeys.contains(e));
		assertFalse(remainKeys.contains(f));
				
		assertEquals(graph.vertices.get(a).get(0), b);
		assertEquals(graph.vertices.get(b).get(0), c);
		assertEquals(graph.vertices.get(b).get(1), d);
		assertEquals(graph.vertices.get(c).get(0), a);
		assertEquals(graph.vertices.get(d).get(0), b);
	}
	
	/**	get SCC
	 *     _a      
	 *     / \         f
	 *    /   \|      /
	 *   c <-- b --> e
	 *        /
	 *       d
	 */
	@Test
	void testGetStrongComponents() {
		MyGraph<Integer> graph = new MyGraph<Integer>();
		Integer a = new Integer(10);
		Integer b = new Integer(-10);
		Integer c = new Integer(2);
		Integer d = new Integer(-2);
		Integer e = new Integer(5);
		Integer f = new Integer(-5);
		graph.addVertex(a);graph.addVertex(b);graph.addVertex(c);graph.addVertex(d);graph.addVertex(e);graph.addVertex(f);
		graph.addEdge(a, b, false);	// GRAPH based on in-class example
		graph.addEdge(b, c, false);
		graph.addEdge(c, a, false);
		graph.addEdge(b, d, true);
		graph.addEdge(b, e, false);
		graph.addEdge(e, f, true);
		
		// Result: 2 SCC
		ArrayList<ArrayList<Integer>> sccList = graph.getStrongComponents();
		assertEquals(sccList.size(), 2);
		// Check elements in each SCC
		ArrayList<Integer> scc1 = sccList.get(0);	// contains e, f
		assertEquals(scc1.get(0), f);
		assertEquals(scc1.get(1), e);
		ArrayList<Integer> scc2 = sccList.get(1);
		assertEquals(scc2.get(0), a);
		assertEquals(scc2.get(1), b);
		assertEquals(scc2.get(2), c);
		assertEquals(scc2.get(3), d);
	}
	
	/**	metagraph (similar to Algorithms-Dasgupta page 93)
	 *  a <--- b <--- c         
	 *       -/|      |
	 *       / |      | 
 	 *      d  e <--- f  
	 *         /\     /\
	 *         |      |
	 *         g ---> h
	 *          |\   /
	 *            \ /_   
	 *             i     
	 */
	@Test
	void testMetagraph() {
		MyGraph<Integer> graph = new MyGraph<Integer>();
		Integer a = new Integer(0);
		Integer b = new Integer(1);
		Integer c = new Integer(2);
		Integer d = new Integer(3);
		Integer e = new Integer(4);
		Integer f = new Integer(5);
		Integer g = new Integer(6);
		Integer h = new Integer(7);
		Integer i = new Integer(8);
//		Integer j = new Integer(9);
//		Integer k = new Integer(10);
//		Integer l = new Integer(11);
		graph.addVertex(a);graph.addVertex(b);graph.addVertex(c);
		graph.addVertex(d);graph.addVertex(e);graph.addVertex(f);
		graph.addVertex(g);graph.addVertex(h);graph.addVertex(i);
		// graph.addVertex(i);graph.addVertex(j);graph.addVertex(k);graph.addVertex(l);
		
		graph.addEdge(d, b, false);
		
		graph.addEdge(b, a, false);
		graph.addEdge(b, e, true);
		
		graph.addEdge(c, b, false);
		graph.addEdge(c, f, true);
		
		graph.addEdge(f, e, false);
		
		graph.addEdge(g, e, false);
		
		graph.addEdge(h, f, false);
		
		graph.addEdge(g, h, false);
		graph.addEdge(h, i, false);
		graph.addEdge(i, g, false);
		
		MyGraph<Integer> metaGraph = graph.metagraph();
		
		Iterator<Integer> vertices = metaGraph.vertices.keySet().iterator();
		int vertexQuantity = 4;
		while (vertices.hasNext()) {
			Integer val = vertices.next();
			// check vertex from source -> sink
			assertEquals(val, vertexQuantity);
			vertexQuantity--;
		}
		// check each edge
		assertTrue(metaGraph.vertices.get(0).isEmpty());
		
		assertEquals(metaGraph.vertices.get(1).get(0), 0);
		
		assertEquals(metaGraph.vertices.get(2).get(0), 1);
		
		assertEquals(metaGraph.vertices.get(3).get(0), 1);
		
		assertEquals(metaGraph.vertices.get(4).get(0), 3);
		assertEquals(metaGraph.vertices.get(4).get(1), 1);
	}
	
	/**	DFS
	 *      a      d
	 *     / \    /|\
	 *    /  _\|   |
	 *   b     c   e
	 */
	@Test
	void testDFS() {
		MyGraph<Integer> graph = new MyGraph<Integer>();
		Integer a = new Integer(10);
		Integer b = new Integer(-10);
		Integer c = new Integer(0);
		Integer d = new Integer(5);
		Integer e = new Integer(-5);
		graph.addVertex(a);graph.addVertex(b);graph.addVertex(c);graph.addVertex(d);graph.addVertex(e);
		graph.addEdge(a, b, true);
		graph.addEdge(a, c, false);
		graph.addEdge(e, d, false);
		
		graph.dfs();
		
		ArrayList<Integer> visitedList = graph.getVisited();
		for(Integer val :  visitedList) {
			assertTrue(graph.visited.get(val));
		}
	}
	
	/**	Reverse
	 *      a      d
	 *     / \    
	 *    /  _\|   
	 *   b     c   
	 */
	@Test
	void testReverse() {
		MyGraph<Integer> graph = new MyGraph<Integer>();
		Integer a = new Integer(10);
		Integer b = new Integer(-10);
		Integer c = new Integer(0);
		Integer d = new Integer(5);
		graph.addVertex(a);graph.addVertex(b);graph.addVertex(c);graph.addVertex(d);
		graph.addEdge(a, b, true);
		graph.addEdge(a, c, false);
		
		graph = graph.reverse();
		
		assertEquals(graph.vertices.get(a).size(), 1);
		assertEquals(graph.vertices.get(a).get(0), b);
		
		assertEquals(graph.vertices.get(b).size(), 1);
		assertEquals(graph.vertices.get(b).get(0), a);
		
		assertEquals(graph.vertices.get(c).size(), 1);
		assertEquals(graph.vertices.get(c).get(0), a);
	}
	
	/**	GetVisited
	 *      a      d
	 *     / \    
	 *    /  _\|   
	 *   b     c   
	 */
	@Test
	void testGetVisited() {
		MyGraph<Integer> graph = new MyGraph<Integer>();
		Integer a = new Integer(10);
		Integer b = new Integer(-10);
		Integer c = new Integer(0);
		Integer d = new Integer(5);
		graph.addVertex(a);graph.addVertex(b);graph.addVertex(c);graph.addVertex(d);
		graph.addEdge(a, b, true);
		graph.addEdge(a, c, false);
		
		graph.explore(a);
		
		ArrayList<Integer> visitedList = graph.getVisited();
		assertEquals(visitedList.size(), 3);
		assertEquals(visitedList.get(0), a);
		assertEquals(visitedList.get(1), b);
		assertEquals(visitedList.get(2), c);
	}
	
	
}
