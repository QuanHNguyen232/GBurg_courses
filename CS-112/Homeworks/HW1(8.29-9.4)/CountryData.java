import java.util.Scanner;

public class CountryData {
	// fields
//	private ArrayList<Integer> population = new ArrayList<Integer>();
//	private ArrayList<Double> percentInternetAccess = new ArrayList<Double>();
//	Hashtable<Integer, Integer> population = new Hashtable<Integer, Integer>();
//	Hashtable<Integer, Double> percentInternetAccess = new Hashtable<Integer, Double>();

	private static final int START_YEAR = 1990, END_YEAR = 2021;
	private String countryName;
	private Integer[] population = new Integer[END_YEAR - START_YEAR + 1];
	private Double[] percentInternetAccess = new Double[END_YEAR - START_YEAR + 1];
	
	
	
	// constructor
	public CountryData() {}
	
	public CountryData(String name) {
		this.countryName = name;
	}
	
	public CountryData(String name, int... data) {
		this.countryName = name;
		for (int i = 0; i < ((population.length < data.length) ? population.length : data.length); i++) {
			population[i] = data[i];
		}
	}
	
	public CountryData(String name, double... data) {
		this.countryName = name;
		for (int i = 0; i < ((percentInternetAccess.length < data.length) ? percentInternetAccess.length : data.length); i++) {
			percentInternetAccess[i] = data[i];
		}
	}
	
	
	// method
	public void getCountryName() {
		System.out.println("Country name is: " + this.countryName);
	}
	
	public void setCountryName(String name) {
		this.countryName = name;
	}
	
	public void getPopulation_All() {
		int year = START_YEAR;
		for (int i = 0; i < population.length; i++) {
			System.out.printf("Year: %d; population: %9d\n", year, population[i]);
			year++;
		}
	}
	
	public void getPopulationByYear() {
		Scanner sc = new Scanner(System.in);
		System.out.println("\"Add whitespace between years\"");
		System.out.print("year? ");
		String y = sc.nextLine();
		Scanner scanYear = new Scanner(y);
		while (scanYear.hasNextInt()) {
			int year = scanYear.nextInt();
			if (year >= START_YEAR && year <= END_YEAR) {
				System.out.printf("Year: %d; population: %9d\n", year, population[year - START_YEAR]);
			}
			else {
				System.out.println(year + " is invalid year");
			}
		}
	}
	
	public void setPopulation() {
		Scanner sc = new Scanner(System.in);
		System.out.println("\"Add whitespace between years or values\"");
		System.out.print("year? ");
		String s = sc.nextLine();
		System.out.print("new data? ");
		String p = sc.nextLine();
		Scanner scanYear = new Scanner(s);
		Scanner scanData = new Scanner(p);
		while (scanYear.hasNextInt()) {
			int year = scanYear.nextInt();
			int data = scanData.nextInt();
			if (year >= START_YEAR && year <= END_YEAR && data >= 0) {
				population[year - START_YEAR] = data;
			}
			else {
				System.out.printf("Invalid values in %d (year) or %d (data)\n", year, data);
			}
		}
	}
	
	public void getPercent_All() {
		int year = START_YEAR;
		for (int i = 0; i < percentInternetAccess.length; i++) {
			System.out.printf("Percent internet access in year %d is %3.4f\n", year, percentInternetAccess[i]);
			year++;
		}
	}
	
	public void getPercentByYear() {
		Scanner sc = new Scanner(System.in);
		System.out.println("\"Add whitespace between years\"");
		System.out.print("year? ");
		String y = sc.nextLine();
		Scanner scanYear = new Scanner(y);
		while (scanYear.hasNextInt()) {
			int year = scanYear.nextInt();
			if (year >= START_YEAR && year <= END_YEAR) {
				System.out.printf("Percent internet access in year %d is %3.4f\n", year, percentInternetAccess[year - START_YEAR]);
			}
			else {
				System.out.println(year + " is invalid year");
			}
		}
	}
	
	public void setPercent() {
		Scanner sc = new Scanner(System.in);
		System.out.println("\"Add whitespace between years or values\"");
		System.out.print("year? ");
		String s = sc.nextLine();
		System.out.print("new data? ");
		String p = sc.nextLine();
		Scanner scanYear = new Scanner(s);
		Scanner scanData = new Scanner(p);
		while (scanYear.hasNextInt()) {
			int year = scanYear.nextInt();
			double data = scanData.nextDouble();
			if (year >= START_YEAR && year <= END_YEAR && data >= 0 && data <= 100) {
				percentInternetAccess[year - START_YEAR] = data;
			}
			else {
				System.out.printf("Invalid values in %d (year) or %3.4f (value)\n", year, data);
			}
		}
	}

//	private void defaultValue(Hashtable a) {
//		for (int i = START_YEAR; i <= END_YEAR; i++) {
//			a.put(i, 0);
//		}
//	}
//	private void constructPopulation(int[] data) {
//		for (int i=START_YEAR; i<=END_YEAR && (i-START_YEAR < data.length); i++) {
//			population.put(i, data[i-START_YEAR]);
//		}
//	}
//	private void constructPercent(double[] data) {
//		for (int i=START_YEAR; i<=END_YEAR && (i-START_YEAR < data.length); i++) {
//			percentInternetAccess.put(i, data[i-START_YEAR]);
//		}
//	}
	
	// Population
//	public void getPopulationBasedOnYear() {
//		Scanner sc = new Scanner(System.in);
//		Queue<Integer> q = new LinkedList<Integer>();
//		System.out.print("What year? (if more than 2, add whitespace between years) ");
////		int input = sc.nextInt();
//		String input = sc.nextLine();
//		Scanner scanner = new Scanner(input);
//		while (scanner.hasNextInt()) {
//			int a = scanner.nextInt();
//			System.out.println(a + " ");
//			q.add(a);
//		}
//		System.out.println((input >= START_YEAR && input <= END_YEAR) ? population.get(input) : "Invalid Year");
		
		//print
//		while (!q.isEmpty()){
//			int year = q.remove();
//			System.out.print("Year:" + year + " population: " + population.get(year) + "\n");
//		}
//		sc.close();
//	}
	
//	public void getPopulationAll() {
//		for (int i = START_YEAR; i <= END_YEAR; i++) {
//			System.out.print("Year " + i + ": " + population.get(i) + "\t");
//		}
//		System.out.println();
//	}
//	public void setPopulationBasedOnYear() {
//		Scanner sc = new Scanner(System.in);
//		System.out.print("What year?: ");
//		int year = sc.nextInt();
//		System.out.print("\nNew population: ");
//		int newPopulation = sc.nextInt();
//		population.replace(year, newPopulation);
//		sc.close();
//	}
//	
//	// Percent
//	public void getPercentBasedOnYear() {
//		Scanner sc = new Scanner(System.in);
//		System.out.print("What year?: ");
//		int input = sc.nextInt();
//		System.out.println((input >= START_YEAR && input <= END_YEAR) ? percentInternetAccess.get(input) : "Invalid Year");
//		sc.close();
//	}
//	
//	public void getPercentAll() {
//		for (int i = START_YEAR; i <= END_YEAR; i++) {
//			System.out.print("Year " + i + ": " + percentInternetAccess.get(i) + "\t");
//		}
//		System.out.println();
//	}
//	
//	public void setPercentBasedOnYear() {
//		Scanner sc = new Scanner(System.in);
//		System.out.print("What year?: ");
//		int year = sc.nextInt();
//		System.out.print("\nNew population: ");
//		double newPercent = sc.nextInt();
//		percentInternetAccess.replace(year, newPercent);
//		sc.close();
//	}

}
