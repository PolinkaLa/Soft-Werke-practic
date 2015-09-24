package controllers;

import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.Date;

/**
 * @author LappoPolina
 * класс содержит функции для проверки правильности вводимых данных
 */
public class Validation {
	private static SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy");
	private Date date;
	
	/**
	 * функция для валидации даты
	 * @param dateInString строка содержащая дату
	 */
	public void parsDate (String dateInString){
		try {
				this.date = format.parse(dateInString);
			} catch (ParseException e) {
				e.printStackTrace();
			}
	}
	/**
	 * свойство для получения даты
	 * @return Date 
	 */
	public Date getDate() {
		return (Date) date.clone();
	}
}
