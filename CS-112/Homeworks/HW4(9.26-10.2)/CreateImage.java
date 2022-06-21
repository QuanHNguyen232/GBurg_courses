import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class CreateImage {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		System.out.print("File name? ");
		String fileName = in.next();
		System.out.print("Height & width? ");
		int height = in.nextInt();
		int width = in.nextInt();

		PGMImage img1 = new PGMImage(height, width);
		PGMImage img2 = new PGMImage();
		PGMImage img3 = new PGMImage(0);
		
		// check data
		System.out.println(img1.getHeight() + "; " + img1.getWidth());
		for (int i=0; i<img1.getHeight(); i++) {
			for (int j = 0; j < img1.getWidth(); j++) {
				System.out.printf("%4d", img1.getValue(i, j));
			}
			System.out.println();
		}
		System.out.println();

		// set data
		System.out.print("(Set) Height, width, value? ");
		while (true) {
			try {
				img1.setValue(in.nextInt(), in.nextInt(), in.nextInt());
				break;
			}
			catch (ArrayIndexOutOfBoundsException aioobe) {
				System.out.println(aioobe);
			}
			catch (InputMismatchException ime) {
				System.out.println(ime);
				in.nextLine();
			}
			catch (Exception e) {
				System.out.println(e);
				in.nextLine();
			}
		}

		// get data
		System.out.print("(Get) Height & width? ");
		while (true) {
			try {
				System.out.println(img1.getValue(in.nextInt(), in.nextInt()));
				break;
			}
			catch (ArrayIndexOutOfBoundsException aioobe) {
				System.out.println(aioobe);
			}
			catch (InputMismatchException ime) {
				System.out.println(ime);
				in.nextLine();
			}
			catch (Exception e) {
				System.out.println(e);
				in.nextLine();
			}
		}



		try {
			img1.writeToFile(fileName);
		} catch (FileNotFoundException fnfe) {
			System.out.println(fnfe + "cannot find file: " + fileName);
		}
		
		// Additional feature
		try {
			img2.writeToFile("img2Test.pgm");
		} catch (FileNotFoundException fnfe) {
			System.out.println(fnfe + "cannot find file: " + fileName);
		}
		
//		try {
//			img3.writeToFile("img3Test.pgm");
//		} catch (FileNotFoundException fnfe) {
//			System.out.println(fnfe + "cannot find file: " + fileName);
//		}
		System.out.println("done");
	}

}
