import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

/*
 * P.S. For those who are rocking the Live Assignments and are looking for more challenges and growth,
 *  I recommend diving deeper into Java regular expressions introduced in Ch. 10. 
 *  I provide a link to a good tutorial in the comments of the attached file.
 */

public class SummaryFun {

	public static void main(String[] args) {
		ch2Summary();
		ch3Summary();
		ch4Summary();
		ch5Summary();
		ch6Summary();
		ch7Summary(args);
		ch8Summary();
		ch9Summary();
		ch10Summary();
	}

	private static void ch2Summary() {
		// TODO Auto-generated method stub
		
	}

	private static void ch3Summary() {
		// TODO Auto-generated method stub
		
	}

	private static void ch4Summary() {
		// TODO Auto-generated method stub
		
	}

	private static void ch5Summary() {
		// TODO Auto-generated method stub
		
	}

	private static void ch6Summary() {
		// TODO Auto-generated method stub
		
	}

	private static void ch7Summary(String[] args) {
		// Single-Dimensional Arrays
		System.out.println("Ch. 7: Single-Dimensional Arrays");
		
		// Declaration and initialization
		int[] arr1 = new int[3]; // array of given length 3 initialized to 0/0.0/false/null/etc. depending on type  
		String[] arr2 = {"This", "is", "a", "test."}; // array with given initial values
		double[] arr3; // Uninitialized array == null; remember: arrays are objects
		arr3 = new double[] {Math.E, Math.PI, 42.0}; //later initialization of arr3 with given values
		
		// Array length
		System.out.println("arr1 has length " + arr1.length);
		
		// Array getting
		System.out.printf("arr2[1] == \"%s\"\n", arr2[1]);
		
		// Array setting
		arr2[1] = "was";
		System.out.println(String.join(" ", arr2));
		
		// Array String representation
		System.out.println(Arrays.toString(arr3));
		
		// Processing arrays (see text for additional examples)

		// Summing values
		double total = 0;	
		for (int i = 0; i < arr3.length; i++) {
			total += arr3[i];
		}
		System.out.println("arr3 total: " + total);
		
		// Maximum value and index of maximum value
		double max = arr3[0];
		int maxIndex = 0;
		for (int i = 1; i < arr3.length; i++) {
			if (arr3[i] > max) {
				max = arr3[i];
				maxIndex = i;
			}
		}
		System.out.printf("Maximum value arr3[%d] == %f\n", maxIndex, max);
		
		// Fisher–Yates/Knuth shuffle
		for (int i = arr2.length - 1; i > 0; i--) {
			// Generate an index j randomly with 0 <= j <= i
			int j = (int)(Math.random() * (i + 1));
			// Swap arr2[i] with arr2[j]
			String temp = arr2[i];
			arr2[i] = arr2[j];
			arr2[j] = temp;
		}
		System.out.println(Arrays.toString(arr2));
		
		// Left-rotate array elements
		String temp = arr2[0];
		System.arraycopy(arr2, 1, arr2, 0, arr2.length - 1); // System.arraycopy; can do with loop too
		arr2[arr2.length - 1] = temp;
		System.out.println(Arrays.toString(arr2));

		// For-each loop: When you need the elements of an "Iterable Collection", but you don't need their indices
		total = 0;
		for (double x : arr3) {
			total += x;
		}
		System.out.println("arr3 total: " + total);
		
		// Arrays are objects, so array variables contain a _reference_ to an array object.
		// Arrays are mutable. An array reference passed to the method allows a side-effect on the array:
		int[] arr4 = {0, 1, 2};
		System.out.println(Arrays.toString(arr4));
		ch7Helper(arr4);
		System.out.println(Arrays.toString(arr4));
		// To prevent changes, pass a copy of the array:
		arr4 = new int[] {0, 1, 2};
		ch7Helper(arr4.clone()); // make a shallow copy of the array
		System.out.println(Arrays.toString(arr4));
		
		// Arrays can be returned from methods
		arr4 = ch7RandomDataArray(10);
		System.out.println(Arrays.toString(arr4));
		
		// Variable arguments "varargs" allow the last arguments of a call to be an array or a variable-length
		// comma-separated list of 0 or more that will be turned into an array:
		System.out.println(Arrays.toString(ch7VarArgArray("Test 1: ", 1))); // String and 1 int
		System.out.println(Arrays.toString(ch7VarArgArray("Test 2: ", new int[] {1, 2}))); // String and an int array
		System.out.println(Arrays.toString(ch7VarArgArray("Test 3: ", 1, 2, 3))); // String and 3 ints
		System.out.println(Arrays.toString(ch7VarArgArray("Test 4: "))); // String and no ints this time
		
		// Finding a value with linear search
		int target = arr4[5];
		for (int i = 0; i < arr4.length; i++)
			if (arr4[i] == target) {
				System.out.printf("Found target value %d at index %d.\n", target, i);
				break;
			}
		
		// One can find a target value more efficiently for large data if the data is sorted and we
		// perform "binary search".  It's like the number-guessing game, where one is trying to guess the index
		// where the target value can be found.
		arr4 = ch7RandomDataArray(1000000);
		Arrays.sort(arr4); // Sort the data - a prerequisite for binary search
		// Read about the Selection sort algorithm in the text.
		for (int i = 0; i < 5; i++) {
			target = (int) (arr4.length * Math.random());
			int index = ch7BinarySearch(arr4, target);
			if (index < 0)
				System.out.println("Target " + target + " not found.");
			else
				System.out.printf("Target %d found at index %d.\n", target, index);
			index = Arrays.binarySearch(arr4, target);
			if (index < 0)
				System.out.println("Target " + target + " not found.");
			else
				System.out.printf("Target %d found at index %d.\n", target, index);
		}

		// Main method parameter "args" (passed here directly as an argument of this call)
		// is an array of String tokens from after "java <classname>" on the command line.
		for (int i = 0; i < args.length; i++)
			System.out.printf("args[%d]: \"%s\"\n", i, args[i]);
		// $ java SummaryFun This is a test.
		// args -> {"This", "is", "a", "test."}
		
	}
	
