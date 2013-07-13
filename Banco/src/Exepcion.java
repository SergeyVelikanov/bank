/**
 * @author Sergey
 * 
 */

public class Exepcion extends Exception {	
	private static final long serialVersionUID = 8390355695274284929L;
	
	public static final String ACCOUNT_TYPE_ERROR = "Account types accepted are: CC, CV, FI";
	public static final String ACCOUNT_BLOCKED = "Your account is blocked";
	public static final String FORBIDDEN_OPERATION = "This operation is not allowed for your account";
	public static final String INSUFFICIENT_BALANCE = "You don't have enough balance for cashing out ";

	public Exepcion(String str) {
		super(str);
	}

}
