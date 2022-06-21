
public class Person {
	
	// field
	private String name, address, phone, e_mail;	
	
	
	
	
	// constructor
	public Person () {}
	public Person (String name, String address, String phone, String e_mail) {
		this.name = name;
		this.address = address;
		this.phone = phone;
		this.e_mail = e_mail;
	}
	
	
	
	
	
	// method
	public String getName() {
		return this.name;
	}
	public String getAddress() {
		return this.address;
	}
	public String getPhone() {
		return this.phone;
	}
	public String getEmail() {
		return this.e_mail;
	}
	
	@Override
	public String toString() {
		return String.format("Class name: [%s], the person's name: [%s]", "Person", this.name);
	}
	
	
//	public static void main(String[] args) {
//	}

}
