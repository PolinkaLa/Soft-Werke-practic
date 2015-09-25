package base;

import java.util.Date;
import java.text.SimpleDateFormat;

/**
 * @author LappoPolina
 * 
 * ����� �������� �������� � �������: ���������� �����, �������, ���, ������� � ���� ��������
 * ��� �� ������� �������� ��� ��������� � ��������� ��������� ����� ������
 * ������������� ����� toString() ��� ����, ��� �� �������� ������ � ������� � ���� ������,
 * 	��� ����������� ������ �� �����
 */
public class Client {
	private static int nextUniquelD = 1;
	private String lastName;
	private String firstName;
	private String middleName;
	private int idClient;
	private Date dateOfBirth;
	
	/**
	  * �����������
	  * ��������� ���������������� ���������� ������
	  * ��������, ��� �������� ������� � ������� ����� ������ ������������ 02.07.1994�.
	  * ����� ������ new Client("Lappo", "Polina", "Vladimirovna", 02.07.1994)
	  * @param lastName �������
	  * @param firstName ���
	  * @param middleName ��������
	  * @param dateOfBirth ���� ��������
	  * 
	  */
	public Client(String lastName, String firstName, String middleName, Date dateOfBirth){
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
	public Date getDateOfBirth(){
		return (Date) dateOfBirth.clone();	  
	}
	
	
	public final void setIdClient(int idClient){ 
        this.idClient = idClient; 
	}
	public final void setLastName(String lastName){ 
        this.lastName = lastName; 
	}
	public final void setFirstName(String firstName){ 
        this.firstName = firstName; 
	}
	public final void setMiddleName(String middleName){ 
        this.middleName = middleName; 
	}
	public final void setDateOfBirth(Date dateOfBirth){ 
        this.dateOfBirth = dateOfBirth; 
	}

	
	/**
	 * ���������������� ����� ��� ������ ���������� � �������
	 * ��� ������ � ������� �������� � ���� ������
	 * @return String 
	 */
	@Override
	public String toString(){
		StringBuilder builder = new StringBuilder();
		final SimpleDateFormat formatOfDate = new SimpleDateFormat("dd.MM.yyyy");
		final String Space = " ";
		builder.append(idClient)
				.append(Space)
				.append(lastName)
				.append(Space)
				.append(firstName)
				.append(Space)
				.append(middleName)
				.append(Space)
				.append(formatOfDate.format(dateOfBirth));
		return builder.toString();
		
	}
}
