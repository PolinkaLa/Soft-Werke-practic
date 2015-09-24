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
		
		/**
		 * Свойство для получения списка клиентов
		 * @return  ArrayList
		 */
		public ArrayList<Client> getClients() {
			return clients;
		}
		/**
		 * Свойстов для получения списка устройст
		 * @return  ArrayList
		 */
		public ArrayList<Device> getDevices() {
			return devices;
		}
		/**
		 * Свойство для получения списка продаж
		 * @return  ArrayList
		 */
		public ArrayList<Sale> getSales() {
			return sales;
		}
		
		/**
		 * Свойство для добавления новой записи о клиенте в список
		 * @param client данные о клиенте
		 */
		public final void setClients(Client client) {
			clients.add(client);
		}
		/**
		 * Свойство для добавления новой записи об устройстве в список
		 * @param device данные об устройстве
		 */
		public final void setDevices(Device device) {
			devices.add(device);
		}
		/**
		 * Свойство ддя добавления новой записи о продаже 
		 * @param sale данные о продаже
		 */
		public final void setSales(Sale sale) {
			sales.add(sale);
		}
}
