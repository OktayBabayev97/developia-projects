import java.util.Scanner;

public class Country {
	String name;
	String capital;
	String language;
	Scanner scan = new Scanner(System.in);

	public Country() {
		System.out.println("Please enter country name");
		name = scan.nextLine();
		System.out.println("Please enter capital name");
		capital = scan.nextLine();
		System.out.println("Please enter language");
		language = scan.nextLine();
	}

	public static void main(String[] args) {
		Country c = new Country();
		System.out.println("country: "+c.name + "\n" +"Capital: "+ c.capital + "\n" +"Language: " + c.language);
	}
	
}
