import java.util.ArrayList;

/**
 * @author Sergey
 * 
 */
public class Bank
{
	private String name;
	private ArrayList<Account> accountList;
	private ArrayList<Client> clientList;

	/**
	 * 
	 * @param name
	 */

	public Bank(String name){
		this.name=name;
		accountList=new ArrayList<Account>();
		clientList=new ArrayList<Client>();
	}
	
	/**
	 * 
	 * @param client
	 *            client to add
	 */
	public void addClient(Client client){
		clientList.add(client);
	}

	/**
	 * 
	 * @param account
	 *            account to add
	 */
	public void addAccount(Account account){
		accountList.add(account);
	}
	
	// Getters and Setters =====================================================
	
	/**
	 * @param accountList the accountList to set
	 */
	public void setAccountList(ArrayList<Account> accountList) {
		this.accountList = accountList;
	}

	/**
	 * 
	 * @return list of all accounts of this bank
	 */
	public ArrayList<Account> getAccountList(){
		return accountList;
	}
	
	/**
	 * @param clientList the clientList to set
	 */
	public void setClientList(ArrayList<Client> clientList) {
		this.clientList = clientList;
	}

	/**
	 * 
	 * @return list of all clients of this bank
	 */

	public ArrayList<Client> getClientList(){
		return clientList;
	}
	
	/**
	 * @param bankName
	 */
	public void setName(String bankName) {
		this.name = bankName;
	}

	/**
	 * 
	 * @return Bank name
	 */

	public String getName(){
		return name;
	}	
}
