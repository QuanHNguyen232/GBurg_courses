
import java.util.Scanner;

public class WindChill {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		System.out.print("Degrees Fahrenheit? ");
		double t = in.nextDouble();
		System.out.print("Wind miles per hour? ");
		double v = in.nextDouble();
		
		double tWC = 35.74 + (0.6215 * t) - (35.75 * Math.pow(v, 0.16)) + (0.4275 * t * Math.pow(v, 0.16));
		
		System.out.printf("The wind chill temperature is %.2f degrees Fahrenheit.", tWC);
		
		in.close();
	}

}
