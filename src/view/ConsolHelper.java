package view;

import java.util.Scanner;
import controllers.MethodsForClient;
import controllers.MethodsForDevice;
import controllers.MethodsForSale;
import history.*;

public class ConsolHelper {
	private static Scanner in = new Scanner(System.in);
	private static HistoryClient historyOfClient = new HistoryClient();
	private static HistoryDevice historyOfDevice = new HistoryDevice();
	private static HistorySale historyOfSale = new HistorySale();
	
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

			switch (in.next()) {

			case "createClient": 
				MethodsForClient.createClient(historyOfClient);
				break;
			case "createDevice": 
				MethodsForDevice.createDevice(historyOfDevice);
				break;
			case "createSale": 
				MethodsForSale.createSale(historyOfSale, historyOfClient, historyOfDevice);
				break;
			case "sortListClient": 
				comandSortClient();
				break;
			case "sortListDevice": 
				comandSortDevice();
				break;
			case "sortListSale": 
				MethodsForSale.sortByDateSaleList(historyOfSale);
				break;
			case "searchOnListClient": 
				comandSearchClient();
				break;
			case "searchOnListDevice":
				comandSearchDevice();
				break;
			case "searchOnListSale":
				MethodsForSale.searchSaleByDate(historyOfSale);
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
				in.close();
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
	public static void comandSortClient() {
		System.out.println("On what basis will sort (Date, LastName, FirstName, MiddeleName):");

		switch (in.next()) {
		case "Date":
			MethodsForClient.sortByDateClientList(historyOfClient);
			break;
		case "LastName":
			MethodsForClient.sortByLastNameClient(historyOfClient);
			break;
		case "FirstName":
			MethodsForClient.sortByFirtsNameClientList(historyOfClient);
			break;
		default: 
			System.out.println("ERROR. Unknown comand. Try again");
			break;	
	}
	}
	
	/**
	 * display command list for sort information about device
	 */
	public static void comandSortDevice() {
		System.out.println("On what basis will sort (Date, Type, Mark, Model, Color, Cost):");

		switch (in.next()) {
		case "Date":
			MethodsForDevice.sortByDateDeviceList(historyOfDevice);
			break;
		case "Type":
			MethodsForDevice.sortByTypeDeviceList(historyOfDevice);
			break;
		case "Mark":
			MethodsForDevice.sortByMarkDeviceList(historyOfDevice);
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
	public static void comandSearchClient() {
		System.out.println("On what basis will search (Date, LastName, LastFirstName, LastNameDate):");

		switch (in.next()) {
		case "Date":
			MethodsForClient.searchClientByDate(historyOfClient);
			break;
		case "LastName":
			MethodsForClient.searchClientByLastName(historyOfClient);
			break;
		case "LastFirstName":
			MethodsForClient.searchClientByLastFirstName(historyOfClient);
			break;
		case "LastNameDate":
			MethodsForClient.searchClientByLastNameDate(historyOfClient);
			break;
		default: 
			System.out.println("ERROR. Unknown comand. Try again");
			break;
		}
	}

	/**
	 * display command list for search information about device
	 */
	public static void comandSearchDevice() {
		System.out.println("On what basis will search (Date, Mark, Model, Type, Color, Cost,"
				+ " DateMark, ModelColor, MarkType, TypeCost):");
		
		switch (in.next()) {
		case "Date":
			MethodsForDevice.searchDeviceByDate(historyOfDevice);
			break;
		case "Mark":
			MethodsForDevice.searchDeviceByMark(historyOfDevice);
			break;
		case "Model":
			MethodsForDevice.searchDeviceByModel(historyOfDevice);
			break;
		case "Type":
			MethodsForDevice.searchDeviceByType(historyOfDevice);
			break;
		case "Color":
			MethodsForDevice.searchDeviceByColor(historyOfDevice);
			break;
		case "Cost":
			MethodsForDevice.searchDeviceByCost(historyOfDevice);
			break;
		case "DateMark":
			MethodsForDevice.searchDeviceByDateMark(historyOfDevice);
			break;
		case "ModelColor":
			MethodsForDevice.searchDeviceByModelColor(historyOfDevice);
			break;
		case "MarkType":
			MethodsForDevice.searchDeviceByMarkType(historyOfDevice);
			break;
		case "TypeCost":
			MethodsForDevice.searchDeviceByTypeCost(historyOfDevice);
			break;
		default: 
			System.out.println("ERROR. Unknown comand. Try again");
			break;
		}
	}
}
