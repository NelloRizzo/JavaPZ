package corso.java;

// compito della classe 
// sarà inizializzata a partire da un testo e, dopo l'inizializzazione,
// dovrà fornire le consonanti e le vocali presenti nel testo
public class ConsonantsVowels {

	private StringBuilder consonants = new StringBuilder();
	private StringBuilder vowels = new StringBuilder();

	public StringBuilder getConsonants() {
		return consonants;
	}

	public StringBuilder getVowels() {
		return vowels;
	}

	public ConsonantsVowels(String text) {
		// metto pute il testo in maiuscolo
		text = text.toUpperCase();
		// percorro tutto il testo
		for (int i = 0; i < text.length(); ++i) {
			// mi prendo un carattere alla volta
			char c = text.charAt(i);
			// se si tratta di un carattere alfabetico
			if (c >= 'A' && c <= 'Z') {
				// controllo se si tratta di una vocale
				if (c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U') {
					vowels.append(c);
				} else {
					consonants.append(c);
				}
			}
		}
	}
}
