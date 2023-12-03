public class Student {
	String name;
	int rollNumber;
	String grade;

	public static void main(String[] args) {
		Student st = new Student("Oktay", 454, "Bachelor");
		System.out.println("Student name: " + st.name + "\nRoll number: " + st.rollNumber + "\nGrade: " + st.grade);
	}

	public Student(String name, int rollNumber, String grade) {
		this.name = name;
		this.rollNumber = rollNumber;
		this.grade = grade;
	}
}
