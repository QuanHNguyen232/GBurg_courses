
public class Student extends Person {
	
	// field
	
//	private String classStatus;	// Must be a constant? how can I pass from constructor and assign it as a constant using final
	public static final String FRES = "freshman", SOPH = "sophomore", JUNI = "junior", SENI = "senior"; 
	private final String status;
	
	
	
	// constructor
	public Student (String status) {
		this.status = status;
	}
	public Student (String name, String address, String phone, String e_mail, String status) {
		super(name, address, phone, e_mail);
		this.status = status;
	}
	
	
	
	
	// method
	public String getStatus() {
		return this.status;
	}	
	@Override
	public String toString() {
		return String.format("Class name: [%s], the student's name: [%s]", "Student", this.getName());
	}
	
	
	
	
	
	
	
//	public static void main(String[] args) {
//	}

}
