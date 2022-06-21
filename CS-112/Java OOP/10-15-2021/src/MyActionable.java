
public interface MyActionable {
	
	static final int N = 1;
	
	public static void printMessage() {
		System.out.println("printMessage Hi");
	}
	
//	public abstract void doAction() {}	// why this has error but below not
	public abstract void doAction();
	
	public default void printToTheMessage() {
		printMessage();
		System.out.println("printToTheMessage hi");
	}
	
	
	
	
}
