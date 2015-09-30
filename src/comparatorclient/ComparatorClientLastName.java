package comparatorclient;

import java.util.Comparator;

import model.Client;

public class ComparatorClientLastName implements Comparator<Object> {
	public int compare(Object arg0, Object arg1) {
		if ((arg0 instanceof Client) & (arg1 instanceof Client)) {
			Client user0 = (Client) arg0;
			Client user1 = (Client) arg1;
			if (( user0.getLastName() != null) & (user1.getLastName() != null)) {
				int flag = user0.getLastName().compareTo(user1.getLastName());
				if (flag == 0)
					return user0.getFirstName().compareTo(user1.getFirstName());
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
