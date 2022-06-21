
import java.util.Scanner;

public class Sort3Strings {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.print("String 1? ");
		String string1 = in.nextLine();
		System.out.print("String 2? ");
		String string2 = in.nextLine();
		System.out.print("String 3? ");
		String string3 = in.nextLine();
				
		// Way 1
		System.out.println(string1.compareTo(string2)<0 && string1.compareTo(string3)<0 ? string1: (string2.compareTo(string1)<0 && string2.compareTo(string3)<0)? string2: string3 );
		System.out.println((string1.compareTo(string2)<0 && string1.compareTo(string3)>0) || (string1.compareTo(string2)>0 && string1.compareTo(string3)<0) ? string1: 
			(string2.compareTo(string1)<0 && string2.compareTo(string3)>0) || (string2.compareTo(string1)>0 && string2.compareTo(string3)<0) ? string2: string3 );
		System.out.println(string1.compareTo(string2)>0 && string1.compareTo(string3)>0 ? string1: (string2.compareTo(string1)>0 && string2.compareTo(string3)>0)? string2: string3 );

		
		// Way 2: swap place
		if (string1.compareTo(string2) > 0) {
			String temp = string1;
			string1 = string2;
			string2 = temp;
		}
		if (string2.compareTo(string3) > 0) {
			String temp = string2;
			string2 = string3;
			string3 = temp;	// string 3 is the largest
		}
		if (string1.compareTo(string2) > 0) {
			String temp = string1;
			string1 = string2;
			string2 = temp;
		}
		System.out.println(string1+"\n"+string2+"\n"+string3);
		
		
		in.close();
	}

}
