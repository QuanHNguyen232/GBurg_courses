import java.util.Stack;

public class test {

	public static void main(String[] args) {
		
//		AVL_Tree<Integer> tree = generateTree();
//		printTree(tree);
//		tree.delete_NEED_HELP_2SUBTREE_PROMOTE_NULL(0);
//		printTree(tree);
		
//		AVL_Tree<Integer> tree1 = generateTree();
//		tree1.delete_NEED_HELP_2SUBTREE_PROMOTE_NULL(20);
//		printTree(tree1);
		
		AVL_Tree<Integer> tree = generateTree();
		tree.insert(-10);
		printTree(tree);
		tree.delete(5);
		printTree(tree);
		
		
//		AVL_Node<Integer> node = tree.getRoot().getRightNode().getRightNode();
//		System.out.println(node.getData()+ "\th=" + node.getHeight() + "\tbalFac=" + node.balFactor());
		
		
	}
	public static void printTree(AVL_Tree<Integer> tree) {
		for (int i = 0; i < 5; i++) {
			System.out.println(tree.depthInOrder(i));
		}
		System.out.println();
	}
	public static AVL_Tree<Integer> generateTree(){
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
}
