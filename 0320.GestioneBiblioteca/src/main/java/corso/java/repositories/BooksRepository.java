package corso.java.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import corso.java.entities.Author;
import corso.java.entities.Book;

public interface BooksRepository extends JpaRepository<Book, Integer> {
	/**
	 * Ricerca per parte del titolo
	 * 
	 * @param title la parte del titolo cercata
	 */
	List<Book> findAllByTitleContains(String title);

	/**
	 * Ricerca per parte del nome o del cognome
	 * 
	 * @param firstName la parte del nome cercata
	 * @param lastName  la parte del cognome cercata
	 */
	List<Book> findAllByAuthorFirstNameContainsOrAuthorLastNameContains(String firstName, String lastName);

	/**
	 * Ricerca per nazionalità
	 * 
	 * @param country la sigla della nazione
	 */
	List<Book> findAllByAuthorCountry(String country);

	/**
	 * Ricerca per anno di pubblicazione
	 * 
	 * @param from anno iniziale
	 * @param to   anno finale
	 * @return
	 */
	List<Book> findAllByYearBetween(int from, int to);

	/**
	 * Ricerca per autore
	 * 
	 * @param author l'entità che rappresenta l'autore cercato
	 */
	List<Book> findAllByAuthor(Author author);

	/**
	 * Ricerca per l'id della categoria
	 * 
	 * @param categoryId l'id della categoria
	 */
	List<Book> findAllByCategoryId(int categoryId);

	/**
	 * Ricerca per anno di nascita dell'autore
	 * 
	 * @param from anno iniziale
	 * @param to   anno finale
	 */
	List<Book> findAllByAuthorYearOfBirthBetween(int from, int to);
}
