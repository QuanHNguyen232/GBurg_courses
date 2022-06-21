import java.io.*;
import java.util.*;

public class ObjectIO {

	public static void main(String[] args) {
		String filename = "objects.dat";

		ArrayList<Student> students = new ArrayList<Student>();

		students.add(new Student("One", 3.4, 1975));
		students.add(new Student("Two", 2.4, 2013));
		students.add(new Student("Three", 4.0, 2015));
		students.add(new Student("Four", 3.0, 2001));

		for(Student s: students){
			System.out.println(s);
		}

		try{
			ObjectOutputStream objOut = new ObjectOutputStream(
					new FileOutputStream(filename));

			//array list is serializable
			objOut.writeObject(students);

			objOut.close();
		}
		catch(IOException ioe){
			ioe.printStackTrace();
		}

	}

}