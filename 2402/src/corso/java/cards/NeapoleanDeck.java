package corso.java.cards;

import corso.java.cards.NeapoleanCard.Seeds;

public class NeapoleanDeck extends Deck {
	/**
	 * Costruisce il mazzo mettendo al suo interno le 40 carte.
	 */
	public NeapoleanDeck() {
		var seeds = Seeds.values();
		for (int s = 0; s < 4; ++s) {
			for (int v = 1; v < 11; ++v) {
				cards.add(new NeapoleanCard(seeds[s], v));
			}
		}
	}
}
