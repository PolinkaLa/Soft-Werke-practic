package console;

import java.util.*;

import menu.UserMenu;
import history.AllHistory;

/**
 * @author LappoPolina
 * 
 */
public class Main {

	public static void main(String[] args) {
				
		Scanner in = new Scanner(System.in);
		AllHistory historyOfAllNotes = new AllHistory();
		//приветствие
		System.out.println("Hi! You can create new Client, new Device, new Sale!");
		System.out.println("So you can sort and search lists");
		System.out.println("Comand:");
		System.out.println("	createCleint -  add new Client");
		System.out.println("	createDevice - add new Device");
		System.out.println("	createSale - add new Sale");
		System.out.println("	sortListClient - sorting list of Client");
		System.out.println("	sortListDevice - sorting list of Device");
		System.out.println("	sortListSale - sorting list of Sale");
		System.out.println("	search - for finding information");
		System.out.println("	showListClient - show list of clients");
		System.out.println("	showListDevice - show list of devices");
		System.out.println("	showListSale - show list of sales");
		System.out.println("	exit - end of work");
		
		//создание списков клиентов, устройств, продаж
		
		
		//обработка команд
		//String operation;
		while (true) {
			System.out.println("Enter comad:");
			
			switch (in.next()){
			
			case "createClient": // добавление нового клиента
				UserMenu.createClient(historyOfAllNotes);
				break;
        	case "createDevice": // добавление нового устройства
				UserMenu.createDevice(historyOfAllNotes);
				break;
			case "createSale": // добавление новой продажи
				UserMenu.createSale(historyOfAllNotes);
				break;
			case "sortListClient": // сортировка
				//System.out.println("On what basis will sort (Date, LastName, FirstName, MiddeleName):");
				
				switch (in.next()){
					case "Date":
						break;
					case "LastName":
						break;
					case "FirsName":
						break;
					case "MiddleName":
						break;
				}
				break;
			case "sortListDevice": // сортировка
				break;
			case "sortListSale": // сортировка
				break;
			case "search": // поиск
				break;
			case "showListClient": // вывод списка клиентов на экран
				UserMenu.showListClient(historyOfAllNotes);
				break;
			case "showListDevice": // вывод списка устройств на экран
				UserMenu.showListDevice(historyOfAllNotes);
				break;
			case "showListSale": // вывод списка продаж на экран
				UserMenu.showListSale(historyOfAllNotes);
				break;
			case "exit": // завершение работы программы
				in.close();
				System.out.println("Bye! Bye!");
				System.exit(0);
				break;
			default: // команда введена неверно
				System.out.println("ERROR. Unknown comand. Try again");
				break;
			}		
		}
	}
}
