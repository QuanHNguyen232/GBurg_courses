
public class MyAction implements MyActionable {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("my action");
	}

	@Override
	public void doAction() {
		MyActionable.printMessage();
	}

}
