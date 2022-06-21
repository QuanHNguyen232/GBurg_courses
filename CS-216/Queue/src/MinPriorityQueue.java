import java.util.ArrayList;
import java.util.Random;

public class MinPriorityQueue<E extends Comparable<E>> {
	
	// array-based binary heap
	public ArrayList<E> heap = new ArrayList<E>();
	
	/**
	 * Insert new data into queue
	 * @param e (type E)
	 */
	public void insert(E e) {
		// add to end of heap array (bottom-right of complete binary tree)
		int idx = heap.size();
		heap.add(e);
		
		// "bubble-up" item to restore heap property
		while (idx > 0) {	// not at root
			int parentIdx = (idx-1)/2;	// int division
			E parent = heap.get(parentIdx);
			if (parent.compareTo(e) > 0) {
				// swap them, bubbling up the inserted value
				heap.set(idx, parent);
				heap.set(parentIdx, e);
				// update new index of inserted item
				idx = parentIdx;
			}
			else {	// case parent is smaller than e
				break;	// done bubbling up
			}
		}
	}
	
	/**
	 * Delete the minimum value in the queue, the reorganize to maintain heap property
	 * @return minimum data in queue
	 */
	public E deleteMin() {
		if (heap.isEmpty()) {
			return null;
		}
		E retVal = heap.get(0);	// store min value for later return
		// replace it with the last value and reduce the heap size
		E lastVal = heap.get(heap.size()-1);
		
		// bring lastVal to top and remove the last item
		heap.set(0, lastVal);
		heap.remove(heap.size()-1);	// careful - specify idx or Obj to remove

		// "bubble down" value substituted at root
		int idx = 0;
		int size = heap.size();
		while (true) {	// while sifting down
			int minIdx = idx;
			int leftIdx = 2*idx + 1;
			int rightIdx = 2*idx + 2;
			E leftVal = (leftIdx >= size) ? null : heap.get(leftIdx);
			E rightVal = (rightIdx >= size) ? null : heap.get(rightIdx);
			if (leftVal == null) {	// no children, done sifting
				break;
			}
			
			// assign lastVal as min
			E minVal = lastVal;
			
			// check left child
			if (leftVal.compareTo(minVal) < 0) {	// leftVal < minVal
				minVal = leftVal;
				minIdx = leftIdx;
			}
			
			// check right child
			if (rightVal != null && rightVal.compareTo(minVal) < 0) {
				minVal = rightVal;
				minIdx = rightIdx;
			}
			
			if (minIdx == idx) {
				break;	// no swapping, done sifting down
			}
			
			// sift down - swap with minimum child
			heap.set(idx, minVal);
			heap.set(minIdx, lastVal);
			
			idx = minIdx;	// update lastVal idx
		}
		
		return retVal;
	}
	
	public E deleteMin_2() {
		if (heap.isEmpty()) {
			return null;
		}
		E retVal = heap.get(0);	// store min value for later return
		// replace it with the last value and reduce the heap size
		E lastVal = heap.get(heap.size()-1);
		
		// bring lastVal to top and remove the last item
		heap.set(0, lastVal);
		heap.remove(heap.size()-1);	// careful - specify idx or Obj to remove

		// "bubble down" value substituted at root
		int idx = 0;
		int maxIdx = heap.size()-1;
		
		// starts from root (idx=0)
		if (maxIdx >= 0) {
			bubbleDown(idx);
		}
		
		return retVal;
	}
	
	public void bubbleDown(int minIdx) {
		int maxIdx = heap.size()-1;
		int currIdx = minIdx;
		int leftIdx = currIdx*2 + 1;
		int rightIdx = currIdx*2 + 2;
		E currVal = heap.get(currIdx);
		E leftVal = leftIdx > maxIdx ? null : heap.get(leftIdx);
		E rightVal = rightIdx > maxIdx ? null : heap.get(rightIdx);
		
		if (leftVal != null) {
			// case: right NULL, LEFT is smallest
			if (rightVal == null && leftVal.compareTo(currVal) < 0) {
				// swap LEFT
				heap.set(currIdx, leftVal);
				heap.set(leftIdx, currVal);
				bubbleDown(leftIdx);
			}
			// case: right NOT null
			else if (rightVal != null) {
				// subcase: LEFT is smallest
				if (leftVal.compareTo(rightVal) <= 0 && leftVal.compareTo(currVal) < 0) {
					// swap LEFT
					heap.set(currIdx, leftVal);
					heap.set(leftIdx, currVal);
					bubbleDown(leftIdx);
				}
				// subcase: RIGHT is smallest
				else if (leftVal.compareTo(rightVal) > 0 && rightVal.compareTo(currVal) < 0) {
					// swap RIGHT
					heap.set(currIdx, rightVal);
					heap.set(rightIdx, currVal);
					bubbleDown(rightIdx);
				}
				// subcase: CURR is smallest -> pass
			}
		}
		// case: leftVal NULL: currNode is Leaf -> pass
	}
	
