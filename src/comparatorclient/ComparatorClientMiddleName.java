package comparatorclient;

import java.util.Comparator;

import base.Client;

public class ComparatorClientMiddleName implements Comparator {
	public int compare(Object arg0, Object arg1) {
		if ((arg0 instanceof Client) & (arg1 instanceof Client)) {
			Client user0 = (Client) arg0;
			Client user1 = (Client) arg1;
			if ((user0.getMiddleName() != null)&(user1.getMiddleName() != null)){
				int flag = user0.getMiddleName().compareTo(user1.getMiddleName());
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
