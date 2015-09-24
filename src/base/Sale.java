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
	private static int nextUniquelD = 1;
	private int idSale;
	private Date dateOfSale;
	private Client client;
	private Map<Device, Integer> checkOfSale = new HashMap<Device, Integer>();
	
	/**
	 *  онструктор дл€ инициализации экземпл€ра класса
	 * @param dateOfSale даты продажи
	 * @param client клиент совершивший покупку
	 * @param checkOfSale купленные устройсва и их количество
	 */
	public Sale(Date dateOfSale, Client client, Map<Device, Integer> checkOfSale){
		idSale = nextUniquelD++;
		this.dateOfSale = dateOfSale;
		this.client = client;
		this.checkOfSale = checkOfSale;
	}

	/**
	 * —войство дл€ получени€ значени€ Id продажи
	 * @return int 
	 */
	public int getIdSale() {
		return idSale;
	}
	/**
	 * —войство дл€ получени€ значени€ даты продажи
	 * @return Date
	 */
	public Date getDateOfSale() {
		return (Date) dateOfSale.clone();
	}
	/**
	 * —войство дл€ получени€ значени€ данных о клиенте, совершившим покупку
	 * @return Client
	 */
	public Client getClient() {
		return client;
	}
	/**
	 * —войство дл€ получени€ значени€ сведений о купленных устройсваи и их количестве
	 * @return Map
	 */
	public  Map<Device, Integer> getCheckOfSle() {
		return checkOfSale;
	}
	
	/**
	 * 	—войство дл€ задани€ значени€ Id продажи
	 * @param idSale уникальный номер продажи
	 */
	public final void setIdSale(int idSale) {
		this.idSale = idSale;
	}
	/**
	 * —войство дл€ задани€ значени€ даты продажи
	 * @param dateOfSale дата продажи
	 */
	public final void setDateOfSale(Date dateOfSale) {
		this.dateOfSale = dateOfSale;
	}
	/**
	 * —войство дл€ задани€ значени€ клиента, совершившего покупку
	 * @param client ƒанные о клиенте
	 */
	public final void setClient(Client client) {
		this.client = client;
	}
	/**
	 * —войство дл€ задани€ значений купленных устройств и их количество
	 * @param checkOfSale купленные устройства и их количество
	 */
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
