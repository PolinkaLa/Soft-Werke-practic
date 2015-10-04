package history;

import java.util.ArrayList;
import java.util.List;
import model.Device;

/**
 * class to store list of devices
 * @author LappoPolina
 *
 */
public class HistoryDevice {
	private List<Device> devices = new ArrayList<>();
	
	public List<Device> getDevices() {
		List<Device> devicesCopy = new ArrayList<Device>();
		devicesCopy.addAll(devices);
		return devicesCopy;
	}
	public final void addDevices(Device device) {
		devices.add(device);
	}
}
