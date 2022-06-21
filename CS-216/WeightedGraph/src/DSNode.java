
public class DSNode<K> {

	K data;
	int height;
	DSNode<K> parent;
	
	public DSNode(K data) {
		this.data = data;
		height = 0;
	}
	
	public void setParent(DSNode<K> parent) {
		this.parent = parent;
	}

	public K getData() {
		return data;
	}

	public int getHeight() {
		return height;
	}

	public DSNode<K> getParent() {
		return parent;
	}
	
	// increase height
	public void increaseHeight() {
		height++;
	}
}
