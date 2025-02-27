package corso.java.services;

import java.time.LocalDate;
import java.util.List;

import corso.java.entities.Author;
import corso.java.entities.Book;
import corso.java.entities.Frequency;
import corso.java.entities.LibraryRecord;
import corso.java.entities.Magazine;
import corso.java.entities.Newspaper;
import corso.java.entities.Publisher;

public interface LibraryService {
	void add(LibraryRecord item);
	int count();
	List<LibraryRecord> getAll();
	List<Book> getBooksByTitle(String title);
	List<Newspaper> getNewspapersByDate(LocalDate from, LocalDate to);
	List<Book> getItemsByAuthor(Author author);
	List<LibraryRecord> getItemsByPublisher(Publisher publisher);
	List<Magazine> getMagazines(Frequency frequency);
}
