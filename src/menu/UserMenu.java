package menu;

import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import base.Client;
import base.Device;
import base.Sale;
import enums.Color;
import enums.Mark;
import enums.Type;
import controllers.Validation;
import history.AllHistory;

/**
 * @author LappoPolina
 * 
 * Содержит функции для добавления новой записи о клиенте/устройстве/продаже
 * Реализована возможность вывода данных н экран
 */
public class UserMenu {
	
	static SimpleDateFormat formatOfDate = new SimpleDateFormat("dd.MM.yyyy"); 
	static Scanner in = new Scanner(System.in);
	
	private static Validation valid = new Validation();
	
	/**
	 * функция для добавления новой записи о клиенте
	 * @param historyOfAllNotes передаются списки кликтов, устройств, продаж
	 */
	public static void createClient(AllHistory historyOfAllNotes){
		System.out.println("Enter Last Name, First Name, Middle Name and date "
				+ "of Birthday in format dd.mm.yyyy:");
		String last = in.next();
		String first = in.next();
		String middle = in.next();
		String dateBirth =in.next();
		if (valid.isValidFirstName(first) & valid.isValidLastName(last) & valid.isValidMiddleName(middle)
				& valid.isValidDate(dateBirth) ) {
			historyOfAllNotes.setClients(new Client(last, first, middle, valid.getDate()));
			System.out.println("Client create successfully.");
		} 
		else 
			System.out.println("ERROR! Сannot create a record from Client, verify the accuracy of information entry");
	}
	
	/**
	 * функция для добавления новой записи об устройстве
	 * @param historyOfAllNotes передаются списки кликтов, устройств, продаж
	 */
	public static void createDevice(AllHistory historyOfAllNotes){
		System.out.println("Enter Code of Mark, Code of Type, Model, Code of Color,"
				+ " Cost and Date of Produce in format dd.mm.yyyy:");
		
		System.out.println("Code of Mark:");
		for (int i = 0; i < Mark.values().length; i++)
			System.out.println("	" + i + " - " + Mark.values()[i]); // вывод кодов марок
		
		System.out.println("Code of Type:");
		for (int i = 0; i < Type.values().length; i++)
			System.out.println("	" + i + " - " + Type.values()[i]); // вывод кодов типов
		
		System.out.println("Code of Color:");
		for (int i = 0; i < Color.values().length; i++)
			System.out.println("	" + i + " - " + Color.values()[i]); // вывод кодов цветов
		
		String mark = in.next();
		String type = in.next();
		String model = in.next();
		String color = in.next();
		String cos = in.next();
		String date = in.next();
		if (valid.isValidMark(mark) & valid.isValidType(type) & valid.isValidColor(color) &
				valid.isValidCost(cos) & valid.isValidDate(date) ) {
			historyOfAllNotes.setDevices(new Device(Mark.values()[valid.getMark()], Type.values()[valid.getType()],
					model, 	Color.values()[valid.getColor()], valid.getCost(), valid.getDate())); // добавление нового устройства
			System.out.println("Device create successfully.");
		}
		else 
			System.out.println("ERROR! Сannot create a record from Device, verify the accuracy of information entry");
	}
	
	/**
	 * функция для добавления новой записи о продаже
	 * @param historyOfAllNotes передаются списки кликтов, устройств, продаж
	 */
	public static void createSale(AllHistory historyOfAllNotes){
		System.out.println("Enter Date in format dd.mm.yyyy, IdClient and Numder of purchased device:");
		String dateSale = in.next();
		valid.isValidDate(dateSale);
		int idClient = in.nextInt();
		int number = in.nextInt();
		int idDevice;
		int count;
		if (valid.isValidClient(idClient, historyOfAllNotes)) {  // если пользователь с таким айдишником существует, то.....
			Map<Device, Integer> checkSale = new HashMap<Device, Integer>();
			for (int i = 0; i < number; i++){
				System.out.println("Enter IdDevice and Count:");
					idDevice = in.nextInt();
					if (valid.isValidDevice(idDevice, historyOfAllNotes)) { // если есть устройство с таким айди существует
						count = in.nextInt();								// считываем его количество
						checkSale.put(historyOfAllNotes.getDevices().get(idDevice-1), count); // и добавляем в чек
					}
					else 
						System.out.println("ERROR! Сannot create a record from Sale, verify the accuracy of information entry");
			}
			historyOfAllNotes.setSales(new Sale(valid.getDate(), historyOfAllNotes.getClients().get(idClient-1), checkSale) );// новая запись о продаже
			System.out.println("Sale create successfully.");
		 }
		else 
			System.out.println("ERROR! Сannot create a record from Sale, verify the accuracy of information entry");
		
	}
	
	/**
	 * функция для вывода на экран списка клиентов
	 * @param historyOfAllNotes передаются списки клиентов, устройств, продаж
	 */
	public static void showListClient(AllHistory historyOfAllNotes){
		for (int i = 0; i < historyOfAllNotes.getClients().size(); i++)
			System.out.println(historyOfAllNotes.getClients().get(i).toString());
	}
	
	/**
	 * функция для вывода на экран списка устройст
	 * @param historyOfAllNotes передаются списки клиентов, устройств, продаж
	 */
	public static void showListDevice(AllHistory historyOfAllNotes){
		for (int i = 0; i < historyOfAllNotes.getDevices().size(); i++)
			System.out.println(historyOfAllNotes.getDevices().get(i).toString());
	}
	
	/**
	 * Функция для вывода на экран списка списка продаж
	 * @param historyOfAllNotes передаются списки клиентов, устройств, продаж
	 */
	public static void showListSale(AllHistory historyOfAllNotes){
		for (int i = 0; i < historyOfAllNotes.getSales().size(); i++)
			System.out.println(historyOfAllNotes.getSales().get(i).toString());
	}
	

}
