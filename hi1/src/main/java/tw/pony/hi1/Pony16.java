package tw.pony.hi1;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import tw.pony.dao.SCDao;
import tw.pony.model.Course;
import tw.pony.model.Student;

public class Pony16 extends JFrame{
	private JLabel name;
	private JButton add;
	private SCDao dao;
	private Student s;
	private CourseMenu menu;

	public Pony16() {
		super("選課");
		setLayout(new FlowLayout());
		
		dao = new SCDao();
		s = dao.getById(4);
		
		name = new JLabel(s.getSname());
		menu = new CourseMenu();
		add = new JButton("確定");
		add (name); add(menu); add(add);
		
		setSize(640, 480);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		add.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Course course =  menu.getSelected();
				s.addCourse(course);
				s = dao.update(s);
			}
		});
		
	}
	
	public static void main(String[] args) {
		new Pony16();
	}

}