package controllers;

import java.util.Comparator;

import model.Device;

public class ComparatorDeviceModel implements Comparator<Object> {
	public int compare(Object arg0, Object arg1) {
		if ((arg0 instanceof Device) & (arg1 instanceof Device)) {
			Device device0 = (Device) arg0;
			Device device1 = (Device) arg1;
			
			if ((device0.getModel() != null) & (device1.getModel() != null)) {
				int flag = device0.getModel().compareTo(device1.getModel());																	
				if (flag == 0)
					return device0.getMark().compareTo(device1.getMark());
				else {
					return flag;
				}
			}
			else {
				return 1;
			}
		} 
		else {
			return 1;
		}
	}
}
