package menu;

import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import base.Client;
import base.Device;
import base.Sale;
import enums.Color;
import enums.Mark;
import enums.Type;
import controllers.Validation;
import history.AllHistory;

/**
 * @author LappoPolina
 * 
 */
public class UserMenu {
	
	static SimpleDateFormat formatOfDate = new SimpleDateFormat("dd.MM.yyyy"); 
	static Scanner in = new Scanner(System.in);
	
	private static Validation valid = new Validation();
	
	public static void createClient(AllHistory historyOfAllNotes){
		System.out.println("Enter Last Name, First Name, Middle Name and date "
				+ "of Birthday in format dd.mm.yyyy:");
		String last = in.next();
		String first = in.next();
		String middle = in.next();
		String dateBirth =in.next();
		valid.parsDate(dateBirth);
		historyOfAllNotes.setClients(new Client(last, first, middle, valid.getDate()));
		System.out.println("Client create successfully.");
	}
	
	public static void createDevice(AllHistory historyOfAllNotes){
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
		double cos = in.nextDouble();
		String date = in.next();
		valid.parsDate(date);
		historyOfAllNotes.setDevices(new Device(Mark.values()[mark], Type.values()[type], model, 
				Color.values()[color], cos, valid.getDate()));
		System.out.println("Device create successfully.");
	}
	
	public static void createSale(AllHistory historyOfAllNotes){
		System.out.println("Enter Date in format dd.mm.yyyy, IdClient and Numder of purchased device:");
		String dateSale = in.next();
		valid.parsDate(dateSale);
		int idClient = in.nextInt();
		int number = in.nextInt();
		int idDevice;
		int count;
		Map<Device, Integer> checkSale = new HashMap<Device, Integer>();
		for (int i = 0; i < number; i++){
			System.out.println("Enter IdDevice and Count:");
			idDevice = in.nextInt();
			count = in.nextInt();
			checkSale.put(historyOfAllNotes.getDevices().get(idDevice-1), count); 
		 }
		historyOfAllNotes.setSales(new Sale(valid.getDate(), historyOfAllNotes.getClients().get(idClient-1), checkSale) ); // заполнить юзерами по их айди
		System.out.println("Sale create successfully.");
	}
	
	public static void showListClient(AllHistory historyOfAllNotes){
		for (int i = 0; i < historyOfAllNotes.getClients().size(); i++)
			System.out.println(historyOfAllNotes.getClients().get(i).toString());
	}
	
	public static void showListDevice(AllHistory historyOfAllNotes){
		for (int i = 0; i < historyOfAllNotes.getDevices().size(); i++)
			System.out.println(historyOfAllNotes.getDevices().get(i).toString());
	}
	
	public static void showListSale(AllHistory historyOfAllNotes){
		for (int i = 0; i < historyOfAllNotes.getSales().size(); i++)
			System.out.println(historyOfAllNotes.getSales().get(i).toString());
	}
	

}
