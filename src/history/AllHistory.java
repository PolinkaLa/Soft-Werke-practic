package history;

import java.util.List;
import java.util.ArrayList;

import model.Client;
import model.Device;
import model.Sale;

/**
 * @author LappoPolina Класс позволяет хранить списки Клиентов, Устройств и
 *         совершаемых продаж Опеределены свойства для получения и изменения
 *         списков
 */
public class AllHistory {

	private List<Client> clients = new ArrayList<>();
	private List<Device> devices = new ArrayList<>();
	private List<Sale> sales = new ArrayList<>();

	public List<Client> getClients() {
		List<Client> clientsCopy = new ArrayList<Client>();
		clientsCopy.addAll(clients);
		return clientsCopy;
	}

	public List<Device> getDevices() {
		List<Device> devicesCopy = new ArrayList<Device>();
		devicesCopy.addAll(devices);
		return devicesCopy;
	}

	public List<Sale> getSales() {
		List<Sale> salesCopy = new ArrayList<Sale>();
		salesCopy.addAll(sales);
		return salesCopy;
	}

	public final void addClients(Client client) {
		clients.add(client);
	}

	public final void addDevices(Device device) {
		devices.add(device);
	}

	public final void addSales(Sale sale) {
		sales.add(sale);
	}
}
