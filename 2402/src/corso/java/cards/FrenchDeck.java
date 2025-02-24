package corso.java.cards;

import corso.java.cards.FrenchCard.Seeds;

public class FrenchDeck extends Deck {

	public FrenchDeck() {
		var seeds = Seeds.values();
		for (var s = 0; s < 4; ++s) {
			for (var v = 1; v < 14; ++v) {
				cards.add(new FrenchCard(seeds[s], v));
			}
		}
		cards.add(new FrenchCard(FrenchCard.BLACK_JOKER_SEED, FrenchCard.JOKER_VALUE));
		cards.add(new FrenchCard(FrenchCard.RED_JOKER_SEED, FrenchCard.JOKER_VALUE));
	}
}
