
public class Device {
	// I choose a sample from a program used by retailers to manage their goods
	
	// field
	private String produceDate;
	private double price, depreciation;
	// Depreciation is the rate of decreasing of a device's value.
	// In this case, I choose it to decrease device's value by year
	// Unit: $/year
	
	
	// constructor
	public Device(String date, double price, double depre) {
		this.produceDate = date;
		this.price = price;
		this.depreciation = depre;
	}
	
	
	
	// method
	
	public double deviceLongevity() {
		if (depreciation > 0) {
			return price/depreciation;
		}
		return price;
	}
//	public double getDepreciation() {
//		return depreciation;
//	}
//	public void setDepreciation(double depreciation) {
//		this.depreciation = depreciation;
//	}
//	public String getProduceDate() {
//		return produceDate;
//	}
//	public double getPrice() {
//		return price;
//	}
	
}
