
import java.util.Scanner;

public class ChineseZodiac {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		System.out.print("Enter a year: ");
		int year = in.nextInt();
		
		System.out.println("case 0");
		switch (year % 12) {
		case 0: System.out.println("monkey"); break;
		case 1: System.out.println("rooster"); break;
		case 2: System.out.println("dog"); break;
		case 3: System.out.println("pig"); break;
		case 4: System.out.println("rat"); break;
		case 5: System.out.println("ox"); break;
		case 6: System.out.println("tiger"); break;
		case 7: System.out.println("rabbit"); break;
		case 8: System.out.println("dragon"); break;
		case 9: System.out.println("snake"); break;
		case 10: System.out.println("horse"); break;
		case 11: System.out.println("sheep"); break;
		}
		
		System.out.println("case 1");
		switch (year % 12) {
		case 0:
		case 1: System.out.println("rooster"); break;
		case 2: System.out.println("dog"); break;
		case 3: System.out.println("pig"); break;
		case 4: System.out.println("rat"); break;
		case 5: System.out.println("ox"); break;
		case 6: System.out.println("tiger"); break;
		case 7: System.out.println("rabbit"); break;
		case 8: System.out.println("dragon"); break;
		case 9: System.out.println("snake"); break;
		case 10: System.out.println("horse"); break;
		case 11: System.out.println("sheep"); break;
		}
		
		
		System.out.println("case 2");
		switch (year % 12) {
		case 0: 
			System.out.println("monkey");
			System.out.println("Really, it's monkey!");
			break;
		case 1: System.out.println("rooster"); break;
		case 2: System.out.println("dog"); break;
		case 3: System.out.println("pig"); break;
		case 4: System.out.println("rat"); break;
		case 5: System.out.println("ox"); break;
		case 6: System.out.println("tiger"); break;
		case 7: System.out.println("rabbit"); break;
		case 8: System.out.println("dragon"); break;
		case 9: System.out.println("snake"); break;
		case 10: System.out.println("horse"); break;
		case 11: System.out.println("sheep"); break;
		}
		
		System.out.println("case 3");
		switch (year % 12) {
		case 0: 
			System.out.println("monkey");
			System.out.println("Really, it's monkey!");
		case 1: System.out.println("rooster"); break;
		case 2: System.out.println("dog"); break;
		case 3: System.out.println("pig"); break;
		case 4: System.out.println("rat"); break;
		case 5: System.out.println("ox"); break;
		case 6: System.out.println("tiger"); break;
		case 7: System.out.println("rabbit"); break;
		case 8: System.out.println("dragon"); break;
		case 9: System.out.println("snake"); break;
		case 10: System.out.println("horse"); break;
		case 11: System.out.println("sheep"); break;
		}
		
		System.out.println("case 4");
		switch (42) {
		case 0: System.out.println("monkey"); break;
		case 1: System.out.println("rooster"); break;
		case 2: System.out.println("dog"); break;
		case 3: System.out.println("pig"); break;
		case 4: System.out.println("rat"); break;
		case 5: System.out.println("ox"); break;
		case 6: System.out.println("tiger"); break;
		case 7: System.out.println("rabbit"); break;
		case 8: System.out.println("dragon"); break;
		case 9: System.out.println("snake"); break;
		case 10: System.out.println("horse"); break;
		case 11: System.out.println("sheep"); break;
		default: System.out.println("Oops!");
		}

		
		
		
		
		in.close();
	}

}
