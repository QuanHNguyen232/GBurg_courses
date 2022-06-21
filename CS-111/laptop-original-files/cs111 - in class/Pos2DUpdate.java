
import java.util.Scanner;

public class Pos2DUpdate {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		System.out.print("x: ");
		double x = in.nextDouble();
		System.out.print("y: ");
		double y = in.nextDouble();
		System.out.print("speed (1/seconds): ");
		double speed = in.nextDouble();
		System.out.print("direction (radians): ");
		double direction = in.nextDouble();
		System.out.print("time step (seconds): ");
		double timeStep = in.nextDouble();
		
		double x2 = x + speed * timeStep * Math.cos(direction);
		double y2 = y + speed * timeStep * Math.sin(direction);
		System.out.println("New position: ("+ x2 + ", " + y2 + ")");

//	This way causes deviation
//		x += speed * timeStep * Math.cos(Math.toDegrees(direction));
//		y += speed * timeStep * Math.sin(Math.toDegrees(direction));
//		
//		System.out.println("New position: ("+ x + ", " + y + ")");
		
		
		
		
		
		in.close();
	}

}
