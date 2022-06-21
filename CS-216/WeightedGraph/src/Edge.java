
public class Edge<K> implements Comparable<Edge<K>> {
	
	K vertex1, vertex2;
	Integer weight;
	
	public Edge(K vertex1, K vertex2, Integer weight) {
		this.vertex1 = vertex1;
		this.vertex2 = vertex2;
		this.weight = weight;
	}
	
	

	public K getVertex1() {
		return vertex1;
	}



	public K getVertex2() {
		return vertex2;
	}



	public Integer getWeight() {
		return weight;
	}



	@Override
	public int compareTo(Edge<K> otherEdge) {
		return weight.compareTo(otherEdge.getWeight());
	}

	
}
