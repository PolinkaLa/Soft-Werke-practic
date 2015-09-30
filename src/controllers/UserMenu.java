package controllers;

import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Collections;
import java.util.List;
import java.util.ArrayList;

import comparatorclient.*;
import comparatordevice.*;
import comparatorsale.*;
import history.AllHistory;
import model.Client;
import model.Color;
import model.Device;
import model.Mark;
import model.Sale;
import model.Type;

/**
 * @author LappoPolina
 * 
 *         Содержит функции для добавления новой записи о
 *         клиенте/устройстве/продаже Реализована возможность вывода данных н
 *         экран
 */
public class UserMenu {

	static SimpleDateFormat formatOfDate = new SimpleDateFormat("dd.MM.yyyy");
	static Scanner in = new Scanner(System.in);

	private static Validation valid = new Validation();

	public static void helpForUser() {
		System.out.println("Hi! You can create new Client, new Device, new Sale!");
		System.out.println("So you can sort and search lists");
		System.out.println("Comand:");
		System.out.println("	createCleint -  add new Client");
		System.out.println("	createDevice - add new Device");
		System.out.println("	createSale - add new Sale");
		System.out.println("	sortListClient - sorting list of Client");
		System.out.println("	sortListDevice - sorting list of Device");
		System.out.println("	sortListSale - sorting list of Sale");
		System.out.println("	searchOnListClient - for finding information about Client");
		System.out.println("	showListClient - show list of clients");
		System.out.println("	showListDevice - show list of devices");
		System.out.println("	showListSale - show list of sales");
		System.out.println("	exit - end of work");
	}

	/**
	 * функция для добавления новой записи о клиенте
	 * 
	 * @param historyOfAllNotes
	 *            передаются списки кликтов, устройств, продаж
	 */
	public static void createClient(AllHistory historyOfAllNotes) {
		System.out.println("Enter Last Name, First Name, Middle Name and date " + "of Birthday in format dd.mm.yyyy:");
		String last = in.next();
		String first = in.next();
		String middle = in.next();
		String dateBirth = in.next();
		if (valid.isValidName(first) & valid.isValidName(last) & valid.isValidName(middle)
				& valid.isValidDate(dateBirth)) {
			historyOfAllNotes.addClients(new Client(last, first, middle, valid.getDate()));
			System.out.println("Client create successfully.");
		} else
			System.out.println("ERROR! Сannot create a record from Client, verify the accuracy of information entry");
	}

	/**
	 * функция для добавления новой записи об устройстве
	 * 
	 * @param historyOfAllNotes
	 *            передаются списки кликтов, устройств, продаж
	 */
	public static void createDevice(AllHistory historyOfAllNotes) {
		System.out.println("Enter Code of Mark, Code of Type, Model, Code of Color,"
				+ " Cost and Date of Produce in format dd.mm.yyyy:");

		System.out.println("Code of Mark:");
		for (int i = 0; i < Mark.values().length; i++)
			System.out.println("	" + i + " - " + Mark.values()[i]); // вывод
																		// кодов
																		// марок

		System.out.println("Code of Type:");
		for (int i = 0; i < Type.values().length; i++)
			System.out.println("	" + i + " - " + Type.values()[i]); // вывод
																		// кодов
																		// типов

		System.out.println("Code of Color:");
		for (int i = 0; i < Color.values().length; i++)
			System.out.println("	" + i + " - " + Color.values()[i]); // вывод
																		// кодов
																		// цветов

		int mark = in.nextInt();
		int type = in.nextInt();
		String model = in.next();
		int color = in.nextInt();
		String cos = in.next();
		String date = in.next();
		if (valid.isValidMark(mark) & valid.isValidType(type) & valid.isValidColor(color) & valid.isValidCost(cos)
				& valid.isValidDate(date)) {
			historyOfAllNotes.addDevices(new Device(Mark.values()[mark], Type.values()[type],
					model, Color.values()[color], valid.getCost(), valid.getDate())); // добавление
																									// нового
																									// устройства
			System.out.println("Device create successfully.");
		} else
			System.out.println("ERROR! Сannot create a record from Device, verify the accuracy of information entry");
	}

