package task_3;

public class Main {

	public static void main(String[] args) {
		Eagle eagle=new Eagle("Golden Eagle",90);
		eagle.isPredator();
		eagle.fly();
		eagle.eat();
		eagle.die();
		
		Fish fish=new Fish("Spearfish",203);
		fish.isAmphibian();
		fish.swim();
		fish.eat();
		fish.die();
	}

}
