package corso.java.services;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import corso.java.entities.Author;
import corso.java.entities.Book;
import corso.java.entities.Frequency;
import corso.java.entities.LibraryRecord;
import corso.java.entities.Magazine;
import corso.java.entities.Newspaper;
import corso.java.entities.Publisher;

public class InMemoryLibraryService implements LibraryService {

	private Set<LibraryRecord> library = new HashSet<LibraryRecord>();

	@Override
	public void add(LibraryRecord item) {
		library.add(item);
	}

	@Override
	public List<Book> getBooksByTitle(String title) {
		return library.stream() //
				.filter(l -> l instanceof Book).map(l -> (Book) l).filter(b -> b.getTitle().equals(title)).toList();
	}

	@Override
	public List<Newspaper> getNewspapersByDate(LocalDate from, LocalDate to) {
		return library.stream() //
				.filter(l -> l instanceof Newspaper) //
				.map(l -> (Newspaper) l) //
				.filter(n -> n.getPublishedAt().isAfter(from.minusDays(1))
						&& n.getPublishedAt().isBefore(to.plusDays(1)))
				.toList();
	}

	@Override
	public List<Book> getItemsByAuthor(Author author) {
		return library.stream() //
				.filter(l -> l instanceof Book) //
				.map(l -> (Book) l) //
				.filter(b -> b.getAuthors().contains(author)) //
				.toList();
	}

	@Override
	public List<LibraryRecord> getItemsByPublisher(Publisher publisher) {
		return library.stream() //
				.filter(b -> b.getPublisher().equals(publisher)) //
				.toList();
	}

	@Override
	public List<Magazine> getMagazines(Frequency frequency) {
		return library.stream() //
				.filter(l -> l instanceof Magazine) //
				.map(l -> (Magazine) l) //
				.filter(b -> b.getFrequency() == frequency) //
				.toList();
	}

	@Override
	public int count() {
		return library.size();
	}

	@Override
	public List<LibraryRecord> getAll() {
		return library.stream().toList();
	}

}
