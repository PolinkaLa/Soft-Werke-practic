package comparatorsale;

import java.util.Comparator;

import model.Sale;

public class ComparatorSaleClient implements Comparator<Object> {
	public int compare(Object arg0, Object arg1) {
		if ((arg0 instanceof Sale) & (arg1 instanceof Sale)) {
			Sale user0 = (Sale) arg0;
			Sale user1 = (Sale) arg1;
			
			if ((user0.getClient() != null) & (user1.getClient() != null)) {
				int flag = user0.getClient().getLastName().compareTo(user1.getClient().getLastName());																	
				if (flag == 0)
					return user0.getClient().getFirstName().compareTo(user1.getClient().getFirstName());
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