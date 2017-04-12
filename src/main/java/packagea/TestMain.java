package packagea;

import java.io.File;
import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;



public class TestMain {
	private static SessionFactory sessionFactory;
	
	public static void insertCourses() {
		Session session= sessionFactory.openSession();
		
		Set<Student> students_hibernate =new HashSet<Student>();
		Student s= new Student("Prakash");
		Student s1= new Student("Vishal");
		students_hibernate.add(s);
		students_hibernate.add(s1);
		
		Course course_hibernate= new Course("Hibernet",students_hibernate);
		//course_hibernate.setStudents(students_hibernate);
		
		Transaction tr=session.beginTransaction();
		session.persist(course_hibernate);
		tr.commit();
		session.close();
		sessionFactory.close();
	}
	public static void main(String[] args) {
		

		Configuration config= new Configuration();
		config.configure(new File("D:/ProjectDocs/Billeo1/Workspace/MappingM-M/src/hibernate.cfg.xml"));
		sessionFactory= config.buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction tr=session.beginTransaction();
		
		insertCourses();
		
		
	}
}
