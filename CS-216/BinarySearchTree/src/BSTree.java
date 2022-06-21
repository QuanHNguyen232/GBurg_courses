import java.util.*;

public class BSTree<T extends Comparable<T>> {
	
	// field
	private BSTNode<T> head;
	
	
	// constructor
	public BSTree () {}
	
	// method
	
	/**
	 * insert new data into tree
	 * @param data
	 */
	public void insert(T data) {
		BSTNode<T> node = new BSTNode<T>(data);
		
		// tree is empty
		if (head == null) {
			this.head = node;
		}
		else {	// tree is NOT empty
			BSTNode<T> currNode = this.head;
			
			while (true) {
				if (node.compare(currNode) <= 0) {	// go to LEFT if node < currNode
					if (currNode.getLeftNode() != null) {	// left child NOT null -> update currNode
						currNode = currNode.getLeftNode();
					}
					else {	// left child NULL -> set as LEFT child, stop loop
						currNode.setLeftNode(node);
						break;
					}
				}
				else {	// go to RIGHT if node > currNode
					if (currNode.getRightNode() != null) {	// right child NOT null -> update currNode
						currNode = currNode.getRightNode();
					}
					else {	// right child NULL -> set as RIGHT child, stop loop
						currNode.setRightNode(node);
						break;
					}
				}
			}
		}
		
	}
	
	/**
	 * Remove node from tree
	 * @param data
	 * @return true if can find and remove it, false if that data does not exists
	 */
	public boolean remove(T data) {
		BSTNode<T> removeNode = findNode(data);
		// case: cannot find
		if (removeNode == null) return false;
		// case: found
		BSTNode<T> parNode = findParent(removeNode);
		BSTNode<T> removeLeft = removeNode.getLeftNode();
		BSTNode<T> removeRight = removeNode.getRightNode();

		// sub_case: currNode is LEAF
		if (removeLeft == null && removeRight == null) {
			// sub_sub_case: remove the root
			if (parNode == null) {this.head = null; return true;}
			// sub_sub_case: remove left
			if (parNode.getLeftNode() == removeNode) {parNode.setLeftNode(null); return true;}
			// sub_sub_case: remove right
			else {parNode.setRightNode(null); return true;}
		}
		// sub_case: currNode has 1 child
		// sub_sub_case: currNode'child is LEFT
		if (removeLeft != null && removeRight == null) {
			// sub_sub_sub_case: remove root
			if (this.head == removeNode) {this.head.setLeftNode(removeNode.getLeftNode()); return true;}
			// sub_sub_sub_case: remove left
			if (parNode.getLeftNode() == removeNode) {parNode.setLeftNode(removeNode.getLeftNode()); return true;}
			// sub_sub_sub_case: remove right
			if (parNode.getRightNode() == removeNode) {parNode.setRightNode(removeNode.getLeftNode()); return true;}
		}
		// sub_sub_case: currNode'child is RIGHT
		if (removeLeft == null && removeRight != null) {
			if (this.head == removeNode) {this.head.setRightNode(removeRight); return true;}
			if (parNode.getLeftNode() == removeNode) {parNode.setLeftNode(removeRight); return true;}
			if (parNode.getRightNode() == removeNode) {parNode.setRightNode(removeRight); return true;}
		}
		// sub_case: currNode has 2 children
		if (removeLeft != null && removeRight != null) {
			// find a node to replace (from currNode, go 1 left, then go right to the end)
			BSTNode<T> nodeReplace = removeLeft;
			while (!(nodeReplace.getLeftNode()==null && nodeReplace.getRightNode() ==null)) {
				nodeReplace = nodeReplace.getRightNode();
			}
			// find parent of nodeReplace
			BSTNode<T> nodeRepPar = findParent(nodeReplace);
			// remove nodeReplace from its parent
			if(nodeRepPar.getLeftNode() == nodeReplace) {nodeRepPar.setLeftNode(null);}
			else {nodeRepPar.setRightNode(null);}
			// case: removeNode is head
			if (this.head == removeNode) {
				this.head = nodeReplace;
				nodeReplace.setLeftNode(removeLeft);
				nodeReplace.setRightNode(removeRight);
			}
			else {	// case: removeNode is NOT head
				// bind: parNode(removeNode's parent) -> nodeReplace 
				if (parNode.getLeftNode() == removeNode) {
					parNode.setLeftNode(nodeReplace);
				}
				else {
					parNode.setRightNode(nodeReplace);
				}
				// bind removeNode's left and right children to nodeReplace
				nodeReplace.setLeftNode(removeLeft);
				nodeReplace.setRightNode(removeRight);
			}
			return true;
		}


		return true;
	}
	
	/**
	 * @param node
	 * @return
	 */
	private BSTNode<T> findParent(BSTNode<T> node){
		if (this.head == node) {return null;}
		BSTNode<T> parNode = this.head;
		BSTNode<T> childNode = (node.compare(parNode) < 0) ? parNode.getLeftNode() : parNode.getRightNode();
		while (childNode != node) {
			parNode = childNode;
			childNode = (node.compare(parNode) < 0) ? parNode.getLeftNode() : parNode.getRightNode();
		}
		return parNode;
	}
	
	/**
	 * Check if data exists in the tree
	 * @param data
	 * @return data if found, else return null
	 */
	public T search(T data){
		BSTNode<T> node = findNode(data);
		return (node == null) ? null : node.getData();
	}
	
