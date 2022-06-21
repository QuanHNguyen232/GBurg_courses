
public class Phone extends Device {
	
	// field
	
	private String phoneName;
	private final double batteryCapacity, consumptionRate;
	
	
	// constructor
	public Phone (String date, double price, double depre, String name, double battery, double rate) {
		super(date, price, depre);
		this.phoneName = name;
		this.batteryCapacity = battery;
		this.consumptionRate = rate;
	}
	
	
	
	// method
	
	public double timeBatteryLast() {
		if (consumptionRate > 0) {
			return batteryCapacity/consumptionRate;
		}
		return batteryCapacity;
	}
//	public String getPhoneName() {
//		return phoneName;
//	}
//	public void setPhoneName(String phoneName) {
//		this.phoneName = phoneName;
//	}
//	public double getBatteryCapacity() {
//		return batteryCapacity;
//	}
//	public double getConsumptionRate() {
//		return consumptionRate;
//	}
	
	
	
}
