import java.util.Calendar;
import java.util.TimerTask;
import java.util.Timer;

/**
 * @author Sergey
 * 
 */
public class Account {
	int countMonth = 0;
	private Client client;
	private Double commission = 0.6; // monthly commission in €
	private Calendar calendar = Calendar.getInstance();
	private AccountType accountType;
	private int day; // for method get(int field) field=5
	private int month; // field=(2) from 0 to 11
	private int year; // field=1 (day, month, year of aperture)
	private Double interest; // interests payment according to account type 0.01
								// for CC,0.02 for CV, 0.034 for FI
	private int checkingInterval = 10000;// 10000 * 60 * 60 * 24;// 1 day for timer
	private Double balance;
	private boolean blocked = false;
	private int points;

	enum AccountType {
		CC, CV, FI;
	} // CC-cuenta corriente(checking account) ,
	  // CV-cuenta vivienda(real estate account), FI-fondo de inversion(investment fund)

	/**
	 * 
	 * @param accountType
	 *            Account Type
	 * @param client
	 *            Client for this account
	 * @throws Exepcion
	 *             throws exception if an account is different of CC,CV o FI
	 */
	public Account(String accountType, Client client) throws Exepcion {
		try {
			this.accountType = AccountType.valueOf(accountType);
			this.setClient(client);
			day = calendar.get(5);
			month = calendar.get(2);
			year = calendar.get(1);
			balance = 0.00;
			Task task = new Task();
			Timer timer = new Timer();
			// execute the task repeatedly according to the checkingInterval
			timer.scheduleAtFixedRate(task, 0, checkingInterval); 

			if (this.accountType == AccountType.CC)
				interest = 0.01;
			else if (this.accountType == AccountType.CV)
				interest = 0.02;
			else
				interest = 0.034;
		} catch (IllegalArgumentException error) {
			throw new Exepcion("ACCOUNT_TYPE_ERROR");
		}
	}

	/**
	 * 
	 * @return accountType
	 */

	public AccountType getAccountType() {
		return accountType;
	}

	/**
	 * 
	 * @param accountType
	 *            accountType
	 * @throws Exepcion
	 *             throws exception if an account is different of CC,CV o FI
	 */
	public void setAccountType(String accountType) throws Exepcion {
		try {
			this.accountType = AccountType.valueOf(accountType);
		} catch (IllegalArgumentException error) {
			throw new Exepcion("ACCOUNT_TYPE_ERROR");
		}
	}

	/**
	 * 
	 * @param amount
	 *            amount to deposit, if the account balance + deposit > 500 € an
	 *            account will be unblocked if it was blocked, every deposit
	 *            adds 1 bonus point
	 */

	public Account deposit(Double amount) {
		this.balance += amount;
		if (this.balance > -500.00)
			this.blocked = false;
		this.points++;
		return this;
	}

	/**
	 * 
	 * @param amount
	 *            amount to draw, the operation is allowed only if the account FI
	 *            balance >= -500€ and the account FI balance - amount to draw >= 500€, also
	 *            if account CC balance > 0.00€ and  account CC balance - amount to draw > 0.00€
	 * @throws Exepcion
	 *             if the account is blocked, balance is insufficient or if the
	 *             account type is CV
	 */
	public void draw(Double amount) throws Exepcion {
		if (!this.blocked) {
			if (this.accountType == AccountType.CC) {
				if (this.balance >= amount)
					this.balance -= amount;
				else
					throw new Exepcion("INSUFFICIENT_BALANCE");
			} else if (this.accountType == AccountType.FI) {
				if (this.balance <= -500.00) {
					this.blocked = true;
					throw new Exepcion("ACCOUNT_BLOCKED");
				} else if(this.balance - amount >= -500.00)
					this.balance -= amount;
			} else
				throw new Exepcion("FORBIDDEN_OPERATION");

		} else
			throw new Exepcion("ACCOUNT_BLOCKED");
	}

	/**
	 * 
	 * @return balance
	 */
	public Double checkBalance() {
		return this.balance;
	}

	/**
	 * update the account balance monthly
	 */
	public void monthlyRevision() {
		if (!this.blocked && this.balance > 0.00) {
			if (this.accountType == AccountType.FI)
				this.balance = this.balance + this.balance * this.interest - this.commission;
			else if (this.accountType == AccountType.CC) { 
				boolean checkPositive = this.balance + this.balance * this.interest - this.commission > 0.00;
				if (checkPositive)
					this.balance = this.balance + this.balance * this.interest - this.commission;
			} else
				this.balance = this.balance + this.balance * this.interest;
		}
	}

	/**
	 * 
	 * @return points - bonus points
	 */
	public int getPuntos() {
		return this.points;
	}

	/**
	 * @return the day
	 */
	public int getDay() {
		return day;
	}

	/**
	 * @param day
	 *            the day to set
	 */
	public void setDay(int day) {
		this.day = day;
	}

	/**
	 * @return the client
	 */
	public Client getClient() {
		return client;
	}

	/**
	 * @param client the client to set
	 */
	public void setClient(Client client) {
		this.client = client;
	}

	/**
	 * * Inner class responsible of monthly revision(every 1st day of the month)
	 */
	class Task extends TimerTask {

		@Override
		public void run() {
			Calendar calendar = Calendar.getInstance();
			if (month != calendar.get(Calendar.MONTH)
					|| year != calendar.get(Calendar.YEAR)) {
				if (calendar.get(Calendar.DAY_OF_MONTH) == 1)
					monthlyRevision();
			}
			
			// TODO test - remove when done =====================================================================			
			 System.out.println("(Month "+countMonth+")Before monthly revision: "
			                      +Account.this.client.getName()+": "+checkBalance());
			 monthlyRevision();
			 System.out.println("After monthly revision: "+Account.this.client.getName()+": "+checkBalance());
			 System.out.println("Draw 101 €");
			 try {
				Account.this.draw(101.00);				
			} catch (Exepcion e) {				
				e.printStackTrace();
			}
			 System.out.println("Deposit 5 €");
			 Account.this.deposit(5.00);
			// end of test ==================================================================================
			 countMonth++;
		}

	}
}
