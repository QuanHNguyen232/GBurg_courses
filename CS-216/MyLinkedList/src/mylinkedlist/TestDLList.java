package mylinkedlist;

public class TestDLList {

	public static void main(String[] args) {
		DLList<Integer> list = new DLList<Integer>();
		for (int i=0; i <= 6; i++) {
			list.add(i);
		}
		
		System.out.println(list.traverse());
		System.out.println(list.reverse());
		for (int i = -2; i < 8; i++) {
			i = (i == 1) ? 2 : i;
			System.out.println("remove "+i+ ": " + list.remove(i));
			System.out.println(list.traverse());
		}
//		for (int i=0; i <= 5; i++) {
//			System.out.println("search ["+i+"]: " + list.search(i));
//		}
		
//		DLNode<Integer> curr = list.head.getNext().getNext();
//		System.out.println(curr.getPrev().getData());
//		System.out.println(curr.getNext().getData());
		
		// empty
//		System.out.println("\nremove item");
//		DLList<Integer> list1 = new DLList<Integer>();
//		list1.traverse();
//		System.out.println("remove empty: " + list1.remove(5));
//		System.out.println("remove empty: " + list1.remove(9));
//		list1.traverse();
		
		
		// NOT empty
		
				// 1 element	
/*		DLList<Integer> list2 = new DLList<Integer>();
		list2.add(9);
		System.out.println(list.traverse());
		System.out.println("remove (1 element) 2: " + list2.remove(2));list2.traverse();
		System.out.println("remove (1 element) 9: " + list2.remove(9));
		System.out.println(list.traverse());
		
				// remove item not exist
		System.out.println("remove (not exist) 8: " + list.remove(8));
		System.out.println(list.traverse());
		
				// remove middle
		System.out.println(list.traverse());
		System.out.println();
		
		System.out.println("remove 4: " + list.remove(4));
		System.out.println(list.traverse());
		
		System.out.println("remove 8: " + list.remove(8));
		System.out.println(list.traverse());
		
		System.out.println("remove 1: " + list.remove(1));
		System.out.println(list.traverse());
		
		System.out.println("remove 6: " + list.remove(6));
		System.out.println(list.traverse());
		
		System.out.println("remove 0: " + list.remove(0));
		System.out.println(list.traverse());
		
*/
	}

}
