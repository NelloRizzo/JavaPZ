package corso.java;

import java.time.LocalDate;

public class FiscalCodeService {

	public String calculateFiscalCode(PersonalData data) {
		StringBuilder sb = new StringBuilder();
//		- 3 lettere per il cognome
		sb.append(handleLastName(data.getLastName()));
//		- 3 lettere per il nome
		sb.append(handleFirstName(data.getFirstName()));
//		- l'anno di nascita (numero)
//		- il mese della data di nascita (lettera)
//		- il giorno della data di nascita (numero)
		sb.append(handleBirthday(data.getBirthday(), data.getGender()));
//		- il codice del comune di nascita
		sb.append("X000");
//		- il carattere di controllo
		sb.append("X");
		return sb.toString();
	}

	private String handleBirthday(LocalDate birthday, Gender gender) {
		/*
		 * Anno di nascita Per l'anno vengono prese semplicemente le ultime due cifre.
		 * 
		 * Esempio: Anno : 1970 - Codice Anno: 70
		 */
		String year = String.format("%ty", birthday);
		/*
		 * Mese Per quanto riguarda il mese c'è una tabella di conversione che
		 * riportiamo qui di seguito. Ad ogni mese corrisponde una lettera
		 * dell'alfabeto: ABCDEHLMPRST
		 */
		String months = "ABCDEHLMPRST";
		char month = months.charAt(birthday.getMonthValue() - 1);
		/*
		 * Giorno In questo caso è sufficiente riportare il numero del giorno, con il
		 * particolare che per le donne questo numero dev'essere aumentato di 40!
		 */
		int day = birthday.getDayOfMonth() + (gender == Gender.FEMALE ? 40 : 0);
		return String.format("%s%c%02d", year, month, day);
	}

	private String handleFirstName(String fn) {
		/*
		 * Per il nome il discorso è analogo al cognome con la particolarità che se il
		 * nome è composto da 4 o più consonanti vengono prese nell'ordine la prima, la
		 * terza e la quarta. Anche qui potremmo trovarci nella situazione di un numero
		 * di consonanti minore di 3 e allo stesso modo si aggiungo le vocali. Ripetiamo
		 * anche qui che se il nome è più corto di 3 lettere è possibile sostituire i
		 * caratteri mancanti con delle X. Se il nome fosse composto da più nomi,
		 * bisogna considerarlo tutto assieme.
		 */
		ConsonantsVowels cv = new ConsonantsVowels(fn);
		StringBuilder cons = cv.getConsonants();
		if (cons.length() > 3) // se ci sono più di tre consonanti
			// elimino il secondo carattere delle consonanti
			cons.delete(1, 2);
		return String.format("%s%sX", cons, cv.getVowels()).substring(0, 3);
	}

	// gestisce il cognome
	private String handleLastName(String ln) {
		/*
		 * Sono necessari 3 caratteri per rappresentare il cognome, e sono la prima la
		 * seconda e la terza consonante del cognome. E' possibile che le consonanti
		 * siano meno di tre, in questo caso è possibile aggiungere le vocali
		 * nell'ordine in cui compaiono nel cognome. Per cognomi più corti di 3
		 * caratteri, è possibile sostituire il carattere mancante con la lettera X.
		 * Chiaramente se ci sono cognomi con più parti, è necessario rimuovere gli
		 * spazi e considerare tutto come un cognome unico.
		 */
		ConsonantsVowels cv = new ConsonantsVowels(ln);
		return String.format("%s%sX", cv.getConsonants(), cv.getVowels()).substring(0, 3);
	}
}
