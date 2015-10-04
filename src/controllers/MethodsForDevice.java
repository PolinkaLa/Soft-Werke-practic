package controllers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
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
	private static Scanner in = new Scanner(System.in);
	private static Validation valid = new Validation();

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

		int mark = in.nextInt();
		int type = in.nextInt();
		String model = in.next();
		int color = in.nextInt();
		String cos = in.next();
		String date = in.next();
		if (valid.isValidMark(mark) & valid.isValidType(type) & valid.isValidColor(color) 
				& valid.isValidCost(cos)
				& valid.isValidDate(date)) {
			historyDevice.addDevices(new Device(Mark.values()[mark], Type.values()[type],
					model, Color.values()[color], valid.getCost(), valid.getDate())); 
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
		for (int i = 0; i < historyDevice.getDevices().size(); i++)
			System.out.println(historyDevice.getDevices().get(i).toString());
	}
	
	/**
	 * method for sort list of devices by date of produce and show result
	 * @param historyDevice list of devices
	 */
	public static void sortByDateDeviceList(HistoryDevice historyDevice) {
		ComparatorDeviceDate comparatorDeviceDate = new ComparatorDeviceDate();
		Collections.sort(historyDevice.getDevices(), comparatorDeviceDate);
		showListDevice(historyDevice);
	}

	/**
	 * method for sort list of devices by mark and show result
	 * @param historyDevice list of devices
	 */
	public static void sortByMarkDeviceList(HistoryDevice historyDevice) {
		ComparatorDeviceMark comparatorDeviceMark = new ComparatorDeviceMark();
		Collections.sort(historyDevice.getDevices(), comparatorDeviceMark);
		showListDevice(historyDevice);
	}

	/**
	 * method for sort list of devices by Model and show result
	 * @param historyDevice list of devices
	 */
	public static void sortByModelDeviceList(HistoryDevice historyDevices) {
		ComparatorDeviceModel comparatorDeviceModel = new ComparatorDeviceModel();
		Collections.sort(historyDevices.getDevices(), comparatorDeviceModel);
		showListDevice(historyDevices);
	}

	/**
	 * method for sort list of devices by Color and show result
	 * @param historyDevice list of devices
	 */
	public static void sortByColorDeviceList(HistoryDevice historyDevice) {
		ComparatorDeviceColor comparatorDeviceColor = new ComparatorDeviceColor();
		Collections.sort(historyDevice.getDevices(), comparatorDeviceColor);
		showListDevice(historyDevice);
	}

	/**
	 * method for sort list of devices by type and show result
	 * @param historyDevice list of devices
	 */
	public static void sortByTypeDeviceList(HistoryDevice historyDevice) {
		ComparatorDeviceType comparatorDeviceType = new ComparatorDeviceType();
		Collections.sort(historyDevice.getDevices(), comparatorDeviceType);
		showListDevice(historyDevice);
	}

	/**
	 * method for sort list of devices by cost and show result
	 * @param historyDevice list of devices
	 */
	public static void sortByCostDeviceListAndShow(HistoryDevice historyDevice) {
		ComparatorDeviceCost comparatorDeviceCost = new ComparatorDeviceCost();
		Collections.sort(historyDevice.getDevices(), comparatorDeviceCost);
		showListDevice(historyDevice);
	}

	/**
	 * method for search devices by date of produce and show result
	 * @param historyDevice list of devices
	 */
	public static void searchDeviceByDate(HistoryDevice historyDevice) {
		System.out.println("Enter date:");
		String dataForSearch = in.next();
		List<Device> resultOfSearch = new ArrayList<>();
		if (valid.isValidDate(dataForSearch)) {
			for (int i = 0; i < historyDevice.getDevices().size(); i++) {
				if (historyDevice.getDevices().get(i).getDateOfProduce().equals(valid.getDate())) {
					resultOfSearch.add(historyDevice.getDevices().get(i));
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
		int mark = in.nextInt();
		List<Device> resultOfSearch = new ArrayList<>();
		if (valid.isValidMark(mark)){
			for (int i = 0; i < historyDevice.getDevices().size(); i++) {
				if (historyDevice.getDevices().get(i).getMark().equals(mark)) {
					resultOfSearch.add(historyDevice.getDevices().get(i));
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
		String model = in.next();
		List<Device> resultOfSearch = new ArrayList<>();
		for (int i = 0; i < historyDevice.getDevices().size(); i++) {
				if (historyDevice.getDevices().get(i).getModel().equals(model)) {
					resultOfSearch.add(historyDevice.getDevices().get(i));
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
		int type = in.nextInt();
		List<Device> resultOfSearch = new ArrayList<>();
		if (valid.isValidType(type)){
			for (int i = 0; i < historyDevice.getDevices().size(); i++) {
				if (historyDevice.getDevices().get(i).getType().equals(type)) {
					resultOfSearch.add(historyDevice.getDevices().get(i));
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
		int color = in.nextInt();
		List<Device> resultOfSearch = new ArrayList<>();
		if (valid.isValidColor(color)){
			for (int i = 0; i < historyDevice.getDevices().size(); i++) {
				if (historyDevice.getDevices().get(i).getColor().equals(color)) {
					resultOfSearch.add(historyDevice.getDevices().get(i));
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
		String cost = in.next();
		List<Device> resultOfSearch = new ArrayList<>();
		if (valid.isValidCost(cost)) {
			for (int i = 0; i < historyDevice.getDevices().size(); i++) {
				if (historyDevice.getDevices().get(i).getCost().equals(valid.getCost())) {
					resultOfSearch.add(historyDevice.getDevices().get(i));
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
		int mark = in.nextInt();
		System.out.println("Enter date:");
		String data = in.next();
		List<Device> resultOfSearch = new ArrayList<>();
		if(valid.isValidDate(data) & valid.isValidMark(mark)) {
			for (int i = 0; i < historyDevice.getDevices().size(); i++) {
				if (historyDevice.getDevices().get(i).getMark().equals(mark)
						& historyDevice.getDevices().get(i).getDateOfProduce()
						.equals(valid.getDate())) {
					resultOfSearch.add(historyDevice.getDevices().get(i));
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
		int mark = in.nextInt();
		
		System.out.println("Code of Type:");
		for (int i = 0; i < Type.values().length; i++)
			System.out.println("	" + i + " - " + Type.values()[i]);
		System.out.println("Enter code of Type:");
		int type = in.nextInt();
		List<Device> resultOfSearch = new ArrayList<>();
		if(valid.isValidType(type) & valid.isValidMark(mark)) {
			for (int i = 0; i < historyDevice.getDevices().size(); i++) {
				if (historyDevice.getDevices().get(i).getMark().equals(mark)
						& historyDevice.getDevices().get(i).getType()
						.equals(type)) {
					resultOfSearch.add(historyDevice.getDevices().get(i));
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
		int color = in.nextInt();
		String model = in.next();
		List<Device> resultOfSearch = new ArrayList<>();
		if(valid.isValidColor(color)) {
			for (int i = 0; i < historyDevice.getDevices().size(); i++) {
				if (historyDevice.getDevices().get(i).getColor().equals(color)
						& historyDevice.getDevices().get(i).getModel()
						.equals(model)) {
					resultOfSearch.add(historyDevice.getDevices().get(i));
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
		int type = in.nextInt();
		String cost = in.next();
		List<Device> resultOfSearch = new ArrayList<>();
		if(valid.isValidType(type) & valid.isValidCost(cost)) {
			for (int i = 0; i < historyDevice.getDevices().size(); i++) {
				if (historyDevice.getDevices().get(i).getCost().equals(valid.getCost())
						& historyDevice.getDevices().get(i).getType()
						.equals(type)) {
					resultOfSearch.add(historyDevice.getDevices().get(i));
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
