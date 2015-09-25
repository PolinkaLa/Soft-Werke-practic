package history;

import java.util.ArrayList;

import base.Client;
import base.Device;
import base.Sale;

/**
 * @author LappoPolina
 * Класс позволяет хранить списки Клиентов, Устройств и совершаемых продаж
 * Опеределены свойства для получения и изменения списков
 */
public class AllHistory {

		private ArrayList<Client> clients = new ArrayList<>();
		private ArrayList<Device> devices = new ArrayList<>();
		private ArrayList<Sale> sales = new ArrayList<>();
		

		public ArrayList<Client> getClients() {
			return clients;
		}
		public ArrayList<Device> getDevices() {
			return devices;
		}
		public ArrayList<Sale> getSales() {
			return sales;
		}
		
	
		public final void setClients(Client client) {
			clients.add(client);
		}
		public final void setDevices(Device device) {
			devices.add(device);
		}
		public final void setSales(Sale sale) {
			sales.add(sale);
		}
}