	private static void ch7Helper(int[] arr) {
		arr[1] = 42;
	}

	private static int[] ch7RandomDataArray(int length) {
		System.out.println("Creating random integer array of length " + length + "...");
		int[] arr = new int[length];
		for (int i = 0; i < arr.length; i++)
			arr[i] = (int) (length * Math.random());
		return arr;
	}
	
	private static int ch7BinarySearch(int[] list, int key) { // assumes that list is sorted
		int low = 0; // minimum possible index for search
		int high = list.length - 1; // maximum possible index for search
		while (high >= low) { // range still permits successful search
			int mid = (low + high) / 2; // guess middle index in range
			if (key < list[mid])
				high = mid - 1; // lower so new maximum search index
			else if (key == list[mid])
				return mid; // search success - return index where found
			else
				low = mid + 1; // higher so new minimum search index
		}
		return -low - 1; // negative value signals search failure, and also carries
						 // information about where the item would have been found
	}
	
	private static int[] ch7VarArgArray(String printMessage, int... arr) {
		System.out.print(printMessage);
		return arr;
	}
	
	private static void ch8Summary() {
		// Multidimensional Arrays
		System.out.println("Ch. 8: Multidimensional Arrays");
		// Note: Most of the examples for working with multidimensional arrays are analogous to 
		// the same for single-dimensional arrays (e.g. finding a maximum in a 2D array),
		// so we won't repeat them here.
		
		// A 2D array is simply an array of arrays.  
		// A 3D array is an array of 2D arrays, i.e. an array of arrays of arrays.
		
		// Declaring and initializing 2D arrays
		int[][] arr1 = new int[2][3]; // array of 2 rows, 3 columns initialized to 0/0.0/false/null/etc. depending on type  
		String[][] arr2 = {{"This", "is"}, {"a", "test."}}; // array with given initial values
		double[][] arr3; // Uninitialized array == null; remember: arrays are objects
		arr3 = new double[][] {{Math.E, Math.PI}, {42.0}}; // later initialization of "ragged" arr3 with given values
		// Ragged arrays have subarrays of different lengths
		
		// Array length
		System.out.printf("arr1 has %d rows and %d columns.\n", arr1.length, arr1[0].length);
		// Note: This pattern assumes a non-ragged, rectangular array.
		
		// Array getting
		System.out.printf("arr2[0][1] == \"%s\"\n", arr2[0][1]);
		
		// Array setting
		arr2[0][1] = "was";
		System.out.println(Arrays.deepToString(arr2));
		
		// Array String representation
		System.out.println(Arrays.deepToString(arr3));
		
		// Study the author's 2D array algorithms, but _don't_ implement shuffling as Liang does through the current edition (12th).
		// It's biased.  See https://medium.com/@oldwestaction/randomness-is-hard-e085decbcbb2 for an explanation.
		// Here's my demonstration with the author's "naive shuffle" code and my Knuth/Fisher-Yates shuffle generalization.
		
		int trials = 1000000; // 10000000;
		
		// Show frequencies of letter orders for the text's naive shuffle algorithm:
		Map<String, Integer> naiveFreq = new TreeMap<>();
		for (int trial = 0; trial < trials; trial++) {
			char[][] matrix = {{'a', 'b'}, {'c', 'd'}};
			
			// "Naive" shuffle
			for (int i = 0; i < matrix.length; i++) {
				for (int j = 0; j < matrix[i].length; j++) {
					int i1 = (int)(Math.random() * matrix.length);
					int j1 = (int)(Math.random() * matrix[i].length);
					// Swap matrix[i][j] with matrix[i1][j1]
					char temp = matrix[i][j];
					matrix[i][j] = matrix[i1][j1];
					matrix[i1][j1] = temp;
				}
			}
			
			StringBuilder sb = new StringBuilder();
			for (char[] row : matrix)
				for (char ch : row)
					sb.append(ch);
			String order = sb.toString();
			naiveFreq.put(order, naiveFreq.containsKey(order) ? naiveFreq.get(order) + 1 : 1);
		}
		System.out.println("Naive shuffle order frequencies are non-uniform with predictable bias:");
		for (String order : naiveFreq.keySet())
			System.out.println(order + " " + naiveFreq.get(order));
		
		// My unbiased Knuth/Fisher-Yates shuffle generalization:
		Map<String, Integer> knuthFreq = new TreeMap<>();
		for (int trial = 0; trial < trials; trial++) {
			char[][] matrix = {{'a', 'b'}, {'c', 'd'}};
			
			// Knuth shuffle
			int rows = matrix.length;
			int cols = matrix[0].length; // assumes rectangular array
			for (int i = rows * cols - 1; i > 0; i--) {
				int j = (int)(Math.random() * (i + 1));
				int iRow = i / cols, iCol = i % cols;
				int jRow = j / cols, jCol = j % cols; 
				char temp = matrix[iRow][iCol];		
				matrix[iRow][iCol] = matrix[jRow][jCol];
				matrix[jRow][jCol] = temp;
			}
			
			StringBuilder sb = new StringBuilder();
			for (char[] row : matrix)
				for (char ch : row)
					sb.append(ch);
			String order = sb.toString();
			knuthFreq.put(order, knuthFreq.containsKey(order) ? knuthFreq.get(order) + 1 : 1);
		}
		System.out.println("Knuth order frequencies are uniform and unbiased:");
		for (String order : knuthFreq.keySet())
			System.out.println(order + " " + knuthFreq.get(order));
		
		// There are many good 2D array algorithm examples in the text.  Study these, and create additional challenges for yourself.
		// Example: Create a 5-by-5 magic square int[][] and computationally verify that all rows, columns, and diagonals sum to the same value.
		// Try recreating this solution on your own in a separate file.
		int[][] magic = {
				{11, 18, 25,  2,  9}, 
				{10, 12, 19, 21,  3}, 
				{ 4,  6, 13, 20, 22}, 
				{23,  5,  7, 14, 16}, 
				{17, 24,  1,  8, 15}
		};
		// Check rows
		for (int r = 0; r < magic.length; r++) {
			int sum = 0;
			for (int c = 0; c < magic[r].length; c++) // Note: This pattern works for ragged arrays (irrelevant here, though).
				sum += magic[r][c];
			System.out.printf("Row %d sum: %d\n", r, sum);
		}
		// Check columns
		for (int c = 0; c < magic[0].length; c++) {
			int sum = 0;
			for (int r = 0; r < magic.length; r++) 
				sum += magic[r][c];
			System.out.printf("Column %d sum: %d\n", c, sum);
		}
		// Check main diagonal
		int sum = 0;
		for (int i = 0; i < magic.length; i++)
			sum += magic[i][i];
		System.out.printf("Main diagonal sum: %d\n", sum);
		// Check antidiagonal
		sum = 0;
		for (int i = 0; i < magic.length; i++)
			sum += magic[i][magic.length - 1 - i];
		System.out.printf("Antidiagonal sum: %d\n", sum);

	}

