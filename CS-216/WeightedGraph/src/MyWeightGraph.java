import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class MyWeightGraph<K> {
	// field
	// should be PRIVATE
	public HashMap<K, HashMap<K, Integer>> vertices;
	public HashMap<K, Integer> distances;
	public HashMap<K, K> previous;
	public K start;
	
	public ArrayList<Edge<K>> edges;
	
	// constructor
	public MyWeightGraph() {
		vertices = new HashMap<K, HashMap<K,Integer>>();
		distances = new HashMap<K, Integer>();
		previous = new HashMap<K, K>();
		
		edges = new ArrayList<Edge<K>>();
	}
	
	// method
	public boolean addVertex(K vertex) {
		// check if vertex already exist
		if (vertices.containsKey(vertex)) { return false;}
		vertices.put(vertex, new HashMap<K, Integer>());
		return true;
	}
	
	// WaryL directed graph only use bidirectional false
	public boolean addEdge(K start, K end, Integer weight) {
		HashMap<K, Integer> startTable = vertices.get(start);
		HashMap<K, Integer> endTable = vertices.get(end);
		
		// check if start/end NOT exist OR edge already exists
		if (startTable == null || startTable.containsKey(end) || endTable == null) {return false;}
		if (endTable.containsKey(start)) return false;
		
		// ADD
		startTable.put(end, weight);
		endTable.put(start, weight);
		edges.add(new Edge<K>(start, end, weight));
		return true;
	}
	
	// reset the distances, previous data-structures
	public void reset() {
		start = null;
		for (K vertex : vertices.keySet()) {
			distances.put(vertex, Integer.MAX_VALUE);
			previous.put(vertex, null);
		}
	}
	
	public void sortEdges() {
		Collections.sort(edges);
	}
	
	// min spanning tree algo
	public MyWeightGraph<K> kruskal() {
		
		// vertices of edges, roots
		K comp1, comp2;
		K vertex1, vertex2;
		
		// vertex labels of original graph
		Set<K> vertexSet = vertices.keySet();
		
		// empty min spanning tree
		MyWeightGraph<K> minTree = new MyWeightGraph<K>();
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
			
			if (comp1!= comp2) {	// if in different Component (different root)
				// update min span tree and comps object

				// in essence: adding this edge to MST, linking two disconnected comps
				minTree.addEdge(vertex1, vertex2, edge.getWeight());
				comps.union(comp1, comp2);
			}
		}
		return minTree;
	}
	
	public void bfs(K start) {
		this.reset();
		this.start = start;
		Set<K> vertexList = vertices.keySet();
		Queue<K> queue = new LinkedList<K>();
		K curr = null;
		
		// init
		distances.put(start, 0);
		previous.put(start, null);
		queue.add(start);
		
		while (!queue.isEmpty()) {
			curr = queue.remove();
			vertexList = this.vertices.get(curr).keySet();
			Integer newDist = distances.get(curr);
			
			for (K vertex : vertexList) {
				// if NOT vistied, update
				if (distances.get(vertex) == Integer.MAX_VALUE) {
					distances.put(vertex, newDist+1);
					previous.put(vertex, curr);
					queue.add(vertex);
				}
			}
		}
	}
	
	public LinkedList<K> getPath(K end){
		LinkedList<K> path = new LinkedList<K>();
		path.add(end);
				
		K curr = end;
		while (previous.get(curr) != null) {
			curr = previous.get(curr);
			path.add(curr);
		}
		
		// returns backward path from end to start.
        // remember, start is a variable of each WeightedClass instance.
//		from this.start to end
		return path;
	}
	
	
	
}
