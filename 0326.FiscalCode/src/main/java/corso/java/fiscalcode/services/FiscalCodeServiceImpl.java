package corso.java.fiscalcode.services;

import java.time.LocalDate;

import org.springframework.stereotype.Service;

import corso.java.fiscalcode.controllers.models.PersonalData;
import corso.java.fiscalcode.entities.City;
import corso.java.fiscalcode.repositories.CitiesRepository;

@Service
public class FiscalCodeServiceImpl implements FiscalCodeService {

	private final CitiesRepository citiesRepository;

	public FiscalCodeServiceImpl(CitiesRepository citiesRepository) {
		this.citiesRepository = citiesRepository;
	}

	@Override
	public String generateFiscalCode(PersonalData data) {
		var sb = new StringBuilder() //
				.append(handleLastName(data.getLastName())) // cognome
				.append(handleFirstName(data.getFirstName())) // nome
				// data di nascita e sesso
				.append(handleBirthday(data.getBirthday(), data.getGender())) //
				.append(handleBirthCity(data.getBirthCity())) // città di nascita
		;
		// calcola il carattere di controllo lo aggiunge al codice fiscale
		// e restituisce il codice fiscale completo
		return sb.append(checkCode(sb)).toString();
	}

	private String checkCode(StringBuilder sb) {
		// tabella di conversione per il calcolo del carattere di controllo
		int[] odds = { 1, 0, 5, 7, 9, 13, 15, 17, 19, 21, 2, 4, 18, 20, 11, 3, 6, 8, 12, 14, 16, 10, 22, 25, 24, 23 };
		var sum = 0;
		// ciclo sui primi 15 caratteri del codice fiscale
		for (var i = 0; i < 15; ++i) {
			// recupera il carattere corrente
			var c = sb.charAt(i);
			// calcola il valore numerico corrispondente
			// se il carattere è una cifra, sottrai '0' per ottenere il valore numerico
			// altrimenti sottrai 'A' per ottenere il valore numerico
			var depl = Character.isDigit(c) ? c - '0' : c - 'A';
			// somma il valore numerico corretto
			// se l'indice è pari (dispari nel codice fiscale),
			// usa il valore della tabella odds
			// altrimenti usa il valore numerico del carattere
			sum += (i % 2 == 0) ? odds[depl] : depl;
		}
		// prende il resto della divisione per 26 e lo converte in carattere
		return Character.toString(sum % 26 + 'A');
	}

	private String handleBirthCity(String birthCity) {
		return citiesRepository.findByName(birthCity) // recupera la città
				.map(City::getCadastralCode) // prende il codice catastale
				.orElse("X000") // se la città non è presente, restituisce un codice fittizio
		;
	}

	private String handleBirthday(LocalDate birthday, char gender) {
		// tabella di conversione per i mesi
		var month = "ABCDEHLMPRST".charAt(birthday.getMonthValue() - 1);
		// calcola il giorno di nascita e aggiunge 40 se il sesso è femminile
		var day = birthday.getDayOfMonth() + (gender == 'm' ? 0 : 40);
		// restituisce la data nel formato richiesto dall'algoritmo
		return String.format("%ty%c%02d", birthday, month, day);
	}

	/**
	 * Classe interna per separare le consonanti dalle vocali.
	 */
	private static class LettersSeparator {
		// StringBuilder è più efficiente di String per concatenare stringhe
		// qui ci saranno le consonanti 
		public final StringBuilder consonants = new StringBuilder();
		// e qui le vocali
		public final StringBuilder vowels = new StringBuilder();

		// dopo la chiamata al costruttore, le stringhe consonants e vowels contengono
		// rispettivamente le consonanti e le vocali del testo
		public LettersSeparator(String text) {
			text.toUpperCase().chars() // apre lo stream di caratteri del testo convertito in maiuscolo
					.filter(Character::isAlphabetic) // esclude tutto ciò che non è alfabetico
					.forEach(c -> {
						// separa le vocali dalle consonanti
						if (c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U') {
							vowels.append(Character.toString(c));
						} else {
							consonants.append(Character.toString(c));
						}
					});
		}
	}

	private String handleFirstName(String firstName) {
		// separa le consonanti dalle vocali
		var ls = new LettersSeparator(firstName);
		// se ci sono più di 3 consonanti, rimuove la seconda
		if (ls.consonants.length() > 3)
			ls.consonants.delete(1, 2);
		// se ci sono meno di 3 consonanti, aggiunge le vocali
		return ls.consonants.append(ls.vowels).append("XXX").substring(0, 3);
	}

	private String handleLastName(String lastName) {
		// separa le consonanti dalle vocali
		var ls = new LettersSeparator(lastName);
		// se ci sono meno di 3 consonanti, aggiunge le vocali
		return ls.consonants.append(ls.vowels).append("XXX").substring(0, 3);
	}

}
