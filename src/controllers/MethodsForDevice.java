package controllers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import history.HistoryDevice;
import model.Color;
import model.Device;
import model.Mark;
import model.Type;

/**
 * the class provides all necessary methods for working with records of devices
 * @author LappoPolina
 *
 */
public class MethodsForDevice {

	/** 
	 * method for create a new record about device on list of devices
	 * @param historyDevice list of devices
	 */
	public static void createDevice(HistoryDevice historyDevice) {
		System.out.println("Enter Code of Mark, Code of Type, Model, Code of Color,"
				+ " Cost and Date of Produce in format dd.mm.yyyy:");

		System.out.println("Code of Mark:");
		for (int i = 0; i < Mark.values().length; i++)
			System.out.println("	" + i + " - " + Mark.values()[i]); 

		System.out.println("Code of Type:");
		for (int i = 0; i < Type.values().length; i++)
			System.out.println("	" + i + " - " + Type.values()[i]); 

		System.out.println("Code of Color:");
		for (int i = 0; i < Color.values().length; i++)
			System.out.println("	" + i + " - " + Color.values()[i]); 

		int mark = Utilit.in.nextInt();
		int type = Utilit.in.nextInt();
		String model = Utilit.in.next();
		int color = Utilit.in.nextInt();
		String cos = Utilit.in.next();
		String date = Utilit.in.next();
		if (Utilit.valid.isValidMark(mark) & Utilit.valid.isValidType(type) & Utilit.valid.isValidColor(color) 
				& Utilit.valid.isValidCost(cos)
				& Utilit.valid.isValidDate(date)) {
			historyDevice.addDevices(new Device(Mark.values()[mark], Type.values()[type],
					model, Color.values()[color], Utilit.valid.getCost(), Utilit.valid.getDate())); 
			System.out.println("Device create successfully.");
		} else
			System.out.println("ERROR! Ñannot create a record from Device, verify the accuracy "
					+ "of information entry");
	}

	/** 
	 * method for show all records about device on list of devices
	 * @param historyDevice list of devices
	 */
	public static void showListDevice(HistoryDevice historyDevice) {
		for (int i = 0; i < historyDevice.getUnchangedCopy().size(); i++)
			System.out.println(historyDevice.getUnchangedCopy().get(i).toString());
	}
	
	/**
	 * method for sort list of devices by date of produce and show result
	 * @param historyDevice list of devices
	 */
	public static void sortByDateDeviceList(HistoryDevice historyDevice) {
		ComparatorDeviceDate comparatorDeviceDate = new ComparatorDeviceDate();
		HistoryDevice historyDeviceCopy = new HistoryDevice();
		historyDeviceCopy.setDevices(historyDevice.getUnchangedCopy());
		Collections.sort(historyDeviceCopy.getChangedCopy(), comparatorDeviceDate);
		showListDevice(historyDeviceCopy);
	}

	/**
	 * method for sort list of devices by mark and show result
	 * @param historyDevice list of devices
	 */
	public static void sortByMarkDeviceList(HistoryDevice historyDevice) {
		ComparatorDeviceMark comparatorDeviceMark = new ComparatorDeviceMark();
		HistoryDevice historyDeviceCopy = new HistoryDevice();
		historyDeviceCopy.setDevices(historyDevice.getUnchangedCopy());
		Collections.sort(historyDeviceCopy.getChangedCopy(), comparatorDeviceMark);
		showListDevice(historyDeviceCopy);
	}

	/**
	 * method for sort list of devices by Model and show result
	 * @param historyDevice list of devices
	 */
	public static void sortByModelDeviceList(HistoryDevice historyDevice) {
		ComparatorDeviceModel comparatorDeviceModel = new ComparatorDeviceModel();
		HistoryDevice historyDeviceCopy = new HistoryDevice();
		historyDeviceCopy.setDevices(historyDevice.getUnchangedCopy());
		Collections.sort(historyDeviceCopy.getChangedCopy(), comparatorDeviceModel);
		showListDevice(historyDeviceCopy);
	}

