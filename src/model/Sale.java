package model;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author LappoPolina
 * 
 *         Класс содержит сведения о продаже: уникальный номер, сведения о
 *         клиенте, сведения о покупаемых устройствах и их количество Так же
 *         имеются свойства для получения и изменения отдельных полей класса
 *         Переопределен метод toString() для того, что бы собирать данные о
 *         продаже в одну строку, для дальнейшего вывода на экран
 */
public class Sale {
	private static int nextUniquelD = 1;
	private int idSale;
	private Date dateOfSale;
	private Client client;
	private Map<Device, Integer> checkOfSale = new HashMap<Device, Integer>();

	/**
	 * Конструктор для инициализации экземпляра класса
	 * 
	 * @param dateOfSale
	 *            даты продажи
	 * @param client
	 *            клиент совершивший покупку
	 * @param checkOfSale
	 *            купленные устройсва и их количество
	 */
	public Sale(Date dateOfSale, Client client, Map<Device, Integer> checkOfSale) {
		idSale = nextUniquelD++;
		this.dateOfSale = dateOfSale;
		this.client = client;
		this.checkOfSale = checkOfSale;
	}

	public Integer getIdSale() {
		return idSale;
	}

	public Date getDateOfSale() {
		return (Date) dateOfSale.clone();
	}

	public Client getClient() {
		return client;
	}

	public Map<Device, Integer> getCheckOfSle() {
		return checkOfSale;
	}

	public final void setIdSale(int idSale) {
		this.idSale = idSale;
	}

	public final void setDateOfSale(Date dateOfSale) {
		this.dateOfSale = dateOfSale;
	}

	public final void setClient(Client client) {
		this.client = client;
	}

	public final void setCheckOfSale(Map<Device, Integer> checkOfSale) {
		this.checkOfSale = checkOfSale;
	}

	/**
	 * Переопределяемый метод для вывода информации о продаже Все данные о
	 * продаже собирает в одну строку
	 * 
	 * @return String
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		final SimpleDateFormat formatOfDate = new SimpleDateFormat("dd.MM.yyyy");
		final String Space = " ";
		builder.append(idSale).append(Space).append(formatOfDate.format(dateOfSale)).append(Space)
				.append(client.getLastName()).append(Space).append(client.getFirstName()).append(Space)
				.append(client.getMiddleName()).append(Space).append(checkOfSale.keySet());
		return builder.toString();
	}
}
