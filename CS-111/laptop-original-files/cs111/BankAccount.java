
public class BankAccount {

	// field(s)
	private int balance = 0;	// "private" -> can only modified in this class BankAccount



	// method(s)

	public int getBalance() {	// "getter" method
		return balance;
	}
	
	public String toString() {
		return String.format("BankAccount[balance=%d]", balance);
	}
	
	public void deposit(int amount) {
		if (amount < 0) {
			System.err.println("Cannot deposit negative amount: " + amount);
		}
		else {
			balance += amount;
		}
	}
	
	public void withdraw(int amount) {
		if (amount < 0) {
			System.err.println("Cannot withdraw negative amount: " + amount);
		}
		else if (amount > balance) {
			System.err.println("Cannot withdraw an amount greater than the balance: " + amount);
		}
		else {
			balance -= amount;
		}
	}
	
	
	// constructor (with int parameter)
	// You can identify a constructor as follow
	// - named with the class name
	// - no return type
	// - no static

	public BankAccount(int balance) {
		this.balance = balance;	// this. refers to balance in line 7. otherwise, it refers to parameter
		// or balance = newBalance;	// With newBalance is the parameter int
	}
	// Note: once we define a constructor, the default constructor is no longer given
	// and we must define it ourselves if we want it

	public BankAccount() {

	}

	


	

}
