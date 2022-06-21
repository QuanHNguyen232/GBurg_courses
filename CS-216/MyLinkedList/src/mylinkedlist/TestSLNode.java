package mylinkedlist;

public class TestSLNode {

	public static void main(String[] args) {
		
		Integer int1 = new Integer(2);	// must use Integer not int since T is a reference type
		Integer int2 = new Integer(5);
		
		SLNode<Integer> node1 = new SLNode<Integer>(int1);
		SLNode<Integer> node2 = new SLNode<Integer>(int2);
		
		
		node1.setNext(node2);
		
		System.out.println(node1.getData());
		System.out.println(node1.getNext().getData());
		System.out.println(node1.getNext().getNext());
		
		System.out.println(node2.getData());
	}

}
