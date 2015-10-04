package controllers;

import java.util.Comparator;

import model.Sale;

public class ComparatorSaleDate implements Comparator<Object> {
	public int compare(Object arg0, Object arg1) {
		if ((arg0 instanceof Sale) & (arg1 instanceof Sale)) {
			Sale sale0 = (Sale) arg0;
			Sale sale1 = (Sale) arg1;

			if ((sale0.getDateOfSale() != null) & (sale1.getDateOfSale() != null)) {
				int flag = sale0.getDateOfSale().compareTo(sale1.getDateOfSale());
				if (flag == 0)
					return sale0.getIdSale().compareTo(sale1.getIdSale());
				else
					return flag;
			} else
				return 1;
		} else
			return 1;
	}
}
