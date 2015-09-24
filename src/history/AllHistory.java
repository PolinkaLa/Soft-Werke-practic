package history;

import java.util.ArrayList;

import base.Client;
import base.Device;
import base.Sale;

/**
 * @author LappoPolina
 * ����� ��������� ������� ������ ��������, ��������� � ����������� ������
 * ����������� �������� ��� ��������� � ��������� �������
 */
public class AllHistory {

		private ArrayList<Client> clients = new ArrayList<>();
		private ArrayList<Device> devices = new ArrayList<>();
		private ArrayList<Sale> sales = new ArrayList<>();
		
		/**
		 * �������� ��� ��������� ������ ��������
		 * @return  ArrayList
		 */
		public ArrayList<Client> getClients() {
			return clients;
		}
		/**
		 * �������� ��� ��������� ������ ��������
		 * @return  ArrayList
		 */
		public ArrayList<Device> getDevices() {
			return devices;
		}
		/**
		 * �������� ��� ��������� ������ ������
		 * @return  ArrayList
		 */
		public ArrayList<Sale> getSales() {
			return sales;
		}
		
		/**
		 * �������� ��� ���������� ����� ������ � ������� � ������
		 * @param client ������ � �������
		 */
		public final void setClients(Client client) {
			clients.add(client);
		}
		/**
		 * �������� ��� ���������� ����� ������ �� ���������� � ������
		 * @param device ������ �� ����������
		 */
		public final void setDevices(Device device) {
			devices.add(device);
		}
		/**
		 * �������� ��� ���������� ����� ������ � ������� 
		 * @param sale ������ � �������
		 */
		public final void setSales(Sale sale) {
			sales.add(sale);
		}
}