	/**
	 * method for sort list of devices by Color and show result
	 * @param historyDevice list of devices
	 */
	public static void sortByColorDeviceList(HistoryDevice historyDevice) {
		ComparatorDeviceColor comparatorDeviceColor = new ComparatorDeviceColor();
		HistoryDevice historyDeviceCopy = new HistoryDevice();
		historyDeviceCopy.setDevices(historyDevice.getUnchangedCopy());
		Collections.sort(historyDeviceCopy.getChangedCopy(), comparatorDeviceColor);
		showListDevice(historyDeviceCopy);
	}

	/**
	 * method for sort list of devices by type and show result
	 * @param historyDevice list of devices
	 */
	public static void sortByTypeDeviceList(HistoryDevice historyDevice) {
		ComparatorDeviceType comparatorDeviceType = new ComparatorDeviceType();
		HistoryDevice historyDeviceCopy = new HistoryDevice();
		historyDeviceCopy.setDevices(historyDevice.getUnchangedCopy());
		Collections.sort(historyDeviceCopy.getChangedCopy(), comparatorDeviceType);
		showListDevice(historyDeviceCopy);
	}

	/**
	 * method for sort list of devices by cost and show result
	 * @param historyDevice list of devices
	 */
	public static void sortByCostDeviceListAndShow(HistoryDevice historyDevice) {
		ComparatorDeviceCost comparatorDeviceCost = new ComparatorDeviceCost();
		HistoryDevice historyDeviceCopy = new HistoryDevice();
		historyDeviceCopy.setDevices(historyDevice.getUnchangedCopy());
		Collections.sort(historyDeviceCopy.getChangedCopy(), comparatorDeviceCost);
		showListDevice(historyDeviceCopy);
	}

