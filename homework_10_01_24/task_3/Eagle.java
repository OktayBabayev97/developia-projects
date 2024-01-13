package task_3;

public class Eagle extends Animal implements Flyable {
	public Eagle(String specie, double size) {
		super.specie = specie;
		super.size = size;
		System.out.println("Eagle specie: " + specie + "\nEagle size: " + size + " cm");
	}

	@Override
	public void fly() {
		System.out.println("Eagle is flying");

	}

	@Override
	public boolean isPredator() {
		System.out.println(specie + " is a bird of prey");
		return true;
	}

	@Override
	public void eat() {
		if (Math.random() * 10 < 6) {
			System.out.println("The eagle is fed");
			size += Math.round(Math.random() * 10);
		} else {
			System.out.println("The eagle is not fed");
		}
		System.out.println("Eagle current size: " + size + " cm");

	}

	@Override
	public void die() {
		// TODO Auto-generated method stub

	}
}
