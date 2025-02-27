package corso.java.words;

import java.util.List;
import java.util.Optional;
import java.util.Random;

public class WordServiceImpl implements WordService {

	private static final Random rnd = new Random();

	private final WordsReader reader;

	public WordServiceImpl(WordsReader reader) {
		this.reader = reader;
	}

	@Override
	public List<Word> getAnagrams(String word) {
		// recupero la "firma" della parola così da cercare tutte le parole
		// che hanno la stessa firma
		var signature = new Word(word).signature();
		return reader.getWords() // prendo lo stream di parole
				.filter(w -> w.signature().equals(signature)) // cerco quelle che hanno la stessa "firma"
				.toList();
	}

	@Override
	public Optional<Word> random(int length) {
		// recupero tutte le parole della lunghezza desiderata
		var list = reader.getWords().filter(w -> w.getWord().length() == length).toList();
		if (list.isEmpty()) // se non ce ne sono
			return Optional.empty(); // restituisco "vuoto"

		return list.stream() // apro uno stream sulle parole trovate
				.skip(rnd.nextLong(list.size())) // ne salto un numero a caso
				.findAny(); // prendo la prima che trovo
	}

}
