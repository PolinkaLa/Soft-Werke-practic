package comparatordevice;

import java.util.Comparator;

import model.Device;

public class ComparatorDeviceDate implements Comparator<Object> {
	public int compare(Object arg0, Object arg1) {
		if ((arg0 instanceof Device) & (arg1 instanceof Device)) {
			Device user0 = (Device) arg0;
			Device user1 = (Device) arg1;
			
			if ((user0.getDateOfProduce() != null) & (user1.getDateOfProduce() != null)) {
				int flag = user0.getDateOfProduce().compareTo(user1.getDateOfProduce());																	
				if (flag == 0)
					return user0.getMark().compareTo(user1.getMark());
				else 
					return flag;
			}
			else 
				return 1;
		} 
		else
			return 1;
	}
}