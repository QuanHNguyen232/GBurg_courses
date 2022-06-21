import java.util.Scanner;

public class CircleMath {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.print("Radius? ");
		int radius = in.nextInt();
		
		double diameter = radius * 2;
		double circumference = diameter * Math.PI;;
		double area = Math.pow(radius, 2) * Math.PI;
		
		System.out.printf("     diameter = %.6f\n",diameter);
		System.out.printf("circumference = %.6f\n", circumference);
		System.out.printf("         area = %.6f\n", area);
		
		in.close();
	}

}