	/**
	 * Updates element at that index to e, then bubbles either up or down to maintain min-heap property
	 * @param idx
	 * @param e (type E)
	 * @return true if key is changed successfully, false if index is out of bound
	 */
	public boolean changeKey(int idx, E e) {
		//Checks for valid index
		if (idx < 0 || idx > heap.size()-1) {return false;}
		// assign item at index to e
		heap.set(idx, e);
		System.out.println(heap);
		// bubble
		int beginIdx=0;
		int size = heap.size();
		int parentIdx = (idx-1)/2;
		int currIdx = idx;
		int leftIdx = 2*currIdx + 1;
		int	rightIdx = 2*currIdx + 2;
		E currVal = heap.get(currIdx);
		E parentVal = heap.get(parentIdx);
		E leftVal = (leftIdx >= size) ? null : heap.get(leftIdx);
		E rightVal = (rightIdx >= size) ? null : heap.get(rightIdx);
		
		// bubble up: parent > currVal
		if (parentVal.compareTo(currVal) > 0) {
			while (parentVal.compareTo(currVal) > 0) {
				// swap value
				heap.set(parentIdx, currVal);
				heap.set(currIdx, parentVal);
				// new index
				currIdx = parentIdx;
				parentIdx = (currIdx-1)/2;
				// stop if currIdx reaches top
				if (currIdx == beginIdx) {break;}
				// new vals
				currVal = heap.get(currIdx);
				parentVal = heap.get(parentIdx);
			}
			return true;
		}
		// nothing happens
		else if (parentVal.compareTo(currVal) == 0) {return true;}
		else {
		// bubble down: currVal > left/right

			while (true) {
				if (leftVal == null) {	// no children, done sifting
					break;
				}
				// swap with left
				if (rightVal.compareTo(leftVal) > 0 && currVal.compareTo(leftVal) > 0) {	// check min is left
					heap.set(leftIdx, currVal);
					heap.set(currIdx, leftVal);
					// update index
					currIdx = leftIdx;
					leftIdx = currIdx*2 + 1;
					rightIdx = currIdx*2 + 2;
					// update vals
					currVal = heap.get(currIdx);
					leftVal = (leftIdx >= size) ? null : heap.get(leftIdx);
					rightVal = (rightIdx >= size) ? null : heap.get(rightIdx);
				}
				else if (leftVal.compareTo(rightVal) >= 0 && currVal.compareTo(rightVal) > 0) {
					heap.set(rightIdx, currVal);
					heap.set(currIdx, rightVal);
					// update index
					currIdx = rightIdx;
					leftIdx = currIdx*2 + 1;
					rightIdx = currIdx*2 + 2;
					// update vals
					currVal = heap.get(currIdx);
					leftVal = (leftIdx >= size) ? null : heap.get(leftIdx);
					rightVal = (rightIdx >= size) ? null : heap.get(rightIdx);
				}
			}
			return true;
		}
//		return true;
	}

	/**
	 * Check if there are elements in queue
	 * @return false if queue is empty, else return true
	 */
	public boolean isEmpty() {
		return heap.isEmpty();
	}
	
	public static void main(String[] args) {
		
		MinPriorityQueue<Integer> pq = new MinPriorityQueue<Integer>();
		ArrayList<Integer> index = new ArrayList<Integer>();
		// randomly insert value
		Random rand = new Random(13);
		int size = 11;
		for (int i=0; i< size; i++) {
			int val = rand.nextInt(size);
			System.out.print(val + " ");
			pq.insert(val);
		}
		for (int i = 0; i < size; i++) {
			index.add(i);
		}

		System.out.println();
		
		// show heap (usually private)
		System.out.println(pq.heap);

		pq.changeKey(9, -1);
		System.out.println(pq.heap);
		System.out.println(index);
		
//		System.out.println(pq.changeKey(3, 3));
//		System.out.println(pq.heap);

		// remove all (in sorted order) CHECKED
//		while (!pq.isEmpty()) {
//			System.out.print(pq.deleteMin() + " ");
//		}
		System.out.println();
		
	}
//	Unused code for changeKey
	// check left child
//	if (leftVal.compareTo(currVal) < 0) {
//		heap.set(leftIdx, currVal);
//		heap.set(currIdx, leftVal);
//		// update index
//		currIdx = leftIdx;
//		leftIdx = currIdx*2 + 1;
//		// update vals
//		currVal = heap.get(currIdx);
//		leftVal = (leftIdx >= size) ? null : heap.get(leftIdx);
//	}
//	// check right child
//	if (rightVal != null && rightVal.compareTo(currVal) < 0) {
//		heap.set(rightIdx, currVal);
//		heap.set(currIdx, rightVal);
//		// update index
//		currIdx = rightIdx;
//		rightIdx = currIdx*2 + 2;
//		// update vals
//		currVal = heap.get(currIdx);
//		rightVal = (rightIdx >= size) ? null : heap.get(rightIdx);
//	}

}
