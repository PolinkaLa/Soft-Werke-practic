package controllers;

import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import history.AllHistory;


/**
 * @author LappoPolina
 * класс содержит функции для проверки правильности вводимых данных
 */
public class Validation {
	private static SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy");
	private Date date;
	private double cost;
	private int color;
	private int type;
	private int mark;
	
	/**
	 * функция для валидации даты
	 * @param dateInString строка содержащая дату
	 * @return true, если дата соответствует заданой маске, false в противном случае
	 */
	public boolean isValidDate (String dateInString){
		Pattern patternForDate = Pattern.compile("(0[1-9]|[12][0-9]|3[01])[- /.](0[1-9]|1[012])[- /.](19|20)");
		Matcher matcherForDate = patternForDate.matcher(dateInString); 
		
		try {
				this.date = format.parse(dateInString);
			} catch (ParseException e) {
				System.out.println("ERROR! You enter Вate in the wrong format! Please try again!");
				//e.printStackTrace();
			}
		return  matcherForDate.matches();
	}
	
	/**
	 * Функция для валидации ввода фамилии
	 * @param lastName фамилия клиента
	 * @return true, если фамилия соответствует заданой маске, false в противном случае
	 */
	public boolean isValidLastName(String lastName) {
		Pattern patternForLastName = Pattern.compile("^[A-Z]{1}+[a-z]+");
		Matcher matcherForLastName = patternForLastName.matcher(lastName); 
		return  matcherForLastName.matches();
	}
	/**
	 * функция для валидации ввода имени
	 * @param firstName имя клиента
	 * @return true, если имя соответствует заданой маске, false в противном случае
	 */
	public boolean isValidFirstName(String firstName) {
		Pattern patternForFirstName = Pattern.compile("^[A-Z]{1}+[a-z]+");
		Matcher matcherForFirstName = patternForFirstName.matcher(firstName); 
		return  matcherForFirstName.matches();
	}
	/**
	 * функция для валидации ввода отчества
	 * @param middleName отчества клиента
	 * @return true, если отчество соответствует заданой маске, false в противном случае
	 */
	public boolean isValidMiddleName(String middleName) {
		Pattern patternForMiddleName = Pattern.compile("^[A-Z]{1}+[a-z]+");
		Matcher matcherForMiddleName = patternForMiddleName.matcher(middleName); 
		return  matcherForMiddleName.matches();
	}
	/**
	 * функция для валидации ввода кода марки
	 * @param mark строка с кодом марки 
	 * если валидация прошла успешно, преобразуем строку в int
	 * @return true, если соответствует заданой маске, false в противном случае
	 */
	public boolean isValidMark(String mark){
		Pattern patternForMark = Pattern.compile("[0-4]{1}");
		Matcher matcherForMark = patternForMark.matcher(mark);
		if (matcherForMark.matches())
			this.mark = Integer.parseInt(mark);
		return  matcherForMark.matches();
	}
	/**
	 * цункция для валидации ввода кода типа устройства
	 * @param type строка с кодом типа усройства
	 * если валидация прошла успешно, преобразуем строку в int
	 * @return true, если соответствует заданой маске, false в противном случае
	 */
	public boolean isValidType(String type){
		Pattern patternForType = Pattern.compile("[0-3]{1}");
		Matcher matcherForType = patternForType.matcher(type);
		if (matcherForType.matches())
			this.type = Integer.parseInt(type);
		return  matcherForType.matches();
	}
	/**
	 * функция для валидации кода цвета
	 * @param color строка с кодом цвета
	 * если валидация прошла успешно, преобразуем строку в int
	 * @return true, если соответствует заданой маске, false в противном случае
	 */
	public boolean isValidColor(String color){
		Pattern patternForColor = Pattern.compile("[0-6]{1}");
		Matcher matcherForColor = patternForColor.matcher(color);
		if (matcherForColor.matches())
			this.color = Integer.parseInt(color);
		return  matcherForColor.matches();
	}
	/**
	 * функция для валидации ввода цены 
	 * @param cost строка со стоимостью устройсва
	 * если валидация прошла успешно, преобразуем строку в double
	 * @return true, если соответствует заданой маске, false в противном случае
	 */
	public boolean isValidCost(String cost) {
		Pattern patternForCost= Pattern.compile("^[1-9]\\d*?(\\.\\d{1,2})?$");
		Matcher matcherForCost = patternForCost.matcher(cost);
		if (matcherForCost.matches()) 
			this.cost = Double.parseDouble(cost);
		return  matcherForCost.matches();
	}
	/**
	 * функция для проверки существования клиента с таким Id 
	 * @param idClient уникальный номер клиента
	 * @param historyOfAllNotes коллекция со списком клиентов
	 * @return true, если клиент с таким Id есть в списке, false в противном случае
	 */
	public boolean isValidClient(int idClient, AllHistory historyOfAllNotes) {
		if (historyOfAllNotes.getClients().size() > idClient )
			return true;
		else 
			return false;
	}
	/**
	 * функция для проверки существования устройства с таким Id
	 * @param idDevice уникальный номер устройства
	 * @param historyOfAllNotes коллекция со списком устройств
	 * @return true, если устройство с таким Id есть в списке, false в противном случае
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
