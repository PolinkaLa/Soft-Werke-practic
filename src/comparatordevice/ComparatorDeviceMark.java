package comparatordevice;

import java.util.Comparator;

import base.Device;

public class ComparatorDeviceMark implements Comparator {
	public int compare(Object arg0, Object arg1) {
		if ((arg0 instanceof Device) & (arg1 instanceof Device)) {
			Device user0 = (Device) arg0;
			Device user1 = (Device) arg1;
			
			if ((user0.getMark() != null) & (user1.getMark() != null)) {
				int flag = user0.getMark().compareTo(user1.getMark());																	
				if (flag == 0)
					return user0.getModel().compareTo(user1.getModel());
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
