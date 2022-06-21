import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.Stack;

import org.junit.jupiter.api.Test;

class AVL_Tree_Test {
	
	public Random rand = new Random(11);
	
	@Test
	void testInsert_Search() {
		AVL_Tree<Integer> tree = new AVL_Tree<Integer>();
		for (int i = 0; i < 10; i++) {
			Integer e = rand.nextInt(10);
			tree.insert(e);
		}
		tree.insert(9);
				
		// Case search in Tree
		assertEquals(tree.search(8).compareTo(8), 0);
		assertEquals(tree.search(3).compareTo(3), 0);
		// Case search NOT in Tree
		assertEquals(tree.search(10),null);
	}
	
	@Test
	void testDelete_Leaf() {
		AVL_Tree<Integer> tree = new AVL_Tree<Integer>();
		// case: empty tree
		assertFalse(tree.delete(0));
		
		// case: NON-EMPTY tree
		for (int i = 0; i < 10; i++) {
			Integer e = rand.nextInt(10);
			tree.insert(e);
		}
		tree.insert(9);
		
		// case: delete failed
		tree.delete(15);
		
		// case: leaf
		// sub-case: NOT root
		assertTrue(tree.delete(0));	// delNode is on the left
		assertEquals(tree.getRoot().getLeftNode().getLeftNode().getData().compareTo(1), 0);
		assertTrue(tree.delete(9));	// delNode is on the right
		assertEquals(tree.getRoot().getRightNode().getRightNode().getRightNode(), null);
		
		// sub-case: root
		AVL_Tree<Integer> tree2 = new AVL_Tree<Integer>();
		tree2.insert(1);
		assertTrue(tree2.delete(1));
		assertEquals(tree2.getRoot(), null);

	}
	
	
	
	@Test
	void testDelete_Right_subtree() {
		// sub-case: root
		AVL_Tree<Integer> tree3 = new AVL_Tree<Integer>();
		tree3.insert(1);
		tree3.insert(2);
		tree3.delete(1);
		assertEquals(tree3.getRoot().getData().compareTo(2), 0);
		
		/* 
		 * 
		 *           5
		 *        /     \
		 *     2          8
		 *    / \        / \
		 *   0   3      7   8
		 * 	/     \    / \   \
		 * 1       4  7   7   9
		 */
		// sub-case: NOT root
		AVL_Tree<Integer> tree = new AVL_Tree<Integer>();
		tree.insert(5);
		tree.insert(2);tree.insert(8);
		tree.insert(0);tree.insert(3);tree.insert(7);tree.insert(8);
		tree.insert(1);tree.insert(4);tree.insert(7);tree.insert(7);tree.insert(9);
		
		// sub-sub-case: currNode on left of Parent
		assertTrue(tree.delete(0));
		assertEquals(tree.getRoot().getLeftNode().getLeftNode().getData().compareTo(1), 0);
		// sub-sub-case: currNode on right of Parent
		tree.insert(1);tree.insert(1);		// just to keep the tree balanced
		assertTrue(tree.delete(3));
		assertEquals(tree.getRoot().getLeftNode().getRightNode().getData().compareTo(4), 0);
	}

