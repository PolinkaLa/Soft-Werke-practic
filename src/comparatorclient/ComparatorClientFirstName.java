package comparatorclient;

import java.util.Comparator;

import base.Client;

public class ComparatorClientFirstName implements Comparator {
	public int compare(Object arg0, Object arg1) {
		if ((arg0 instanceof Client) & (arg1 instanceof Client)) {
			Client user0 = (Client) arg0;
			Client user1 = (Client) arg1;
			if ((user0.getFirstName() != null)&(user1.getFirstName() != null)) {
				int flag = user0.getFirstName().compareTo(user1.getFirstName());
				if (flag == 0)
					return user0.getLastName().compareTo(user1.getLastName());
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
