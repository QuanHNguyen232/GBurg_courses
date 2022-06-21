import java.util.HashMap;

// tracks connected components of undirected graph
// use disjoint set nodes
public class ConnectedComponents<K> {

	HashMap<K, DSNode<K>> vertices;
	
	public ConnectedComponents() {
		vertices = new HashMap<K, DSNode<K>>();
	}
	
	public void add(K vertex) {
		vertices.put(vertex, new DSNode<K>(vertex));
	}
	
	
	// determine which connected component
	public K find(K vertex) {
		DSNode<K> curNode = vertices.get(vertex);
		if (curNode == null) return null;
		
		// traverse up to root
		while (curNode.getParent() != null) {
			curNode = curNode.getParent();
		}
		return curNode.getData();
	}
	
	// take union of disjoint sets
	public void union(K vertex1, K vertex2) {
		K root1 = find(vertex1);
		K root2 = find(vertex2);
		
		// are the set the same
		if (root1 == root2) return;
		
		// recover the nodes
		DSNode<K> setNode1 = vertices.get(root1);
		DSNode<K> setNode2 = vertices.get(root2);
		
		if (setNode1.getHeight() > setNode2.getHeight()) {
			setNode2.setParent(setNode1);
		}
		else if (setNode1.getHeight() < setNode2.getHeight()) {
			setNode1.setParent(setNode2);
		}
		else {
			setNode1.setParent(setNode2);
			setNode2.increaseHeight();
		}
	}
}
