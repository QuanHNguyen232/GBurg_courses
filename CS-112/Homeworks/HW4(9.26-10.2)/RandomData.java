import java.util.Random;
import java.util.Scanner;

public class RandomData {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		Random rand = new Random();

		int[] intArr = new int[100];
		for (int i = 0; i < intArr.length; i++) {
			intArr[i] = rand.nextInt();
		}

		System.out.print("Index? ");
		try {
			System.out.println(intArr[in.nextInt()]);
		}
		catch (ArrayIndexOutOfBoundsException aioobe) {
			System.out.println("Out of Bounds");
		}
	}

}
