package controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import exception.CreateNewRecordException;
import exception.ValidationException;

import java.util.ArrayList;
import java.util.Collections;
import history.*;
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
	public static void createSale(HistorySale historySale, HistoryClient historyClient, 
			HistoryDevice historyDevice) throws CreateNewRecordException {
		System.out.println("Enter Date in format dd.mm.yyyy, IdClient and Numder "
				+ "of purchased device:");
		String dateSale = Utilit.IN.next();
		Utilit.VALID.isValidDate(dateSale);
		int idClient = Utilit.IN.nextInt();
		int number = Utilit.IN.nextInt();
		int idDevice;
		int count;
		if (Utilit.VALID.isValidClient(idClient, historyClient)) { 
			Map<Integer, Integer> checkSale = new HashMap<Integer, Integer>();
			for (int i = 0; i < number; i++) {
				System.out.println("Enter IdDevice and Count:");
				idDevice = Utilit.IN.nextInt();
				if (Utilit.VALID.isValidDevice(idDevice, historyDevice)) { 
					count = Utilit.IN.nextInt(); 
					checkSale.put((idDevice - 1), count); 
				} else
					throw new CreateNewRecordException();
			}
			historySale
					.addSales(new Sale(Utilit.VALID.getDate(), (idClient - 1), checkSale));
			System.out.println("Sale create successfully.");
		} else
			throw new CreateNewRecordException();

	}

	/**
	 * method for show all record of list of sales
	 * @param historySale list of sales
	 */
	public static void showListSale(HistorySale historySale) {
		for (int i = 0; i < historySale.getUnchangedCopy().size(); i++)
			System.out.println(historySale.getUnchangedCopy().get(i));
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
	public static void searchSaleByDate(HistorySale historySale) throws ValidationException  {
		System.out.println("Enter date:");
		String dateForSearch = Utilit.IN.next();
		List<Sale> resultOfSearch = new ArrayList<>();
		if (Utilit.VALID.isValidDate(dateForSearch)) {
			for (int i = 0; i < historySale.getUnchangedCopy().size(); i++) {
				if (historySale.getUnchangedCopy().get(i).getDateOfSale().equals(Utilit.VALID.getDate())) {
					resultOfSearch.add(historySale.getUnchangedCopy().get(i));
				}
			}
			if (resultOfSearch.size() > 0) {
				for (int i = 0; i < resultOfSearch.size(); i++)
					System.out.println(resultOfSearch.get(i));
			} else
				System.out.println("We can't find necessary records");
		} else
			throw new ValidationException();
	}	
}
