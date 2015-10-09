package controllers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import history.HistoryClient;
import model.Client;

/**
 * the class provides all necessary methods for working with records of clients
 * @author LappoPolina
 *
 */
public class MethodsForClient {
	

	/**
	 * method for create a new record about client on list of clients
	 * @param historyClient list of clients
	 */
	public static void createClient(HistoryClient historyClient) {
		System.out.println("Enter Last Name, First Name, Middle Name and date " + "of Birthday in "
				+ "format dd.mm.yyyy:");
		String last = Utilit.in.next();
		String first = Utilit.in.next();
		String middle = Utilit.in.next();
		String dateBirth = Utilit.in.next();
		if (Utilit.valid.isValidName(first) & Utilit.valid.isValidName(last) & Utilit.valid.isValidName(middle)
				& Utilit.valid.isValidDate(dateBirth)) {
			historyClient.addClients(new Client(last, first, middle, Utilit.valid.getDate()));
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
		for (int i = 0; i < historyClient.getUnchangedCopy().size(); i++)
			System.out.println(historyClient.getUnchangedCopy().get(i));
	}

	/**
	 * method for sort list of clients by date and show sorted list 
	 * @param historyClient list of clients
	 */
	public static void sortByDateClientList(HistoryClient historyClient) {
		ComparatorClientDate comparatorDate = new ComparatorClientDate();
		HistoryClient historyClientCopy = new HistoryClient();
		historyClientCopy.setClients(historyClient.getUnchangedCopy());
		Collections.sort(historyClientCopy.getChangedCopy(), comparatorDate);
		showListClient(historyClientCopy);
	}

	/**
	 * method for sort list of clients by last name and show sorted list 
	 * @param historyClient list of clients
	 */
	public static void sortByLastNameClient(HistoryClient historyClient) {
		ComparatorClientLastName comparatorLastName = new ComparatorClientLastName();
		HistoryClient historyClientCopy = new HistoryClient();
		historyClientCopy.setClients(historyClient.getUnchangedCopy());
		Collections.sort(historyClientCopy.getChangedCopy(), comparatorLastName);
		showListClient(historyClientCopy);
	}

	/**
	 * method for sort list of clients by first name and show sorted list 
	 * @param historyClient list of clients
	 */
	public static void sortByFirtsNameClientList(HistoryClient historyClient) {
		ComparatorClientFirstName comparatorFirstName = new ComparatorClientFirstName();
		HistoryClient historyClientCopy = new HistoryClient();
		historyClientCopy.setClients(historyClient.getUnchangedCopy());
		Collections.sort(historyClient.getChangedCopy(), comparatorFirstName);
		showListClient(historyClient);
	}

	/**
	 * method for search clients by date and show finding information 
	 * @param historyClient list of clients
	 */
	public static void searchClientByDate(HistoryClient historyClient) {
		System.out.println("Enter date:");
		String dataForSearch = Utilit.in.next();
		List<Client> resultOfSearch = new ArrayList<>();
		if (Utilit.valid.isValidDate(dataForSearch)) {
			for (int i = 0; i < historyClient.getUnchangedCopy().size(); i++) {
				if (historyClient.getUnchangedCopy().get(i).getDateOfBirth().equals(Utilit.valid.getDate())) {
					resultOfSearch.add(historyClient.getUnchangedCopy().get(i));
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
		String lastNameForSearch = Utilit.in.next();
		List<Client> resultOfSearch = new ArrayList<>();
		if (Utilit.valid.isValidName(lastNameForSearch)) {
			for (int i = 0; i < historyClient.getUnchangedCopy().size(); i++) {
				if (historyClient.getUnchangedCopy().get(i).getLastName().equals(lastNameForSearch)) {
					resultOfSearch.add(historyClient.getUnchangedCopy().get(i));
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
		String lastNameForSearch = Utilit.in.next();
		System.out.println("Enter First Name:");
		String firstNameForSearch = Utilit.in.next();
		List<Client> resultOfSearch = new ArrayList<>();
		if (Utilit.valid.isValidName(lastNameForSearch) & Utilit.valid.isValidName(firstNameForSearch)) {
			for (int i = 0; i < historyClient.getUnchangedCopy().size(); i++) {
				if (historyClient.getUnchangedCopy().get(i).getLastName().equals(lastNameForSearch)
						& historyClient.getUnchangedCopy().get(i).getFirstName()
						.equals(firstNameForSearch)) {
					resultOfSearch.add(historyClient.getUnchangedCopy().get(i));
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
		String dataForSearch = Utilit.in.next();
		List<Client> resultOfSearch = new ArrayList<>();
		System.out.println("Enter Last Name:");
		String lastNameForSearch = Utilit.in.next();
		if (Utilit.valid.isValidName(lastNameForSearch) & Utilit.valid.isValidDate(dataForSearch)) {
			for (int i = 0; i < historyClient.getUnchangedCopy().size(); i++) {
				if (historyClient.getUnchangedCopy().get(i).getLastName().equals(lastNameForSearch)
						& historyClient.getUnchangedCopy().get(i).getDateOfBirth()
						.equals(dataForSearch)) {
					resultOfSearch.add(historyClient.getUnchangedCopy().get(i));
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
