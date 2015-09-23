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
	
	/**
	 * �������� ��� ��������� Id ������
	 * @return idClient 
	 */
	public int getIdClient() {
        return idClient;
    }
	
	/**
	 * �������� ��� ��������� �������
	 * @return lastName 
	 */
	public String getLastName() {
        return lastName;
    }
	
	/**
	 * �������� ��� ��������� �����
	 * @return firstName 
	 */
	
	public String getFirstName() {
        return firstName;
    }
	
	/**
	 * �������� ��� ��������� ��������
	 * @return middleName 
	 */
	public String getMiddleName() {
        return middleName;
    }
	
	/**
	 * �������� ��� ��������� ���� ��������
	 * @return dateOfBirth 
	 */
	public Date getDateOfBirth(){
		return (Date) dateOfBirth.clone();	  
	}
	
	
	/**
	 * �������� ��� ������� Id �������
	 * @param idClient ���������� ����� ������ 
	 */
	public final void setIdClient(int idClient){ 
        this.idClient = idClient; 
	}
	
	/**
	 * �������� ��� ������� ������� �������
	 * @param lastName ������� 
	 */
	public final void setLastName(String lastName){ 
        this.lastName = lastName; 
	}
	
	/**
	 * �������� ��� ������� ����� �������
	 * @param firstName ���
	 */
	public final void setFirstName(String firstName){ 
        this.firstName = firstName; 
	}
	
	/**
	 * �������� ��� ������� �������� �������
	 * @param middleName �������� 
	 */
	public final void setMiddleName(String middleName){ 
        this.middleName = middleName; 
	}
	
	/**
	 * �������� ��� ������� ���� ��������
	 * @param  dateOfBirth ���� ��������
	 */
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