	/**
	 * функция для добавления новой записи о продаже
	 * 
	 * @param historyOfAllNotes
	 *            передаются списки кликтов, устройств, продаж
	 */
	public static void createSale(AllHistory historyOfAllNotes) {
		System.out.println("Enter Date in format dd.mm.yyyy, IdClient and Numder of purchased device:");
		String dateSale = in.next();
		valid.isValidDate(dateSale);
		int idClient = in.nextInt();
		int number = in.nextInt();
		int idDevice;
		int count;
		if (valid.isValidClient(idClient, historyOfAllNotes)) { // если
																// пользователь
																// с таким
																// айдишником
																// существует,
																// то.....
			Map<Device, Integer> checkSale = new HashMap<Device, Integer>();
			for (int i = 0; i < number; i++) {
				System.out.println("Enter IdDevice and Count:");
				idDevice = in.nextInt();
				if (valid.isValidDevice(idDevice, historyOfAllNotes)) { // если
																		// есть
																		// устройство
																		// с
																		// таким
																		// айди
																		// существует
					count = in.nextInt(); // считываем его количество
					checkSale.put(historyOfAllNotes.getDevices().get(idDevice - 1), count); // и
																							// добавляем
																							// в
																							// чек
				} else
					System.out.println(
							"ERROR! Сannot create a record from Sale, verify the accuracy of information entry");
			}
			historyOfAllNotes
					.addSales(new Sale(valid.getDate(), historyOfAllNotes.getClients().get(idClient - 1), checkSale));// новая
																														// запись
																														// о
																														// продаже
			System.out.println("Sale create successfully.");
		} else
			System.out.println("ERROR! Сannot create a record from Sale, verify the accuracy of information entry");

	}

	/**
	 * функция для вывода на экран списка клиентов
	 * 
	 * @param historyOfAllNotes
	 *            передаются списки клиентов, устройств, продаж
	 */
	public static void showListClient(AllHistory historyOfAllNotes) {
		for (int i = 0; i < historyOfAllNotes.getClients().size(); i++)
			System.out.println(historyOfAllNotes.getClients().get(i).toString());
	}

	/**
	 * функция для вывода на экран списка устройст
	 * 
	 * @param historyOfAllNotes
	 *            передаются списки клиентов, устройств, продаж
	 */
	public static void showListDevice(AllHistory historyOfAllNotes) {
		for (int i = 0; i < historyOfAllNotes.getDevices().size(); i++)
			System.out.println(historyOfAllNotes.getDevices().get(i).toString());
	}

	/**
	 * Функция для вывода на экран списка продаж
	 * 
	 * @param historyOfAllNotes
	 *            передаются списки клиентов, устройств, продаж
	 */
	public static void showListSale(AllHistory historyOfAllNotes) {
		for (int i = 0; i < historyOfAllNotes.getSales().size(); i++)
			System.out.println(historyOfAllNotes.getSales().get(i).toString());
	}

	/**
	 * функция для сортировки списка клиентов по дате и вывода его на экран
	 * 
	 * @param historyOfAllNotes
	 *            коллекция со списком клиентов
	 */
	public static void compareClientDate(AllHistory historyOfAllNotes) {
		ComparatorClientDate comparatorDate = new ComparatorClientDate();
		Collections.sort(historyOfAllNotes.getClients(), comparatorDate);
		showListClient(historyOfAllNotes);
	}

	/**
	 * функция для сортировки списка клиентов по фамилии и вывод его на экран
	 * 
	 * @param historyOfAllNotes
	 *            коллекция по списком клиентов
	 */
	public static void compareClientLastName(AllHistory historyOfAllNotes) {
		ComparatorClientLastName comparatorLastName = new ComparatorClientLastName();
		Collections.sort(historyOfAllNotes.getClients(), comparatorLastName);
		showListClient(historyOfAllNotes);
	}

