import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class WriteDataFile {

	public static void main(String[] args) {
		
		String filename = "test.dat"; 
		
		try {
			// write to a file
			FileOutputStream fileOut = new FileOutputStream(filename);
			DataOutputStream dataOut = new DataOutputStream(fileOut);
			
			dataOut.writeInt(14);	// can cause ioe
			dataOut.writeDouble(3.14159);	// can cause ioe
			dataOut.writeUTF("Hello");	// can cause ioe
			
			dataOut.close();	// can also cause ioe
			fileOut.close();
		}
		catch (FileNotFoundException fnfe) {
			System.err.println("Unable to open: " + filename);
		}
		catch (IOException ioe) {
			System.err.println("Problem writing to fle");
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
