package mylinkedlist;

/**
 * 
 * @author nguyqu03
 *
 * @param <T>
 */
public class SLList<T> {
	
	// field
	
	private SLNode<T> head;
	private SLNode<T> tail;
	
	
	// constructor
	
	public SLList () {
		this.head = null;
		this.tail = null;
	}
	
	
	// method
	
	/**
	 * @param data
	 */
	public void add(T data) {
		SLNode<T> newNode = new SLNode<T>(data);
		
		if (this.head == null) {	// case: list is empty
			this.head = newNode;
			this.tail = newNode;
		}
		else {
			this.tail.setNext(newNode);
			this.tail = newNode;
		}
	}
	
	/**
	 * @param data
	 * @return true if successfully remove data, else return false
	 */
	public boolean remove(T data) {
		// case: linked list is empty
		if (this.head == null) {
			return false;
		}
		else if (this.head.getNext() == null) {	// case: linked list has 1 element
			if (this.head.getData().equals(data)) {	// sub-case: the node is to be removed
				this.head = null;
				this.tail = null;
				return true;
			}
			else {
				return false;
			}
		}
		else {	// case: linked list has 2 or more elements
			if (this.head.getData().equals(data)) {	// sub-case: delete head
				this.head = this.head.getNext();
				return true;
			}
			else {	// sub-case: search beyond head
				// tracks the current node in search
				SLNode<T> currNode = this.head;
				
				// look one node ahead for target
				// if not found and not at the end of the list, proceed forward
				while (currNode.getNext() != null && !currNode.getNext().getData().equals(data)) {
					currNode = currNode.getNext();
				}
				
				// NOT DONE ???
			}
		}
		
		return false;
	}
	
	/**
	 * ver.2 of remove method, using search method to get index of item
	 * @param data
	 * @return true if item is found and removed, else return false
	 */
	public boolean remove_ver2(T data) {
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
			SLNode<T> currNode = this.head;
			int indexNext = 1;
//			while (indexNext != target) {
			while (indexNext < target) {
				currNode = currNode.getNext();
				indexNext++;
			}
			currNode.setNext(currNode.getNext().getNext());
			return true;
		}
		
		return false;
	}
	
	/**
	 * Loop through each node (for all nodes in list from head to tail)
	 * @return String contains data of all nodes
	 */
	public String traverse() {
		StringBuilder sb = new StringBuilder();

		// used to track current Node
		SLNode<T> currNode = this.head;
		
		// loops through all nodes, printing data value at each iteration
		while (currNode != null) {
//			System.out.print(currNode.getData() + " - ");
			sb.append(currNode.getData() + " - ");
			currNode = currNode.getNext();
		}
//		System.out.println();
//		sb.append("\n");
		
		return sb.toString();
	}
	
	/**
	 * Loop through each node reversely
	 * @return String contains data of all nodes
	 */
	public String reverse() {
		StringBuilder sb = new StringBuilder();
		
		// used to track current Node
		SLNode<T> currNode = this.tail;
		
		if (currNode != null) {
			while (currNode != this.head) {
				sb.append(currNode.getData() + " - ");
				
				SLNode<T> runNode = this.head;
				
				while (runNode.getNext() != currNode) {
					runNode = runNode.getNext();
				}
				currNode = runNode;
			}
			sb.append(currNode.getData());
		}
		
		return sb.toString();
	}
	
	/**
	 * find if data is in list
	 * @param data
	 * @return index if data exist in linked list (starting with 0 for head), else return -1
	 */
	public int search(T data) {
		SLNode<T> currNode = this.head;
		int index = 0;
		
		// list is not null
		if (currNode != null) {
			while (currNode != null) {
				if (currNode.getData().equals(data)) {
					return index;
				}
				// update
				currNode = currNode.getNext();
				index++;
			}
		}

		return -1;
	}
	
}
