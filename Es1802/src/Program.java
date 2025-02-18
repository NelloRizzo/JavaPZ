
public class Program {

	// controlla se un anno è bisestile
	static boolean isLeapYear(int year) {
		// anno divisibile per 400
		return (year % 400 == 0) //
				// oppure
				||
				// non divisibile per 100 ma divisibile per 4
				(year % 100 != 0 && year % 4 == 0);
	}

	// restituisce i giorni dei mesi per un anno specifico
	static int[] monthDays(int year) {
		// days[0] = giorni di gennaio ... days[11] = giorni di dicembre
		int[] days = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
		if (isLeapYear(year)) // se l'anno è bisestile
			days[1] = 29; // febbraio (secondo mese) ha 29 giorni
		return days;
	}

	// controlla se una tripletta di interi rappresenta una data valida
	static boolean isValidDate(int year, int month, int day) {
		// recupero i giorni dei mesi per l'anno in esame
		int[] days = monthDays(year);
		return month > 0 && month < 13 // mese compreso tra 1 e 12
		// giorno compreso tra 1 e il numero di giorni del mese
		// il -1 dipende dal fatto che il primo mese (gennaio = 1)
		// sta in posizione 0 nell'array e quindi è necessario "aggiustare" il valore
		// per accedere all'array
				&& day > 0 && day <= days[month - 1];
	}

	// raprpesenta una data come stringa a partire da giorno, mese e anno
	static String toDate(int year, int month, int day) {
		if (!isValidDate(year, month, day))
			return "Non è una data";
		return "" + day + "/" + month + "/" + year;
	}

	// fa lo stesso a partire da un array
	static String toDate(int[] dateParts) {
		return toDate(dateParts[0], dateParts[1], dateParts[2]);
	}

	// restituisce un array che rappresentano giorno mese e anno
	// di una data rappresentata nel formato g/m/y
	static int[] fromDate(String date) {
		String[] p = date.split("/");
		int year = Integer.parseInt(p[2]);
		int month = Integer.parseInt(p[1]);
		int day = Integer.parseInt(p[0]);
		return new int[] { year, month, day };
	}

	// aggiunge un numero di giorni ad una data rappresentata da un array [y,m,d]
	static int[] addDays(int[] dateParts, int daysToAdd) {
		return addDays(dateParts[0], dateParts[1], dateParts[2], daysToAdd);
	}

	// aggiunge un nunero di giorni ad una data
	static int[] addDays(int year, int month, int day, int daysToAdd) {
		// serve ad incrementare il giorno
		int increment = 1;
		// se il numero di giorni è negativo
		if (daysToAdd < 0) {
			increment = -1; // l'incremento è negativo
			daysToAdd = -daysToAdd; // ma metto il numero di giorni in positivo
		}
		while (daysToAdd > 0) { // fin quando non ho terminato i giorni
			// leggo i giorni dei mesi nell'anno corrente
			int[] md = monthDays(year);
			day = day + increment; // incremento (o decremento) il giorno
			if (day < 0) { // se son passato al mese precedente
				month = month - 1; // cambio mese
				if (month < 0) { // se son passato all'anno precedente
					month = 12; // metto a dicembre
					year = year - 1; // e cambio anno
				}
				md = monthDays(year); // recupero i giorni dei mesi dell'anno
				day = md[month - 1]; // e imposto il numero di giorni al numero totale del mese
			} else if (day > md[month - 1]) { // se son passato al mese successivo
				day = 1; // il giorno è 1
				month = month + 1; // il mese cambia
				if (month > 12) { // se passo all'anno successivo
					month = 1; // il mese è gennaio
					year = year + 1; // e cambia l'anno
				}
			}
			daysToAdd--; // decremento il numero totale di giorni da aggiungere
		}
		// restituisco la nuova "data"
		return new int[] { year, month, day };
	}

	public static void main(String[] args) {
		// Dati tre interi che indicano giorno, mese e anno
		// controllare che essi possano rappresentare una data "valida"
		System.out.println("2025 => " + isLeapYear(2025));
		System.out.println("18/2/2025 => " + isValidDate(2025, 2, 18));
		System.out.println("29/2/2025 => " + isValidDate(2025, 2, 29));
		// creare un algoritmo che, a partire da una data "valida"
		// possa consentire di aggiungere ad essa un numero di giorni
		// e restituire la data "valida" corrispondente
		String dt = "18/2/2025";
		System.out.println(toDate(addDays(fromDate(dt), 12)));

	}

}
