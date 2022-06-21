import java.util.Scanner;

public class ReadData2 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		//read the number of items in the data
		int n = in.nextInt();
		
		// hold DataList object
		DataList[] lists = new DataList[n];
		
		for(int i = 0; i < n; i++) {
			lists[i] = new DataList();
			
			//read each data set (sentinel)
			double value = in.nextDouble();
			
			while(value > 0) {
				lists[i].addValue(value);
				value = in.nextDouble();
			}
			
		}
		System.out.println("hello");
		for (int i = 0; i < lists.length; i++) {
			System.out.printf("List %d's sum is %.4f.\n", i, lists[i].getSum());
		}
		in.close();
	}

}
