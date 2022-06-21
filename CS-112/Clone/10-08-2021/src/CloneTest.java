
public class CloneTest {

	public static void main(String[] args) {
		MyData data1 = new MyData("First", 10);
		data1.setDataAt(0, -1);
		
		MyData data2 = (MyData)data1.clone();	// clone() from MyData returns an Object type -> so must cast into MyData

		data1.setDataAt(1, 3);
		
		System.out.println(data1);
		System.out.println(data2);
	}

}
