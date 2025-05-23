package tw.pony.hi1;

import java.util.List;
import java.util.Scanner;
import java.util.Set;

import tw.pony.dao.SCDao;
import tw.pony.model.Course;
import tw.pony.model.Student;

public class Pony15 {
	public static void main(String[] args) {
		SCDao dao = new SCDao();
		Student s1 = dao.getById(2);
		if (s1 != null) {
			System.out.printf("Welcome, %s\n", s1.getSname());
			
			List<Course> courses = dao.getAllCourse();
			for (Course course : courses) {
				if (!isExist(s1, course.getStudents())) {
					System.out.printf("%d. %s\n", course.getId(), course.getCname());
				}
			}
			
			Scanner scanner = new Scanner(System.in);
			while (true) {
				System.out.print("Which course? ");
				int cid = scanner.nextInt();
				if (cid == 0) break;
				s1.addCourse(dao.getCourseById(cid));
			}
			
			dao.update(s1);
			
			
		}else {
			System.out.println("Student NOT FOUND");
		}
	}
	
	private static boolean isExist(Student s, Set<Student> students) {
		boolean ret = false;
		for (Student student: students) {
			if (student.getId() == s.getId()) {
				ret = true;
				break;
			}
		}
		
		return ret;
	}
	
	
	
}