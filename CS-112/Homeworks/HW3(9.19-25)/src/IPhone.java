
public class IPhone extends Phone {

	// field

	private String IMEI; 
	private boolean isLightOn = false;


	// constructor
	public IPhone (String date, double price, double depre, String name, double battery, double rate, String imei) {
		super(date, price, depre, name, battery, rate);
		this.IMEI = imei;
	}



	// method

	public void dialing() {
		System.out.println("Phone is dialing");
	}
	public int findSum(int a, int b) {
		return a+b;
	}
	public boolean turnOnOffLight() {
		return (isLightOn = !isLightOn);
	}
//	public boolean getIsLightOn() {
//		return isLightOn;
//	}
//	public void setLightOn(boolean isLightOn) {
//		this.isLightOn = isLightOn;
//	}
//	public String getIMEI() {
//		return IMEI;
//	}

}
