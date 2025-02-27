package corso.java;

import corso.java.words.WordService;
import corso.java.words.WordServiceImpl;
import corso.java.words.WordsReader;

public class Program {

	static void useWordService(WordService s) {
		var word = "ricerca";
		System.out.printf("Anagrammi della parola %s%n", word);
		s.getAnagrams(word).forEach(w -> System.out.println(w));
		int len = 25;
		System.out.printf("Parole a caso di %d lettere%n", len);
		for (var i = 0; i < 10; ++i) {
			System.out.println(s.random(len));
		}
	}

	public static void main(String[] args) {
		var reader = new WordsReader("./italian_wordlist.txt");
		System.out.printf("Lette %s parole%n", reader.getWords().count());
		int anaCount = 5;
		System.out.printf("Prime %s parole che hanno anagrammi%n", anaCount);
		reader.getWords()
				// filtro:
				.filter(
						// w è la parola che sto filtrando
						w -> reader.getWords() // tra tutte le parole
								// anyMatch -> ce n'è qualcuna che corrisponde
								.anyMatch(
										// i è la parola che sto filtrando con anyMatch
										i ->
										// innanzitutto non è la parola che sto filtrando
										!i.equals(w) &&
										// e poi deve avere la stessa firma della parola che sto filtrando
												i.signature().equals(w.signature()))) //
				.limit(anaCount) // limito la ricerca alle prime occorrenze
				.forEach(w -> System.out.println(w));
		var service = new WordServiceImpl(reader);
		useWordService(service);
	}

}
