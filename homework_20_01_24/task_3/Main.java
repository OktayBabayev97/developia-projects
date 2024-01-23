package task_3;

public class Main {

	public static void main(String[] args) {
		GenericArray arr = new GenericArray();
		Footballer[] footballer = new Footballer[6];
		footballer[0] = new Footballer("Cristiano Ronaldo", 39, "Portugal", 7, "Al-nassr", "Forward");
		footballer[1] = new Footballer("Lionel Messi", 36, "Argentina", 10, "Inter Miami", "Forward");
		footballer[2] = new Footballer("Luca Modric", 39, "Croatia", 10, "Real Madrid", "Midfielder");
		footballer[3] = new Footballer("Sergio Ramos", 38, "Spain", 4, "Sevilla FC", "Defender");
		footballer[4] = new Footballer("Alphonso  Davies", 24, "Canada", 19, "Bayern Munich", "Defender");
		footballer[5] = new Footballer("Manuel Neuer", 38, "Germany", 1, "Bayern Munich", "Goalkeeper");
		Integer[] numbers = { 9, 42, 8, 97, 7 };
		arr.firstElement(footballer);
		arr.lastElement(footballer);
		
		arr.firstElement(numbers);
		arr.lastElement(numbers);
	}

}