	private static void ch9Summary() {
		// Objects and Classes
		System.out.println("Ch. 9: Objects and Classes");
		/*
		 * Remember: A class is a set of objects.  An object is a member of a set.  Class is to set as object is to set member.
		 * A class definition defines (1) _static_ fields (data) and methods (code) relevant to the class as a whole, and
		 * (2) _nonstatic_ fields and methods relevant to each object (member) of that class.
		 * 
		 * For example, each BankAccount object might have it's own (nonstatic) balance field, 
		 * but there might be a single ABA routing number for all accounts at that bank as a static field.
		 * 
		 * The question to ask when deciding about whether to declare something static or not is "Will I need different values
		 * for different objects of this class, i.e. members of this set? 
		 */

		// Normally, we define a class definition as a "public class <classname> { ... }" in a file named <classname>.java
		// where convention has <classname> be an CapitalizedCamelcaseStyle name.
		// Here we define a Circle class after this class for easy illustration in this file.
		
		// IMPORTANT: An Object is a "reference type", i.e. the variables hold a reference/pointer to _where_ the Object
		// is stored in memory.  The variable doesn't hold the Object itself.  This has important implications:
		Circle c1 = new Circle(); // The "new" keyword directs Java to allocate space for a new Object, clear the memory (with zeros)
		                          // and run the given constructor to initialize the Object.
		System.out.println(c1); // println automatically calls toString() on Objects to get their String representation
		// Output: "Circle [xCenter=0.0, yCenter=0.0, radius=0.0]"
		Circle c2 = c1; // Only the reference to c1's Circle is copied with this assignment.  
		// Both c1 and c2 refer to the same Circle!  Observe:
		c2.setRadius(1.0);
		System.out.println(c1);
		// Output: "Circle [xCenter=0.0, yCenter=0.0, radius=1.0]"  A change to c2 is a change to c1, the same Circle.
		
		// This can also be observed when passing an Object (or rather a reference to the Object) to a method:
		ch9ObjectPassing(c1, 1.0, 2.0, 3.0);
		System.out.println(c1);
		// Output: "Circle [xCenter=1.0, yCenter=2.0, radius=3.0]"
		
		// Copy constructors (and clone methods (Ch. 13)) create distinct copies of an object to preserve the original.
		Circle c3 = new Circle(c1); // Using a copy constructor to create a distinct copy.
		c3.setxCenter(-1.0);
		System.out.println(c1.getxCenter()); // 1.0
		System.out.println(c3.getxCenter()); // -1.0

		// We can also create methods that generate new Objects and return them:
		Circle c4 = circleFromDiameter(-1.0, -1.0, 2.0, 3.0);
		System.out.println(c4);
		// Output: "Circle [xCenter=0.5, yCenter=1.0, radius=2.5]"
		System.out.println(c4.containsPoint(0, 0)); // true
		System.out.println(c4.containsPoint(10, 10)); // false
		System.out.println(c4.intersectsCircle(c1)); // true
		System.out.println(c4.intersectsCircle(new Circle(100, 100, 1))); // false

		// Regarding access specifiers: It is generally good to declare fields and methods as "private" 
		// unless there's a good reason for it to be "public".  The most common reason to declare
		// a public field/method is that it's part of the intended interface for use from other
		// classes and objects.  Sometimes less (a simpler interface) is more.
	}
	
