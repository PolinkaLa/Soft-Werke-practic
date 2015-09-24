package base;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author LappoPolina
 * 
 * ����� �������� �������� � �������: ���������� �����, �������� � �������, �������� � ���������� ����������� � �� ����������
 * ��� �� ������� �������� ��� ��������� � ��������� ��������� ����� ������
 * ������������� ����� toString() ��� ����, ��� �� �������� ������ � ������� � ���� ������,
 * 	��� ����������� ������ �� �����
 */
public class Sale {
	private static int nextUniquelD = 1;
	private int idSale;
	private Date dateOfSale;
	private Client client;
	private Map<Device, Integer> checkOfSale = new HashMap<Device, Integer>();
	
	/**
	 * ����������� ��� ������������� ���������� ������
	 * @param dateOfSale ���� �������
	 * @param client ������ ����������� �������
	 * @param checkOfSale ��������� ��������� � �� ����������
	 */
	public Sale(Date dateOfSale, Client client, Map<Device, Integer> checkOfSale){
		idSale = nextUniquelD++;
		this.dateOfSale = dateOfSale;
		this.client = client;
		this.checkOfSale = checkOfSale;
	}

	/**
	 * �������� ��� ��������� �������� Id �������
	 * @return int 
	 */
	public int getIdSale() {
		return idSale;
	}
	/**
	 * �������� ��� ��������� �������� ���� �������
	 * @return Date
	 */
	public Date getDateOfSale() {
		return (Date) dateOfSale.clone();
	}
	/**
	 * �������� ��� ��������� �������� ������ � �������, ����������� �������
	 * @return Client
	 */
	public Client getClient() {
		return client;
	}
	/**
	 * �������� ��� ��������� �������� �������� � ��������� ���������� � �� ����������
	 * @return Map
	 */
	public  Map<Device, Integer> getCheckOfSle() {
		return checkOfSale;
	}
	
	/**
	 * 	�������� ��� ������� �������� Id �������
	 * @param idSale ���������� ����� �������
	 */
	public final void setIdSale(int idSale) {
		this.idSale = idSale;
	}
	/**
	 * �������� ��� ������� �������� ���� �������
	 * @param dateOfSale ���� �������
	 */
	public final void setDateOfSale(Date dateOfSale) {
		this.dateOfSale = dateOfSale;
	}
	/**
	 * �������� ��� ������� �������� �������, ������������ �������
	 * @param client ������ � �������
	 */
	public final void setClient(Client client) {
		this.client = client;
	}
	/**
	 * �������� ��� ������� �������� ��������� ��������� � �� ����������
	 * @param checkOfSale ��������� ���������� � �� ����������
	 */
	public final void setCheckOfSale (Map<Device, Integer> checkOfSale) {
		this.checkOfSale = checkOfSale;
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
