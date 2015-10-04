package model;

import java.util.Date;
import java.text.SimpleDateFormat;

/**
 * @author LappoPolina
 * 
 * Class contains information about the client: unique number, last name, first name,
 * middle name and date of birth also has properties for getting and
 * change individual fields of a class
 * Overridden toString() method for
 * collect data about the client in one line, for further
 * display
 */
public class Client {
	private static int nextUniquelD = 1;
	private String lastName;
	private String firstName;
	private String middleName;
	private int idClient;
	private Date dateOfBirth;

	/**
	 * The constructor
	 * Allows you to initialize instances of the class 
	 * for example, 
	 * create Client data Polina Lappo Vladimirovna 02.07.1994 
	 * Need enter <code> new Client("Lappo", "Polina", "Vladimirovna", 02.07.1994) </code>
	 * 
	 * @param lastName
	 *            Last Name
	 * @param firstName
	 *            First Name
	 * @param middleName
	 *            Middle Name
	 * @param dateOfBirth
	 *            Date of Birthday
	 * 
	 */
	public Client(String lastName, String firstName, String middleName, Date dateOfBirth) {
		this.lastName = lastName;
		this.firstName = firstName;
		this.middleName = middleName;
		this.dateOfBirth = dateOfBirth;
		idClient = nextUniquelD++;
	}

	public int getIdClient() {
		return idClient;
	}

	public String getLastName() {
		return lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public Date getDateOfBirth() {
		return (Date) dateOfBirth.clone();
	}

	public final void setIdClient(int idClient) {
		this.idClient = idClient;
	}

	public final void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public final void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public final void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public final void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	/**
	 * Override method to output information about the client
	 * All the data about client collects in one line
	 * 
	 * @return String
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		final SimpleDateFormat formatOfDate = new SimpleDateFormat("dd.MM.yyyy");
		final String Space = " ";
		builder.append(idClient).append(Space).append(lastName).append(Space).append(firstName).append(Space)
				.append(middleName).append(Space).append(formatOfDate.format(dateOfBirth));
		return builder.toString();

	}
}


