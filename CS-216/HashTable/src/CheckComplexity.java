import java.util.LinkedList;
import java.util.Random;

public class CheckComplexity {

	public static void main(String[] args) {
		Random rand = new Random();
		myHashTable<Integer> hash = new myHashTable<Integer>();
		double avgDepth = 0;
		int maxDepth = 0;
		double emptyRatio = 0;
//		int size = 0;
		
		int numIter = 100000;
		for (int i = 0; i < numIter; i++) {
			hash.add(rand.nextInt());
			
			if (i >= 128) {
				avgDepth = avgDepth < hash.avgDepth() ? hash.avgDepth() : avgDepth;
				maxDepth = maxDepth < hash.maxDepth() ? hash.maxDepth() : maxDepth;
				emptyRatio = emptyRatio < hash.emptyBuckets() ? hash.emptyBuckets() : emptyRatio;
			}
		}
		
		System.out.printf("avgDepth=%6.5f \n"
				+ "maxDepth=%2d \n"
				+ "emptyRatio=%6.5f\n"
				, avgDepth, maxDepth, emptyRatio);

		
		
	}

}