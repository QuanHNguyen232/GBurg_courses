import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.LinkedList;

public class MyGraph<K> {

	// field
	public Hashtable<K, LinkedList<K>> vertices;	// change to private, deepcopy in getters
	public Hashtable<K, Boolean> visited;	// should be PRIVATE
	public Hashtable<K, Integer> pre;	// should be PRIVATE
	public Hashtable<K, Integer> post;	// should be PRIVATE
	public int clock;	// should be PRIVATE

	// constructor
	public MyGraph() {
		vertices = new Hashtable<K, LinkedList<K>>();
		visited = new Hashtable<K, Boolean>();
		pre = new Hashtable<K, Integer>();
		post = new Hashtable<K, Integer>();
		clock = 0;
	}


	// methods
	/**
	 * Add new vertex into MyGraph
	 * @param key (K type)
	 */
	public void addVertex(K key) {
		// place empty neighbor list at new location in vertices hashtable
		vertices.put(key, new LinkedList<K>());
		visited.put(key, false);
		pre.put(key, -1);
		post.put(key, -1);
	}

	/**
	 * Add edge to MyGraph. Do nothing if one of the vertices does not exist in MyGraph
	 * @param begin vertex
	 * @param end vertex
	 * @param bidirectional
	 */
	public void addEdge(K begin, K end, boolean bidirectional) {
		// check if vertices are in Graph
		if (!vertices.containsKey(begin) || !vertices.containsKey(end)) {return;}

		// add appropriate edges
		vertices.get(begin).add(end);
		
		if (bidirectional) {
			vertices.get(end).add(begin);
		}
	}

	/**
	 * DFS of reachable vertices
	 * @param key (K type)
	 */
	public void explore(K key) {	// change to private later
		// mark the vertex as visited
		visited.put(key, true);

		// Pre-visit; note clock value and increase clock
		previsit(key);

		// neighbors of current vertex
		LinkedList<K> neighbors = vertices.get(key);
		K neighbor;
		
		// Loop over neighbors list
		for (int idx = 0; idx < neighbors.size(); idx++) {
			neighbor = neighbors.get(idx);
			// if neighbor is not visited, go there
			if (!visited.get(neighbor)) {
				explore(neighbor);
			}
		}

		// Post-visit; note clock value and increase clock
		postvisit(key);

	}

	// previsitation procedure at each vertex
	// MUST BE PRIVATE
	public void previsit(K key) {
		pre.put(key, clock);
		clock++;
	}

	// postvisitation procedure at each vertex
	// MUST BE PRIVATE
	public void postvisit(K key) {
		post.put(key, clock);
		clock++;
	}

	
	// clear the visited data structure; all false
	// MUST BE PRIVATE
	public void resetVisited() {
		// Loop over entire visited data structure
		Enumeration<K> keys = visited.keys();
		while (keys.hasMoreElements()) {
			visited.put(keys.nextElement(), false);
		}
	}
	
	// MUST BE PRIVATE
	public void resetClock() {clock = 0;}

	/**
	 * Find vertex w/ highest post number, assumes dfs was already run
	 * @return vertex label w/ highest post number
	 */
	public K highPost() {
			// vertex w/ current highest post
			K source = null;
			// current vertex in loop
			K key = null;
			// current highest post number
			int highPost = -1;
			
			// iterable over vertices
			Enumeration<K> keys = post.keys();
			// loop finds highest post
			while (keys.hasMoreElements()) {
				key = keys.nextElement();
				// case: new highest post found
				if (post.get(key) >= highPost) {
					source = key;	// update K w/ highest post
					highPost = post.get(key);
				}
			}
			
			return source;
		}
	
	/**
	 * get the subgraph w/o visited vertices
	 * @param toRemove
	 * @return MyGraph w/o visited vertices
	 */
	public MyGraph<K> trim(ArrayList<K> toRemove) {
		// trimmed graph to return later
		MyGraph<K> subGraph = new MyGraph<K>();
		K key;
		LinkedList<K> neighbors = null;
		
		// iterable type over vertices
		Enumeration<K> keys = vertices.keys();
		while (keys.hasMoreElements()) {
			key = keys.nextElement();
			// add vertex if not in remove list
			if (!toRemove.contains(key)) {
				subGraph.addVertex(key);
			}
		}
		
		// add edges
		keys = vertices.keys();
		while (keys.hasMoreElements()) {
			// get neighbors
			key = keys.nextElement();
			// get neighbors if that vertex is not in remove list
			if (!toRemove.contains(key)) {
				neighbors = vertices.get(key);
				// add each neighbor
				for (int idx = 0; idx < neighbors.size(); idx++) {
					subGraph.addEdge(key, neighbors.get(idx), false);
				}
			}
			
		}
		
		return subGraph;
	}
	
	/**
	 * Check if the graph is empty
	 * @return true if no vertex in graph
	 */
	public boolean isEmpty() {
		if (vertices.size() == 0) {
			return true;
		}
		return false;
	}
	
	/**
	 * Get SCC which is itself a list of vertex label
	 * @return list of strongly connect components
	 */
	public ArrayList<ArrayList<K>> getStrongComponents(){
		// reverse graph & copy of original
		MyGraph<K> revGraph = this.reverse();
		MyGraph<K> forGraph = revGraph.reverse();
		
		ArrayList<ArrayList<K>> components = new ArrayList<ArrayList<K>>();
		K key;
		ArrayList<K> strongComponents;
		
		while (!revGraph.isEmpty()) {
			// DFS on reverse graph
			revGraph.dfs();
			// highest post vertex in dfs
			key = revGraph.highPost();
			
			// explore from highest post vertex (sink in G/ source of G_rev)
			forGraph.explore(key);
			// array list of keys visited during explore
			strongComponents = forGraph.getVisited();
			
			components.add(strongComponents);
			
			/**
			 * homework
			 */
			// remove found SCC from graph to find the next SCC
			forGraph = forGraph.trim(strongComponents);
			revGraph = forGraph.reverse();
		}
		
		return components;
	}
	
