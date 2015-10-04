package controllers;

import java.util.Comparator;

import model.Client;

public class ComparatorClientLastName implements Comparator<Object> {
	public int compare(Object arg0, Object arg1) {
		if ((arg0 instanceof Client) & (arg1 instanceof Client)) {
			Client client0 = (Client) arg0;
			Client client1 = (Client) arg1;
			if (( client0.getLastName() != null) & (client1.getLastName() != null)) {
				int flag = client0.getLastName().compareTo(client1.getLastName());
				if (flag == 0)
					return client0.getFirstName().compareTo(client1.getFirstName());
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
