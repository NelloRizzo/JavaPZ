package corso.java;

import corso.java.cards.Deck;
import corso.java.cards.FrenchCard;
import corso.java.cards.FrenchDeck;
import corso.java.cards.NeapoleanCard;
import corso.java.cards.NeapoleanDeck;
import corso.java.cards.exceptions.InvalidCardValueException;

public class Program {

	public static void deal(Deck deck) {
		var iterator = deck.iterator();
		while (iterator.hasNext())
			System.out.println(iterator.next());
	}

	public static void main(String[] args) {
		try {
			var nc = new NeapoleanCard(NeapoleanCard.Seeds.DENARI, 15);
			System.out.println(nc);
		} catch (InvalidCardValueException e) {
			System.out.println("Il valore non è corretto: " + e.getInvalidValue());
		} catch (Exception e) {
			System.out.println("Si è verificato un problema");
			System.out.println(e.getMessage());
		}
		// Occorre distribuire un mazzo di carte da gioco.
		deal(new NeapoleanDeck());
		deal(new FrenchDeck());
		
		
		for(var card : new FrenchDeck()) {
			System.out.println(card);
		}
		var nc = new NeapoleanCard(NeapoleanCard.Seeds.BASTONI, 4);
		var fc = new FrenchCard(FrenchCard.Seeds.HEARTS, 11);
		
		System.out.println(FrenchCard.JOKER_VALUE);
	}

}
