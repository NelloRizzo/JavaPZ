package corso.java.dices;

/**
 * Un dado truccato sbilanciato sull'estrazione del 6.
 */
public class LoadedDice extends Dice {

	@Override
	public int roll() {
		// estraggo un numero casuale tra 1 e 10
		var v = rnd.nextInt(10) + 1;
		// se il numero è maggiore di 5
		if (v > 5)
			// restituisco 6
			return 6;
		// altrimenti restituisco il numero (1-5)
		return v;
	}
}
