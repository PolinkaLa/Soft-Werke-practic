package comparatorsale;

import java.util.Comparator;

import model.Sale;

public class ComparatorSaleDate implements Comparator<Object> {
	public int compare(Object arg0, Object arg1) {
		if ((arg0 instanceof Sale) & (arg1 instanceof Sale)) {
			Sale user0 = (Sale) arg0;
			Sale user1 = (Sale) arg1;

			if ((user0.getDateOfSale() != null) & (user1.getDateOfSale() != null)) {
				int flag = user0.getDateOfSale().compareTo(user1.getDateOfSale());
				if (flag == 0)
					return user0.getIdSale().compareTo(user1.getIdSale());
				else
					return flag;
			} else
				return 1;
		} else
			return 1;
	}
}