	/**
	 * Get the metagraph of this MyGraph
	 * @return MyGraph with SCC labeled as integers
	 */
	public MyGraph<Integer> metagraph(){	//FAILED
		MyGraph<Integer> metaGraph = new MyGraph<Integer>();	
		ArrayList<ArrayList<K>> sccList = this.getStrongComponents();
		ArrayList<K> scc = null;
		ArrayList<K> currSCC = null;

		// Add VERTICES
		for (int i = 0; i < sccList.size(); i++) {
			metaGraph.addVertex(i);
		}
		
		// Add EDGES
		// Loop through each SCC from back: add source -> sink
		for (int b_metaVer = sccList.size()-1; b_metaVer >= 0; b_metaVer--) {
			
			currSCC = sccList.get(b_metaVer);
			
			// For each vertex in current SCC
			for (K beginVertex : currSCC) {
				
				// get EDGE_LIST of current VERTEX
				LinkedList<K> list = vertices.get(beginVertex);
				
				for (int k = 0; k < list.size(); k++) {
					K endVertex = list.get(k);
					
					// check if those edgeVertices exist in other SCCs
					for (int e_metaVer = 0; e_metaVer < sccList.size(); e_metaVer++) {
						scc = sccList.get(e_metaVer);
						// i != j: check if SCCs are different
						// scc.contains(endVertex): find which SCC that endVertex belongs to
						if (b_metaVer != e_metaVer && scc.contains(endVertex)) {	
							// add edge if it is not in edge-list
							if (!metaGraph.vertices.get(b_metaVer).contains(e_metaVer)) {
								metaGraph.addEdge(b_metaVer, e_metaVer, false);
							}
						}
					}
				}
			}
		}
		
		return metaGraph;
	}

	/**
	 * depth-first-search through MyGraph
	 */
	public void dfs() {
		resetVisited();
		// reset clock
		resetClock();

		// iterater-type obj of vertices in graph
		Enumeration<K> keys = visited.keys();

		// execute explore on all unexplored vertices
		while (keys.hasMoreElements()) {
			K key = keys.nextElement();
			if (!visited.get(key)) {
				this.explore(key);
			}
		}

	}
	
	/**
	 * reverse the direction in MyGraph
	 * @return a new MyGraph, but reversed edges
	 */
	public MyGraph<K> reverse(){
		// reverse graph to construct
		MyGraph<K> revGraph = new MyGraph<K>();
		
		// current vertex in original graph and its neighbors
		K key;
		LinkedList<K> neighbors;
		Enumeration<K> keys;
		
		// loop over the vertices of graph
		keys = vertices.keys();
		while (keys.hasMoreElements()) {
			// add vertices to revGraph
			key = keys.nextElement();
			revGraph.addVertex(key);
		}
		
		// loop again, inserting reverse edges
		keys = vertices.keys();
		while (keys.hasMoreElements()) {
			// current vertex
			key = keys.nextElement();
			// graph neighbors
			neighbors = vertices.get(key);
			for (int idx = 0; idx < neighbors.size(); idx++) {
				// add reversed edge
				revGraph.addEdge(neighbors.get(idx), key, false); 
			}
		}
		
		return revGraph;
	}
	
	/**
	 * Get the visited vertices
	 * @return ArrayList of visited vertices
	 */
	public ArrayList<K> getVisited(){
		Enumeration<K> keys = visited.keys();
		ArrayList<K> visitList = new ArrayList<K>();
		K key = null;
		
		while (keys.hasMoreElements()) {
			key = keys.nextElement();
			if (visited.get(key)) {
				visitList.add(key);
			}
		}
		
		return visitList;
	}
	
	
}
/*	METAGRAPH
MyGraph<Integer> metaGraph = new MyGraph<Integer>();
// returns the metagraph of your graph object. uses getStrongComponents as a helper.
// metavertices are labeled according to the order they are identified.

ArrayList<ArrayList<K>> sccList = this.getStrongComponents();

// Add VERTICES
for (int i = 0; i < sccList.size(); i++) {
	metaGraph.addVertex(i);
}

// Add EDGES
ArrayList<ArrayList<K>> sccList_full = this.getStrongComponents();
ArrayList<K> scc = null;
ArrayList<K> currSCC = null;


while (!sccList.isEmpty()) {
int currIdx = sccList.size()-1;
ArrayList<K> currSCC = sccList.remove(currIdx);	// get from bottom (source of metagraph)

// For each vertex in current SCC
for (K vertex : currSCC) {
	
	// get EDGE_LIST of current VERTEX
	LinkedList<K> list = vertices.get(vertex);
	
	for (int i = 0; i < list.size(); i++) {
		
		K edgeVertex = list.get(i);
		// check if those edgeVertices exist in other SCCs
//		for (ArrayList<K> scc : sccList_full) {
//			if (currSCC!=scc && scc.contains(edgeVertex)) {
//				metaGraph.addEdge(currSCC, scc, false);
//			}
//		}
		for (int j = 0; j < sccList_full.size(); j++) {
			scc = sccList_full.get(j);
			if (currIdx != j && scc.contains(edgeVertex)) {
				metaGraph.addEdge(currIdx, j, false);
			}
		}
	}
}
}
*/
