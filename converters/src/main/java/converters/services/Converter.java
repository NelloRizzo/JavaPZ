package converters.services;

public interface Converter {
	/**
	 * Da decimale in binario.
	 * 
	 * @param number numero da convertire.
	 * @return la rappresentazione del numero in binario.
	 */
	String toBin(int number);

	/**
	 * Da decimale in esadecimale.
	 * 
	 * @param number numero da convertire.
	 * @return la rappresentazione del numero in esadecimale.
	 */
	String toHex(int number);

	/**
	 * Da decimale in ottale.
	 * 
	 * @param number numero da convertire.
	 * @return la rappresentazione del numero in ottale.
	 */
	String toOct(int number);

	/**
	 * Da binario in decimale.
	 * 
	 * @param number il numero da convertire.
	 * @return il valore del numero in decimale.
	 */
	int fromBin(String number);

	/**
	 * Da esadecimale in decimale.
	 * 
	 * @param number il numero da convertire.
	 * @return il valore del numero in decimale.
	 */
	int fromHex(String number);

	/**
	 * Da ottale in decimale.
	 * 
	 * @param number il numero da convertire.
	 * @return il valore del numero in decimale.
	 */
	int fromOct(String number);
}
