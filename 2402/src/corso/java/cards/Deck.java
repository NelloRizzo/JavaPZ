package corso.java.cards;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Un mazzo di carte da gioco.
 */
public abstract class Deck implements Iterable<Card> {
	/**
	 * Le carte nel mazzo.
	 */
	protected List<Card> cards = new ArrayList<Card>();

	/**
	 * Iteratore sulle carte: consente di usare la classe
	 * Deck in un contesto di enhanced-for.
	 */
	@Override
	public Iterator<Card> iterator() {
		return cards.iterator();
	}

}
