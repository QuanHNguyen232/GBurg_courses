import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Set;

public class WeightedGraph<K> {
	
	// PRIVATE
	public HashMap<K, HashMap<K, Integer>> vertices;
	public HashMap<K, Integer> distances;
	public HashMap<K, K> previous;
	public K start;
	
	public ArrayList<Edge<K>> edges;
	
	public WeightedGraph() {
		vertices = new HashMap<K, HashMap<K, Integer>>();
		distances = new HashMap<K, Integer>();
		previous = new HashMap<K, K>();
		
		edges = new ArrayList<Edge<K>>();
	}
	
	public boolean addVertex(K vertex) {
		// does vertex already exist
		if (vertices.containsKey(vertex)) {
			return false;
		}
		// new unique vertex into graph
		vertices.put(vertex, new HashMap<K, Integer>());
		return true;
	}
	
	// undirected edge
	public boolean addEdge(K start, K end, Integer weight) {
		HashMap<K, Integer> startTable = vertices.get(start);
		HashMap<K, Integer> endTable = vertices.get(end);
		// check if start non-exist or edge already exists
		if (startTable == null || startTable.containsKey(end) || endTable == null) {
			return false;
		}
		if (endTable.containsKey(start)) return false;
		
		startTable.put(end, weight);
		endTable.put(start, weight);
		edges.add(new Edge<K>(start, end, weight));
		return true;
	}
	
	// will reset the distances, previous data structure
	public void reset() {
		start = null;
		for ( K vertex : vertices.keySet() ) {
			distances.put(vertex, Integer.MAX_VALUE);
			previous.put(vertex, null);
		}
	}

	public void sortEdges() {
		Collections.sort(edges);
	}
	
	// min spanning tree algo
	public WeightedGraph<K> kruskal() {
		
		// vertices of edges, roots
		K comp1, comp2;
		K vertex1, vertex2;
		
		// vertex labels of original graph
		Set<K> vertexSet = vertices.keySet();
		
		// empty min spanning tree
		WeightedGraph<K> minTree = new WeightedGraph<K>();
		ConnectedComponents<K> comps = new ConnectedComponents<K>();
		
		// populate vertices
		for (K vertex: vertexSet) {
			minTree.addVertex(vertex);
			comps.add(vertex);
		}
		// sort edges by weight
		sortEdges();
		for (Edge<K> edge: edges) {
			vertex1 = edge.getVertex1();
			vertex2 = edge.getVertex2();
			
			comp1 = comps.find(vertex1);
			comp2 = comps.find(vertex2);
			
			if (comp1!= comp2) {
				// update min span tree and comps object

				// in essence: adding this edge to MST, linking two disconnected comps
				minTree.addEdge(vertex1, vertex2, edge.getWeight());
				comps.union(comp1, comp2);
			}
		}
		return minTree;
	}
}
