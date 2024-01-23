package task_3;

public class Footballer extends Person {
	int number;
	String team;
	String position;

	public Footballer(String name, int age, String nationality, int number, String team, String position) {
		super(name, age, nationality);
		this.number = number;
		this.team = team;
		this.position = position;
	}

	@Override
	public String toString() {
		return "\nFootballer name:" + name + "\nAge: " + age + "\nNationality: " + nationality + "\nNumber: " + number
				+ "\nCurrent team: " + team + "\nPosition: " + position;
	}

}
