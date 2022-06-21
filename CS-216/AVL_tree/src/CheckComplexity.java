import java.util.ArrayList;
import java.util.Random;

public class CheckComplexity {
	
	static int loop = 1_000_000;
	static Integer maxHeight = Integer.MIN_VALUE;
	
	static AVL_Tree<Integer> tree = new AVL_Tree<Integer>();
	static ArrayList<Integer> arr = new ArrayList<Integer>();
	
	static Random r = new Random(0);
	
	public static void main(String[] args) {
		
		insertVal();
		
		while (arr.size()>0) {
			if (arr.size() % 10000 == 0) {System.out.println("size: " + arr.size());}
			Integer delVal = arr.remove(0);
			
			tree.delete(delVal);

			// check and update maxHeight if need
			maxHeight = (tree.getRoot().getHeight() > maxHeight) ? tree.getRoot().getHeight() : maxHeight;
		}
		
		insertVal();
		
		System.out.println(maxHeight);
	}
	
	public static void insertVal() {
		for (int i = 0; i < loop; i++) {
			if (i % 10000 == 0) {System.out.println("loop: " + i);}
			
			Integer val = new Integer(r.nextInt());
			tree.insert(val);
			
			// flip a coin and add that current random Integer to the ArrayList
			if (r.nextInt(2) == 0) {arr.add(val);}
			
			// check and update maxHeight if need
			maxHeight = (tree.getRoot().getHeight() > maxHeight) ? tree.getRoot().getHeight() : maxHeight;
		}
	}
}
