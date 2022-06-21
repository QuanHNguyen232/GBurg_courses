import java.util.Scanner;

public class ThreePileNim {
	
	public static Scanner in = new Scanner(System.in);
	public static int num0 = in.nextInt(), num1 = in.nextInt(), num2 = in.nextInt();
	public static int[] game = {num0, num1, num2};
	
	public static void main(String[] args) {
		
		while (!isGameOver()) {
			printGame();
			int numPile = in.nextInt(), numDraw = in.nextInt();
			game[numPile] -= numDraw;	
		}
		in.close();
	}
	
	public static boolean isGameOver() {
		return game[0] == 0 && game[1] == 0 && game[2] == 0;
	}
	
	public static void printGame() {
		for (int i = 0; i < 3; i++) {
			System.out.print(i + ":");
			for (int j = 0; j < game[i]; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		
	}
	
}
