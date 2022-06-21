package mylinkedlist;

/**
 * 
 * @author nguyqu03
 *
 * @param <T>
 */

public class DLList<T> {
	// field
	private DLNode<T> head;
	private DLNode<T> tail;
	
	// constructor
	public DLList(){
		head = null;
		tail = null;
	}
	
	// method
	/**
	 * Add object into the end (tail) of the list
	 * @param data
	 */
	public void add(T data) {
		DLNode<T> newNode = new DLNode<T>(data);
		
		// is empty
		if (this.head == null) {
			this.head = newNode;
			this.tail = newNode;
		}
		else {
			this.tail.setNext(newNode);
			newNode.setPrev(this.tail);
			
			this.tail = newNode;
		}
	}
	
	/**
	 * using search method to get index of item and loop through each item until reach that index
	 * @param data
	 * @return true if item is found and removed, else return false
	 */
	public boolean remove(T data) {
		// case: linked list is empty
		if (this.head == null) {
			return false;
		}
		// Not empty
		int target = search(data);

		if (target == 0) {	// remove head
			// list has 1 element
			if (this.head.getNext() == null) {
				this.head = null;
				this.tail = null;
			}
			else {
				this.head = this.head.getNext();
			}

			return true;
		}
		if (target > 0) {	// list has more than 1 element
			DLNode<T> currNode = this.head;
			int indexNext = 1;
			while (indexNext != target) {
				currNode = currNode.getNext();
				indexNext++;
			}
			currNode.setNext(currNode.getNext().getNext());
			return true;
		}

		return false;
	}
	/**
	 * Print the data of each node (for all nodes in list from head to tail)
	 */
	public String traverse() {
		DLNode<T> currNode= this.head;
		StringBuilder sb = new StringBuilder();
		
		while (currNode != null) {
//			System.out.print(currNode.getData() + " - ");
			sb.append(currNode.getData() + " - ");
			currNode = currNode.getNext();
		}
//		System.out.println();
		
		return sb.toString();
	}
	/**
	 * Print the data of each node (for all nodes in list from tail to head)
	 */
	public String reverse() {
		DLNode<T> currNode= this.tail;
		StringBuilder sb = new StringBuilder();
		
		while (currNode != null) {
//			System.out.print(currNode.getData() + " - ");
			sb.append(currNode.getData() + " - ");
			currNode = currNode.getPrev();
		}
//		System.out.println();
		
		return sb.toString();
	}
	/**
	 * find if data is in list
	 * @param data
	 * @return index if data exist in linked list (starting with 0 for head), else return -1
	 */
	public int search(T data) {
		DLNode<T> currNode = this.head;
		int index = 0;
		
		while (currNode != null) {
			if (currNode.getData().equals(data)) {
				return index;
			}
			// update
			currNode = currNode.getNext();
			index++;
		}
		
		return -1;
	}
	
}
