package corso.java.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import corso.java.entities.Author;

public interface AuthorsRepository extends JpaRepository<Author, Integer> {
	/**
	 * Cerca il primo autore che ha il cognome che inizia per una stringa
	 * 
	 * @param surname la parte iniziale del cognome
	 */
	Author findFirstByLastNameStartsWith(String surname);

	/**
	 * Cerca tutti gli autori in cui la data di morte è NULL
	 */
	List<Author> findAllByYearOfDeathIsNull();
}
