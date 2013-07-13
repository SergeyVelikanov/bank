/**
 * @author Sergey
 * 
 */
public class Client {
	private String dni;
	private String name;
	private String surname;
	private String address;
	private Integer telephone;

	/**
	 * @param dni
	 * @param name
	 * @param surname
	 * @param address
	 * @param telephone
	 */
	public Client(String dni, String name, String surname, String address, Integer telephone) {
		this.dni = dni;
		this.name = name;
		this.surname = surname;
		this.address = address;
		this.telephone = telephone;
	}
	
	// Getters and Setters ========================================================================

	/**
	 * @return the dni
	 */
	public String getDni() {
		return dni;
	}

	/**
	 * @param dni
	 *            the dni to set
	 */
	public void setDni(String dni) {
		this.dni = dni;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the surname
	 */
	public String getSurname() {
		return surname;
	}

	/**
	 * @param surname
	 *            the surname to set
	 */
	public void setSurname(String surname) {
		this.surname = surname;
	}

	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * @param address
	 *            the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * @return the telephone
	 */
	public Integer getTelephone() {
		return telephone;
	}

	/**
	 * @param telephone
	 *            the telephone to set
	 */
	public void setTelephone(Integer telephone) {
		this.telephone = telephone;
	}

}
