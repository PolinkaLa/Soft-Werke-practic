package console;

import java.util.*;

import menu.UserMenu;
import history.AllHistory;

/**
 * @author LappoPolina Класс предоставляет программе общение с пользователем
 *         через консоль Содержит точку входа
 */
public class Main {

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		AllHistory historyOfAllNotes = new AllHistory();

		// приветствие
		UserMenu.helpForUser();

		while (true) {
			System.out.println("Enter comad:");

			switch (in.next()) {

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
				System.out.println("On what basis will sort (Date, LastName, FirstName, MiddeleName):");

				switch (in.next()) {
				case "Date":
					UserMenu.compareClientDate(historyOfAllNotes);
					break;
				case "LastName":
					UserMenu.compareClientLastName(historyOfAllNotes);
					break;
				case "FirstName":
					UserMenu.compareClientFirstName(historyOfAllNotes);
					break;
				case "MiddleName":
					UserMenu.compareClientMiddleName(historyOfAllNotes);
					break;
				}
				break;
			case "sortListDevice": // сортировка
				break;
			case "sortListSale": // сортировка
				break;
			case "searchOnListClient": // поиск
				System.out.println("On what basis will search (Date, LastName, FirstName, MiddeleName):");

				switch (in.next()) {
				case "Date":
					UserMenu.searchClientDate(historyOfAllNotes);
					break;
				case "LastName":
					UserMenu.searchClientLastName(historyOfAllNotes);
					break;
				case "LastFirstName":
					UserMenu.searchClientLastFirstName(historyOfAllNotes);
					break;
				case "MiddleName":
					UserMenu.compareClientMiddleName(historyOfAllNotes);
					break;
				}
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
