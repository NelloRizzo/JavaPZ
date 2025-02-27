package corso.java;

import java.util.Arrays;
import java.util.List;

import corso.java.dices.Dice;
import corso.java.services.DiceShaker;

public class Program {

	static void play(DiceShaker shaker) {
		for (int i = 0; i < 10; ++i) {
			System.out.println(shaker.shake());
		}
	}

	public static void main(String[] args) {
		// dadi da mettere nel bicchiere
		var dices = List.of(new Dice(), new Dice());
		var shaker = new DiceShaker(dices);
		play(shaker);
	}

}
