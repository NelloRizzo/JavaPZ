package converters;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import converters.services.Converter;
import converters.services.ConverterImpl;
import converters.services.NumberTranslator;
import converters.services.NumbersTranslatorImpl;
import converters.services.exceptions.NumberOutOfRangeException;

public class Program {
	private static final Logger log = LoggerFactory.getLogger(Program.class);

	static void convert(Converter converter) {
		int min = 0;
		int max = 128;
		log.info("Conversione dei numeri da {} a {}", min, max);
		for (var i = min; i <= max; ++i) {
			var bin = converter.toBin(i);
			var oct = converter.toOct(i);
			var hex = converter.toHex(i);

			converter.fromBin(bin);
			converter.fromOct(oct);
			converter.fromHex(hex);
		}
	}

	static void numbersTranslation(NumberTranslator translator) {
		int min = 1900;
		int max = 1000000;
		try {
			for (var i = min; i <= max; ++i) {

				log.info("{} -> {}", i, translator.translate(i));

			}
		} catch (NumberOutOfRangeException e) {
			log.error("Il numero {} è fuori dai limiti gestiti", e.getNumber());
		}
	}

	public static void main(String[] args) {
		// Scrivere un convertitore di numeri da base 10 a binario,
		// ottale ed esadecimale e viceversa.
		convert(new ConverterImpl());

		// Aggiungiamo un convertitore che trasformi i numeri in lettere.
		// Esempio: 1234 -> milleduecentotrentaquattro
		numbersTranslation(new NumbersTranslatorImpl());
	}

}
