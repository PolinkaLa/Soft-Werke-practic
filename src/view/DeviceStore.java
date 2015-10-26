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
		ConsolHelper.helpForUser();
		ConsolHelper.comand();
	}

	static DeviceStore deviceStore;
	
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
		if (Utilit.VALID.isValidClient(clientId, ConsolHelper.historyOfClient)) {
			ConsolHelper.historyOfSale.addSales(new Sale(dateOfSale, clientId, deviceIdAndQuantity));
		}		
	}

	@Override
	public void searchClientsByName(String name){
		List<Client> resultOfSearch = new ArrayList<>();
		List<Client> listForSearch = ConsolHelper.historyOfClient.getChangedCopy();
		if (Utilit.VALID.isValidName(name)) {
			for (Client client : listForSearch)
			{
				if (client.getFirstName().equals(name))
					resultOfSearch.add(client);
			}
		}		
	}

	@Override
	public void searchDevicesByIssueDate(Date issueDate) {
		List<Device> resultOfSearch = new ArrayList<>();
		List<Device> listForSearch = ConsolHelper.historyOfDevice.getChangedCopy();
		for (Device device : listForSearch)
		{
			if (device.getDateOfProduce().equals(issueDate))
				resultOfSearch.add(device);
		}
	}

	@Override
	public void sortClientsByName() {
		ComparatorClientDate comparatorFirstName = new ComparatorClientDate();
		HistoryClient historyClientCopy = new HistoryClient();
		historyClientCopy.setClients(ConsolHelper.historyOfClient.getChangedCopy());
		Collections.sort(historyClientCopy.getChangedCopy(), comparatorFirstName);		
	}

	@Override
	public void sortDevicesByModel() {
		ComparatorDeviceMark comparatorDeviceMark = new ComparatorDeviceMark();
		HistoryDevice historyDeviceCopy = new HistoryDevice();
		historyDeviceCopy.setDevices(ConsolHelper.historyOfDevice.getChangedCopy());
		Collections.sort(historyDeviceCopy.getChangedCopy(), comparatorDeviceMark);	
	}

	@Override
	public void sortSalesByDate() {
		ComparatorSaleDate comparatorSaleDate = new ComparatorSaleDate();
		HistorySale historySaleCopy = new HistorySale();
		historySaleCopy.setSale(ConsolHelper.historyOfSale.getChangedCopy());
		Collections.sort(historySaleCopy.getChangedCopy(), comparatorSaleDate);
	}
	
	public static IDeviceStore getDeviceStore() {
		return deviceStore;
	}
}
