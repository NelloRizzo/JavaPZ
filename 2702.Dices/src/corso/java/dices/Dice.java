package corso.java.dices;

import java.util.Random;

/**
 * Un dado.
 */
public class Dice {
	/**
	 * Generatore di numeri casuali.
	 */
	protected static final Random rnd = new Random();

	/**
	 * Lancia il dado.
	 * 
	 * @return il risultato del lancio del dado.
	 */
	public int roll() {
		return rnd.nextInt(6) + 1;
	}
}
