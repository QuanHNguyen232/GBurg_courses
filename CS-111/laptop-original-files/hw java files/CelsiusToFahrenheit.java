
import java.util.Scanner;

public class CelsiusToFahrenheit {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		System.out.print("Enter a degree in Celsius: ");
		double degreeC = in.nextDouble();
		double degreeF = (9.0/5) * degreeC + 32;
		System.out.println(degreeC + " Celsius is " + degreeF + " Fahrenheit");
		
		in.close();
	}

}
