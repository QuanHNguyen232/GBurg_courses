package mylinkedlist;

public class TestDLNode {

	public static void main(String[] args) {
		
		DLNode<Integer> node1 = new DLNode<Integer>(1);
		System.out.println("data: "+node1.getData());
		System.out.println("prev: "+node1.getPrev());
		System.out.println("next: "+node1.getNext());
		
		
		DLNode<Integer> node2 = new DLNode<Integer>(2);
		node1.setNext(node2);
		System.out.println("next: "+node1.getNext().getData());
		
		DLNode<Integer> node3 = new DLNode<Integer>(0);
		node1.setPrev(node3);
		System.out.println("prev: "+node1.getPrev().getData());
	}

}
