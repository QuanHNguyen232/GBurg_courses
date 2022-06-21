import java.util.ArrayList;
import java.util.Random;


//what is wrong with this code?
public class ArrayListRemoveExample {

	public static final int MAX = 20;
	public static final int MAX_VALUE = 10;
	
	public static void main(String[] args) {
		Random rand = new Random(0);
		
		//fill an array list with random values
		ArrayList<Integer> values = new ArrayList<Integer>();
		for(int i = 0; i < MAX; i++) {
			values.add(rand.nextInt(MAX_VALUE));
		}
		System.out.println(values);
		
		for(int i = 0; i < values.size(); i++) {
			//remove evens
			if(values.get(i) % 2 == 0) {
				values.remove(i);
				
				// We have to look at this location again, because something new moved into it
				i--;
			}
		}
		System.out.println(values);
	}

}
