package tw.pony.hi1;

import tw.pony.dao.SCDao;
import tw.pony.model.Course;

public class Pony14 {

	public static void main(String[] args) {
		Course c1 = new Course("Java");
		Course c2 = new Course("JDBC");
		Course c3 = new Course("Servlet");
		Course c4 = new Course("JSP");
		Course c5 = new Course("Hibernate");
		
		SCDao dao = new SCDao();
		dao.add(c1);dao.add(c2);dao.add(c3);
		dao.add(c4);dao.add(c5);
		
	}

}