	@Test
	void testDelete_Left_subtree() {
		// sub-case: root
		AVL_Tree<Integer> tree3 = new AVL_Tree<Integer>();
		tree3.insert(5);
		tree3.insert(1);
		tree3.delete(5);
		assertEquals(tree3.getRoot().getData().compareTo(1), 0);
		
		// sub-case: NOT root
		AVL_Tree<Integer> tree = new AVL_Tree<Integer>();
		for (int i = 0; i < 10; i++) {
			Integer e = rand.nextInt(10);
			tree.insert(e);
		}
		tree.insert(9);

		// sub-sub-case: currNode on left of Parent
		assertTrue(tree.delete(7));
		/* Current tree:
		 *        5
		 *     /     \
		 * 	 3         8
		 *	/ \       / \
		 * 1   3     7   8
		 * 	\             \
		 *   3             9
		 */
		
		// sub-sub-case: currNode on right of Parent
		AVL_Tree<Integer> tree4 = new AVL_Tree<Integer>();
		tree4.insert(5);
		tree4.insert(3);
		tree4.insert(7);
		tree4.insert(0);
		tree4.insert(6);
		tree4.insert(4);
		tree4.insert(9);
		tree4.insert(8);
		/* tree4:
		 *        5
		 *     /     \
		 * 	 3         7
		 *	/ \       / \
		 * 0   4     6   9
		 * 	            /      
		 *             8
		 */
		assertTrue(tree4.delete(9));
	}
	@Test
	void testDelete_2_subtree() {
		// sub-case: ROOT
		// sub-sub-case: promote NOT null
		AVL_Tree<Integer> tree5 = new AVL_Tree<Integer>();
		tree5.insert(5);
		tree5.insert(0);tree5.insert(10);
		tree5.insert(-5);
		assertTrue(tree5.delete(5));
		assertEquals(tree5.getRoot().getData().compareTo(0), 0);
		// sub-sub-case: promote NULL
		AVL_Tree<Integer> tree6 = generateTree();
		assertTrue(tree6.delete(10));
		assertEquals(tree6.getRoot().getData().compareTo(7), 0);
		assertEquals(tree6.getRoot().getHeight(), 3);
		
		// sub-case: NOT root
		// sub-sub-case: promote NOT null
		AVL_Tree<Integer> tree7 = generateTree();
		assertTrue(tree7.delete(20));
		assertEquals(tree7.getRoot().getRightNode().getData().compareTo(17), 0);
		assertEquals(tree7.getRoot().getRightNode().getHeight(), 2);
		
		assertTrue(tree7.delete(0));
		assertEquals(tree7.getRoot().getLeftNode().getData().compareTo(-3), 0);
		assertEquals(tree7.getRoot().getLeftNode().getHeight(), 2);
		
		// sub-sub-case: promote NULL
		AVL_Tree<Integer> tree8 = generateTree();
		tree8.insert(-10);
		tree8.delete(-5);
		assertEquals(tree8.getRoot().getLeftNode().getLeftNode().getData().compareTo(-7), 0);
		
		AVL_Tree<Integer> tree9 = generateTree();
		tree9.insert(1);
		/* 
		 *             10
		 *         /         \
		 *       0            20
		 *     /   \        /    \
		 *   -5     5     15      25
		 *   / \   / \    / \     / \
		 *  -7 -3 3   7  13  17  23  27
		 *       /
		 *      1 
		 */
		assertTrue(tree9.delete(5));
		System.out.println();
		assertEquals(tree9.getRoot().getLeftNode().getRightNode().getData().compareTo(3), 0);
		assertEquals(tree9.getRoot().getLeftNode().getRightNode().getHeight(), 1);
		assertEquals(tree9.getRoot().getLeftNode().getHeight(), 2);
	}
	
	private AVL_Tree<Integer> generateTree(){
		/* 
		 *             10
		 *        /         \
		 *      0            20
		 * 	  /   \        /    \
		 *  -5     5     15      25
		 *  / \   / \    / \     / \
		 * -7 -3 3   7  13  17  23  27
		 */
		AVL_Tree<Integer> tree = new AVL_Tree<Integer>();
		tree.insert(10);
		
		tree.insert(0);
		tree.insert(20);
		
		tree.insert(-5);
		tree.insert(5);
		tree.insert(15);
		tree.insert(25);
		
		tree.insert(-7);
		tree.insert(-3);
		tree.insert(3);
		tree.insert(7);
		tree.insert(13);
		tree.insert(17);
		tree.insert(23);
		tree.insert(27);
		
		return tree;
	}

