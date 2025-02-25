package corso.java.cards.exceptions;

public class InvalidCardValueException extends RuntimeException {
	private int invalidValue;

	public InvalidCardValueException(int invalidValue) {
		this.invalidValue = invalidValue;
	}

	public int getInvalidValue() {
		return invalidValue;
	}
}
