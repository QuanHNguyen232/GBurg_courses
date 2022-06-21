import java.util.Arrays;
// Ask Thanh for updating MyData that I missed
public class MyData implements Cloneable{
	private String label;
	private double data[];	// this way is fine ??? Not double[] data?
	
	public MyData(String label, int n) {
		this.label = label;
		data = new double[n];
	}
	
	public String getLabel() {
		return label;
	}
	
	public double getDataAt(int index) {
		return data[index];
	}
	
	public void setDataAt(int index, double value) {
		if(index < 0 || index >= data.length) {
			throw new IndexOutOfBoundsException("Invalid index: " + index);
		}
		data[index] = value;
	}
	
	@Override
	public String toString() {
		return String.format("%s: %s\n", label, Arrays.toString(data));
	}
	
	@Override
	public Object clone() {	// SHALLOW CLONE if without copy.data = Arrays.copyOf(data, data.length); Else: called DEEP CLONE
		try {
			//use the super class for the clone
			MyData copy = (MyData)super.clone();
			
			//deep clone
			copy.data = Arrays.copyOf(data, data.length);
			// Since the (String) label is immutable, so it is fine not to copy the String
			return copy;
		}
		catch(CloneNotSupportedException cnse) {
			cnse.printStackTrace();
			return null;
		}
	}
}