	/**
	 * determine if a node exists in tree with specified data entry
	 * @param data
	 * @return
	 */
	private BSTNode<T> findNode(T data) {
		BSTNode<T> currNode = this.head;
		
		while (currNode != null) {
			if (data.compareTo(currNode.getData()) == 0) {
				return currNode;
			}
			else if (data.compareTo(currNode.getData()) < 0) {
				currNode = currNode.getLeftNode();
			}
			else {
				currNode = currNode.getRightNode();
			}
		}
		
		return currNode;	// if stop while loop => currNode is null
	}
	
	/**
	 * Get the list of objs in ordered
	 * @return ArrayList of ordered objects
	 */
	public ArrayList<T> inOrder() {
		if (this.head == null) return null;
		else {
			// ArrayList container for ordered elements
			ArrayList<T> datum = new ArrayList<T>();
			return getSubTree(head, datum);
		}
	}

	/**
	 * 
	 * @param node
	 * @param sublist
	 * @return
	 */
	private ArrayList<T> getSubTree(BSTNode<T> node, ArrayList<T> sublist){
		// add left, add parent, then add right
		// add leftNode to sublist
		if (node.getLeftNode() != null) {
			getSubTree(node.getLeftNode(), sublist);
		}
		// add currNode to sublist
		sublist.add(node.getData());
		// add rightNode to sublist
		if (node.getRightNode() != null) {
			getSubTree(node.getRightNode(), sublist);
		}

		return sublist;
	}
	
	/**
	 * Get the maximum height of the tree. A node that has child(ren) is counted as height=1
	 * @param node
	 * @param currHeight
	 * @return maximum height of the tree
	 */
	public int height(BSTNode<T> node, int currHeight) {
		// case: empty tree
		if(this.head == null) {return -1;}
		else {
			BSTNode<T> left = node.getLeftNode();
			BSTNode<T> right = node.getRightNode();
			System.out.println("currNode="+node.getData()+"\tcurrHeight="+currHeight);
			// case: leaf node -> height=0
			if (left == null && right == null) {
				return currHeight;
			}
			// case: node has LEFT child -> height + 1 (current node & its child) + (height of child)
			else if (left != null && right == null) {
				System.out.println("left="+left.getData());
				return height(left, currHeight+1);
			}
			// case: node has RIGHT child
			else if (left == null && right != null) {
				System.out.println("right="+right.getData());				
				return height(right, currHeight+1);
			}
			// case: node has both children
			else {
				System.out.println("left="+left.getData()+"\tright="+right.getData());
				int leftHeight = height(left, currHeight+1);
				int rightHeight = height(right, currHeight+1);
				// only use higher height
				if (leftHeight > rightHeight) {
					return leftHeight;
				}
				else {
					return rightHeight;
				}
			}
		}
	}
	
	/**
	 * Check if the tree is balanced or not
	 * @param node
	 * @return true if the difference b/w weight of left and right sides is less than 2, else return false
	 */
	public boolean checkWeightBalance(BSTNode<T> node) {
		// case node is null
		if (node == null) {return false;}
		// case empty tree
		if (this.head == null) {return false;}
		// case tree has 1 node (head)
		if (this.head.getLeftNode() == null && this.head.getRightNode() == null) {System.out.print("head only\t");return true;}
		
		System.out.print("currNode="+ node.getData()+ " \n");
		
		// case tree has > 1 node
		BSTNode<T> left = node.getLeftNode();
		BSTNode<T> right = node.getRightNode();
		
		// case leaf node (reach the end of tree)
//		if (left == null && right == null) {System.out.print("leaf\t"); return true;}
		
		// case node that has child
		int countLeft=0;
		int countRight=0;
		if (left != null) {
			countLeft = count(left)+1;
		}
		if (right != null) {
			countRight = count(right)+1;
		}
		System.out.println("\tcountLeft="+countLeft);
		System.out.println("\tcountRight="+countRight);

		// if balance -> continue checking children
		int different = Math.abs(countLeft - countRight);
		System.out.println("\t\tdiff=" + different);
		if (different > 1) {
			return false;
		}
		else {//if (different <= 1) {
			if (left != null) {return checkWeightBalance(left);}
			if (right != null) {return checkWeightBalance(right);}
			else {return true;}
		}
		
//		return false;
	}
	
	private int count(BSTNode<T> currNode) {
		int total = 0;
		BSTNode<T> left = currNode.getLeftNode();
		BSTNode<T> right = currNode.getRightNode();
		if (left != null) {
			// include left into count and count its subtree
			total += 1;
			total += count(left);
		}
		if (right != null) {
			// include right into count and count its subtree
			total += 1;
			total += count(right);
		}
		return total;
	}
	
	/**
	 * Reform the tree so that it is in balance state
	 */
	public void badWeightBalance() {
		List<T> list = inOrder();
		if (list != null) {
			ArrayList<T> newArr = new ArrayList<T>();
			ArrayList<T> finalArr = arrBalance(list, newArr);
			this.head = null;
			for (int i = 0; i < finalArr.size(); i++) {
				insert(finalArr.get(i));
			}
			System.out.println(finalArr);
		}
	}
	
	private ArrayList<T> arrBalance(List<T> list, ArrayList<T> output) {
		int idx = list.size()/2;
		System.out.println(idx + "-" + list.get(idx) + "\t" + list);
		output.add(list.get(idx));
		int l, r;
		if (idx>0 && idx < list.size()) {
			// Left half
			l = 0; r = idx;
			if (l < r) {
				arrBalance(list.subList(l, r), output);
			}
			// Right half
			l = idx+1; r = list.size();
			if (l < r) {
				arrBalance(list.subList(l, r), output);
			}
		}
		return output;
	}
	
	/**
	 * Get the root node of the tree
	 * @return the root node
	 */
	public BSTNode<T> getHead(){return this.head;}
	
}
