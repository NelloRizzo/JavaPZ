package corso.java.services;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import corso.java.dices.Dice;

/**
 * Bicchiere per lanciare i dadi.
 */
public class DiceShaker {
	/**
	 * I dadi contenuti nel bicchiere.
	 */
	private final List<Dice> dices = new ArrayList<Dice>();

	/**
	 * Costruttore.
	 * 
	 * @param dices elenco dei dadi utilizzati nel bicchiere.
	 */
	public DiceShaker(Collection<Dice> dices) {
		// aggiunge i dati passati come parametro al bicchiere
		this.dices.addAll(dices);
	}

	/**
	 * Agita il bicchiere e mostra il risultato dei lanci dei dadi.
	 * 
	 * @return il totale collezionato sui vari risultati.
	 */
	public int shake() {
		return dices.stream() // prende i dadi uno a uno
				.mapToInt(d -> d.roll()) // prende i risultati dei lanci
				.sum(); // e fa la somma
	}
}
