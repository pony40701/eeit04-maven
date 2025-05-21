package tw.pony.hi1;

import java.lang.reflect.Member;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;

import tw.pony.utils.HibernateUtil;

public class Pony02 {
	public static void main(String[] args) {
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {

			Transaction transaction = session.beginTransaction();
			String sql = "INSERT INTO member (account,passwd,cname)" + "VALUES (:account, :passwd, :cname)";
			NativeQuery<Member> query = session.createNativeQuery(sql, Member.class);
			query.setParameter("account", "test1");
			query.setParameter("passwd", "test2");
			query.setParameter("cname", "test3");

			int n = query.executeUpdate();

			transaction.commit();

		} catch (Exception e) {
			System.out.println(e);
		}

	}
}