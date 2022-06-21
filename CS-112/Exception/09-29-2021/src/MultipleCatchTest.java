import java.io.IOException;

public class MultipleCatchTest {
	
	public static void example(int value) throws IOException {
		System.out.println("Example: " + value);
		
		int[] data = new int[1];
		Object obj = null;
		
		try {
			switch(value) {
			case 0:
				int x = 10/0;  //ArithmeticException
				break;
			case 1:
				obj.toString(); //NullPointerException
				break;
			case 2:
				data[2] = 5;  //ArrayIndexOutOfBoundsException
				break;
			case 3:
				// gets caught in RuntimeException catch block
				throw new IllegalArgumentException("3 is a magic number");	// exception is like return, so codes after it is unreachable
//				break;	// there must be no code after RETURN or EXCEPTION
			case 4:
				// checked exception (not Runtime)
				// gets caught in main's Exception
				throw new IOException("Input/Output problem");
			default:
				System.out.println("This works");
			}
		}
		catch (NullPointerException npe) {
			System.out.println("Example: " + npe);
		}
		catch (ArrayIndexOutOfBoundsException aioobe) {
			System.out.println("example = " + aioobe);
		}
		catch (RuntimeException rte) {
			System.out.println("examPLE: " + rte);
		}
		finally {
			// runs regardless of exception or not
			System.out.println("Finally");
		}

		System.out.printf("Done: %s\n", value);
	}
	
	public static void main(String[] args) {	// main throws IOException

		for(int i = 0; i < 5; i++) {
			try {
				example(i);
			}
			catch(Exception e) {	// catch all exceptions that are subclass of "Exception" (see lecture 9/27)
				System.out.println(e);
			}
			System.out.println();
		}
	}
	
//	public static void main(String[] args) throws IOException {
//
//		for(int i = 0; i < 5; i++) {
//			
//			example(i);
//			
//			System.out.println();
//		}
//	}
}
