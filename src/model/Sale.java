package model;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author LappoPolina
 * 
 *        Class contains information about the sale: a unique number, information about
 * client, information about devices and their number 
 * as well there are properties to retrieve and change individual fields of a class
 * Overridden the toString() method in order to collect data about
 * sale in one line, for further display
 */
public class Sale {
	private static int nextUniquelD = 1;
	private int idSale;
	private Date dateOfSale;
	private Integer idClient;
	private Map<Integer, Integer> checkOfSale = new HashMap<Integer, Integer>();

	/**
	 * Constructor to initialize the new created instance
	 * 
	 * @param dateOfSale
	 *            date of sale
	 * @param client
	 *            information about client
	 * @param checkOfSale
	 *            information about device and their number
	 */
	public Sale(Date dateOfSale, Integer idClient, Map<Integer, Integer> checkOfSale) {
		idSale = nextUniquelD++;
		this.dateOfSale = dateOfSale;
		this.idClient = idClient;
		this.checkOfSale = checkOfSale;
	}

	public Integer getIdSale() {
		return idSale;
	}

	public Date getDateOfSale() {
		return (Date) dateOfSale.clone();
	}

	public Integer getClient() {
		return idClient;
	}

	public Map<Integer, Integer> getCheckOfSle() {
		return checkOfSale;
	}

	public final void setIdSale(int idSale) {
		this.idSale = idSale;
	}

	public final void setDateOfSale(Date dateOfSale) {
		this.dateOfSale = dateOfSale;
	}

	public final void setClient(Integer idClient) {
		this.idClient = idClient;
	}

	public final void setCheckOfSale(Map<Integer, Integer> checkOfSale) {
		this.checkOfSale = checkOfSale;
	}

	/**
	 * Override method to output information about the sale
	 * All the data about sale collects in one line
	 * 
	 * @return String
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		final SimpleDateFormat formatOfDate = new SimpleDateFormat("dd.MM.yyyy");
		final String Space = " ";
		builder.append(idSale).append(Space).append(formatOfDate.format(dateOfSale)).append(Space)
				.append(idClient).append(Space).append(checkOfSale.keySet());
		return builder.toString();
	}
}
