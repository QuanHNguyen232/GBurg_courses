package mylinkedlist;

public class TestSLList {

	public static void main(String[] args) {
		
		SLList<Integer> list = new SLList<Integer>();
		
		for (int i = 0; i < 6; i++) {
			list.add(i);
		}
		System.out.println(list.traverse());
		System.out.println(list.reverse());
		for (int i = -1; i < 8; i+=2) {
			System.out.println("remove "+i+ ": " + list.remove_ver2(i));
			System.out.println(list.traverse());
		}
		
//		System.out.println("traverse: ");
//		System.out.println("["+list.traverse()+"]");
//		
//		System.out.println("reverse: ");
//		System.out.println("["+list.reverse()+"]");
		
//		System.out.println("\nsearch item");
//		for (int i=0; i <= 7; i++) {
//			System.out.println("search ["+i+"]: " + list.search(i));
//		}
		
		// empty
//		System.out.println("\nremove item");
//		SLList<Integer> list1 = new SLList<Integer>();
//		list1.traverse();
//		System.out.println("remove empty: " + list1.remove_ver2(0));
//		System.out.println("remove empty: " + list1.remove_ver2(5));
//		list1.traverse();
		
		
		// NOT empty
		
				// 1 element
		
//		SLList<Integer> list2 = new SLList<Integer>();
//		list2.add(9);
//		list2.traverse();
//		System.out.println("remove (1 element) 2: " + list2.remove_ver2(2));list2.traverse();
//		System.out.println("remove (1 element) 9: " + list2.remove_ver2(9));
//		list2.traverse();
		
				// remove item not exist
//		System.out.println("remove (not exist) 0: " + list.remove_ver2(0));
//		list.traverse();
		
				// remove middle
//		System.out.println();
//		list.traverse();
//
//		System.out.println("remove 4: " + list.remove_ver2(4));
//		System.out.println(list.traverse());
//		
//		System.out.println("remove 8: " + list.remove_ver2(8));
//		System.out.println(list.traverse());
//		
//		System.out.println("remove 1: " + list.remove_ver2(1));
//		System.out.println(list.traverse());
//		
//		System.out.println("remove 6: " + list.remove_ver2(6));
//		System.out.println(list.traverse());
//		
//				// remove head  
//		System.out.println("remove 1: " + list.remove_ver2(1));
//		System.out.println(list.traverse());
	}

}
