package bookTask;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Book implements Comparable<Book> {
	String title, author;
	Integer publicationYear;

	public static void main(String[] args) {
		Book b = new Book("Crime and Punishment", "Fyodor Dostoevsky", 1866);
		Book b2 = new Book("Les Misérables", "Victor Hugo", 1862);
		Book b3 = new Book("1984", "George Orwell", 1949);
		List<Book> books = new ArrayList();
		books.add(b);
		books.add(b2);
		books.add(b3);
		Collections.sort(books);
		for (Book allBooks : books) {
			System.out.println(allBooks);
		}
	}

	public Book(String title, String author, Integer publicationYear) {
		this.title = title;
		this.author = author;
		this.publicationYear = publicationYear;
	}

	@Override
	public int compareTo(Book b) {
		return this.publicationYear - b.publicationYear;
	}

	@Override
	public String toString() {
		return "Book title=" + title + ", author=" + author + ", publicationYear=" + publicationYear + "";
	}

}
