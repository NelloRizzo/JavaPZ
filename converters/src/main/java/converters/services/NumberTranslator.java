package converters.services;

public interface NumberTranslator {
	/**
	 * Produce la rappresentazione di un numero sotto forma di stringa.
	 * 
	 * @param number il numero.
	 * @return la rappresentazione come stringa (in italiano) del numero.
	 */
	String translate(int number);
}
