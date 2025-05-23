package tw.pony.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import tw.pony.hi1.HibernateUtil;
import tw.pony.model.Course;
import tw.pony.model.Student;

public class SCDao {
	public void add(Student student) {
		Transaction transaction = null;
		try(Session session = 
				HibernateUtil.getSessionFactory().openSession()){
			transaction = session.beginTransaction();
			
			session.persist(student);
			
			transaction.commit();
		}catch(Exception e) {
			System.out.println(e);
			if (transaction != null) {
				transaction.rollback();
			}
		}
	}
	public void add(Course course) {
		Transaction transaction = null;
		try(Session session = 
				HibernateUtil.getSessionFactory().openSession()){
			transaction = session.beginTransaction();
			
			session.persist(course);
			
			transaction.commit();
		}catch(Exception e) {
			System.out.println(e);
			if (transaction != null) {
				transaction.rollback();
			}
		}
	}
	
	public void delete(Student student) {
		Transaction transaction = null;
		try(Session session = 
				HibernateUtil.getSessionFactory().openSession()){
			transaction = session.beginTransaction();
			
			session.remove(student);
			
			transaction.commit();
		}catch(Exception e) {
			System.out.println(e);
			if (transaction != null) {
				transaction.rollback();
			}
		}		
	}

	public Student update(Student student) {
		Transaction transaction = null;
		try(Session session = 
				HibernateUtil.getSessionFactory().openSession()){
			transaction = session.beginTransaction();
			
			session.merge(student);
			
			transaction.commit();
			
			return getById(student.getId());
			
			
		}catch(Exception e) {
			System.out.println(e);
			if (transaction != null) {
				transaction.rollback();
			}
			return null;
		}		
	}
	
	public Student getById(long id) {
		try(Session session = 
				HibernateUtil.getSessionFactory().openSession()){
			return session.get(Student.class, id);
		}catch(Exception e) {
			System.out.println(e);
			return null;
		}		
	}
	public Course getCourseById(int id) {
		try(Session session = 
				HibernateUtil.getSessionFactory().openSession()){
			return session.get(Course.class, id);
		}catch(Exception e) {
			System.out.println(e);
			return null;
		}		
	}	
	
	public List<Course> getAllCourse(){
		try(Session session = 
				HibernateUtil.getSessionFactory().openSession()){
			return session.createQuery("FROM Course", Course.class).getResultList();
		}catch(Exception e) {
			System.out.println(e);
			return null;
		}			
	}
	
	
	
	
}