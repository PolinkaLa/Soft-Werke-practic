package comparatordevice;

import java.util.Comparator;

import base.Device;

public class ComparatorDeviceColor implements Comparator {
	public int compare(Object arg0, Object arg1) {
		if ((arg0 instanceof Device) & (arg1 instanceof Device)) {
			Device user0 = (Device) arg0;
			Device user1 = (Device) arg1;
			
			if ((user0.getColor() != null) & (user1.getColor() != null)) {
				int flag = user0.getColor().compareTo(user1.getColor());																	
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
