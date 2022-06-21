import java.util.ArrayList;
import java.util.Random;

public class test {

	public static void main(String[] args) {
		Random r = new Random(1);
		MinPriorityQueue<Integer> obj = new MinPriorityQueue<Integer>();
		MinPriorityQueue<Integer> obj2 = new MinPriorityQueue<Integer>();
		for (int i = 0; i < 10; i++) {
			Integer val = r.nextInt(20);
			obj.insert(val);
			obj2.insert(val);
		}
		
		System.out.println(obj.heap);
		System.out.println(obj2.heap);

//		obj.heap.set(2, 15);
//		obj.bubbleDown(2);
//		System.out.println(obj.heap);
		
//		obj.heap.set(1, 20);
//		obj.bubbleDown(1);
//		System.out.println(obj.heap);
		
		for (; !obj.isEmpty();) {
			obj.deleteMin();
			obj2.deleteMin_2();
			System.out.println(obj.heap);
			System.out.println(obj2.heap);
		}
		

	}

}
