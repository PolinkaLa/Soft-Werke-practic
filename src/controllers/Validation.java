package controllers;

import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import history.AllHistory;


/**
 * @author LappoPolina
 * ����� �������� ������� ��� �������� ������������ �������� ������
 */
public class Validation {
	private static SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy");
	private Date date;
	private double cost;
	private int color;
	private int type;
	private int mark;
	
	/**
	 * ������� ��� ��������� ����
	 * @param dateInString ������ ���������� ����
	 * @return true, ���� ���� ������������� ������� �����, false � ��������� ������
	 */
	public boolean isValidDate (String dateInString){
		Pattern patternForDate = Pattern.compile("(0[1-9]|[12][0-9]|3[01])[- /.](0[1-9]|1[012])[- /.](19|20)");
		Matcher matcherForDate = patternForDate.matcher(dateInString); 
		
		try {
				this.date = format.parse(dateInString);
			} catch (ParseException e) {
				System.out.println("ERROR! You enter �ate in the wrong format! Please try again!");
				//e.printStackTrace();
			}
		return  matcherForDate.matches();
	}
	
	/**
	 * ������� ��� ��������� ����� �������
	 * @param lastName ������� �������
	 * @return true, ���� ������� ������������� ������� �����, false � ��������� ������
	 */
	public boolean isValidLastName(String lastName) {
		Pattern patternForLastName = Pattern.compile("^[A-Z]{1}+[a-z]+");
		Matcher matcherForLastName = patternForLastName.matcher(lastName); 
		return  matcherForLastName.matches();
	}
	/**
	 * ������� ��� ��������� ����� �����
	 * @param firstName ��� �������
	 * @return true, ���� ��� ������������� ������� �����, false � ��������� ������
	 */
	public boolean isValidFirstName(String firstName) {
		Pattern patternForFirstName = Pattern.compile("^[A-Z]{1}+[a-z]+");
		Matcher matcherForFirstName = patternForFirstName.matcher(firstName); 
		return  matcherForFirstName.matches();
	}
	/**
	 * ������� ��� ��������� ����� ��������
	 * @param middleName �������� �������
	 * @return true, ���� �������� ������������� ������� �����, false � ��������� ������
	 */
	public boolean isValidMiddleName(String middleName) {
		Pattern patternForMiddleName = Pattern.compile("^[A-Z]{1}+[a-z]+");
		Matcher matcherForMiddleName = patternForMiddleName.matcher(middleName); 
		return  matcherForMiddleName.matches();
	}
	/**
	 * ������� ��� ��������� ����� ���� �����
	 * @param mark ������ � ����� ����� 
	 * ���� ��������� ������ �������, ����������� ������ � int
	 * @return true, ���� ������������� ������� �����, false � ��������� ������
	 */
	public boolean isValidMark(String mark){
		Pattern patternForMark = Pattern.compile("[0-4]{1}");
		Matcher matcherForMark = patternForMark.matcher(mark);
		if (matcherForMark.matches())
			this.mark = Integer.parseInt(mark);
		return  matcherForMark.matches();
	}
	/**
	 * ������� ��� ��������� ����� ���� ���� ����������
	 * @param type ������ � ����� ���� ���������
	 * ���� ��������� ������ �������, ����������� ������ � int
	 * @return true, ���� ������������� ������� �����, false � ��������� ������
	 */
	public boolean isValidType(String type){
		Pattern patternForType = Pattern.compile("[0-3]{1}");
		Matcher matcherForType = patternForType.matcher(type);
		if (matcherForType.matches())
			this.type = Integer.parseInt(type);
		return  matcherForType.matches();
	}
	/**
	 * ������� ��� ��������� ���� �����
	 * @param color ������ � ����� �����
	 * ���� ��������� ������ �������, ����������� ������ � int
	 * @return true, ���� ������������� ������� �����, false � ��������� ������
	 */
	public boolean isValidColor(String color){
		Pattern patternForColor = Pattern.compile("[0-6]{1}");
		Matcher matcherForColor = patternForColor.matcher(color);
		if (matcherForColor.matches())
			this.color = Integer.parseInt(color);
		return  matcherForColor.matches();
	}
	/**
	 * ������� ��� ��������� ����� ���� 
	 * @param cost ������ �� ���������� ���������
	 * ���� ��������� ������ �������, ����������� ������ � double
	 * @return true, ���� ������������� ������� �����, false � ��������� ������
	 */
	public boolean isValidCost(String cost) {
		Pattern patternForCost= Pattern.compile("^[1-9]\\d*?(\\.\\d{1,2})?$");
		Matcher matcherForCost = patternForCost.matcher(cost);
		if (matcherForCost.matches()) 
			this.cost = Double.parseDouble(cost);
		return  matcherForCost.matches();
	}
	/**
	 * ������� ��� �������� ������������� ������� � ����� Id 
	 * @param idClient ���������� ����� �������
	 * @param historyOfAllNotes ��������� �� ������� ��������
	 * @return true, ���� ������ � ����� Id ���� � ������, false � ��������� ������
	 */
	public boolean isValidClient(int idClient, AllHistory historyOfAllNotes) {
		if (historyOfAllNotes.getClients().size() > idClient )
			return true;
		else 
			return false;
	}
	/**
	 * ������� ��� �������� ������������� ���������� � ����� Id
	 * @param idDevice ���������� ����� ����������
	 * @param historyOfAllNotes ��������� �� ������� ���������
	 * @return true, ���� ���������� � ����� Id ���� � ������, false � ��������� ������
	 */
	public boolean isValidDevice(int idDevice, AllHistory historyOfAllNotes) {
		if (historyOfAllNotes.getDevices().size() > idDevice )
			return true;
		else 
			return false;
	}
	
	public Date getDate() {
		return (Date) date.clone();
	}
	public double getCost() {
		return cost;
	}
	public int getColor() {
		return color;
	}
	public int getType() {
		return type;
	}
	public int getMark() {
		return mark;
	}
}
