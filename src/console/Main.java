package console;

import java.util.*;

import menu.UserMenu;
import history.AllHistory;

/**
 * @author LappoPolina ����� ������������� ��������� ������� � �������������
 *         ����� ������� �������� ����� �����
 */
public class Main {

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		AllHistory historyOfAllNotes = new AllHistory();

		// �����������
		UserMenu.helpForUser();

		while (true) {
			System.out.println("Enter comad:");

			switch (in.next()) {

			case "createClient": // ���������� ������ �������
				UserMenu.createClient(historyOfAllNotes);
				break;
			case "createDevice": // ���������� ������ ����������
				UserMenu.createDevice(historyOfAllNotes);
				break;
			case "createSale": // ���������� ����� �������
				UserMenu.createSale(historyOfAllNotes);
				break;
			case "sortListClient": // ����������
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
			case "sortListDevice": // ����������
				break;
			case "sortListSale": // ����������
				break;
			case "searchOnListClient": // �����
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
			case "showListClient": // ����� ������ �������� �� �����
				UserMenu.showListClient(historyOfAllNotes);
				break;
			case "showListDevice": // ����� ������ ��������� �� �����
				UserMenu.showListDevice(historyOfAllNotes);
				break;
			case "showListSale": // ����� ������ ������ �� �����
				UserMenu.showListSale(historyOfAllNotes);
				break;
			case "exit": // ���������� ������ ���������
				in.close();
				System.out.println("Bye! Bye!");
				System.exit(0);
				break;
			default: // ������� ������� �������
				System.out.println("ERROR. Unknown comand. Try again");
				break;
			}
		}
	}
}
