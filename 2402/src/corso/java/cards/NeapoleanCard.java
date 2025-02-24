package corso.java.cards;

public class NeapoleanCard extends Card {

	/**
	 * Semi delle carte napoletane.
	 */
	public enum Seeds {
		DENARI, COPPE, SPADE, BASTONI
	}

	public NeapoleanCard(Seeds seed, int value) {
		// ordinal di una enum restituisce la posizione
		// dell'elemento nella dichiarazione della enum
		// (nel nostro caso denari = 0, bastoni = 3
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
		if (value < 1 || value > 10)
			return;
		super.setValue(value);
	}

	@Override
	public String toString() {
		var value = getValue();
		var seed = getSeed();
		// seme = denari = 0 e valore = 7 => settebello
		if (seed == 0 && value == 7)
			return "settebello";
		// le figure delle carte napoletane
		String[] figures = { "donna", "cavallo", "re" };
		// se valore = 1 allora è un asso
		var v = value == 1 ? "asso" : //
		// altrimenti se valore < 8 scrivi il numero
				value < 8 ? String.format("%s", getValue()) : //
				// altrimenti prendi la stringa dall'array delle figure
						figures[value - 8];
		return String.format("%s di %s", v, Seeds.values()[seed].toString().toLowerCase());
	}
}
