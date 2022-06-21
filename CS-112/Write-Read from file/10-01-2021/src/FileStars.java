import java.io.*;
import java.util.Scanner;

public class FileStars {

	public static void main(String[] args) {
		
		System.out.print("Enter a file name: ");
		
		Scanner keyboard = new Scanner(System.in);
		String filename = keyboard.nextLine();
//		String filename = "myFile";
		
		try {
			PrintWriter outToFile = new PrintWriter(filename);
//			PrintWriter outToFile = new PrintWriter(new File(filename));
			
//			outToFile.print("Hello");
			for (int i = 1; i <= 10; i++) {
				for (int j = 1; j<= i; j++) {
					outToFile.print("*");
				}
				outToFile.println();
			}
			
			// close the file when done
			// if there are so much letters, the system will write it in the file w/o close()
			outToFile.close();
			 
			
		} catch (FileNotFoundException fnfe) {
			System.out.println("Could not open file: " + filename);
			
		}

	}

}
