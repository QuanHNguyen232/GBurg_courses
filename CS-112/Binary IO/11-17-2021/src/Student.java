import java.io.Serializable;

import javafx.scene.shape.Circle;

public class Student implements Serializable{	// appear error if Student is not serializable
	
	protected String name;
	protected double gpa;
	protected int year;
	
	// Circle is not Serializable -> exception when writing
	// transient: do not serialize it
	transient protected Circle c;
	
	public Student(String n, double avg, int yr){
		name = n;
		gpa = avg;
		year = yr;
		
		c = new Circle(0, 0, 10);
	}
	
	public String toString(){
		return String.format("%s: gpa=%.2f class of %d\n",
				name, gpa, year);
	}
}

// How can we recognize which Object is Serializable ???