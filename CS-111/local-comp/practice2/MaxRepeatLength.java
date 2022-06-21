
public class MaxRepeatLength {

	// constructor
	MaxRepeatLength() {}
	
	/// method
	public static int getMaxRepeatLength(int[] data) {
		int maxRepeat = 0;
		if (data == null) {
			return 0;
		}
		else if (data.length==1) {
			return 1;
		}
		int timesRepeat = 1;
		for (int i = 1; i < data.length; i++) {
			timesRepeat = data[i] == data[i-1] ? timesRepeat+=1 : 1;
			maxRepeat = maxRepeat < timesRepeat ? timesRepeat : maxRepeat;
		}
		return maxRepeat;
	}
	
	
	
	
	public static void main(String[] args) {
		int[] z = {0, 0, 2, 2, 2, 2, 3, 4, 3, 3, 3};
		System.out.println(getMaxRepeatLength(z));
		System.out.println("new:" + getMaxRepeatLength(new int[] {}));
		System.out.println("new1:"+getMaxRepeatLength(new int[] {1}));
	}

}
