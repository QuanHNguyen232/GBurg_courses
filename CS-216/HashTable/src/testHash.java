import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Random;

public class testHash {

	public static void main(String[] args) {
		myHashTable<Integer> hash2 = new myHashTable<Integer>();
		hash2.resizeTable(256);
		for (int i = 0; i < 66; i++) {
			hash2.add(i);			
		}
		System.out.println(hash2.keys());
		for (int i = 0; i < 10; i++) {
			hash2.delete(i);
		}
		System.out.println(hash2.keys());
//		System.out.println(hash2.traverse());
		
		
		//		myHashTable<Integer> hash = new myHashTable<Integer>();
//		hash.add(0);
//		hash.add(1);
//		hash.add(128*1+1);
//		hash.add(128*2+1);
//		System.out.println(hash.traverse());
//		System.out.println(hash.avgDepth());
		
//		Integer i = new Integer(1);
//		Integer i1 = new Integer(2);
//		hash.add(1);
//		hash.add(2);
//		hash.add(129);
//		hash.add(20);
		
		
//		for (int j = 0; j < 193; j++) {
//			System.out.print("j="+j+" ");
//			hash.add(j);
//			System.out.println("\tsize="+hash.size());
//		}
//		System.out.println("\tcurSize="+hash.size());
//		for (int i = 0; i < 70; i++) {
//			hash.delete(i);
//			System.out.println("\t\talpha="+hash.keys()/(double)hash.size());
//		}
//		
//		System.out.println("\tdel_size="+hash.size());
		
		
//		hash.resizeTable(256*2);
//		System.out.println("\tresize 256*2="+hash.size());
		
//		myHashTable<Integer> hash1 = new myHashTable<Integer>();
//		for (int i = 0; i < 100; i++) {
//			hash1.add(i);			
//		}
//		hash1.resizeTable(128);
//		System.out.println(hash1.size());
//	}

		
//		myHashTable<Integer> hash = new myHashTable<Integer>();
//		ArrayList<Integer> list = new ArrayList<Integer>();
//		Random rand = new Random(0);
//		for (int i = 0; i < 20; i++) {
//			int a = rand.nextInt(10);
//			list.add(a);
//			hash.add(a);
//		}
//		hash.add(128);list.add(128);
//		hash.add(128*2);list.add(128*2);
//		hash.add(128*3);list.add(128*3);
//		ArrayList<Integer> check_list = hash.traverse();
//		System.out.println(check_list);
//		System.out.println(list);
//		System.out.println(hash.maxDepth());
//		System.out.println(hash.avgDepth());
//		System.out.println((4 + 8)/128.0);
//		System.out.println(hash.emptyBuckets());
//		System.out.println((128-9)/128.0);
//		System.out.println(hash.keys());
	}
}