	@Test
	void testInOrder() {
		AVL_Tree<Integer> tree = new AVL_Tree<Integer>();
		
		// case empty
		ArrayList<Integer> arrTest0 = tree.inOrder();
		assertEquals(arrTest0, null);
		
		// case NOT empty
		List<Integer> arr = new ArrayList<Integer>();
		for (int i = 0; i < 10; i++) {
			Integer e = rand.nextInt(10);
			tree.insert(e);
			arr.add(e);
		}
		tree.insert(9);
		arr.add(9);
		
		// sort array in order
		Collections.sort(arr);
		// get inOrder
		ArrayList<Integer> arrTest = tree.inOrder();
		// check (compare b/w arr, original, and arrTest, result of InOrder)
		for (int i = 0; i < arrTest.size(); i++) {
			assertEquals(arrTest.get(i).compareTo(arr.get(i)), 0);
		}
	}
	
	/*	Input: 8 8 1 5 3 7 0 3 3 7 9
	 * 
	 *        5
	 *     /     \
	 * 	 1         8
	 *	/ \       / \
	 * 0   3     7   8
	 * 	  / \   /     \
	 *   3 	 3 7       9
	 */
	
	@Test
	void testDepthInOrder() {
		AVL_Tree<Integer> tree = new AVL_Tree<Integer>();
		for (int i = 0; i < 10; i++) {
			Integer e = rand.nextInt(10);
			tree.insert(e);
		}
		tree.insert(9);
		// Create ArrayList for depth=0
		int[] arr0 = {5};	
		// Create ArrayList for depth=1
		int[] arr1 = {1, 8};
		// Create ArrayList for depth=2
		int[] arr2 = {0, 3, 7, 8};
		// Create ArrayList for depth=3
		int[] arr3 = {3, 3, 7, 9};
		ArrayList<int[]> arr = new ArrayList<int[]>();
		arr.add(arr0);arr.add(arr1);arr.add(arr2);arr.add(arr3);
		
		// Loop through each depth
		for (int i = 0; i < arr.size(); i++) {
			// loop through each element in specific depth
			for (int j = 0; j < arr.get(i).length; j++) {
				assertEquals(tree.depthInOrder(i).get(j).compareTo(arr.get(i)[j]), 0);
			}
		}
	}
	
	/*	Input: 8 8 1 5 3 7 0 3 3 7 9
	 * 
	 *        5
	 *     /     \
	 * 	 1         8
	 *	/ \       / \
	 * 0   3     7   8
	 * 	  / \   /     \
	 *   3 	 3 7       9
	 */
	
	@Test
	void testFindPath() {
		AVL_Tree<Integer> tree = new AVL_Tree<Integer>();
		for (int i = 0; i < 10; i++) {
			Integer e = rand.nextInt(10);
			tree.insert(e);
		}
		tree.insert(9);
		
		// Case: startVal in tree
		// subcase: normal
		Stack<Integer> stack_norm = tree.findPath(5, 7);
		int[] arr_norm = {7, 8, 5};
		for(int i=0;!stack_norm.isEmpty();i++) {
			assertEquals(stack_norm.pop().compareTo(arr_norm[i]), 0);
		}
		// subcase: duplicate values
		AVL_Tree<Integer> tree1 = new AVL_Tree<Integer>();
		tree1.insert(0);tree1.insert(0);tree1.insert(0);tree1.insert(0);tree1.insert(0);tree1.insert(0);tree1.insert(0);
		tree1.insert(0);tree1.insert(0);tree1.insert(0);tree1.insert(0);tree1.insert(0);tree1.insert(0);tree1.insert(0);tree1.insert(0);
		tree1.insert(9);
		Stack<Integer> stack_dup = tree1.findPath(0, 9);
		int[] arr_dup = {9, 0};
		for(int i=0;!stack_dup.isEmpty();i++) {
			assertEquals(stack_dup.pop().compareTo(arr_dup[i]), 0);
		}	
		// subcase: startVal is below endVal
		assertTrue(tree.findPath(3, 5).isEmpty());
		// subcase: startVal, endVal in different branch
		assertTrue(tree.findPath(0, 7).isEmpty());
		// subcase: endVal NOT in tree
		assertTrue(tree.findPath(8, 10).isEmpty());

		
		// Case: startVal NOT in tree
		assertTrue(tree.findPath(6, 1).isEmpty());
	}
}