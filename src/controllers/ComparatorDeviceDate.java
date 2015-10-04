package controllers;

import java.util.Comparator;

import model.Device;

public class ComparatorDeviceDate implements Comparator<Object> {
	public int compare(Object arg0, Object arg1) {
		if ((arg0 instanceof Device) & (arg1 instanceof Device)) {
			Device device0 = (Device) arg0;
			Device device1 = (Device) arg1;
			
			if ((device0.getDateOfProduce() != null) & (device1.getDateOfProduce() != null)) {
				int flag = device0.getDateOfProduce().compareTo(device1.getDateOfProduce());																	
				if (flag == 0)
					return device0.getMark().compareTo(device1.getMark());
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