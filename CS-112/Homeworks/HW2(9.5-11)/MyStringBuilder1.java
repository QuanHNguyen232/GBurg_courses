
public class MyStringBuilder1 {
	// fields
	private String s = "";
	
	// constructor
	public MyStringBuilder1(String s) {
		this.s = s;
	}
	
	// method
	public MyStringBuilder1 append(MyStringBuilder1 s1) {
//		MyStringBuilder1 mSB = new MyStringBuilder1(this.s + s1.s);
//		return mSB;
		this.s = this.s.concat(s1.s);
		return this;
	}
	
	public MyStringBuilder1 append(int i) {
//		MyStringBuilder1 mSB = new MyStringBuilder1(this.s + String.valueOf(i));
//		return mSB ;
		this.s = this.s.concat(String.valueOf(i));
		return this;
	}
	public int length() {
		return s.length();
	}
	public char charAt(int i) {
		return s.charAt(i);
	}
	public MyStringBuilder1 toLowerCase() {
//		MyStringBuilder1 mSB = new MyStringBuilder1(this.s.toLowerCase());
//		return mSB;
		this.s = this.s.toLowerCase();
		return this;
	}
	public MyStringBuilder1 substring(int start, int end) {
//		MyStringBuilder1 mSB = new MyStringBuilder1(this.s.substring(start, end));
//		return mSB;
		this.s = this.s.substring(start, end);
		return this;
	}
	
	@Override
	public String toString() {
		return "MyStringBuilder1 [s = " + this.s + "]";
	}
	
	// For testing only
//	public static void main(String[] args) {
//		MyStringBuilder1 mSB1 = new MyStringBuilder1("hELlo ");
//		MyStringBuilder1 mSB2 = new MyStringBuilder1("woRLd ");
//		System.out.println(mSB1.append(mSB2));
//		System.out.println(mSB1.append(5));
//		System.out.println(mSB1.length());
//		System.out.println(mSB1.charAt(2));
//		System.out.println(mSB1.toLowerCase());
//		System.out.println(mSB1.substring(1, 7));
//	}

}
