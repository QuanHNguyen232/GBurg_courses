package mylinkedlist;

/**
 * Based on Prof.Daniel White's sample code
 * 
 * @author nguyqu03
 *
 * @param <T>
 */

public class SLNode<T> {
	
	// field
	/**
	 * T type data
	 */
	private T data;
	
	/**
	 * refer to the next node
	 */
	private SLNode<T> next;
	
	// constructor

	/**
	 * By default, the next node is null
	 * @param data Obj stored in node
	 */
	public SLNode (T data) {
		this.data = data;
		this.next = null;
	}
	

	// method

	/**
	 * Used to retrieve the obj stored in node
	 * @return Reference to obj stored in node
	 */
	public T getData() {
		return this.data;
	}
	
	/**
	 * Re-binds the forward pointer in node
	 * @param next The node obj to which the forward pointer should reference
	 */
	public void setNext(SLNode<T> next) {
		this.next = next; 
	}
	
	/**
	 * Obtain the next node
	 * @return The node pointed to with the forward reference
	 */
	public SLNode<T> getNext() {
		return this.next; 
	}
	
}
