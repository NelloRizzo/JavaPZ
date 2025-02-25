package corso.java.cards;

public abstract class Card {
	/**
	 * Il seme della carta.
	 */
	private int seed;
	/**
	 * Il valore della carta.
	 */
	private int value;

	public Card(int seed, int value)  {
		setSeed(seed);
		setValue(value);
	}

	public int getSeed() {
		return seed;
	}

	public int getValue() {
		return value;
	}

	// protected: aggiunge il metodo alla private view delle sottoclassi
	protected void setSeed(int seed) {
		this.seed = seed;
	}

	protected void setValue(int value)  {
		this.value = value;
	}
}