	/**
	 * Функция для сортировки списка клиентов по имени и вывод его на экран
	 * 
	 * @param historyOfAllNotes
	 *            коллекция со списком клиентов
	 */
	public static void compareClientFirstName(AllHistory historyOfAllNotes) {
		ComparatorClientFirstName comparatorFirstName = new ComparatorClientFirstName();
		Collections.sort(historyOfAllNotes.getClients(), comparatorFirstName);
		showListClient(historyOfAllNotes);
	}

	/**
	 * Функция для сортировки списка клиентов по отвечтву и вывод его на экран
	 * 
	 * @param historyOfAllNotes
	 *            коллекция со списком клиентов
	 */
	public static void compareClientMiddleName(AllHistory historyOfAllNotes) {
		ComparatorClientMiddleName comparatorMiddleName = new ComparatorClientMiddleName();
		Collections.sort(historyOfAllNotes.getClients(), comparatorMiddleName);
		showListClient(historyOfAllNotes);
	}

	/**
	 * функция для сортировки списка устройств по дате производства и вывод его
	 * на экран
	 * 
	 * @param historyOfAllNotes
	 *            коллекция со списком устройств
	 */
	public static void compareDeviceData(AllHistory historyOfAllNotes) {
		ComparatorDeviceDate comparatorDeviceDate = new ComparatorDeviceDate();
		Collections.sort(historyOfAllNotes.getDevices(), comparatorDeviceDate);
		showListDevice(historyOfAllNotes);
	}

	/**
	 * функция для сортировки списка устройств по марке и вывод его на экран
	 * 
	 * @param historyOfAllNotes
	 *            коллекция со списком устройств
	 */
	public static void compareDeviceMark(AllHistory historyOfAllNotes) {
		ComparatorDeviceMark comparatorDeviceMark = new ComparatorDeviceMark();
		Collections.sort(historyOfAllNotes.getDevices(), comparatorDeviceMark);
		showListDevice(historyOfAllNotes);
	}

	/**
	 * функция для сортировки списка устройств по модели и вывод его на экран
	 * 
	 * @param historyOfAllNotes
	 *            коллекция со списком устройств
	 */
	public static void compareDeviceModel(AllHistory historyOfAllNotes) {
		ComparatorDeviceModel comparatorDeviceModel = new ComparatorDeviceModel();
		Collections.sort(historyOfAllNotes.getDevices(), comparatorDeviceModel);
		showListDevice(historyOfAllNotes);
	}

	/**
	 * функция для сортировки списка устройств по цвету и вывод его на экран
	 * 
	 * @param historyOfAllNotes
	 *            коллекция со списком устройств
	 */
	public static void compareDeviceColor(AllHistory historyOfAllNotes) {
		ComparatorDeviceColor comparatorDeviceColor = new ComparatorDeviceColor();
		Collections.sort(historyOfAllNotes.getDevices(), comparatorDeviceColor);
		showListDevice(historyOfAllNotes);
	}

	/**
	 * функция для сортировки списка устройств по типу и вывод его на экран
	 * 
	 * @param historyOfAllNotes
	 *            коллекция со списком устройств
	 */
	public static void compareDeviceType(AllHistory historyOfAllNotes) {
		ComparatorDeviceType comparatorDeviceType = new ComparatorDeviceType();
		Collections.sort(historyOfAllNotes.getDevices(), comparatorDeviceType);
		showListDevice(historyOfAllNotes);
	}

	/**
	 * функция для сортировки списка устройст по цене и вывод его на экран
	 * 
	 * @param historyOfAllNotes
	 *            коллекция со списком устройств
	 */
	public static void compareDeviceCost(AllHistory historyOfAllNotes) {
		ComparatorDeviceCost comparatorDeviceCost = new ComparatorDeviceCost();
		Collections.sort(historyOfAllNotes.getDevices(), comparatorDeviceCost);
		showListDevice(historyOfAllNotes);
	}

