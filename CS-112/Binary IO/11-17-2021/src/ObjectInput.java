import java.io.*;
import java.util.ArrayList;

public class ObjectInput {

	public static void main(String[] args) {
		String filename = "objects.dat";
		ArrayList<Student> students = null;
		
		try {
			ObjectInputStream objIn = new ObjectInputStream(
					new FileInputStream(filename));
			
			students = (ArrayList<Student>)objIn.readObject();
			
			objIn.close();
		}
		catch(Exception ioe){
			ioe.printStackTrace();
		}
		
		for(Student s: students){
			System.out.println(s);
		}
	}

}