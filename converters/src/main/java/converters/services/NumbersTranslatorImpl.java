package converters.services;

import converters.services.exceptions.NumberOutOfRangeException;

public class NumbersTranslatorImpl implements NumberTranslator {

	@Override
	public String translate(int number) {
		// se mi chiedono di tradurre 0, scrivo "zero"
		if (number == 0)
			return "zero";
		// se il numero è negativo
		if (number < 0)
			// restituisco "meno " + la traduzione del suo opposto
			return "meno " + translate(-number);
		return translateNumber(number) //
				.replace("iu", "u") //
				.replace("au", "u") //
				.replace("io", "o") //
				.replace("ao", "o") //
				.replace("oo", "o") //
		;
	}

	/**
	 * Algoritmo di "traduzione" del numero.
	 * @param number numero da tradurre.
	 * @return la rappresentazione del numero come stringa.
	 */
	private String translateNumber(int number) {
		// lo 0 è un caso gestito nel metodo pubblico del servizio
		if (number == 0)
			// quindi se 0 non restituisco nulla
			return "";
		// 1-19
		if (number < 20) {
			String[] units = { "uno", "due", "tre", "quattro", "cinque", "sei", "sette", //
					"otto", "nove", "dieci", "undici", "dodici", "tredici", "quattordici", //
					"quindici", "sedici", "diciassette", "diciotto", "diciannove" };
			return units[number - 1];
		}
		// 20-99
		if (number < 100) {
			String[] decades = { "venti", "trenta", "quaranta", "cinquanta", //
					"sessanta", "settanta", "ottanta", "novanta" };
			int decade = number / 10;
			int unit = number % 10;
			return decades[decade - 2] + translateNumber(unit);
		}
		// 100-999
		if (number < 1000) {
			int hundreds = number / 100;
			int remaining = number % 100;
			if (hundreds == 1)
				return "cento " + translateNumber(remaining);
			else
				return translateNumber(hundreds) + "cento " + translateNumber(remaining);
		}
		// 1000 - 999999
		if (number < 1000000) {
			int thousands = number / 1000;
			int remaining = number % 1000;
			if (thousands == 1)
				return "mille " + translateNumber(remaining);
			else
				return translateNumber(thousands) + "mila " + translateNumber(remaining);
		}
		// se arrivo qui significa che il numero non è gestito!!!
		throw new NumberOutOfRangeException(number);
	}

}
