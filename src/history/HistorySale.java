package history;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import model.*;

/**
 * class to store list of sales
 * @author LappoPolina
 *
 */
public class HistorySale {

private List<Sale> sales = new ArrayList<>();

	public List<Sale> getUnchangedCopy() {
		List<Sale> salesCopy = new ArrayList<Sale>();
		salesCopy.addAll(sales);
		return salesCopy;
	}

	public final void addSales(Sale sale) {
		sales.add(sale);
	}
	public Map<Device, Integer> getDevices(int idClient) {
		Map<Device, Integer> deviceCopy = new HashMap<Device, Integer>();
		deviceCopy.putAll(sales.get(idClient).getCheckOfSle());
		return deviceCopy;
	}
	public void setSale(List<Sale> sales) {
		this.sales = sales;
	}
	public List<Sale> getChangedCopy() {
		return sales;
	}
}
