import java.util.Scanner;

import javax.swing.JOptionPane;

public class StringFun {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.print("String? ");
		String line = in.nextLine();
		char c = line.charAt(0);	// get first char at index 0
		System.out.println("First character: " + c);
		System.out.println("Unicode value: " + (int) c);
		// https://en.wikipedia.org/wiki/List_of_Unicode_characters
		// 16 bit unsigned int
		if (c > 'a') {
			System.out.println("after 'a'");
		}
		if (c == 'a') {
			System.out.println("equals 'a'");
		}
		if (c < 'a') {
			System.out.println("before 'a'");
		}
		
		if (Character.isDigit(c)) {
			System.out.println("Digit");
		}
		if (Character.isLetter(c)) {
			System.out.println("Letter");
		}
		if (Character.isUpperCase(c)) {
			System.out.println("Uppercase");
		}
		if (Character.isLowerCase(c)) {
			System.out.println("Lowercase");
		}
		System.out.println(Character.toUpperCase(c));
		System.out.println(Character.toLowerCase(c));
		
		
		// String type
		String s = "strong literal";	// length 14 (indices 0-13)
		String s2 = "Hello!";	// length 6 (indices 0-5)
		System.out.println(s);
		System.out.println(s2);
		System.out.println(s2.substring(0, 5));
		int i = 3;
		System.out.println(s2.substring(0, i));
		System.out.println(s2.substring(i));
		System.out.println(s2.substring(i, s2.length()));
		s = line;
		System.out.println("Length: " + s.length());
		System.out.println("First character: " + s.charAt(0));
		System.out.println("Last character: " + s.charAt(s.length()-1));
		
		System.out.println("Compared to \"compare\": " + s.compareTo("compare"));
		System.out.println("Equal to \"compare\": " + s.equals("compare"));
		System.out.println("Equal (ignioring case) to \"compare\": " + s.equalsIgnoreCase("compare"));
		
		System.out.println("Has the same middle as \'Hello!\"? " + s.regionMatches(1, s2, 1, s2.length()-2));
		
		System.out.println("Starts with \"ante\"? " + s.startsWith("ante"));
		System.out.println("Ends with \"post\"? " + s.endsWith("post"));
		
		System.out.println("Index of the first 'a': " + s.indexOf('a'));
		System.out.println("Index of the first 'a': " + s.indexOf('a', 6));	// find 'a' after index 6
		System.out.println("Index of the last 'a': " + s.lastIndexOf('a'));
		
		System.out.println("concat" + "enate");
		System.out.println("concat".concat("enate"));
		
		System.out.println("bononos".replace('o', 'a'));
		
		System.out.println("To uppercase: " + s.toUpperCase());
		System.out.println("To uppercase: " + s.toLowerCase());
		
		System.out.printf("[%s] trims to [%s].\n", s, s.trim());	// remove whiteSpace before & after the String
		System.out.printf("String values: %s %s %s\n", String.valueOf(42), String.valueOf(Math.PI), String.valueOf(true));	// convert other types into String
		
		// Can also use Integer.toString(223) or Double.toString(2.23), or Arrays.toString(an_array)
		
		int d = Integer.parseInt("42");	// convert String into Integer
		double f = Double.parseDouble("1.23");	// convert String into Double
		System.out.println(d + " " + f + " ;d + f = " + (d+f));
		
		// Can also use Integer.valueOf("2"), ...
		
		System.out.println((char) 65);	// cast number 65 to character 'A' (Unicode)
		System.out.println((int) 'A');	// cast character 'A' to int 65 (Unicode)
		
		
		
		// printf
		f = Math.PI;
		System.out.printf("This is how you print a string %s, a decimal integer %d, and a floating-point number %f.\n", s, d, f);
		System.out.printf("10 decimal places: %.10f\n", f);
		System.out.printf("... >= 15 spaces: %15.10f\n", f);
		System.out.printf("%e %f %g\n", Math.PI, Math.PI, Math.PI);
		// %e - [e]xponential (scientific) notation.
		// %f - [f]loating-point (6 figures after the ".")
		// %g - [g]ood balance between %e and %f
		
		
//		// JOptionPane - popup windows for simple I/O
//		String name = JOptionPane.showInputDialog("Please enter your name.");
//		System.out.println(name);
//		String massage = String.format("Hello, %s!", name);
//		JOptionPane.showMessageDialog(null, massage);
		
		
		// Understand Scanner
		System.out.print("Integer? ");
		i = in.nextInt();
		System.out.println(i);
		in.nextLine();	// Only need for a string input following a number input; Only happens to nextLine
		System.out.print("Another string? ");
		s = in.nextLine();
		System.out.println("[" + s + "]");
		
		System.out.print("A word? ");
		s = in.next();	// Enter "This is a test."
		System.out.println(s);
		in.nextLine();
		System.out.print("Another string? ");
		s = in.nextLine();
		System.out.println(s);
		
		
		
		in.close();
	}

}
