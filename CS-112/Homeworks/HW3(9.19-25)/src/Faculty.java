
public class Faculty extends Employee{
	
	// field
	private String officeHour, rank;
	
	
	
	// constructor
	public Faculty () {}
	public Faculty (String name, String address, String phone, String e_mail, String office, String dateHired, double salary, String officeHour, String rank) {
		super(name, address, phone, e_mail, office, dateHired, salary);
		this.officeHour = officeHour;
		this.rank = rank;
	}
	
	
	
	
	
	
	// method
	public String getOfficeHour() {
		return this.officeHour;
	}
	public String getRank() {
		return this.rank;
	}
	@Override
	public String toString() {
		return String.format("Class name: [%s], the faculty's name: [%s]", "Faculty", this.getName());
	}
	
	
	
	
	
	
	
//	public static void main(String[] args) {
//	}

}
