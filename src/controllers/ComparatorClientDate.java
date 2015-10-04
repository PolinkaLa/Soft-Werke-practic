package controllers;

import java.util.Comparator;

import model.Client;

public class ComparatorClientDate implements Comparator<Object> {
	public int compare(Object arg0, Object arg1) {
		if ((arg0 instanceof Client) & (arg1 instanceof Client)) {
			Client client0 = (Client) arg0;
			Client client1 = (Client) arg1;

			if ((client0.getDateOfBirth() != null) & (client1.getDateOfBirth() != null)) {
				int flag = client0.getDateOfBirth().compareTo(client1.getDateOfBirth());
				if (flag == 0)
					return client0.getLastName().compareTo(client1.getLastName());
				else
					return flag;
			} else
				return 1;
		} else
			return 1;
	}
}
