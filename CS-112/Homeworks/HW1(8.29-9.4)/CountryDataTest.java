import java.util.Scanner;

public class CountryDataTest {

	public static void main(String[] args) {
		
		// Test constructors
		CountryData vn= new CountryData();
		
		CountryData us = new CountryData("US");
		
		CountryData jp = new CountryData("Japan", 1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
		
		CountryData uk = new CountryData("UK", 1.1, 2.2, 3.3, 4.4, 5.5, 6.6, 7.7);
		
		// Test get all population
		jp.getPopulation_All();
		
		// Test get all percent
		uk.getPercent_All();
		
		// Test set population
		vn.setPopulation();
		
		// Test set percent
		us.setPercent();
		
		// Test get population by year
		vn.getPopulationByYear();
		
		// Test get percent by year
		us.getPercentByYear();
	}

}
