package studentsGpaComparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		Student s1 = new Student("James", 25, 75);
		Student s2 = new Student("Kane", 22, 84);
		Student s3 = new Student("Lara", 27, 90);
		List<Student> studentsList = new ArrayList();
		studentsList.add(s1);
		studentsList.add(s2);
		studentsList.add(s3);

		Collections.sort(studentsList);
		for (Student student : studentsList) {
			System.out.println(student);
		}
	}

}
