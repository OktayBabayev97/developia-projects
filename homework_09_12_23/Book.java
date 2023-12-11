package homework_09_12_23;

public class Book {
	String name;
	String author;
	int pageCount;
	int publicationDate;
	static int totalBookCount;

	public Book(String name, String author, int pageCount, int publicationDate) {
		this.name = name;
		this.author = author;
		this.pageCount = pageCount;
		this.publicationDate = publicationDate;
		totalBookCount++;
	}

	public void displayDetails(Book bookDisplay) {
		System.out.println("Book name: " + bookDisplay.name + "\nBook author: " + bookDisplay.author + "\nPage count: "
				+ bookDisplay.pageCount + "\nDate: " + bookDisplay.publicationDate);
	}

	public static int getTotalBooks() {
		System.out.print("Total books count: ");
		return totalBookCount;
	}
}