	private static void ch9ObjectPassing(Circle c, double dx, double dy, double radiusScale) {
		c.translate(dx, dy);
		c.scale(radiusScale);
	}
	
	private static Circle circleFromDiameter(double x1, double y1, double x2, double y2) {
		double dx = x1 - x2;
		double dy = y1 - y2;
		return new Circle((x1 + x2) / 2, (y1 + y2) / 2, Math.sqrt(dx * dx + dy * dy) / 2);
	}
	
	private static void ch10Summary() {
		// Object-Oriented Programming (OOP) is, in a sense, Computer Scientists cleaning their rooms.
		// When problems become complex, it's good to have organizing principles.
		// One important discipline is to gather related code and data into Objects.
		// This allows for abstraction, encapsulation, and knowing where to look to find your stuff.
		
		// In general, a problem description's central organizing nouns are candidate Objects. 
		// Other nouns are often fields of the Objects.
		// Verbs often suggest methods of the Objects they involve.
		
		// A very useful Object that's like an array that grows as needed is Java's ArrayList.
		// Like most Java data structures, ArrayList only holds Object types.
		// However, we can still use it with primitive types (e.g. int, double) because
		// each primitive type has a corresponding "wrapper class" that holds a primitive value.
		// int --> class Integer
		// double --> class Double
		// char --> class Character
		// boolean --> class Boolean
		// etc.
		Integer iWrapper = new Integer(42);
		ArrayList<Integer> iList = new ArrayList<>(); // The "< >" syntax specifies the contained type is Java generics notation (Ch. 19)
		iList.add(iWrapper);
		System.out.println(iList);  // [42]
		System.out.println(iList.get(0)); // 42
		int iPrimitive = iList.get(0).intValue(); // get the only Integer (at index 0) and unwrap the int
		// Now if it seems cumbersome to you to wrap an int up in a wrapper class and call a method to get it back,
		// you're absolutely right.  Java performs "autoboxing" and "auto-unboxing" as would be expected for convenience.
		// That is, it wraps up a given int as an Integer when needed, and unpacks the int from the Integer when needed.
		// Observe:
		iList.add(1000000); // autoboxed and added at the next available index 1
		iPrimitive = iList.get(1); // gotten and unboxed from index 1
		System.out.println(iPrimitive); // 1000000
		
		// We are used to using String as an immutable (unchangeable) type.  Concatenating String, for instance, 
		// creates a new String object and leaves original Strings unchanged.
		String a = "a";
		String b = "b";
		String ab = a + b;
		System.out.println(a); // a
		System.out.println(b); // b
		System.out.println(ab); // ab
		
		// BigInteger is another immutable type that doesn't have numeric limits for magnitude (only memory limits).
		// Without the "syntactic sugar" we're used to with primitive numeric types, working with BigInteger can 
		// take some getting used to:
		// Compute the product of the integers 1 through 1000 (1000!, i.e. 1000 factorial):
		BigInteger product = BigInteger.ONE; // predefined static constant of class BigInteger
		BigInteger maxTerm = new BigInteger("1000"); // String constructor
		for (BigInteger term = BigInteger.ONE; term.compareTo(maxTerm) <= 0; term = term.add(BigInteger.ONE))
			product = product.multiply(term);
		System.out.println(product); // 402387260077093773543702433923003985719374864210714632543799910429938512398629020592044208486969404800479988610197196058631666872994808558901323829669944590997424504087073759918823627727188732519779505950995276120874975462497043601418278094646496291056393887437886487337119181045825783647849977012476632889835955735432513185323958463075557409114262417474349347553428646576611667797396668820291207379143853719588249808126867838374559731746136085379534524221586593201928090878297308431392844403281231558611036976801357304216168747609675871348312025478589320767169132448426236131412508780208000261683151027341827977704784635868170164365024153691398281264810213092761244896359928705114964975419909342221566832572080821333186116811553615836546984046708975602900950537616475847728421889679646244945160765353408198901385442487984959953319101723355556602139450399736280750137837615307127761926849034352625200015888535147331611702103968175921510907788019393178114194545257223865541461062892187960223838971476088506276862967146674697562911234082439208160153780889893964518263243671616762179168909779911903754031274622289988005195444414282012187361745992642956581746628302955570299024324153181617210465832036786906117260158783520751516284225540265170483304226143974286933061690897968482590125458327168226458066526769958652682272807075781391858178889652208164348344825993266043367660176999612831860788386150279465955131156552036093988180612138558600301435694527224206344631797460594682573103790084024432438465657245014402821885252470935190620929023136493273497565513958720559654228749774011413346962715422845862377387538230483865688976461927383814900140767310446640259899490222221765904339901886018566526485061799702356193897017860040811889729918311021171229845901641921068884387121855646124960798722908519296819372388642614839657382291123125024186649353143970137428531926649875337218940694281434118520158014123344828015051399694290153483077644569099073152433278288269864602789864321139083506217095002597389863554277196742822248757586765752344220207573630569498825087968928162753848863396909959826280956121450994871701244516461260379029309120889086942028510640182154399457156805941872748998094254742173582401063677404595741785160829230135358081840096996372524230560855903700624271243416909004153690105933983835777939410970027753472000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000
		System.out.println(product.toString().length() + " digits! That's one BigInteger!");
		
		// BigDecimal is very similar to BigInteger, except that floating point division can lead to 
		// infinite memory needs, e.g. 1/3, so, we need to provide scale limits and rounding guidance in such cases:
		BigDecimal five = new BigDecimal(5.0); // double constructor
		BigDecimal nine = BigDecimal.valueOf(9.0); // static generator that does the same thing
		BigDecimal fiveNinths = five.divide(nine, 10, RoundingMode.HALF_UP); // to 10 digits, rounding as we most commonly do.
		System.out.println(fiveNinths); // 0.5555555556
		
		// The String class has many helpful methods.  See StringFun.java for more examples.
		// Here's we'll cover a few.  First, note that Strings are essentially arrays of chars:
		char[] howdyArr = {'h', 'o', 'w', 'd', 'y'};
		String howdy = new String(howdyArr);
		System.out.println(howdy); // howdy
		// But arrays are immutable, so it copies the characters from my array and I can't modify the String through it.
		howdyArr[0] = 'H';
		System.out.println(howdy); // howdy (not Howdy)
		// A very common, simple format for data are CSV (comma-separated value) files.
		// There's often a header line with column labels (in double-quotes for labels with spaces)
		// followed by rows of comma-separated values for each column label.
		// Imagine we read these first lines from a file, standard input, etc., and note how we process them.
		String line1 = "Item,Price,\"Date of Sale\"";
		String line2 = "42,12.34,4/27/2021";
		// We can split these lines according to the ',' delimiter:
		String[] labels = line1.split(",");
		System.out.println(Arrays.toString(labels)); // [Item, Price, "Date of Sale"]
		// We can strip the double quotes from the labels if we wish:
		for (int i = 0; i < labels.length; i++)
			labels[i] = labels[i].replaceAll("^\"|\"$", ""); // replace starting (^) double quote or (|) ending ($) double quote with nothing.
		System.out.println(Arrays.toString(labels)); // [Item, Price, Date of Sale]
		// Sometimes we need to do special purpose processing for data Strings:
		String[] dataStr = line2.split(",");
		Object[] data = new Object[dataStr.length];
		System.out.println(Arrays.toString(dataStr)); // [42, 12.34, 4/27/2021] (At this point, these are just Strings.)
		data[0] = Integer.parseInt(dataStr[0]);
		data[1] = Double.parseDouble(dataStr[1]);
		DateFormat df = new SimpleDateFormat("MM/dd/yyyy"); 
		try { // try-catch Covered in Ch. 12 Exceptions
			data[2] = df.parse(dataStr[2]);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		System.out.println(Arrays.toString(data)); // [42, 12.34, Tue Apr 27 00:00:00 EDT 2021] (Here, the data are Objects.)
		
		// A full treatment of Java regular expressions (Regex) for pattern matching is beyond the scope of this course.
		// However, it is a strongly recommended, practical topic that takes practice, and many good tutorials are available,
		// e.g. https://docs.oracle.com/javase/tutorial/essential/regex/
		
		// Formatted printing with printf derives from C programming language formatted printing. 
		// Parameters include a format string following by the variable arguments that fill in the % placeholders in the 
		// format string.  Common formatting:
		
		System.out.printf("int %d, double %f, double to 2 decimal places %.2f, String %s\n", 42, 1.2345, 1.2345, "test");
		// Output: int 42, double 1.234500, double to 2 decimal places 1.23, String test
		
		// A printf quick reference is here: http://cs.gettysburg.edu/~tneller/cs111/Java_printf_method_quick_reference.pdf
		
		// StringBuilder is an excellent class for building complex String.
		// All you need to know is how to construct one with a default constructor, 
		// add elements with append(), and toString() to build the String.
		// (This is much more efficient than constantly rebuilding Strings with concatenation.)
		
		// Example: Build a checkerboard pattern with X's and O's:
		int rows = 11;
		int cols = 79;
		StringBuilder sb = new StringBuilder();
		for (int r = 0; r < rows; r++) {
			for (int c = 0; c < cols; c++)
				sb.append((r + c) % 2 == 0 ? "X" : "O");
			sb.append("\n");
		}
		String s = sb.toString();
		System.out.println(s);
		
	}

}

class Circle {
	private double xCenter, yCenter, radius; // (1) Define your fields, the data relevant to your class.
	// Uninitialized fields will be assigned a "zero" value:
	// boolean: false
	// int, long, byte, short: 0
	// double, float: 0.0
	// char: '\u0000'
	// Object (reference type): null (meaning "referring to no object")
	
