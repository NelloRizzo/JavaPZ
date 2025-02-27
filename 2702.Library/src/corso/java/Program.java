package corso.java;

import java.time.LocalDate;

import corso.java.entities.Author;
import corso.java.entities.Book;
import corso.java.entities.Frequency;
import corso.java.entities.Magazine;
import corso.java.entities.Newspaper;
import corso.java.entities.Publisher;
import corso.java.services.InMemoryLibraryService;
import corso.java.services.LibraryService;

public class Program {
	static void useService(LibraryService service) {
		var caltagirone = new Publisher("Caltagirone Editore", "Roma");
		var mondadori = new Publisher("Mondadori", "Milano");
		var edisport = new Publisher("Edisport", "Milano");
		service.add(new Newspaper(1, caltagirone, LocalDate.now(), "Il Mattino"));
		service.add(new Newspaper(2, caltagirone, LocalDate.now().minusDays(1), "Il Mattino"));
		service.add(new Newspaper(3, caltagirone, LocalDate.now().minusDays(2), "Il Mattino"));
		service.add(new Newspaper(4, caltagirone, LocalDate.now().minusDays(3), "Il Mattino"));
		service.add(new Newspaper(5, caltagirone, LocalDate.now().minusDays(3), "Il Messaggero"));
		service.add(new Magazine(5, caltagirone, LocalDate.of(2025, 1, 1), Frequency.Weekly, "La Settimana Enigmistica",
				"1/2025"));
		service.add(new Magazine(5, edisport, LocalDate.of(2025, 1, 1), Frequency.Monthly, "In Sella", "1/2025"));
		service.add(new Magazine(5, mondadori, LocalDate.of(2025, 1, 1), Frequency.Monthly, "Focus", "1/2025"));

		var book = new Book(100, mondadori, "Programmare in Windows", 1900, "9303030330", 1980);
		book.getAuthors().add(new Author("Charles", "Petzold", "USA"));
		service.add(book);
		
		System.out.println("Tutta la libreria");
		service.getAll().forEach(i -> System.out.println(i));
		System.out.println("Tutte le pubblicazioni di Caltagirone");
		service.getItemsByPublisher(caltagirone).forEach(i -> System.out.println(i));
	}

	public static void main(String[] args) {
		useService(new InMemoryLibraryService());
	}
}
