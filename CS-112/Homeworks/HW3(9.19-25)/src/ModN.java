import java.util.ArrayList;
import java.util.Scanner;

public class ModN {
	
	// Test case: String "1 2 -3 3.3 4 -5 f 6 7.5 8k 9 -s quit"
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		ArrayList<Integer> intList = new ArrayList<Integer>();
		
		// Input ArrayList
		System.out.println("Enter array, use \"quit\" to stop");
		String s="";
		while (in.hasNext()) {
			while (in.hasNextInt()) {
				intList.add(in.nextInt());
			}
			s =in.next();
			if (s.equals("quit")) {
				break;
			}
		}
		System.out.println(intList);
		
		
		// Input divisor
		int divisor = 1;
		System.out.print("Divisor? ");
		while (true) {
			try {
				divisor = in.nextInt();
				break;
			}
			catch (Exception e) {
				System.out.println(e);
				System.out.println("Enter again");
				in.nextLine();
			}
		}
		
		// Computing
		System.out.println("count: " + countModN(intList, divisor));
		System.out.println("removed: " + removeModN(intList, divisor));
		System.out.println(intList);
		
		in.close();
	}
	

	public static int countModN(ArrayList<Integer> intList, int divisor) {
		int count = 0;
		for (Integer i : intList) {
			count = i%divisor == 0 ? ++count : count;
		}
		return count;
	}
	
	public static int removeModN(ArrayList<Integer> intList, int divisor) {
		int count = 0;
		for (int i = 0; i < intList.size(); i++) {
			if (intList.get(i)%divisor == 0) {
				intList.remove(i);
				count++;
				i--;
			}
		}
		return count;
	}
	
	
}
