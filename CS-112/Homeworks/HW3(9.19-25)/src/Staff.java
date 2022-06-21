
public class Staff extends Employee {
	
	// field
	private String title;
	
	
	
	// constructor
	public Staff () {}
	public Staff (String name, String address, String phone, String e_mail, String office, String dateHired, double salary, String title) {
		super(name, address, phone, e_mail, office, dateHired, salary);
		this.title = title;
	}
	
	
	
	
	
	
	// method
	public String getTitle() {
		return this.title;
	}
	@Override
	public String toString() {
		return String.format("Class name: [%s], the staff's name: [%s]", "Staff", this.getName());
	}
	
	
	
	
	
	
	

//	public static void main(String[] args) {
//	}

}
