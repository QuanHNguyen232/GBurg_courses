
public class BSTNode<T extends Comparable<T>> {
	
	// field
	private BSTNode<T> leftNode;
	private BSTNode<T> rightNode;
	private T data;
	
	// constructor
	public BSTNode (T data) {
		this.data = data;
		leftNode = null;
		rightNode = null;
	}

	// method

	public BSTNode<T> getLeftNode() {
		return leftNode;
	}

	public void setLeftNode(BSTNode<T> leftNode) {
		this.leftNode = leftNode;
	}

	public BSTNode<T> getRightNode() {
		return rightNode;
	}

	public void setRightNode(BSTNode<T> rightNode) {
		this.rightNode = rightNode;
	}

	public T getData() {
		return data;
	}
	
	public int compare(BSTNode<T> other) {
		return this.data.compareTo(other.getData());
	}
	
	
	
	
	
	
	
}
