import java.util.Scanner;

public class Midterm {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);






		System.out.println(getPigTurnScore(new Scanner("4 5 6 3 3"))); // 21
		System.out.println(getPigTurnScore(new Scanner("4 5 6 3 1"))); // 0
		System.out.println(getPigTurnScore(new Scanner("4 5 6 3 3 6"))); // 27
		System.out.println(getPigTurnScore(new Scanner("6 1"))); // 0
		System.out.println(getPigTurnScore(new Scanner("2 3 4"))); // 9

		


		in.close();
	}


	public static int getPigTurnScore(Scanner in) {
		int roll = in.nextInt();
		int sum=0;
		while (roll >= 1 && roll <= 6) {
			if (roll == 1) {
				sum =0;
				break;
			}
			else {
				sum += roll;
			}
		}
		
		return sum;
		
	}
}
