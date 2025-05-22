package tw.pony.hi1;

import java.util.Date;

import tw.pony.dao.CustDao;
import tw.pony.model.Cust;
import tw.pony.model.Order;

public class Pony10 {
	public static void main(String[] args) {
		CustDao custDao = new CustDao();
		Cust cust = new Cust();
		cust.setName("pony1");
		cust.setBirthday("1999-01-02");
		cust.setTel("0912-456789");
		
		Order order1 = new Order();
		order1.setOrderDate(new Date());
		
		Order order2 = new Order();
		order2.setOrderDate(new Date());
		
		cust.addOrder(order1);
		cust.addOrder(order2);
		
		custDao.save(cust);
	}
}
