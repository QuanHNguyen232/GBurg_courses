import java.util.InputMismatchException;
import java.util.Scanner;

public class ExceptionTest {

	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);

		System.out.print("Integer? ");

		boolean done = false;
		int n = 0;

		while(!done) {
			try {
				n = in.nextInt();	// if input is not int, the input value is still kept in the input 
				System.out.println("Got it");
				done = true;
			}
			catch (InputMismatchException ime) {
//				System.out.println("error");
//				ime.printStackTrace();
				System.out.println(ime);	// use exception's toString
				
				// consume the input value that is not used yet
//				in.next();
				// OR
				String line = in.nextLine();
				System.out.println(line + " is not an integer");
				
				System.out.print("Integer? ");
				
//				return;	// not important
			}
		}
		

		System.out.println("Entered: " + n);



	}

}
