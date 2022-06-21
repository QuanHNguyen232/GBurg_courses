
import java.util.Scanner;

public class Username {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.print("Please enter a first name, last name, and 1-2 digit positive integer separated by spaces: ");
		String s = in.nextLine();
		
		int space1 = s.indexOf(" ")+1;
		int space2 = s.indexOf(" ", s.indexOf(" ")+1);
		
		String num = s.substring(space2+1, s.length());
		String firstName = s.substring(0, space1-1).toLowerCase();
		if (firstName.length()>2) {
			firstName = firstName.substring(0,2);
		}
		String lastName = s.substring(space1, space2).toLowerCase();
		if (lastName.length()>4) {
			lastName = lastName.substring(0,4);
		}
		
		
		
		System.out.println(lastName + firstName + (num.length()==1 ? "0" + num : num));
		
		
		
		in.close();
	}

}
