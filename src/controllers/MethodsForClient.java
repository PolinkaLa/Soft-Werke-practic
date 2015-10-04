package controllers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import history.HistoryClient;
import model.Client;

/**
 * the class provides all necessary methods for working with records of clients
 * @author LappoPolina
 *
 */
public class MethodsForClient {
	private static Scanner in = new Scanner(System.in);
	private static Validation valid = new Validation();

	/**
	 * method for create a new record about client on list of clients
	 * @param historyClient list of clients
	 */
	public static void createClient(HistoryClient historyClient) {
		System.out.println("Enter Last Name, First Name, Middle Name and date " + "of Birthday in "
				+ "format dd.mm.yyyy:");
		String last = in.next();
		String first = in.next();
		String middle = in.next();
		String dateBirth = in.next();
		if (valid.isValidName(first) & valid.isValidName(last) & valid.isValidName(middle)
				& valid.isValidDate(dateBirth)) {
			historyClient.addClients(new Client(last, first, middle, valid.getDate()));
			System.out.println("Client create successfully.");
		} else
			System.out.println("ERROR! Ñannot create a record from Client, verify the accuracy of "
					+ "information entry");
	}
	
	/**
	 * method for show all records about clients on list of clients
	 * @param historyClient list of clients
	 */
	public static void showListClient(HistoryClient historyClient) {
		for (int i = 0; i < historyClient.getClients().size(); i++)
			System.out.println(historyClient.getClients().get(i).toString());
	}

	/**
	 * method for sort list of clients by date and show sorted list 
	 * @param historyClient list of clients
	 */
	public static void sortByDateClientList(HistoryClient historyClient) {
		ComparatorClientDate comparatorDate = new ComparatorClientDate();
		Collections.sort(historyClient.getClients(), comparatorDate);
		showListClient(historyClient);
	}

	/**
	 * method for sort list of clients by last name and show sorted list 
	 * @param historyClient list of clients
	 */
	public static void sortByLastNameClient(HistoryClient historyClient) {
		ComparatorClientLastName comparatorLastName = new ComparatorClientLastName();
		Collections.sort(historyClient.getClients(), comparatorLastName);
		showListClient(historyClient);
	}

	/**
	 * method for sort list of clients by first name and show sorted list 
	 * @param historyClient list of clients
	 */
	public static void sortByFirtsNameClientList(HistoryClient historyClient) {
		ComparatorClientFirstName comparatorFirstName = new ComparatorClientFirstName();
		Collections.sort(historyClient.getClients(), comparatorFirstName);
		showListClient(historyClient);
	}

	/**
	 * method for search clients by date and show finding information 
	 * @param historyClient list of clients
	 */
	public static void searchClientByDate(HistoryClient historyClient) {
		System.out.println("Enter date:");
		String dataForSearch = in.next();
		List<Client> resultOfSearch = new ArrayList<>();
		if (valid.isValidDate(dataForSearch)) {
			for (int i = 0; i < historyClient.getClients().size(); i++) {
				if (historyClient.getClients().get(i).getDateOfBirth().equals(valid.getDate())) {
					resultOfSearch.add(historyClient.getClients().get(i));
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
	 *  method for search clients by last name and show finding information 
	 * @param historyClient list of clients
	 */
	public static void searchClientByLastName(HistoryClient historyClient) {
		System.out.println("Enter Last Name:");
		String lastNameForSearch = in.next();
		List<Client> resultOfSearch = new ArrayList<>();
		if (valid.isValidName(lastNameForSearch)) {
			for (int i = 0; i < historyClient.getClients().size(); i++) {
				if (historyClient.getClients().get(i).getLastName().equals(lastNameForSearch)) {
					resultOfSearch.add(historyClient.getClients().get(i));
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
	 *  method for search clients by last and first and show finding information 
	 * @param historyClient list of clients
	 */
	public static void searchClientByLastFirstName(HistoryClient historyClient) {
		System.out.println("Enter Last Name:");
		String lastNameForSearch = in.next();
		System.out.println("Enter First Name:");
		String firstNameForSearch = in.next();
		List<Client> resultOfSearch = new ArrayList<>();
		if (valid.isValidName(lastNameForSearch) & valid.isValidName(firstNameForSearch)) {
			for (int i = 0; i < historyClient.getClients().size(); i++) {
				if (historyClient.getClients().get(i).getLastName().equals(lastNameForSearch)
						& historyClient.getClients().get(i).getFirstName()
						.equals(firstNameForSearch)) {
					resultOfSearch.add(historyClient.getClients().get(i));
				}
			}
			if (resultOfSearch.size() > 0) {
				for (int i = 0; i < resultOfSearch.size(); i++)
					System.out.println(resultOfSearch.get(i).toString());
			} else
				System.out.println("We can't find necessary records");
		} else
			System.out.println("ERROR! You enter wrong Last Name or First Name!");
	}

	/**
	 * method for search record about client by given last name and date
	 * @param historyClient list of Client
	 */
	public static void searchClientByLastNameDate(HistoryClient historyClient){
		System.out.println("Enter date:");
		String dataForSearch = in.next();
		List<Client> resultOfSearch = new ArrayList<>();
		System.out.println("Enter Last Name:");
		String lastNameForSearch = in.next();
		if (valid.isValidName(lastNameForSearch) & valid.isValidDate(dataForSearch)) {
			for (int i = 0; i < historyClient.getClients().size(); i++) {
				if (historyClient.getClients().get(i).getLastName().equals(lastNameForSearch)
						& historyClient.getClients().get(i).getDateOfBirth()
						.equals(dataForSearch)) {
					resultOfSearch.add(historyClient.getClients().get(i));
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
