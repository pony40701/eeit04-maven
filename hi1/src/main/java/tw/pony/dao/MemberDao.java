package tw.pony.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import tw.pony.apis.BCrypt;
import tw.pony.hi1.HibernateUtil;
import tw.pony.model.Member;

public class MemberDao {
	
	public void save(Member member) {
		Transaction transaction = null;
		try(Session session = 
				HibernateUtil.getSessionFactory().openSession()){
			transaction = session.beginTransaction();
			
			member.setPasswd(
				BCrypt.hashpw(member.getPasswd(), BCrypt.gensalt()));
			
			session.persist(member);
			
			transaction.commit();
		}catch(Exception e) {
			System.out.println(e);
			if (transaction != null) {
				transaction.rollback();
			}
		}
	}
	
	public Member getById(int id) {
		try(Session session = 
				HibernateUtil.getSessionFactory().openSession()){
			
			return session.get(Member.class, id);
		}catch(Exception e) {
			System.out.println(e);
			return null;
		}		
	}
	
	
	
}