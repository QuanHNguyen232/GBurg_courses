import java.util.Random;
import java.util.Scanner;

public class ChuckALuck {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		Random rand = new Random();
		
		System.out.print("Place your bet on a number 1-6: ");
		int betValue = in.nextInt();
		
		int numOfBetRolled = 0;
		
		
		if (betValue <1 || betValue >6) {
			System.out.println("Invalid bet.");
		}
		else {
			System.out.print("Roll: ");
			
			// Roll
			int num1 = rand.nextInt(6) +1;
			System.out.print(num1 + ",");
			numOfBetRolled = betValue == num1 ? numOfBetRolled+=1 : numOfBetRolled;
			int num2 = rand.nextInt(6) +1;
			System.out.print(num2 + ",");
			numOfBetRolled = betValue == num2 ? numOfBetRolled+=1 : numOfBetRolled;
			int num3 = rand.nextInt(6) +1;
			System.out.print(num3);
			numOfBetRolled = betValue == num3 ? numOfBetRolled+=1 : numOfBetRolled;
			
			System.out.print(" --> ");
			
			System.out.println(numOfBetRolled==0 ? "You lose your stake." : "The banker pays you "+ numOfBetRolled + " to 1!");
			
		}
		
		
		
		
		in.close();
	}

}
