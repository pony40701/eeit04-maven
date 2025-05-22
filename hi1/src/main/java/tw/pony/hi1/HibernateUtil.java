package tw.pony.hi1;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import tw.pony.model.Cust;
import tw.pony.model.Gift;
import tw.pony.model.Member;
import tw.pony.model.MemberInfo;
import tw.pony.model.Order;

public class HibernateUtil {
	private static SessionFactory sessionFactory;
	
	public static SessionFactory getSessionFactory() {
		if (sessionFactory == null) {
			try {
				Configuration config = new Configuration();
				config.configure("hibernate.cfg.xml");
				
				config.addAnnotatedClass(Member.class);
				config.addAnnotatedClass(MemberInfo.class);
				config.addAnnotatedClass(Gift.class);
				config.addAnnotatedClass(Cust.class);
				config.addAnnotatedClass(Order.class);
				
				sessionFactory = config.buildSessionFactory();
				
			}catch(Exception e) {
				System.out.println(e);
			}
		}
		return sessionFactory;
	}
}