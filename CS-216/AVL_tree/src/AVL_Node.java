/**
 * Node for AVL Tree
 * @author nguyqu03
 *
 * @param <T> comparable
 */


public class AVL_Node<T extends Comparable<T>> {

	// field
	private AVL_Node<T> leftNode;
	private AVL_Node<T> rightNode;
	private T data;
	private int height = 0;
	
	// constructor
	public AVL_Node (T data) {
		this.data = data;
		leftNode = null;
		rightNode = null;
	}

	// method
	/**
	 * Get the left node of the current one
	 * @return node
	 */
	public AVL_Node<T> getLeftNode() {
		return leftNode;
	}
	
	/**
	 * Set the left node of the current one to the new value
	 * @param leftNode
	 */
	public void setLeftNode(AVL_Node<T> leftNode) {
		this.leftNode = leftNode;
	}
	
	/**
	 * Get the right node of the current one
	 * @return node
	 */
	public AVL_Node<T> getRightNode() {
		return rightNode;
	}
	
	/**
	 * Set the right node of the current one to the new value
	 * @param rightNode
	 */
	public void setRightNode(AVL_Node<T> rightNode) {
		this.rightNode = rightNode;
	}
	
	/**
	 * Get the height of this node in the tree
	 * @return height (int)
	 */
	public int getHeight() {
		return height;
	}
	
	// update height of node
	/**
	 * Update the height of current node
	 */
	public void updateHeight() {
		int leftHeight = -1, rightHeight = -1;
		if (leftNode != null) {
			leftHeight = leftNode.getHeight();
		}
		if (rightNode != null) {
			rightHeight = rightNode.getHeight();
		}
		this.height = Math.max(leftHeight, rightHeight) + 1;	// +1: including this. So no child, height=0
	}
	
	/**
	 * Check if the node and its subtree is balanced (height b/w subtrees is <= 1)
	 * @return true if this node and its subtree is balanced
	 */
	// check if node is balanced AND all descendant nodes are balanced
	public boolean balanced() {
		// values until left/right checked again null
		int leftHeight = -1, rightHeight = -1;
		// flag which passes a series of checks
		boolean isBalanced = true;
		// probe the left of the node
		if (this.leftNode != null) {
			isBalanced = leftNode.balanced();
			leftHeight = leftNode.getHeight();
		}
		// probe the right of the node
		if (this.rightNode != null && isBalanced) {
			isBalanced = rightNode.balanced();
			leftHeight = rightNode.getHeight();
		}
		// check if initial node is balanced
		if (Math.abs(rightHeight - leftHeight) > 1) {
			isBalanced = false;
		}
		
		return isBalanced;
	}

	/**
	 * Get data of current node
	 * @return data (generic type)
	 */
	public T getData() {
		return data;
	}
	
	/**
	 * Rotate the subtree to the left
	 * @return new Node after rotating
	 */
	public AVL_Node<T> rotateLeft(){
		// create new node that should be rebound to parent
		AVL_Node<T> root = this.rightNode;
		// when nothing is changed
		if (root == null) {return this;}
		
		AVL_Node<T> rootLeft = root.getLeftNode();
		
		// perform rotation
		this.setRightNode(rootLeft);
		root.setLeftNode(this);
		
		// update height (node t0, tL, tR still have the same height - image in notebook)
		this.updateHeight();
		root.updateHeight();
		
		return root;
	}
	
	/**
	 * Rotate the subtree to the right
	 * @return new Node after rotating
	 */
	public AVL_Node<T> rotateRight(){
		// create new node that should be rebound to parent
		AVL_Node<T> root = this.leftNode;
		// when nothing is changed
		if (root == null) {return this;}
		
		AVL_Node<T> rootRight = root.getRightNode();
		// perform rotation
		this.setLeftNode(rootRight);
		root.setRightNode(this);
		
		// update height (node t0, tL, tR still have the same height - image in notebook)
		this.updateHeight();
		root.updateHeight();
		
		return root;
	}
	
	/**
	 * Get the difference b/w height of left and right subtree
	 * @return integer
	 */
	public int balFactor() {
		int leftHeight = -1, rightHeight = -1;
		if (this.leftNode != null) {leftHeight = this.leftNode.getHeight();}
		if (this.rightNode != null) {rightHeight = this.rightNode.getHeight();}
		return rightHeight-leftHeight;
	}
	
	/**
	 * Compare data of this node and another one
	 * @param another node
	 * @return 0 if values are equal, < 0 if this node's data is less/smaller, > 0 for the another case
	 */
	public int compareTo(AVL_Node<T> other) {
		return this.data.compareTo(other.getData());
	}
	
	
	
}
