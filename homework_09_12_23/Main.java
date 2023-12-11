package homework_09_12_23;

public class Main {

	public static void main(String[] args) {
		Book b = new Book("Crime and Punishment", "Fyodor Dostoevsky", 527, 1866);
		b.displayDetails(b);
		System.out.println(Book.getTotalBooks());
		Book b2 = new Book("Les Misérables", "Victor Hugo", 1462, 1862);
		b2.displayDetails(b2);
		System.out.println(Book.getTotalBooks());
	}

}
