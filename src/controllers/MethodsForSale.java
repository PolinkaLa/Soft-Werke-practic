package controllers;

import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
import history.*;
import model.Device;
import model.Sale;

/**
 * the class provides all necessary methods for working with records of sales
 * @author LappoPolina
 *
 */
public class MethodsForSale {

	static SimpleDateFormat formatOfDate = new SimpleDateFormat("dd.MM.yyyy");
	static Scanner in = new Scanner(System.in);
	private static Validation valid = new Validation();

	/**
	 * method for create a new record about sale on list of sale
	 * @param historySale list of sales
	 * @param historyClient list of clients
	 * @param historyDevice list of device
	 */
	public static void createSale(HistorySale historySale, HistoryClient historyClient, HistoryDevice historyDevice) {
		System.out.println("Enter Date in format dd.mm.yyyy, IdClient and Numder of purchased device:");
		String dateSale = in.next();
		valid.isValidDate(dateSale);
		int idClient = in.nextInt();
		int number = in.nextInt();
		int idDevice;
		int count;
		if (valid.isValidClient(idClient, historyClient)) { 
			Map<Device, Integer> checkSale = new HashMap<Device, Integer>();
			for (int i = 0; i < number; i++) {
				System.out.println("Enter IdDevice and Count:");
				idDevice = in.nextInt();
				if (valid.isValidDevice(idDevice, historyDevice)) { 
					count = in.nextInt(); 
					checkSale.put(historyDevice.getDevices().get(idDevice - 1), count); 
				} else
					System.out.println(
							"ERROR! Ñannot create a record from Sale, verify the accuracy of "
							+ "information entry");
			}
			historySale
					.addSales(new Sale(valid.getDate(), historyClient.getClients()
							.get(idClient - 1), checkSale));
			System.out.println("Sale create successfully.");
		} else
			System.out.println("ERROR! Ñannot create a record from Sale, verify the accuracy"
					+ " of information entry");

	}

	/**
	 * method for show all record of list of sales
	 * @param historySale list of sales
	 */
	public static void showListSale(HistorySale historySale) {
		for (int i = 0; i < historySale.getSales().size(); i++)
			System.out.println(historySale.getSales().get(i).toString());
	}
	
	/**
	 * method for sort list of sale by date
	 * @param historySale list of sales
	 */
	public static void sortByDateSaleList(HistorySale historySale) {
		ComparatorSaleDate comparatorSaleDate = new ComparatorSaleDate();
		Collections.sort(historySale.getSales(), comparatorSaleDate);
		showListSale(historySale);
	}
	
	/**
	 * method for search records about sale by date
	 * @param historySale list of sales
	 */
	public static void searchSaleByDate(HistorySale historySale) {
		System.out.println("Enter date:");
		String dateForSearch = in.next();
		List<Sale> resultOfSearch = new ArrayList<>();
		if (valid.isValidDate(dateForSearch)) {
			for (int i = 0; i < historySale.getSales().size(); i++) {
				if (historySale.getSales().get(i).getDateOfSale().equals(valid.getDate())) {
					resultOfSearch.add(historySale.getSales().get(i));
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
}