	// (2) Generate/create your constructor(s).  These are methods that _initialize_ your new objects.
	public Circle() { // Note: Constructors have no return type and have the same name as the class.
		// If no constructors are defined a no-parameter constructor like this that does nothing is
		// defined for you.  Of course, we could have a no-parameter constructor that does something.
	}
	
	public Circle(double xCenter, double yCenter, double radius) {
		// One of the most common tasks of constructors as object initializers is the
		// copying of ephemeral parameters (that cease to exist when the constructor's execution concludes)
		// into persistent fields (that exist as long as the object exists in memory).
		// To differentiate between these parameters and the fields of the same name,
		// we use the keyword "this" to reference this Object. This is the most typical task of a constructor.
		this.xCenter = xCenter;
		this.yCenter = yCenter;
		this.radius = radius;
	}
	
	// We can have any number of constructors, as long as the method headers are different.
	public Circle(double radius) {
		this.radius = radius;
		// Note that xCenter and yCenter are 0.0 by default.
	}
	
	// This is what is often referred to as a "copy constructor".  
	// It takes another Object of the same class and copies its fields:
	public Circle(Circle other) {
		xCenter = other.xCenter; // That that a "." after an Object reference reaches inside to access a field (or method).
		yCenter = other.yCenter;
		radius = other.radius;
	}

