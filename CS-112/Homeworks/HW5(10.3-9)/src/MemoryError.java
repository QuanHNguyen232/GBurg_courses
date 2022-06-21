import java.util.*;

public class MemoryError {

	public static void main(String[] args) {
	      try {
	  		Integer[] array = new Integer[100000 * 1000000];
	      }
	      catch (OutOfMemoryError oome) {
	         System.out.println(oome.toString());
	         System.out.println("print printStackTrace");
	         oome.printStackTrace();
	      }
	}

	
//	Source: https://www.geeksforgeeks.org/understanding-outofmemoryerror-exception-java/

}
