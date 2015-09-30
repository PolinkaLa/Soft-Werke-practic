package controllers;

import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import history.AllHistory;
import model.*;


/**
 * @author LappoPolina ����� �������� ������� ��� �������� ������������ ��������
 *         ������
 */
public class Validation {
	private static SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy");
	private Date date;
	private double cost;

	/**
	 * ������� ��� ��������� ����
	 * 
	 * @param dateInString
	 *            ������ ���������� ����
	 * @return true, ���� ���� ������������� ������� �����, false � ���������
	 *         ������
	 */
	public boolean isValidDate(String dateInString) {
		// Pattern patternForDate = Pattern.compile("(0[1-9]|[12][0-9]|3[01])[-
		// /.](0[1-9]|1[012])[- /.](19|20)");
		// Matcher matcherForDate = patternForDate.matcher(dateInString);
		boolean flag = false;
		try {
			this.date = format.parse(dateInString);
			flag = true;
		} catch (ParseException e) {
			System.out.println("ERROR! You enter Date in the wrong format! Please try again!");
			// e.printStackTrace();
		}
		return flag;
	}

	/**
	 * ������� ��� ��������� ����� �������
	 * 
	 * @param lastName
	 *            ������� �������
	 * @return true, ���� ������� ������������� ������� �����, false � ���������
	 *         ������
	 */
	public boolean isValidName(String name) {
		Pattern patternForName = Pattern.compile("^[A-Z]{1}+[a-z]+$");
		Matcher matcherForName = patternForName.matcher(name);
		return matcherForName.matches();
	}

	/**
	 * ������� ��� ��������� ����� ���� �����
	 * 
	 * @param mark
	 *            ������ � ����� ����� 
	 * @return true, ���� ������������� ��������� ���������, false � ��������� ������
	 */
	public boolean isValidMark(int mark) {
		if ((mark >= 0) & (mark < Mark.values().length)) {
			return true;
		}
		return false;
	}

	/**
	 * ������� ��� ��������� ����� ���� ���� ����������
	 * 
	 * @param type
	 *            ������ � ����� ���� ��������� 
	 * @return true, ���� ������������� ��������� ���������, false � ��������� ������
	 */
	public boolean isValidType(int type) {
		if ((type >= 0) & (type < Type.values().length)) {
			return true;
		}
		return false;
	}

	/**
	 * ������� ��� ��������� ���� �����
	 * 
	 * @param color
	 *            ������ � ����� ����� 
	 * @return true, ���� ������������� ��������� ���������, false � ��������� ������
	 */
	public boolean isValidColor(int color) {
		if ((color >= 0) & (color < Color.values().length)) {
			return true;
		}
		return false;
	}

	/**
	 * ������� ��� ��������� ����� ����
	 * 
	 * @param cost
	 *            ������ �� ���������� ��������� ���� ��������� ������ �������,
	 *            ����������� ������ � double
	 * @return true, ���� ������������� ������� �����, false � ��������� ������
	 */
	public boolean isValidCost(String cost) {
		Pattern patternForCost = Pattern.compile("^[1-9]\\d*?(\\.\\d{1,2})?$");
		Matcher matcherForCost = patternForCost.matcher(cost);
		if (matcherForCost.matches()) {
			this.cost = Double.parseDouble(cost);
		}
		return matcherForCost.matches();
	}

	/**
	 * ������� ��� �������� ������������� ������� � ����� Id
	 * 
	 * @param idClient
	 *            ���������� ����� �������
	 * @param historyOfAllNotes
	 *            ��������� �� ������� ��������
	 * @return true, ���� ������ � ����� Id ���� � ������, false � ���������
	 *         ������
	 */
	public boolean isValidClient(int idClient, AllHistory historyOfAllNotes) {
		if (historyOfAllNotes.getClients().size() > idClient) {
			return true;
		}
		return false;
	}

	/**
	 * ������� ��� �������� ������������� ���������� � ����� Id
	 * 
	 * @param idDevice
	 *            ���������� ����� ����������
	 * @param historyOfAllNotes
	 *            ��������� �� ������� ���������
	 * @return true, ���� ���������� � ����� Id ���� � ������, false � ���������
	 *         ������
	 */
	public boolean isValidDevice(int idDevice, AllHistory historyOfAllNotes) {
		if (historyOfAllNotes.getDevices().size() > idDevice) {
			return true;
		}
		return false;
	}

	public Date getDate() {
		return (Date) date.clone();
	}

	public double getCost() {
		return cost;
	}
}
