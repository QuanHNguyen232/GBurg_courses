import java.io.File;
import java.util.Scanner;

public class FileSize {

	public static long fileSize(File file){
		long result = 0;
		// base case: this is a file
		if (file.isFile()) {
			System.out.printf("%s: %d\n", file.getPath(), file.length());
			return file.length();
		}
		else if (file.isDirectory()) {
			File[] files = file.listFiles();
			for (File f : files) {
				result += fileSize(f);
			}
			System.out.printf("%s: %d\n", file.getPath(), result);
		}
		
		return result;
	}

	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		
		System.out.print("Enter file/dir name: ");
		String name = in.nextLine();
		
		File file = new File(name);
		
		fileSize(file);
		
	}
	
}
