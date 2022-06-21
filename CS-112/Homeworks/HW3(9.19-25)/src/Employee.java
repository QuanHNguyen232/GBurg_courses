
public class Employee extends Person {
	
	// field
	private String office, dateHired;
	private double salary;
		
	
	
	
		
	// constructor
	public Employee () {}
	public Employee	(String name, String address, String phone, String e_mail, String office, String dateHired, double salary) {
		super(name, address, phone, e_mail);
		this.office = office;
		this.dateHired = dateHired;
		this.salary = salary;
	}
	
		
	
	
	// method
	public String getOffice() {
		return this.office;
	}
	public String getDateHired() {
		return this.dateHired;
	}
	public double getSalary() {
		return this.salary;
	}
	@Override
	public String toString() {
		return String.format("Class name: [%s], the employee's name: [%s]", "Employee", this.getName());
	}
	
//	public static void main(String[] args) {
//	}

}
