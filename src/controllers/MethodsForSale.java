package controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
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

	/**
	 * method for create a new record about sale on list of sale
	 * @param historySale list of sales
	 * @param historyClient list of clients
	 * @param historyDevice list of device
	 */
	public static void createSale(HistorySale historySale, HistoryClient historyClient, HistoryDevice historyDevice) {
		System.out.println("Enter Date in format dd.mm.yyyy, IdClient and Numder of purchased device:");
		String dateSale = Utilit.in.next();
		Utilit.valid.isValidDate(dateSale);
		int idClient = Utilit.in.nextInt();
		int number = Utilit.in.nextInt();
		int idDevice;
		int count;
		if (Utilit.valid.isValidClient(idClient, historyClient)) { 
			Map<Device, Integer> checkSale = new HashMap<Device, Integer>();
			for (int i = 0; i < number; i++) {
				System.out.println("Enter IdDevice and Count:");
				idDevice = Utilit.in.nextInt();
				if (Utilit.valid.isValidDevice(idDevice, historyDevice)) { 
					count = Utilit.in.nextInt(); 
					checkSale.put(historyDevice.getUnchangedCopy().get(idDevice - 1), count); 
				} else
					System.out.println(
							"ERROR! Ñannot create a record from Sale, verify the accuracy of "
							+ "information entry");
			}
			historySale
					.addSales(new Sale(Utilit.valid.getDate(), historyClient.getUnchangedCopy()
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
		for (int i = 0; i < historySale.getUnchangedCopy().size(); i++)
			System.out.println(historySale.getUnchangedCopy().get(i).toString());
	}
	
	/**
	 * method for sort list of sale by date
	 * @param historySale list of sales
	 */
	public static void sortByDateSaleList(HistorySale historySale) {
		ComparatorSaleDate comparatorSaleDate = new ComparatorSaleDate();
		HistorySale historySaleCopy = new HistorySale();
		historySaleCopy.setSale(historySale.getUnchangedCopy());
		Collections.sort(historySaleCopy.getChangedCopy(), comparatorSaleDate);
		showListSale(historySaleCopy);
	}
	
	/**
	 * method for search records about sale by date
	 * @param historySale list of sales
	 */
	public static void searchSaleByDate(HistorySale historySale) {
		System.out.println("Enter date:");
		String dateForSearch = Utilit.in.next();
		List<Sale> resultOfSearch = new ArrayList<>();
		if (Utilit.valid.isValidDate(dateForSearch)) {
			for (int i = 0; i < historySale.getUnchangedCopy().size(); i++) {
				if (historySale.getUnchangedCopy().get(i).getDateOfSale().equals(Utilit.valid.getDate())) {
					resultOfSearch.add(historySale.getUnchangedCopy().get(i));
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
