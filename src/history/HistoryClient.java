package history;

import java.util.ArrayList;
import java.util.List;

import model.Client;

/**
 * class to store list of clients
 * @author LappoPolina
 *
 */
public class HistoryClient {
	private List<Client> clients = new ArrayList<>();
	
	public List<Client> getUnchangedCopy() {
		List<Client> clientsCopy = new ArrayList<Client>();
		clientsCopy.addAll(clients);
		return clientsCopy;
	}
	public final void addClients(Client client) {
		clients.add(client);
	}
	
	public void setClients(List<Client> clients) {
		this.clients = clients;
	}
	public List<Client> getChangedCopy() {
		return clients;
	}
}
