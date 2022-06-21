import java.util.Scanner;

public class Ch2StringFun {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("A String starts and ends with double-quotes, so how do we print a double-quote itself?");
		System.out.println("We use an \"escape character\", the backward-slash (backslash) before each double quote.");
		System.out.println("The escape character itself causes Java to treat what follows specially.");
		System.out.println("To print a backslash, we escape it as well: \\");
		System.out.println("To print the lowercase n with tilde, we note the unicode value of 0xf1 and use it in a string like this:");
		System.out.println("\u00f1");
		System.out.println("Note that we can\nbreak the line within strings (\\n) and ...");
		System.out.println("... make the Best.\tTabs.\tEver. (\\t)");
		
		// Magic trick
		System.out.println("Math magic trick: Stack a number of 6-sided dice one a top the other in a tower.");
		System.out.print("How many dice are in your tower? ");
		Scanner in = new Scanner(System.in); 
		int numberOfDice = in.nextInt();
		System.out.print("What number shows on the very top of your tower? ");
		int topNum = in.nextInt();
		int unseenSum = 7 * numberOfDice - topNum;
		System.out.println("Then the sum of the numbers on your unseen dice faces is " + unseenSum + ".");
		
		
		in.close();
		
		
		
	}

}
