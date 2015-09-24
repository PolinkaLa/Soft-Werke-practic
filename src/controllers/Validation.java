package controllers;

import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.Date;

/**
 * @author LappoPolina
 * ����� �������� ������� ��� �������� ������������ �������� ������
 */
public class Validation {
	private static SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy");
	private Date date;
	
	/**
	 * ������� ��� ��������� ����
	 * @param dateInString ������ ���������� ����
	 */
	public void parsDate (String dateInString){
		try {
				this.date = format.parse(dateInString);
			} catch (ParseException e) {
				e.printStackTrace();
			}
	}
	/**
	 * �������� ��� ��������� ����
	 * @return Date 
	 */
	public Date getDate() {
		return (Date) date.clone();
	}
}