	// (3) Generate/create a toString() method to generate a String representation of your Object.
	// This is especially helpful for debugging, but may also be relevant to storing/transmitting
	// information about the Object.  StringBuilder is a class that's helpful for building complicated
	// String representations.
	@Override
	public String toString() {
		return "Circle [xCenter=" + xCenter + ", yCenter=" + yCenter + ", radius=" + radius + "]";
	}

	
	// (4) Generate/create any getter/setter methods that are desired.  If you're creating an immutable
	// (unchangeable) class, be sure that there are no setters and that no methods modify your fields.
	
	public double getxCenter() {
		return xCenter;
	}

	public void setxCenter(double xCenter) {
		this.xCenter = xCenter;
	}

	public double getyCenter() {
		return yCenter;
	}

	public void setyCenter(double yCenter) {
		this.yCenter = yCenter;
	}

	public double getRadius() {
		return radius;
	}

	public void setRadius(double radius) {
		this.radius = radius;
	}

	// (5) Create any additional methods that chiefly concern this Object.  Here are some examples for a Circle class.
	public void translate(double dx, double dy) {
		xCenter += dx;
		yCenter += dy;
	}
	
	public void scale(double radiusScale) {
		radius *= radiusScale;
	}
	
	public boolean containsPoint(double x, double y) {
		double dx = x - xCenter;
		double dy = y - yCenter;
		return dx * dx + dy * dy <= radius * radius;
	}
	
	public boolean intersectsCircle(Circle other) {
		if (other == null)
			return false; // prevents NullPointerException on next line (which may be preferred handling)
		double dx = other.xCenter - xCenter; 
		double dy = other.yCenter - yCenter;
		double radiiSum = radius + other.radius;
		return dx * dx + dy * dy <= radiiSum * radiiSum;
	}
	
	public double getDiameter() {
		return 2 * radius;
	}
	
	// and getCircumference(), getArea(), getArcLength(), getSectorArea(), etc. (https://www.coolmath.com/reference/circles-geometry)
}
