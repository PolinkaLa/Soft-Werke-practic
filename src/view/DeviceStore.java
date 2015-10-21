package view;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Map;

import controllers.ComparatorClientDate;
import controllers.ComparatorDeviceMark;
import controllers.ComparatorSaleDate;
import controllers.MethodsForClient;
import controllers.MethodsForDevice;
import controllers.MethodsForSale;
import controllers.Utilit;
import history.HistoryClient;
import history.HistoryDevice;
import history.HistorySale;
import model.*;

/**
 * @author LappoPolina 
 * Contains the entry point
 */

public class DeviceStore implements IDeviceStore {

	public static void main(String[] args) {
		
		//public static IDeviceStore getDeviceStore() {

		
		ConsolHelper.helpForUser();
		ConsolHelper.comand();
	}

	@Override
	public void addClient(String lastName, String firstName, String middleName, Date birthDate) {
		Client client = new Client(lastName, firstName, middleName, birthDate);
		ConsolHelper.historyOfClient.addClients(client);
		
	}

	@Override
	public void addDevice(String type, String brand, String model, Color color, Date issueDate) {
		Device device = new Device(brand, type, model, color, issueDate);
		ConsolHelper.historyOfDevice.addDevices(device);
		
	}

	@Override
	public void addSale(Date dateOfSale, Integer clientId, Map<Integer, Integer> deviceIdAndQuantity) {
		Sale sale = new Sale(dateOfSale, clientId, deviceIdAndQuantity);
		ConsolHelper.historyOfSale.addSales(sale);
		
	}

	@Override
	public void searchClientsByName(String name){
		//System.out.println("Enter Last Name:");
		//String lastNameForSearch = Utilit.IN.next();
		List<Client> resultOfSearch = new ArrayList<>();
		if (Utilit.VALID.isValidName(name)) {
			for (int i = 0; i < ConsolHelper.historyOfClient.getUnchangedCopy().size(); i++) {
				if (ConsolHelper.historyOfClient.getUnchangedCopy().get(i).getFirstName().
						equals(name)) {
					resultOfSearch.add(ConsolHelper.historyOfClient.getUnchangedCopy().get(i));
				}
			}
			if (resultOfSearch.size() > 0) {
				for (int i = 0; i < resultOfSearch.size(); i++)
					System.out.println(resultOfSearch.get(i));
			} else
				System.out.println("We can't find necessary records");
		} else
			System.out.println("Invalid input");;		
	}

	@Override
	public void searchDevicesByIssueDate(Date issueDate) {
		//System.out.println("Enter date:");
		//String dataForSearch = Utilit.IN.next();
		List<Device> resultOfSearch = new ArrayList<>();
		
			for (int i = 0; i < ConsolHelper.historyOfDevice.getUnchangedCopy().size(); i++) {
				if (ConsolHelper.historyOfDevice.getUnchangedCopy().get(i).getDateOfProduce().equals(issueDate)) {
					resultOfSearch.add(ConsolHelper.historyOfDevice.getUnchangedCopy().get(i));
				}
			}
			if (resultOfSearch.size() > 0) {
				for (int i = 0; i < resultOfSearch.size(); i++)
					System.out.println(resultOfSearch.get(i));
			} else
				System.out.println("We can't find necessary records");		
	}

	@Override
	public void sortClientsByName() {
		ComparatorClientDate comparatorFirstName = new ComparatorClientDate();
		HistoryClient historyClientCopy = new HistoryClient();
		historyClientCopy.setClients(ConsolHelper.historyOfClient.getUnchangedCopy());
		Collections.sort(historyClientCopy.getChangedCopy(), comparatorFirstName);
		MethodsForClient.showListClient(historyClientCopy);
		
	}

	@Override
	public void sortDevicesByModel() {
		ComparatorDeviceMark comparatorDeviceMark = new ComparatorDeviceMark();
		HistoryDevice historyDeviceCopy = new HistoryDevice();
		historyDeviceCopy.setDevices(ConsolHelper.historyOfDevice.getUnchangedCopy());
		Collections.sort(historyDeviceCopy.getChangedCopy(), comparatorDeviceMark);
		MethodsForDevice.showListDevice(historyDeviceCopy);
		
	}

	@Override
	public void sortSalesByDate() {
		ComparatorSaleDate comparatorSaleDate = new ComparatorSaleDate();
		HistorySale historySaleCopy = new HistorySale();
		historySaleCopy.setSale(ConsolHelper.historyOfSale.getUnchangedCopy());
		Collections.sort(historySaleCopy.getChangedCopy(), comparatorSaleDate);
		MethodsForSale.showListSale(historySaleCopy);
		
	}
	
	public static IDeviceStore getDeviceStore() {
		return DeviceStore.getDeviceStore();
	}
}
