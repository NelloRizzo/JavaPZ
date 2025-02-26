package converters.services.exceptions;

import lombok.Getter;

/**
 * Indica che il numero da tradurre è troppo grande.
 */
public class NumberOutOfRangeException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	/**
	 * Il numero che si è cercato di tradurre.
	 */
	@Getter
	private int number;

	/**
	 * Costruttore.
	 * 
	 * @param number il numero che ha provocato l'errore.
	 */
	public NumberOutOfRangeException(int number) {
		super("Number out of range");
		this.number = number;
	}
}
