import java.util.Scanner;

public class CounterLoop {

	public static void main(String[] args) {
		 Scanner in =  new Scanner(System.in); // Ctr + Shift + O to import package
		 
		 int n = in.nextInt();
		 double sum = 0;
		 for (int i = 0; i < n; i++){
			 sum += in.nextDouble();
		 }
		 System.out.println(sum);
		 
		 
		 in.close();
	}

}
