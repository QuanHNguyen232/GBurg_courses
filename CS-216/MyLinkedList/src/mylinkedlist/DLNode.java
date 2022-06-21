package mylinkedlist;
/**
 * 
 * @author nguyqu03
 *
 * @param <T>
 */
public class DLNode<T> {
	
	// field
	private DLNode<T> prev;
	private DLNode<T> next;
	private T data;
	
	// constructor
	
	/**
	 * By default, the previous and next nodes are null
	 * @param data Obj stored in node
	 */
	public DLNode(T data) {
		this.data = data;
		this.prev = null;
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
	 * Obtain the next node
	 * @return The node pointed to with the forward reference
	 */
	public DLNode<T> getNext(){
		return this.next;
	}
	
	/**
	 * Re-binds the forward pointer in node
	 * @param next The node obj to which the forward pointer should reference
	 */
	public void setNext(DLNode<T> next) {
		this.next = next;
	}
	
	/**
	 * Obtain the previous node
	 * @return The node pointed to the previous reference
	 */
	public DLNode<T> getPrev(){
		return this.prev;
	}
	
	/**
	 * Re-binds the previous node
	 * @param prev The previoud node obj to which the pointer should reference
	 */
	public void setPrev(DLNode<T> prev) {
		this.prev = prev;
	}
	
	
}
