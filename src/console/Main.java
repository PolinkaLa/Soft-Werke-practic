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
		//�����������
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
		
		//�������� ������� ��������, ���������, ������
		
		
		//��������� ������
		//String operation;
		while (true) {
			System.out.println("Enter comad:");
			
			switch (in.next()){
			
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
			case "sortListDevice": // ����������
				break;
			case "sortListSale": // ����������
				break;
			case "search": // �����
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
