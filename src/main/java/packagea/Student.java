package packagea;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Student {

	
	private int StudentId;
	@Id
	@GeneratedValue
	@Column
	public int getStudentId() {
		return StudentId;
	}
	public void setStudentId(int studentId) {
		StudentId = studentId;
	}
	public Student() {
		// TODO Auto-generated constructor stub
	}
	
	
	public Student(String studentName) {
		super();
		StudentName = studentName;
	}
	public Student(String studentName, Set<Course> courses) {
		super();
		StudentName = studentName;
		this.courses = courses;
	}


	@Column
	public String getStudentName() {
		return StudentName;
	}
	public void setStudentName(String studentName) {
		StudentName = studentName;
	}
	
	
	@ManyToMany(cascade={CascadeType.ALL})
	@JoinTable(name = "STUDENT_COURSE", joinColumns = @JoinColumn(name ="StudentId"), inverseJoinColumns = @JoinColumn(name = "CourseId"))	
	public Set<Course> getCourses() {
		return courses;
	}
	public void setCourses(Set<Course> courses) {
		this.courses = courses;
	}
	private String StudentName;
	private Set<Course> courses= new HashSet<Course>();
	
}
