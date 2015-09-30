package controllers;

import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import history.AllHistory;
import model.*;


/**
 * @author LappoPolina класс содержит функции для проверки правильности вводимых
 *         данных
 */
public class Validation {
	private static SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy");
	private Date date;
	private double cost;

	/**
	 * функция для валидации даты
	 * 
	 * @param dateInString
	 *            строка содержащая дату
	 * @return true, если дата соответствует заданой маске, false в противном
	 *         случае
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
	 * Функция для валидации ввода фамилии
	 * 
	 * @param lastName
	 *            фамилия клиента
	 * @return true, если фамилия соответствует заданой маске, false в противном
	 *         случае
	 */
	public boolean isValidName(String name) {
		Pattern patternForName = Pattern.compile("^[A-Z]{1}+[a-z]+$");
		Matcher matcherForName = patternForName.matcher(name);
		return matcherForName.matches();
	}

	/**
	 * функция для валидации ввода кода марки
	 * 
	 * @param mark
	 *            строка с кодом марки 
	 * @return true, если соответствует заданному диапазону, false в противном случае
	 */
	public boolean isValidMark(int mark) {
		if ((mark >= 0) & (mark < Mark.values().length)) {
			return true;
		}
		return false;
	}

	/**
	 * цункция для валидации ввода кода типа устройства
	 * 
	 * @param type
	 *            строка с кодом типа усройства 
	 * @return true, если соответствует заданному диапазону, false в противном случае
	 */
	public boolean isValidType(int type) {
		if ((type >= 0) & (type < Type.values().length)) {
			return true;
		}
		return false;
	}

	/**
	 * функция для валидации кода цвета
	 * 
	 * @param color
	 *            строка с кодом цвета 
	 * @return true, если соответствует заданному диапазону, false в противном случае
	 */
	public boolean isValidColor(int color) {
		if ((color >= 0) & (color < Color.values().length)) {
			return true;
		}
		return false;
	}

	/**
	 * функция для валидации ввода цены
	 * 
	 * @param cost
	 *            строка со стоимостью устройсва если валидация прошла успешно,
	 *            преобразуем строку в double
	 * @return true, если соответствует заданой маске, false в противном случае
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
	 * функция для проверки существования клиента с таким Id
	 * 
	 * @param idClient
	 *            уникальный номер клиента
	 * @param historyOfAllNotes
	 *            коллекция со списком клиентов
	 * @return true, если клиент с таким Id есть в списке, false в противном
	 *         случае
	 */
	public boolean isValidClient(int idClient, AllHistory historyOfAllNotes) {
		if (historyOfAllNotes.getClients().size() > idClient) {
			return true;
		}
		return false;
	}

	/**
	 * функция для проверки существования устройства с таким Id
	 * 
	 * @param idDevice
	 *            уникальный номер устройства
	 * @param historyOfAllNotes
	 *            коллекция со списком устройств
	 * @return true, если устройство с таким Id есть в списке, false в противном
	 *         случае
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
