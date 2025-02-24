package corso.java;

import corso.java.cards.Deck;
import corso.java.cards.FrenchDeck;
import corso.java.cards.NeapoleanDeck;

public class Program {

	public static void deal(Deck deck) {
		var iterator = deck.iterator();
		while (iterator.hasNext())
			System.out.println(iterator.next());
	}

	public static void main(String[] args) {
		// Occorre distribuire un mazzo di carte da gioco.
		deal(new NeapoleanDeck());
		deal(new FrenchDeck());
	}

}