	/**
	 * method for search devices by date of produce and show result
	 * @param historyDevice list of devices
	 */
	public static void searchDeviceByDate(HistoryDevice historyDevice) {
		System.out.println("Enter date:");
		String dataForSearch = Utilit.in.next();
		List<Device> resultOfSearch = new ArrayList<>();
		if (Utilit.valid.isValidDate(dataForSearch)) {
			for (int i = 0; i < historyDevice.getUnchangedCopy().size(); i++) {
				if (historyDevice.getUnchangedCopy().get(i).getDateOfProduce().equals(Utilit.valid.getDate())) {
					resultOfSearch.add(historyDevice.getUnchangedCopy().get(i));
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
	 * method for search devices by mark and show result
	 * @param historyDevice list of devices
	 */
	public static void searchDeviceByMark(HistoryDevice historyDevice) {
		System.out.println("Code of Mark:");
		for (int i = 0; i < Mark.values().length; i++)
			System.out.println("	" + i + " - " + Mark.values()[i]);
		System.out.println("Enter code of Mark:");
		int mark = Utilit.in.nextInt();
		List<Device> resultOfSearch = new ArrayList<>();
		if (Utilit.valid.isValidMark(mark)){
			for (int i = 0; i < historyDevice.getUnchangedCopy().size(); i++) {
				if (historyDevice.getUnchangedCopy().get(i).getMark().equals(mark)) {
					resultOfSearch.add(historyDevice.getUnchangedCopy().get(i));
				}
			}
			if (resultOfSearch.size() > 0) {
				for (int i = 0; i < resultOfSearch.size(); i++)
					System.out.println(resultOfSearch.get(i).toString());
			} else
				System.out.println("We can't find necessary records");
		} else
			System.out.println("ERROR! You enter wrong code of mark!");		
	}
	
	/**
	 * method for search devices by model and show result
	 * @param historyDevice list of devices
	 */
	public static void searchDeviceByModel(HistoryDevice historyDevice) {
		System.out.println("Enter Model:");
		String model = Utilit.in.next();
		List<Device> resultOfSearch = new ArrayList<>();
		for (int i = 0; i < historyDevice.getUnchangedCopy().size(); i++) {
				if (historyDevice.getUnchangedCopy().get(i).getModel().equals(model)) {
					resultOfSearch.add(historyDevice.getUnchangedCopy().get(i));
				}
			}
		if (resultOfSearch.size() > 0) {
			for (int i = 0; i < resultOfSearch.size(); i++)
				System.out.println(resultOfSearch.get(i).toString());
		} else
			System.out.println("We can't find necessary records");
	}
	
	/**
	 * method for search devices by type and show result
	 * @param historyDevice list of devices
	 */
	public static void searchDeviceByType(HistoryDevice historyDevice) {
		System.out.println("Code of Type:");
		for (int i = 0; i < Type.values().length; i++)
			System.out.println("	" + i + " - " + Type.values()[i]);
		System.out.println("Enter code of Type:");
		int type = Utilit.in.nextInt();
		List<Device> resultOfSearch = new ArrayList<>();
		if (Utilit.valid.isValidType(type)){
			for (int i = 0; i < historyDevice.getUnchangedCopy().size(); i++) {
				if (historyDevice.getUnchangedCopy().get(i).getType().equals(type)) {
					resultOfSearch.add(historyDevice.getUnchangedCopy().get(i));
				}
			}
			if (resultOfSearch.size() > 0) {
				for (int i = 0; i < resultOfSearch.size(); i++)
					System.out.println(resultOfSearch.get(i).toString());
			} else
				System.out.println("We can't find necessary records");
		} else
			System.out.println("ERROR! You enter wrong code of type!");	
	}
	
	/**
	 * method for search devices by color and show result
	 * @param historyDevice list of devices
	 */
	public static void searchDeviceByColor(HistoryDevice historyDevice) {
		System.out.println("Code of Color:");
		for (int i = 0; i < Color.values().length; i++)
			System.out.println("	" + i + " - " + Color.values()[i]);
		System.out.println("Enter code of Color:");
		int color = Utilit.in.nextInt();
		List<Device> resultOfSearch = new ArrayList<>();
		if (Utilit.valid.isValidColor(color)){
			for (int i = 0; i < historyDevice.getUnchangedCopy().size(); i++) {
				if (historyDevice.getUnchangedCopy().get(i).getColor().equals(color)) {
					resultOfSearch.add(historyDevice.getUnchangedCopy().get(i));
				}
			}
			if (resultOfSearch.size() > 0) {
				for (int i = 0; i < resultOfSearch.size(); i++)
					System.out.println(resultOfSearch.get(i).toString());
			} else
				System.out.println("We can't find necessary records");
		} else
			System.out.println("ERROR! You enter wrong code of color!");	
	}
	
	/**
	 * method for search devices by cost and show result
	 * @param historyDevice list of devices
	 */
	public static void searchDeviceByCost(HistoryDevice historyDevice) {
		System.out.println("Enter cost:");
		String cost = Utilit.in.next();
		List<Device> resultOfSearch = new ArrayList<>();
		if (Utilit.valid.isValidCost(cost)) {
			for (int i = 0; i < historyDevice.getUnchangedCopy().size(); i++) {
				if (historyDevice.getUnchangedCopy().get(i).getCost().equals(Utilit.valid.getCost())) {
					resultOfSearch.add(historyDevice.getUnchangedCopy().get(i));
				}
			}
			if (resultOfSearch.size() > 0) {
				for (int i = 0; i < resultOfSearch.size(); i++)
					System.out.println(resultOfSearch.get(i).toString());
			} else
				System.out.println("We can't find necessary records");
		} else
			System.out.println("ERROR! You enter wrong cost!");
	}
	
	/**
	 *  method for search devices by date and code of mark and show result
	 * @param historyDevice list of devices
	 */
	public static void searchDeviceByDateMark(HistoryDevice historyDevice) {
		System.out.println("Code of Mark:");
		for (int i = 0; i < Mark.values().length; i++)
			System.out.println("	" + i + " - " + Mark.values()[i]);
		System.out.println("Enter code of Mark:");
		int mark = Utilit.in.nextInt();
		System.out.println("Enter date:");
		String data = Utilit.in.next();
		List<Device> resultOfSearch = new ArrayList<>();
		if(Utilit.valid.isValidDate(data) & Utilit.valid.isValidMark(mark)) {
			for (int i = 0; i < historyDevice.getUnchangedCopy().size(); i++) {
				if (historyDevice.getUnchangedCopy().get(i).getMark().equals(mark)
						& historyDevice.getUnchangedCopy().get(i).getDateOfProduce()
						.equals(Utilit.valid.getDate())) {
					resultOfSearch.add(historyDevice.getUnchangedCopy().get(i));
				}
			}
			if (resultOfSearch.size() > 0) {
				for (int i = 0; i < resultOfSearch.size(); i++)
					System.out.println(resultOfSearch.get(i).toString());
			} else
				System.out.println("We can't find necessary records");
			
		} else
			System.out.println("ERROR! You enter wrong date or code of mark!");
	}
	
	/**
	 *  method for search devices by code of mark and type and show result
	 * @param historyDevice list of devices
	 */
	public static void searchDeviceByMarkType(HistoryDevice historyDevice) {
		System.out.println("Code of Mark:");
		for (int i = 0; i < Mark.values().length; i++)
			System.out.println("	" + i + " - " + Mark.values()[i]);
		System.out.println("Enter code of Mark:");
		int mark = Utilit.in.nextInt();
		
		System.out.println("Code of Type:");
		for (int i = 0; i < Type.values().length; i++)
			System.out.println("	" + i + " - " + Type.values()[i]);
		System.out.println("Enter code of Type:");
		int type = Utilit.in.nextInt();
		List<Device> resultOfSearch = new ArrayList<>();
		if(Utilit.valid.isValidType(type) & Utilit.valid.isValidMark(mark)) {
			for (int i = 0; i < historyDevice.getUnchangedCopy().size(); i++) {
				if (historyDevice.getUnchangedCopy().get(i).getMark().equals(mark)
						& historyDevice.getUnchangedCopy().get(i).getType()
						.equals(type)) {
					resultOfSearch.add(historyDevice.getUnchangedCopy().get(i));
				}
			}
			if (resultOfSearch.size() > 0) {
				for (int i = 0; i < resultOfSearch.size(); i++)
					System.out.println(resultOfSearch.get(i).toString());
			} else
				System.out.println("We can't find necessary records");
			
		} else
			System.out.println("ERROR! You enter wrong code of typr or code of mark!");
	}
	
	/**
	 *  method for search devices by model and color code and show result
	 * @param historyDevice list of devices
	 */
	public static void searchDeviceByModelColor(HistoryDevice historyDevice) {
		System.out.println("Code of Color:");
		for (int i = 0; i < Color.values().length; i++)
			System.out.println("	" + i + " - " + Color.values()[i]);
		System.out.println("Enter code of Color:");
		int color = Utilit.in.nextInt();
		String model = Utilit.in.next();
		List<Device> resultOfSearch = new ArrayList<>();
		if(Utilit.valid.isValidColor(color)) {
			for (int i = 0; i < historyDevice.getUnchangedCopy().size(); i++) {
				if (historyDevice.getUnchangedCopy().get(i).getColor().equals(color)
						& historyDevice.getUnchangedCopy().get(i).getModel()
						.equals(model)) {
					resultOfSearch.add(historyDevice.getUnchangedCopy().get(i));
				}
			}
			if (resultOfSearch.size() > 0) {
				for (int i = 0; i < resultOfSearch.size(); i++)
					System.out.println(resultOfSearch.get(i).toString());
			} else
				System.out.println("We can't find necessary records");
			
		} else
			System.out.println("ERROR! You enter wrong code of color!");
	}
	
	/**
	 *  method for search devices by code of type and cost and show result
	 * @param historyDevice list of devices
	 */
	public static void searchDeviceByTypeCost(HistoryDevice historyDevice) {
		System.out.println("Code of Type:");
		for (int i = 0; i < Type.values().length; i++)
			System.out.println("	" + i + " - " + Type.values()[i]);
		System.out.println("Enter code of Type:");
		int type = Utilit.in.nextInt();
		String cost = Utilit.in.next();
		List<Device> resultOfSearch = new ArrayList<>();
		if(Utilit.valid.isValidType(type) & Utilit.valid.isValidCost(cost)) {
			for (int i = 0; i < historyDevice.getUnchangedCopy().size(); i++) {
				if (historyDevice.getUnchangedCopy().get(i).getCost().equals(Utilit.valid.getCost())
						& historyDevice.getUnchangedCopy().get(i).getType()
						.equals(type)) {
					resultOfSearch.add(historyDevice.getUnchangedCopy().get(i));
				}
			}
			if (resultOfSearch.size() > 0) {
				for (int i = 0; i < resultOfSearch.size(); i++)
					System.out.println(resultOfSearch.get(i).toString());
			} else
				System.out.println("We can't find necessary records");
			
		} else
			System.out.println("ERROR! You enter wrong code of type or cost!");
	}	
}
