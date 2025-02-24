package corso.java.cards;

public class FrenchCard extends Card {

	public static final int JOKER_VALUE = 14;
	public static final Seeds RED_JOKER_SEED = Seeds.HEARTS;
	public static final Seeds BLACK_JOKER_SEED = Seeds.SPADES;

	public enum Seeds {
		HEARTS, DIAMONDS, CLUBS, SPADES
	};

	public FrenchCard(Seeds seed, int value) {
		super(seed.ordinal(), value);
	}

	@Override
	protected void setSeed(int seed) {
		// occorre gestire il valore del seme per evitare valori non validi
		if (seed < 0 || seed > 3)
			return;
		super.setSeed(seed);
	}

	@Override
	protected void setValue(int value) {
		// occorre gestire il valore per evitare errori
		if ((value < 1 || value > 13) && value != JOKER_VALUE)
			return;
		super.setValue(value);
	}

	@Override
	public String toString() {
		var value = getValue();
		var seed = getSeed();

		if (value == JOKER_VALUE)
			return seed == RED_JOKER_SEED.ordinal() ? "Red joker" : "Black joker";

		// le figure delle carte francesi
		String[] figures = { "J", "Q", "K" };
		// se valore = 1 allora è un asso
		var v = value == 1 ? "A" : //
		// altrimenti se valore < 11 scrivi il numero
				value < 11 ? String.format("%s", getValue()) : //
				// altrimenti prendi la stringa dall'array delle figure
						figures[value - 11];
		return String.format("%s of %s", v, Seeds.values()[seed].toString().toLowerCase());
	}
}
