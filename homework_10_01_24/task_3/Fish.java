package task_3;

public class Fish extends Animal implements Swimmable {
	public Fish(String specie, double size) {
		super.specie = specie;
		super.size = size;
		System.out.println("Fish specie: " + specie + "\nFish size: " + size + " cm");
	}

	@Override
	public void swim() {
		System.out.println("Fish is swimming");

	}

	@Override
	public boolean isAmphibian() {
		System.out.println(specie + " is not amphibian");
		return false;
	}

	@Override
	public void eat() {
		if (Math.random() * 10 < 5) {
			System.out.println("The fish is fed");
			size += Math.round(Math.random() * 10);
		} else {
			System.out.println("The fish is not fed");
		}
		System.out.println("Fish current size: " + size + " cm");
	}

	@Override
	public void die() {
		if (Math.random() * 10 < 5) {
			System.out.println("Fish died");
		}

	}

}
