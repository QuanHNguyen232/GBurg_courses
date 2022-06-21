
public class BankAccountTest {

	public static void main(String[] args) {
		// constructors, getBalance
		BankAccount ba1 = new BankAccount();	// default constructor
		System.out.println(ba1.getBalance());

		BankAccount ba2 = new BankAccount(123);
		System.out.println(ba2.getBalance());


		// toString
		System.out.println(ba1);
		System.out.println(ba2);	// why no need to call the method toString ???


		// deposit
		ba1.deposit(1000);
		ba2.deposit(1000000);
		System.out.println(ba1);
		System.out.println(ba2);
		ba1.deposit(-1);
		ba1.deposit(0);
		System.out.println(ba1);
		System.out.println(ba2);


		// withdraw
		ba1.withdraw(1000);
		ba2.withdraw(1000000);
		System.out.println(ba1);
		System.out.println(ba2);
		ba1.withdraw(-1);
		ba1.withdraw(2000000);
		System.out.println(ba1);
		System.out.println(ba2);
	}

}
