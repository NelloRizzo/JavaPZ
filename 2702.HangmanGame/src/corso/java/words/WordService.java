package corso.java.words;

import java.util.List;
import java.util.Optional;

/**
 * Servizio che elenca i metodi applicativi.
 */
public interface WordService {
	/**
	 * Ottiene gli anagrammi di una parola.
	 * 
	 * @param word la parola da cui partire.
	 * @return l'elenco degli anagrammi della parola data.
	 */
	List<Word> getAnagrams(String word);

	/**
	 * Recupera una parola a caso di una determinata lunghezza.
	 * 
	 * @param length la lunghezza della parola da produrre.
	 * @return una parola a caso della lunghezza richiesta (o Optional.empty() se
	 *         non esistono parole di quella lunghezza).
	 */
	Optional<Word> random(int length);
	
}
