package studentsGpaComparator;

import java.util.Comparator;

public class Student implements Comparable<Student> {
	String name;
	Integer age;
	Integer gpa;

	public Student(String name, int age, int gpa) {
		this.name = name;
		this.age = age;
		this.gpa = gpa;
	}

	@Override
	public String toString() {
		return "Student name=" + name + ", age=" + age + ", gpa=" + gpa + "";
	}

	@Override
	public int compareTo(Student s) {
		return -1 * (this.gpa - s.gpa);
	}
}
