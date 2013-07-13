/**
 * 
 */

/**
 * @author Sergey
 * 
 */
public class TestClass {
	Bank bank;
	Client client1;
	Client client2;
	Client client3;
	Account account1;
	Account account2;
	Account account3;

	public TestClass() throws Exepcion {
		try {
		bank = new Bank("BBA");
		client1 = new Client("A123456-B", "Juan", "Perez", "Av. Americas, 4", 123);
		bank.addClient(client1);		
		bank.addAccount(new Account("CC", client1).deposit(100.00));
		client2 = new Client("C281452-D", "Martin", "Velazques", "C/ Mallorca, 321", 456);
		bank.addClient(client2);
		bank.addAccount(new Account("CV", client2).deposit(100.00));
		client3 = new Client("E983782-F", "Carlos", "Ramos", "C/Libertad, 23", 789);		
		bank.addClient(client3);
		bank.addAccount(new Account("FI", client3).deposit(100.00));			
		} catch (IllegalArgumentException error) {
			throw new Exepcion("ACCOUNT_TYPE_ERROR");
		}
	}

	/**
	 * @param args
	 * @throws Exepcion
	 */
	public static void main(String[] args) throws Exepcion {
		new TestClass();
	}
	
}
