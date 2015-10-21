package view;

import java.util.HashMap;
import java.util.Map;

import controllers.MethodsForClient;
import controllers.MethodsForDevice;
import controllers.MethodsForSale;
import controllers.Utilit;
import exception.ValidationException;
import history.*;

public class ConsolHelper {
	static HistoryClient historyOfClient = new HistoryClient();
	static HistoryDevice historyOfDevice = new HistoryDevice();
	static HistorySale historyOfSale = new HistorySale();
	
	/**
	 * display a basic command list
	 */
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
		System.out.println("	searchOnListDevice - for finding information about Device");
		System.out.println("	searchOnListSale - for finding information about Sale");
		System.out.println("	showListClient - show list of clients");
		System.out.println("	showListDevice - show list of devices");
		System.out.println("	showListSale - show list of sales");
		System.out.println("	exit - end of work");
	}
	/**
	 * basic command list
	 */
	public static void comand () {
		while (true) {
			System.out.println("Enter comad:");

			switch (Utilit.IN.next()) {

			case "createClient": 
					System.out.println("Enter Last Name, First Name, Middle Name and date " + "of Birthday in "
						+ "format dd.mm.yyyy:");
				String last = Utilit.IN.next();
				String first = Utilit.IN.next();
				String middle = Utilit.IN.next();
				String dateBirth = Utilit.IN.next();
				Utilit.VALID.isValidDate(dateBirth);
				DeviceStore.getDeviceStore().addClient(last, first, middle, Utilit.VALID.getDate());
				break;
			case "createDevice": 
				System.out.println("Enter Code of Mark, Code of Type, Model, Code of Color,"
						+ " and Date of Produce in format dd.mm.yyyy:");
				String mark = Utilit.IN.next();
				String type = Utilit.IN.next();
				String model = Utilit.IN.next();
				String color = Utilit.IN.next();
				String date = Utilit.IN.next();
				Utilit.VALID.isValidDate(date);
				DeviceStore.getDeviceStore().addDevice(type, mark, model, java.awt.Color.getColor(color), Utilit.VALID.getDate());
				break;
			case "createSale": 
				System.out.println("Enter Date in format dd.mm.yyyy, IdClient and Numder "
						+ "of purchased device:");
				String dateSale = Utilit.IN.next();
				Utilit.VALID.isValidDate(dateSale);
				int idClient = Utilit.IN.nextInt();
				int number = Utilit.IN.nextInt();
				int idDevice;
				int count;
				Map<Integer, Integer> checkSale = new HashMap<Integer, Integer>();
				for (int i = 0; i < number; i++) {
					System.out.println("Enter IdDevice and Count:");
					idDevice = Utilit.IN.nextInt();
					if (Utilit.VALID.isValidDevice(idDevice, historyOfDevice)) { 
						count = Utilit.IN.nextInt(); 
						checkSale.put((idDevice - 1), count); 
					}
				}
				DeviceStore.getDeviceStore().addSale(Utilit.VALID.getDate(), idClient, checkSale);
				break;
			case "sortListClient": 
				comandSortClient();
				break;
			case "sortListDevice": 
				comandSortDevice();
				break;
			case "sortListSale": 
				DeviceStore.getDeviceStore().sortSalesByDate();
				break;
			case "searchOnListClient": 
				comandSearchClient();
				break;
			case "searchOnListDevice":
				comandSearchDevice();
				break;
			case "searchOnListSale":
				try {
					MethodsForSale.searchSaleByDate(historyOfSale);
				} catch (ValidationException e) {
					e.showError();
				}
				break;
			case "showListClient": 
				MethodsForClient.showListClient(historyOfClient);
				break;
			case "showListDevice": 
				MethodsForDevice.showListDevice(historyOfDevice);
				break;
			case "showListSale": 
				MethodsForSale.showListSale(historyOfSale);
				break;
			case "exit": 
				Utilit.IN.close();
				System.out.println("Bye! Bye!");
				System.exit(0);
				break;
			default: 
				System.out.println("ERROR. Unknown comand. Try again");
				break;
			}
		}
	}

	/**
	 * display command list for sort information about client
	 */
	private static void comandSortClient() {
		System.out.println("On what basis will sort (Date, LastName, FirstName, MiddeleName):");

		switch (Utilit.IN.next()) {
		case "Date":
			MethodsForClient.sortByDateClientList(historyOfClient);
			break;
		case "LastName":
			MethodsForClient.sortByLastNameClient(historyOfClient);
			break;
		case "FirstName":
			DeviceStore.getDeviceStore().sortClientsByName();;
			break;
		default: 
			System.out.println("ERROR. Unknown comand. Try again");
			break;	
	}
	}
	
	/**
	 * display command list for sort information about device
	 */
	private static void comandSortDevice() {
		System.out.println("On what basis will sort (Date, Type, Mark, Model, Color, Cost):");

		switch (Utilit.IN.next()) {
		case "Date":
			MethodsForDevice.sortByDateDeviceList(historyOfDevice);
			break;
		case "Type":
			MethodsForDevice.sortByTypeDeviceList(historyOfDevice);
			break;
		case "Mark":
			DeviceStore.getDeviceStore().sortDevicesByModel();;
			break;
		case "Model":
			MethodsForDevice.sortByModelDeviceList(historyOfDevice);
			break;
		case "Color":
			MethodsForDevice.sortByColorDeviceList(historyOfDevice);
			break;
		case "Cost":
			MethodsForDevice.sortByCostDeviceListAndShow(historyOfDevice);
			break;
		default: 
			System.out.println("ERROR. Unknown comand. Try again");
			break;
	}
	}
	
	/**
	 * display command list for search information about client
	 */
	private static void comandSearchClient() {
		System.out.println("On what basis will search (Date, LastName, LastFirstName, LastNameDate):");

		switch (Utilit.IN.next()) {
		case "Date":
			try {
				MethodsForClient.searchClientByDate(historyOfClient);
			} catch (ValidationException e) {
				e.showError();
			}
			break;
		case "FirstName":
			System.out.println("Enter Name:");
			String lastNameForSearch = Utilit.IN.next();
			DeviceStore.getDeviceStore().searchClientsByName(lastNameForSearch);
			break;
		case "LastFirstName":
			try {
				MethodsForClient.searchClientByLastFirstName(historyOfClient);
			} catch (ValidationException e) {
				e.showError();
			}
			break;
		case "LastNameDate":
			try {
				MethodsForClient.searchClientByLastNameDate(historyOfClient);
			} catch (ValidationException e) {
				e.showError();
			}
			break;
		default: 
			System.out.println("ERROR. Unknown comand. Try again");
			break;
		}
	}

	/**
	 * display command list for search information about device
	 */
	private static void comandSearchDevice() {
		System.out.println("On what basis will search (Date, Mark, Model, Type, Color, Cost,"
				+ " DateMark, ModelColor, MarkType, TypeCost):");
		
		switch (Utilit.IN.next()) {
		case "Date":
			System.out.println("Enter date:");
			String dataForSearch = Utilit.IN.next();
			Utilit.VALID.isValidDate(dataForSearch);
			DeviceStore.getDeviceStore().searchDevicesByIssueDate(Utilit.VALID.getDate());
			break;
		case "Mark":
			try {
				MethodsForDevice.searchDeviceByMark(historyOfDevice);
			} catch (ValidationException e) {
				e.showError();
			}
			break;
		case "Model":
			try {
				MethodsForDevice.searchDeviceByModel(historyOfDevice);
			} catch (ValidationException e) {
				e.showError();
			}
			break;
		case "Type":
			try {
				MethodsForDevice.searchDeviceByType(historyOfDevice);
			} catch (ValidationException e) {
				e.showError();
			}
			break;
		case "Color":
			try {
				MethodsForDevice.searchDeviceByColor(historyOfDevice);
			} catch (ValidationException e) {
				e.showError();
			}
			break;
		case "Cost":
			try {
				MethodsForDevice.searchDeviceByCost(historyOfDevice);
			} catch (ValidationException e) {
				e.showError();
			}
			break;
		case "DateMark":
			try {
				MethodsForDevice.searchDeviceByDateMark(historyOfDevice);
			} catch (ValidationException e) {
				e.showError();
			}
			break;
		case "ModelColor":
			try {
				MethodsForDevice.searchDeviceByModelColor(historyOfDevice);
			} catch (ValidationException e) {
				e.showError();
			}
			break;
		case "MarkType":
			try {
				MethodsForDevice.searchDeviceByMarkType(historyOfDevice);
			} catch (ValidationException e) {
				e.showError();
			}
			break;
		case "TypeCost":
			try {
				MethodsForDevice.searchDeviceByTypeCost(historyOfDevice);
			} catch (ValidationException e) {
				e.showError();
			}
			break;
		default: 
			System.out.println("ERROR. Unknown comand. Try again");
			break;
		}
	}
}
