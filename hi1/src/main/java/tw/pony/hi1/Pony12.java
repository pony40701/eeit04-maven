package tw.pony.hi1;

import java.util.Date;

import tw.pony.dao.CustDao;
import tw.pony.model.Cust;
import tw.pony.model.Order;

public class Pony12 {

	public static void main(String[] args) {
		CustDao custDao = new CustDao();
		custDao.removeOrderFromCust(9, 7);
	}

}