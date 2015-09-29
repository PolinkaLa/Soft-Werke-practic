package history;

import java.util.List;
import java.util.ArrayList;

import base.Client;
import base.Device;
import base.Sale;

/**
 * @author LappoPolina ����� ��������� ������� ������ ��������, ��������� �
 *         ����������� ������ ����������� �������� ��� ��������� � ���������
 *         �������
 */
public class AllHistory {

	private List<Client> clients = new ArrayList<>();
	private List<Device> devices = new ArrayList<>();
	private List<Sale> sales = new ArrayList<>();

	public List<Client> getClients() {
		return clients;
	}

	public List<Device> getDevices() {
		return devices;
	}

	public List<Sale> getSales() {
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
