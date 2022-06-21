
import java.util.Scanner;

public class Division {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		System.out.print("Please enter integer a: ");
		int a = in.nextInt();
		System.out.print("Please enter integer b: ");
		int b = in.nextInt();
		
		System.out.println("Floating point division: a/b = "+ (double) a/b);
		System.out.println("Integer division: a/b = " + a/b + " remainder " + a%b);
		
		in.close();
	}

}
