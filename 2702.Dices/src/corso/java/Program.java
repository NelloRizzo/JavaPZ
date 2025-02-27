package corso.java;

import java.util.Collection;
import java.util.List;

import corso.java.dices.Dice;
import corso.java.dices.LoadedDice;
import corso.java.services.DiceShaker;

public class Program {

	static void play(DiceShaker shaker) {
		for (int i = 0; i < 10; ++i) {
			System.out.println(shaker.shake());
		}
	}

	public static void main(String[] args) {
		// dadi da mettere nel bicchiere
		Collection<Dice> dices = List.of(new LoadedDice(), new Dice());
		var shaker = new DiceShaker(dices);
		play(shaker);
	}

}
