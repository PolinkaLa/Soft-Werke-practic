package base;

import java.util.Date;
import java.text.SimpleDateFormat;

/**
 * @author LappoPolina
 * 
 * Класс содержит сведения о клиенте: уникальный номер, фамилию, имя, отчетво и дату рождения
 * Так же имеются свойства для получения и изменения отдельных полей класса
 * Переопределен метод toString() для того, что бы собирать данные о клиенте в одну строку,
 * 	для дальнейшего вывода на экран
 */
public class Client {
	private static int nextUniquelD = 1;
	private String lastName;
	private String firstName;
	private String middleName;
	private int idClient;
	private Date dateOfBirth;
	
	/**
	  * Конструктор
	  * Позволяет инициализировать экземпляры класса
	  * Например, для создание Клиента с данными Лаппо Полина Владимировна 02.07.1994г.
	  * Нужно ввести new Client("Lappo", "Polina", "Vladimirovna", 02.07.1994)
	  * @param lastName Фамилия
	  * @param firstName Имя
	  * @param middleName Отчество
	  * @param dateOfBirth Дата рождения
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
	 * Переопределяемый метод для вывода информации о клиенте
	 * Все данные о клиенте собирает в одну строку
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
