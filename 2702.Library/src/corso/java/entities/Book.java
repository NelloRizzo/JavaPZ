package corso.java.entities;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class Book extends LibraryRecord {
	private String title;
	private int pages;
	private String isbn;
	private int year;
	private final List<Author> authors = new ArrayList<>();

	public Book(int id, Publisher publisher, String title, int pages, String isbn, int year) {
		super(id, publisher);
		this.title = title;
		this.pages = pages;
		this.isbn = isbn;
		this.year = year;
	}

}
