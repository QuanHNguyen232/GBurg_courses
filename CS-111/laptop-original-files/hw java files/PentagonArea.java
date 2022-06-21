
import java.util.Scanner;

public class PentagonArea {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.print("Enter the length from the center to a vertex: ");
		double r = in.nextDouble();
		double s = 2 * r * Math.sin(Math.PI / 5.0);
		
		double area = (5 * Math.pow(s, 2)) / (4 * Math.tan(Math.PI / 5.0));
		
		System.out.printf("The area of the pentagon is %.2f\n", area);
		
		
		
		
		
		
		in.close();
	}

}
