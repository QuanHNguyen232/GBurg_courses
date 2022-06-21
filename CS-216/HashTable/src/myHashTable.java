import java.util.*;

public class myHashTable<T> {
	// field
	private static int minSize = 128;
	private int keys = 0;	// to check if we need to expand size of hash table
	private ArrayList<LinkedList<T>> table; 
	
	// constructor
	public myHashTable() {
//		table = new ArrayList<LinkedList<T>>(minSize);
		table = new ArrayList<LinkedList<T>>();
		for (int i = 0; i < minSize; i++) {
			table.add(new LinkedList<T>());
		}
	}
	
	// private to resize only
	private myHashTable(int size) {
		table = new ArrayList<LinkedList<T>>();
		for (int i = 0; i < size; i++) {
			table.add(new LinkedList<T>());
		}
	}
	
	/**
	 * Count the number of objects in table
	 * @return number of objs in table
	 */
	public int keys() {return keys;}
	
	/**
	 * Check the number of buckets
	 * @return size of arrayList
	 */
	public int size() {return table.size();}
	
	/**
	 * Add new data into hashtable
	 * @param data
	 * @return true if data is added, false if data exists, so it is not added
	 */
	public boolean add(T data) {
		int index = hash(data);
		// bucket that would contains data if it exists
		LinkedList<T> bucket = getBucket(index);
		// if data is NOT already in hashtable
		if(!bucket.contains(data)) {
			bucket.add(data);
			this.keys++;
			checkExpand();
			return true;
		}
		// if data is already in hashtable
		return false;
	}
	
	private void checkExpand() {
		double alpha = (double)this.keys/this.table.size();
		int newSize = this.size()*2; 
		if (alpha > 0.75) {
			resizeTable(newSize);
		}
	}
	
	/**
	 * Delete data from hashtable
	 * @param data
	 * @return true if data is deleted
	 */
	public boolean delete(T data) {
		// Get index of bucket that contains data
		int index = hash(data);
		// get that bucket
		LinkedList<T> bucket = getBucket(index);
		for (int i = 0; i < bucket.size(); i++) {
			if (data.equals(bucket.get(i))) {
				bucket.remove(data);
				this.keys--;
				checkCompress();
				return true;
			}
		}
		return false;
	}

	private void checkCompress() {
		double alpha = (double)this.keys/this.table.size();
		int newSize = this.size()/2;
		if (alpha < 0.25 && newSize >= minSize) {
			resizeTable(newSize);
		}
	}
	
	/**
	 * Search if data is in the hashtable
	 * @param data
	 * @return true if data is in the hashtable, else false
	 */
	public boolean search(T data) {
		// same data -> obj has same hashCode
		// Get index of bucket that contains data
		int index = hash(data);
		// get that bucket
		LinkedList<T> bucket = getBucket(index);
		// search if data in that bucket
		for (int i = 0; i < bucket.size(); i++) {
			if (data.equals(bucket.get(i))) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Get list of all items in hashtable
	 * @return list of all items in hashtable
	 */
	public ArrayList<T> traverse() {
		// ArrayList as container of returning type
		ArrayList<T> returnData = new ArrayList<T>();
		// loop through table
		for (int i = 0; i < this.table.size(); i++) {
			LinkedList<T> bucket = getBucket(i);
			if (bucket != null) {
				// loop through linkedList in current bucket
				for (int j = 0; j < bucket.size(); j++) {
					// add obj to container
					returnData.add(bucket.get(j));
				}
			}
		}
		return returnData;
	}
	
	/**
	 * Change size of ArrayList that contains buckets based on number of data inside
	 * @param size
	 */
	public void resizeTable(int size) {	// when should we resize ??? (target: keep linkedlist small as possible)
		// new ArrayList with specified size OR new hashtable object
//		ArrayList<LinkedList<T>> newTable = new ArrayList<LinkedList<T>>(size);	// wy not just change fields???
		myHashTable<T> newHashTable = new myHashTable<T>(size);

		// you can use new data structure's add method for efficiency
		// loop through original hash table
		for(int bucketIdx = 0; bucketIdx < size(); bucketIdx++) {
			// grab current bucket in current table
			LinkedList<T> bucket = table.get(bucketIdx);
			for (int i = 0; i < bucket.size(); i++) {
				// add to new hashtable obj (use traverse -> add each item into new ArrayList)
				newHashTable.add(bucket.get(i));
			}
		}
		// update new table
		table = newHashTable.table;

		
		// use table from new table
		// bind old table to this new table
	}
	
	/**
	 * Get size of the largest bucket
	 * @return size of the largest bucket
	 */
	public int maxDepth() {
		int maxDepth = -1;	// if buckets do not exist, return -1
		for (int i = 0; i < table.size(); i++) {
			LinkedList<T> bucket = table.get(i);
			int depth = bucket.size();
			if (maxDepth < depth) {
				maxDepth = depth;
			}
		}
		return maxDepth;
	}
	
	/**
	 * Get average size of all buckets
	 * @return (double) average size of all buckets
	 */
	public double avgDepth() {
		double total = 0;
		for (int i = 0; i < table.size(); i++) {
			LinkedList<T> bucket = table.get(i);
			int depth = bucket.size();
			total += depth*(depth+1)/2;
		}
		return total/this.table.size();
	}
	
	/**
	 * Get the proportion of buckets that are empty in the hash table
	 * @return (double) proportion of buckets that are empty in the hash table
	 */
	public double emptyBuckets() {
		double totalEmpty = 0;
		for (int i = 0; i < table.size(); i++) {
			LinkedList<T> bucket = table.get(i);
			if (bucket.size() == 0) { totalEmpty ++; }
		}
		return totalEmpty/this.table.size();
	}


	private int hash(T data) {
		return Math.abs(data.hashCode() % this.size());
	}
	
	private LinkedList<T> getBucket(int idx) {
		return table.get(idx);
	}
	
	
	
	
}
