package homework_27_12_23;

public class Person {
	private String name;
	private int age;
	private Gender gender;

	public static void main(String[] args) {
		Person person = new Person("Oktay", 26, Gender.MALE);
		person.setAge(27);
		System.out.println("Name: " + person.getName() + "\nAge: " + person.getAge() + "\nGender: " + person.getGender());
	}

	public Person(String name, int age, Gender gender) {
		this.name = name;
		this.age = age;
		this.gender = gender;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

}
