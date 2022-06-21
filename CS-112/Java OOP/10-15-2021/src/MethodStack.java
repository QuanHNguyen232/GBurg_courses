
public class MethodStack {

	public static void f3() {
		throw new NullPointerException("sth is null");
	}

	public static void f2() {
		f3();
	}

	public static void f1() throws Exception {
		try {
			f2();
		}
		catch (NullPointerException npe) {
			npe.printStackTrace();
			throw new Exception(npe);
		}
	}

	public static void main(String[] args) { // throws Exception {
		try {
			f1();
		} catch (Exception e) {
			System.out.println(e);
		}
		System.out.println("main");

//		Error and out Stream are different
//		java.lang.NullPointerException: sth is null
//		main
//			at MethodStack.f3(MethodStack.java:5)
//			at MethodStack.f2(MethodStack.java:9)
//			at MethodStack.f1(MethodStack.java:14)
//			at MethodStack.main(MethodStack.java:22)

		MyAction my = new MyAction();
		my.main(args);
	}

}