	/**
	 * функция для сортировки списка продаж по дате продажи и вывод его на экран
	 * 
	 * @param historyOfAllNotes
	 *            коллекция со списком продаж
	 */
	public static void compareSaleDate(AllHistory historyOfAllNotes) {
		ComparatorSaleDate comparatorSaleDate = new ComparatorSaleDate();
		Collections.sort(historyOfAllNotes.getDevices(), comparatorSaleDate);
		showListDevice(historyOfAllNotes);
	}

	/**
	 * Функция для поиска клиента по введенной дате рождения и вывод списка
	 * найденны клиентов на экран
	 * 
	 * @param historyOfAllNotes
	 *            коллекция со списком клиентов
	 */
	public static void searchClientDate(AllHistory historyOfAllNotes) {
		System.out.println("Enter date:");
		String dataForSearch = in.next();
		List<Client> resultOfSearch = new ArrayList<>();
		if (valid.isValidDate(dataForSearch)) {
			for (int i = 0; i < historyOfAllNotes.getClients().size(); i++) {
				if (historyOfAllNotes.getClients().get(i).getDateOfBirth().equals(valid.getDate())) {
					resultOfSearch.add(historyOfAllNotes.getClients().get(i));
				}
			}
			if (resultOfSearch.size() > 0) {
				for (int i = 0; i < resultOfSearch.size(); i++)
					System.out.println(resultOfSearch.get(i).toString());
			} else
				System.out.println("We can't find necessary records");
		} else
			System.out.println("ERROR! You enter wrong date!");
	}

	/**
	 * Функция для поиска клиента по введенной фамилии и вывод списка найденных
	 * клиентов на экран
	 * 
	 * @param historyOfAllNotes
	 *            коллекция со списком клиентов
	 */
	public static void searchClientLastName(AllHistory historyOfAllNotes) {
		System.out.println("Enter Last Name:");
		String lastNameForSearch = in.next();
		List<Client> resultOfSearch = new ArrayList<>();
		if (valid.isValidName(lastNameForSearch)) {
			for (int i = 0; i < historyOfAllNotes.getClients().size(); i++) {
				if (historyOfAllNotes.getClients().get(i).getLastName().equals(lastNameForSearch)) {
					resultOfSearch.add(historyOfAllNotes.getClients().get(i));
				}
			}
			if (resultOfSearch.size() > 0) {
				for (int i = 0; i < resultOfSearch.size(); i++)
					System.out.println(resultOfSearch.get(i).toString());
			} else
				System.out.println("We can't find necessary records");
		} else
			System.out.println("ERROR! You enter wrong Last Name!");
	}

	/**
	 * функция для поиска клинета по введеным фамилии и имени и вывод найденного
	 * списка на экран
	 * 
	 * @param historyOfAllNotes
	 */
	public static void searchClientLastFirstName(AllHistory historyOfAllNotes) {
		System.out.println("Enter Last Name:");
		String lastNameForSearch = in.next();
		System.out.println("Enter First Name:");
		String firstNameForSearch = in.next();
		List<Client> resultOfSearch = new ArrayList<>();
		if (valid.isValidName(lastNameForSearch) & valid.isValidName(firstNameForSearch)) {
			for (int i = 0; i < historyOfAllNotes.getClients().size(); i++) {
				if (historyOfAllNotes.getClients().get(i).getLastName().equals(lastNameForSearch)
						& historyOfAllNotes.getClients().get(i).getFirstName().equals(firstNameForSearch)) {
					resultOfSearch.add(historyOfAllNotes.getClients().get(i));
				}
			}
			if (resultOfSearch.size() > 0) {
				for (int i = 0; i < resultOfSearch.size(); i++)
					System.out.println(resultOfSearch.get(i).toString());
			} else
				System.out.println("We can't find necessary records");
		} else
			System.out.println("ERROR! You enter wrong Last Name!");
	}
}
