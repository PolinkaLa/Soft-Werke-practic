package practic;

import java.util.Comparator;

import base.Client;

public class ComparatorClientDate implements Comparator{
	  public int compare(Object arg0, Object arg1) {
	        Client user0 = (Client) arg0;
	        Client user1 = (Client) arg1;

	        int flag = user0.getDateOfBirth().compareTo(user1.getDateOfBirth());
	        if (flag == 0) {
	            return user0.getLastName().compareTo(user1.getLastName());
	        } else {
	            return flag;
	        }
	    }

}
