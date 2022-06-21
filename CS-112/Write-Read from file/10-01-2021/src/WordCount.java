import java.util.Scanner;
import java.io.*;

public class WordCount {

	public static void main(String[] args) {
		System.out.print("Enter a file name: ");

		Scanner keyboard = new Scanner(System.in);
		String filename = keyboard.nextLine();
		
		// read a file
		File inFile =  new File(filename);
		try {
			Scanner inFromFile = new Scanner(inFile);
			
			int count = 0;
			while (inFromFile.hasNext()) {
				System.out.printf("%d: %s.\n", count, inFromFile.next());
				count++;
			}
			// close the file when done
			inFromFile.close();
			System.out.printf("File %s has %d words.\n", filename, count);
		} catch (FileNotFoundException fnfe) {
			System.out.println("Could not open file: " + filename);
		}
		
	}

}
