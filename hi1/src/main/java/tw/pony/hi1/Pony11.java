package tw.pony.hi1;

import java.util.Date;

import tw.pony.dao.CustDao;
import tw.pony.model.Cust;
import tw.pony.model.Order;

public class Pony11 {

	public static void main(String[] args) {
		CustDao custDao = new CustDao();
		Cust cust = custDao.getById(9);
		if (cust != null) {
			System.out.println(cust.getOrders().size());
			
			Order order1 = new Order();
			order1.setOrderDate(new Date());
			
			Order order2 = new Order();
			order2.setOrderDate(new Date());
			
			cust.addOrder(order1);
			cust.addOrder(order2);
			
			custDao.update(cust);
		}else {
			System.out.println("NOT FOUND");
		}
	}

}