import java.util.Scanner;

public class StringRepeater {
	
	public static String s;
	public static int repetitions;
	
	public static String repString(String s, int repetitions) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < repetitions; i++) {
			sb.append(s);
		}
		return sb.toString();
	}

	
	
	
	
//	public static void main(String[] args) {
//		Scanner in = new Scanner(System.in);
//		System.out.print("String? ");
//		s = in.next();
//		System.out.print("repetitions: ");
//		repetitions = in.nextInt();
//		System.out.println(repString(s, repetitions ));
//		in.close();
//	}

}
