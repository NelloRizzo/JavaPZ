package corso.java.words;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Stream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Lettore del dizionario.
 */
public class WordsReader {
	private static final Logger log = LoggerFactory.getLogger(WordsReader.class);
	/**
	 * L'elenco delle parole lette.
	 */
	private final Set<Word> words = new HashSet<Word>();

	/**
	 * @return uno Stream sulle parole gestite.
	 */
	public Stream<Word> getWords() {
		return words.stream();
	}

	/**
	 * Costruisce il dizionario.
	 * @param fileName nome del file da cui leggere le parole.
	 */
	public WordsReader(String fileName) {
		// try-with-resources: richiama su r automaticamente il metodo close()
		try (var r = new BufferedReader(new FileReader(fileName))) {
			String line;
			while ((line = r.readLine()) != null) {
				words.add(new Word(line));
			}
		} catch (FileNotFoundException e) {
			log.error("File not found: {}", fileName);
		} catch (IOException e) {
			log.error("Exception reading file", e);
		}
	}
}
