import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class PGMImage {
	
	// field
	private final int MAX = 225;
	private int height, width;
	private int[][] data;
	
	
	// constructor
	public PGMImage (int height, int width) {
		this.height = height;
		this.width = width;
		data = new int[this.height][this.width];
		initImage();
	}
	public PGMImage () {
		this.height = 1000;
		this.width = 1000;
		data = new int[this.height][this.width];
		initImage2();
	}
	public PGMImage (int x) {
		this.height = 1000;
		this.width = 1000;
		data = new int[this.height][this.width];
		initImage3();
	}
	
	// method
	protected void initImage() {
		for (int i=0; i< this.height; i++) {
			for (int j=0; j < this.width; j++) {
				data[i][j] = (int)((Math.pow(i, 2) + Math.pow(j, 2)) % (MAX+1));
			}
		}
	}
	protected void initImage2() {
		for (int i=0; i< this.height; i++) {
			for (int j=0; j < this.width; j++) {
				data[i][j] = (int)((Math.pow(i, 2) + Math.pow(j, 3)) % (MAX * 2));
			}
		}
	}
	protected void initImage3() {
		for (int i=0; i< this.height; i++) {
			for (int j=0; j < this.width; j++) {
				data[i][j] = (int)((Math.pow(i, 2) + Math.pow(j, 2)) % (MAX/2));
			}
		}
	}
	public int getValue(int x, int y) {
		try {
			return data[x][y];
		}
		catch (ArrayIndexOutOfBoundsException aioobe) {
			throw new ArrayIndexOutOfBoundsException("Out of bound");
		}
	}
	public void setValue(int x, int y, int p) {
		try {
			this.data[x][y] = p < 0 ? 0 : p > this.MAX ? this.MAX : p;
		}
		catch (ArrayIndexOutOfBoundsException aioobe) {
			throw new ArrayIndexOutOfBoundsException("Out of bound");
		}

	}
	public void writeToFile(String fileName) throws FileNotFoundException {
		try {
			PrintWriter file = new PrintWriter(fileName);
			file.println("P2");
			file.printf("%d %d\n", this.height, this.width);
			file.println(this.MAX);
			for (int i=0; i <this.height; i++) {
				for (int j =0; j <this.width; j++) {
					file.printf("%4d ", getValue(i, j));
				}
				file.println();
			}
			file.close();
		}
		catch (FileNotFoundException fnfe) {
			System.out.println(fnfe + "cannot find: " + fileName);
			throw new FileNotFoundException("cannot find: " + fileName);
		}
	}
	public int getHeight() {
		return this.height;
	}
	public int getWidth() {
		return this.width;
	}

	


}
