
import java.util.Scanner;

public class FutureValue {

	public static void main(String[] args) {
		
		// Enter data
		Scanner in = new Scanner(System.in);
		System.out.print("Enter investment amount: ");
		double investmentAmount = in.nextDouble();
		System.out.print("Enter annual interest rate in percentage: ");
		double annualInterestRate = in.nextDouble();
		System.out.print("Enter number of years: ");
		int numOfYear = in.nextInt();
		
		// Calculation
		double monthlyInterestRate = (annualInterestRate/100) / 12;		
		double futureInvestmentValue = investmentAmount * (Math.pow(1 + monthlyInterestRate, numOfYear * 12));
		
		// Only use 2 decimals
		futureInvestmentValue = (int) (futureInvestmentValue * 100);
		futureInvestmentValue /= 100;
		
		// Result
		System.out.println("Future value is $" + futureInvestmentValue);
		
		
		in.close();
	}

}
