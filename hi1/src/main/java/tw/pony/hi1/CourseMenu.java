package tw.pony.hi1;

import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;

import tw.pony.dao.SCDao;
import tw.pony.model.Course;

public class CourseMenu extends JComboBox<String>{
	private MyModel myModel;
	private List<Course> courses;
	
	public CourseMenu() {
		courses = new SCDao().getAllCourse();
		
		myModel = new MyModel();
		setModel(myModel);
	}
	
	public Course getSelected() {
		return courses.get(getSelectedIndex());
	}
	
	private class MyModel extends DefaultComboBoxModel<String>{

		@Override
		public int getSize() {
			return courses.size();
		}

		@Override
		public String getElementAt(int index) {
			return courses.get(index).getCname();
		}
		
	}
	
}