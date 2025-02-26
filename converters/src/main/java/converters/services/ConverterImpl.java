package converters.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ConverterImpl implements Converter {
	private static final Logger log = LoggerFactory.getLogger(ConverterImpl.class);

	// tutte le cifre possibili
	private static final String DIGITS = "0123456789ABCDEF";

	/**
	 * Da intero verso una base.
	 * 
	 * @param number numero da convertire.
	 * @param base   base di conversione.
	 * @return il numero convertito nella base richiesta.
	 */
	private String toBase(int number, int base) {
		if (number == 0)
			return "0";
		log.info("Da {} decimale a base {}", number, base);
		// per produrre l'output
		StringBuilder sb = new StringBuilder();
		while (number > 0) {
			// prendo il resto della divisione tra number e base
			// e recupero la cifra dalle cifre di sopra
			// n.b. insert inserisce la cifra a sinistra della stringa
			sb.insert(0, DIGITS.charAt(number % base));
			// divido il numero per la base e vado avanti
			number /= base;
		}
		log.info(" = {}", sb);
		return sb.toString();
	}

	/**
	 * Da una base verso decimale.
	 * 
	 * @param number il numero scritto nella base specificata.
	 * @param base   la base nella quale è scritto il numero.
	 * @return il valore decimale del numero.
	 */
	private int fromBase(String number, int base) {
		int result = 0;
		// scorro a ritroso le cifre del numero
		// i è l'indice sulla stringa e pow è la potenza alla quale devo elevare la base
		for (int i = number.length() - 1, pow = 1; i >= 0; --i, pow *= base) {
			// recupero la posizione della cifra tra tutte le cifre possibili
			// (in pratica prendo il valore della cifra
			int digit = DIGITS.indexOf(number.charAt(i));
			// la moltiplico per la potenza e aggiungo al risultato
			result += digit * pow;
		}
		log.info("Da {} in base {} a decimale {}", number, base, result);
		return result;
	}

	@Override
	public String toBin(int number) {
		var result = toBase(number, 2);
		// calcolo quanti 0 aggiungere per allineare ad un byte
		var pad = 8 - result.length() % 8;
		// "0".repeat(pad) aggiunge gli 0 di allineamento
		return String.format("%s%s", "0".repeat(pad), result);
	}

	@Override
	public String toHex(int number) {
		return toBase(number, 16);
	}

	@Override
	public String toOct(int number) {
		return toBase(number, 8);
	}

	@Override
	public int fromBin(String number) {
		return fromBase(number, 2);
	}

	@Override
	public int fromHex(String number) {
		return fromBase(number, 16);
	}

	@Override
	public int fromOct(String number) {
		return fromBase(number, 8);
	}

}
