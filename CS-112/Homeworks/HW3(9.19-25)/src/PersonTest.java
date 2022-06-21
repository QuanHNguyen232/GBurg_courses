import java.util.ArrayList;

public class PersonTest {

	public static void main(String[] args) {
		
		ArrayList<Person> peopleList = new ArrayList<Person>();
		
		peopleList.add(new Person("Q", "Gettys", "123456***", "abc@gmail.com"));
		peopleList.add(new Student("Quan", "Gburg", "717420***", "nguyqu03@gmail.com", Student.SOPH));
		peopleList.add(new Employee("U", "Penn", "987321***", "def@gmail.com", "Glat207", "9/31/2021", 1234.5));
		peopleList.add(new Faculty("A", "US", "2468", "ghij@gmail.com", "Glat001", "29/2/2020", 1.2, "T/Th 2-9pm", "Lecturer"));
		peopleList.add(new Staff("N", "Earth", "13579", "klmn@gmail.com", "Glat400", "12/24/2020", 55.9, "chef"));
		
		
		
		
		System.out.println(peopleList);
		for (int i=0; i < peopleList.size(); i++) {
			System.out.println(peopleList.get(i));
			System.out.println("\t Addr: " + peopleList.get(i).getAddress() + ";\n\t phone: " + peopleList.get(i).getPhone()
								+ ";\n\t mail: " + peopleList.get(i).getEmail());
			if (peopleList.get(i) instanceof Student) {
				Student stud = (Student) peopleList.get(i);
				System.out.println("\t Status: " + stud.getStatus());
			}
			else if (peopleList.get(i) instanceof Employee) {
				Employee em = (Employee) peopleList.get(i);
				System.out.println("\t Datehired: " + em.getDateHired() + ";\n\t office: " + em.getOffice() + ";\n\t salary: " + em.getSalary());
				if (peopleList.get(i) instanceof Faculty) {
					Faculty fa = (Faculty) peopleList.get(i);
					System.out.println("\t OffHour: " + fa.getOfficeHour() + ";\n\t rank: " + fa.getRank());
				}
				else if (peopleList.get(i) instanceof Staff) {
					Staff st = (Staff) peopleList.get(i);
					System.out.println("\t title: " + st.getTitle());
				}
			}
		}
	}

}
