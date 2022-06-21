import java.util.Scanner;

public class ScannerReplaceChar {

	public ScannerReplaceChar() {}
	
	public static Scanner replaceChar(Scanner in, char oldChar, char newChar) {
		StringBuilder sb = new StringBuilder();
		while (in.hasNextLine()) {
			String s = in.nextLine();
			s = s.replace(oldChar, newChar);
			sb.append(s);
			sb.append("\n");
		}
		
		return new Scanner(sb.toString());
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		in = replaceChar(new Scanner("a b c"), 'c', 'a');
		while (in.hasNextLine()) {
			System.out.println(in.nextLine());
		}
		

		in.close();
	}

}
