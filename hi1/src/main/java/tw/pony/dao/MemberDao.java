package tw.pony.dao;


import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.*;
import java.util.*;

import tw.pony.apis.BCrypt;
import tw.pony.hi1.HibernateUtil;
import tw.pony.model.Member;

public class MemberDao {

	public void save(Member member) {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();

			member.setPasswd(BCrypt.hashpw(member.getPasswd(), BCrypt.gensalt()));

			session.persist(member);

			transaction.commit();
		} catch (Exception e) {
			System.out.println(e);
			if (transaction != null) {
				transaction.rollback();
			}
		}
	}

	public Member getById(int id) {
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {

			return session.get(Member.class, id);
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}

	public void delete(Member member) {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();

			session.remove(member);

			transaction.commit();
		} catch (Exception e) {
			System.out.println(e);
			if (transaction != null) {
				transaction.rollback();
			}
		}
	}

	public void update(Member member) {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();

			session.merge(member);

			transaction.commit();
		} catch (Exception e) {
			System.out.println(e);
			if (transaction != null) {
				transaction.rollback();
			}
		}
	}
	public List<Member> getall(){
		try (Session session = HibernateUtil.getSessionFactory().openSession()){
				String hql = "FROM Member";
				return session.createQuery(hql, Member.class).getResultList();
		}catch(Exception e) {
			System.out.println(e);
			return null;
		}
	}
}