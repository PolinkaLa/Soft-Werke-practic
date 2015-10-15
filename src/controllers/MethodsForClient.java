package controllers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import exception.CreateNewRecordException;
import exception.ValidationException;
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
	public static void createClient(HistoryClient historyClient) throws CreateNewRecordException {
		System.out.println("Enter Last Name, First Name, Middle Name and date " + "of Birthday in "
				+ "format dd.mm.yyyy:");
		String last = Utilit.IN.next();
		String first = Utilit.IN.next();
		String middle = Utilit.IN.next();
		String dateBirth = Utilit.IN.next();
		if (Utilit.VALID.isValidName(first) & Utilit.VALID.isValidName(last) & Utilit.VALID.isValidName(middle)
				& Utilit.VALID.isValidDate(dateBirth)) {
			historyClient.addClients(new Client(last, first, middle, Utilit.VALID.getDate()));
			System.out.println("Client create successfully.");
		} else
			throw new CreateNewRecordException();
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
	public static void searchClientByDate(HistoryClient historyClient) 
			throws ValidationException {
		System.out.println("Enter date:");
		String dataForSearch = Utilit.IN.next();
		List<Client> resultOfSearch = new ArrayList<>();
		if (Utilit.VALID.isValidDate(dataForSearch)) {
			for (int i = 0; i < historyClient.getUnchangedCopy().size(); i++) {
				if (historyClient.getUnchangedCopy().get(i).getDateOfBirth().
						equals(Utilit.VALID.getDate())) {
					resultOfSearch.add(historyClient.getUnchangedCopy().get(i));
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

	/**
	 *  method for search clients by last name and show finding information 
	 * @param historyClient list of clients
	 */
	public static void searchClientByLastName(HistoryClient historyClient) 
			throws ValidationException {
		System.out.println("Enter Last Name:");
		String lastNameForSearch = Utilit.IN.next();
		List<Client> resultOfSearch = new ArrayList<>();
		if (Utilit.VALID.isValidName(lastNameForSearch)) {
			for (int i = 0; i < historyClient.getUnchangedCopy().size(); i++) {
				if (historyClient.getUnchangedCopy().get(i).getLastName().
						equals(lastNameForSearch)) {
					resultOfSearch.add(historyClient.getUnchangedCopy().get(i));
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

	/**
	 *  method for search clients by last and first and show finding information 
	 * @param historyClient list of clients
	 */
	public static void searchClientByLastFirstName(HistoryClient historyClient) 
			throws ValidationException {
		System.out.println("Enter Last Name:");
		String lastNameForSearch = Utilit.IN.next();
		System.out.println("Enter First Name:");
		String firstNameForSearch = Utilit.IN.next();
		List<Client> resultOfSearch = new ArrayList<>();
		if (Utilit.VALID.isValidName(lastNameForSearch) & Utilit.VALID.
				isValidName(firstNameForSearch)) {
			for (int i = 0; i < historyClient.getUnchangedCopy().size(); i++) {
				if (historyClient.getUnchangedCopy().get(i).getLastName().
						equals(lastNameForSearch)
						& historyClient.getUnchangedCopy().get(i).getFirstName()
						.equals(firstNameForSearch)) {
					resultOfSearch.add(historyClient.getUnchangedCopy().get(i));
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

	/**
	 * method for search record about client by given last name and date
	 * @param historyClient list of Client
	 */
	public static void searchClientByLastNameDate(HistoryClient historyClient) 
			throws ValidationException {
		System.out.println("Enter date:");
		String dataForSearch = Utilit.IN.next();
		List<Client> resultOfSearch = new ArrayList<>();
		System.out.println("Enter Last Name:");
		String lastNameForSearch = Utilit.IN.next();
		if (Utilit.VALID.isValidName(lastNameForSearch) & Utilit.VALID.isValidDate(dataForSearch)) {
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
			throw new ValidationException();
	}
}
