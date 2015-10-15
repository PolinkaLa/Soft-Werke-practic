package controllers;

import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import history.*;
import model.*;


/**
 * the class contains methods for validation of input data
 * @author LappoPolina
 *
 */
public class Validation {
	private static SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy");
	private double cost;
	private Date date;
	
	/**
	 * method for validate date
	 * @param dateInString date in format string
	 * @return true if date valid, false else
	 */
	public boolean isValidDate(String dateInString) {
		boolean flag = false;
		try {
			this.date = format.parse(dateInString);
			flag = true;
		} catch (ParseException e) {
			System.out.println("ERROR! You enter Date in the wrong format! Please try again!");
		}
		return flag;
	}

	/**
	 * method for validate last name, first name and middle name
	 * @param name Last, First or Middle Name
	 * @return true if name valid, false else
	 */
	public boolean isValidName(String name){
		Pattern patternForName = Pattern.compile("^[A-Z]{1}+[a-z]+$");
		Matcher matcherForName = patternForName.matcher(name);
		return matcherForName.matches();
	}

	/**
	 * method for validate mark
	 * @param mark code of mark
	 * @return true if mark valid, false else
	 */
	public boolean isValidMark(int mark) {
		if ((mark >= 0) & (mark < Mark.values().length)) {
			return true;
		}
		return false;
	}

	/**
	 * method for validate type
	 * @param type code of type
	 * @return true if type valid, false else
	 */
	public boolean isValidType(int type) {
		if ((type >= 0) & (type < Type.values().length)) {
			return true;
		}
		return false;
	}

	/**
	 * method for validate color
	 * @param color code of color
	 * @return true if color valid, false else
	 */
	public boolean isValidColor(int color) {
		if ((color >= 0) & (color < Color.values().length)) {
			return true;
		}
		return false;
	}

	/**
	 * method for validate cost
	 * @param cost cost in format string
	 * @return true if cost valid, false else
	 */
	public boolean isValidCost(String cost) {
		Pattern patternForCost = Pattern.compile("^[1-9]\\d*?(\\.\\d{1,2})?$");
		Matcher matcherForCost = patternForCost.matcher(cost);
		if (matcherForCost.matches()) {
			this.cost = Double.parseDouble(cost);
		}
		return matcherForCost.matches();
	}

	/**
	 * method for validate client
	 * @param idClient unique number f client
	 * @param historyClient list of clients
	 * @return true if historyClient contain client with idClient , false else
	 */
	public boolean isValidClient(int idClient, HistoryClient historyClient) {
		if (historyClient.getUnchangedCopy().size() > idClient) {
			return true;
		}
		return false;
	}

	/**
	 * method for validate device
	 * @param idDevice unique number of device
	 * @param historyDevice list of devices
	 * @return true if historyDevice contain device with idDevice , false else
	 */
	public boolean isValidDevice(int idDevice, HistoryDevice historyDevice) {
		if (historyDevice.getUnchangedCopy().size() > idDevice) {
			return true;
		}
		return false;
	}

	public double getCost() {
		return cost;
	}
	public Date getDate() {
		return date;
	}
}
