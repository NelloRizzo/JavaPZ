package corso.java;

import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import corso.java.exceptions.GameEndedException;
import lombok.Getter;

/**
 * Gestione del gioco in un contesto applicativo.
 */
public class GuessTheNumber {
	private static final Logger log = LoggerFactory.getLogger(GuessTheNumber.class);

	/**
	 * Possibili risultati ad ogni tentativo effettuato.
	 */
	public enum Result {
		/**
		 * Il numero da indovinare è più piccolo.
		 */
		LESS,
		/**
		 * Il numero da indovinare è più grande.
		 */
		GREATER,
		/**
		 * Il numero è stato indovinato.
		 */
		WIN
	}

	/**
	 * Il numero da indovinare.
	 */
	private int target;
	/**
	 * I tentativi a disposizione.
	 */
	@Getter
	private int attempts;
	/**
	 * Indica se il numero è stato indovinato.
	 */
	@Getter
	private boolean win;
	/**
	 * Il limite massimo per il numero da indovinare.
	 */
	@Getter
	private int maxTarget;
	/**
	 * Il numero di tentativi a disposizione.
	 */
	@Getter
	private int maxAttempts;

	/**
	 * Consente di leggere il numero da indovinare solo se sono stati esauriti i
	 * tentativi a disposizione.
	 * 
	 * @return il numero da indovinare o -1 se ancora si è in gioco.
	 */
	public int getTarget() {
		if (attempts > 0 && !win)
			return -1;
		return target;
	}

	/**
	 * Indica una sconfitta.
	 */
	public boolean isLose() {
		return attempts == 0;
	}

	/**
	 * Costruttore di default.<br/>
	 *
	 * Imposta il range per il numero da indovinare tra 1 e 1000, con 10 tentativi a
	 * disposizione.
	 */
	public GuessTheNumber() {
		this(1000, 10);
	}

	/**
	 * Costruttore.
	 * 
	 * @param maxTarget il massimo valore del numero da indovinare.
	 * @param attempts  il numero di tentativi a disposizione.
	 */
	public GuessTheNumber(int maxTarget, int attempts) {
		startGame(maxTarget, attempts);
	}

	/**
	 * Inizia una nuova partita.
	 * 
	 * @param maxTarget il massimo valore del numero da indovinare.
	 * @param attempts  il numero di tentativi a disposizione.
	 */
	public void startGame(int maxTarget, int attempts) {
		this.maxTarget = maxTarget;
		this.maxAttempts = attempts;
		target = new Random().nextInt(maxTarget) + 1;
		this.attempts = attempts;
		win = false;
		log.debug("{}", target);
	}

	/**
	 * Gestisce un tentativo di indovinare.
	 * 
	 * @param number il tentativo effettuato.
	 * @return il risultato del tentativo.
	 */
	public Result attempt(int number) {
		if (win || attempts == 0)
			throw new GameEndedException();
		attempts--;
		if (number < target)
			return Result.GREATER;
		if (number > target)
			return Result.LESS;
		win = true;
		return Result.WIN;
	}
}
