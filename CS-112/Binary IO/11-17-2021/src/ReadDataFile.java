import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class ReadDataFile {

	public static void main(String[] args) {
		
		String filename = "test.dat";
		
		try {
			DataInputStream dataIn = new DataInputStream(new FileInputStream(filename));
			
			int n = dataIn.readInt();
			double d = dataIn.readDouble();
			String word = dataIn.readUTF();
			
			System.out.printf("%d, %f, %s\n", n, d, word);
			
			dataIn.close();
		}
		catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}

}
