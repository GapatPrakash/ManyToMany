package packagea;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Course {

	@javax.persistence.Id
	@GeneratedValue
	private int Id;
	private String CourseName;
	public int getId() {
		return Id;
	}
	public Course(String courseName) {
		super();
		CourseName = courseName;
	}
	public void setId(int id) {
		Id = id;
	}
	
	public Course() {
		// TODO Auto-generated constructor stub
	}
	public Course(String courseName, Set<Student> students) {
		super();
		CourseName = courseName;
		this.students = students;
	}
	
	public String getCourseName() {
		return CourseName;
	}
	public void setCourseName(String courseName) {
		CourseName = courseName;
	}
	
	@ManyToMany(cascade={CascadeType.ALL},mappedBy="courses")	
	
	public Set<Student> getStudents() {
		return students;
	}
	public void setStudents(Set<Student> students) {
		this.students = students;
	}
	private Set<Student> students=new HashSet<Student>();
	
}
