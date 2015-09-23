package base;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author LappoPolina
 * 
 *  ласс содержит сведени€ о продаже: уникальный номер, сведени€ о клиенте, сведени€ о покупаемых устройствах и их количество
 * “ак же имеютс€ свойства дл€ получени€ и изменени€ отдельных полей класса
 * ѕереопределен метод toString() дл€ того, что бы собирать данные о продаже в одну строку,
 * 	дл€ дальнейшего вывода на экран
 */
public class Sale {
	// пол€ класса
	private static int nextUniquelD = 1;
	private int idSale;
	private Date dateOfSale;
	private Client client;
	private Map<Device, Integer> checkOfSale = new HashMap<Device, Integer>();
	
	// конструктор
	public Sale(Date dateOfSale, Client client, Map<Device, Integer> checkOfSale){
		idSale = nextUniquelD++;
		this.dateOfSale = dateOfSale;
		this.client = client;
		this.checkOfSale = checkOfSale;
	}

	// получение значений полей
	public int getIdSale() {
		return idSale;
	}
	public Date getDateOfSale() {
		return (Date) dateOfSale.clone();
	}
	public Client getClient() {
		return client;
	}
	public  Map<Device, Integer> getCheckOfSle() {
		return checkOfSale;
	}
	
	// задание значений полей
	public final void setIdSale(int idSale) {
		this.idSale = idSale;
	}
	public final void setDateOfSale(Date dateOfSale) {
		this.dateOfSale = dateOfSale;
	}
	public final void setClient(Client client) {
		this.client = client;
	}
	public final void setCheckOfSale (Map<Device, Integer> checkOfSale) {
		this.checkOfSale = checkOfSale;
	}

	/**
	 * ѕереопредел€емый метод дл€ вывода информации о продаже
	 * ¬се данные о продаже собирает в одну строку
	 * @return String 
	 */
	@Override
	public String toString(){
		StringBuilder builder = new StringBuilder();
		final SimpleDateFormat formatOfDate = new SimpleDateFormat("dd.MM.yyyy");
		final String Space = " ";
		builder.append(idSale)
				.append(Space)
				.append(formatOfDate.format(dateOfSale))
				.append(Space)
				.append(client.getLastName())
				.append(Space)
				.append(client.getFirstName())
				.append(Space)
				.append(client.getMiddleName())
				.append(Space)
				.append(checkOfSale.keySet());
		return builder.toString();
	}
}
