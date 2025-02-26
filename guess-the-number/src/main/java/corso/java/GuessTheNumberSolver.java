package corso.java;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import corso.java.GuessTheNumber.Result;

public class GuessTheNumberSolver {

	private static final Logger log = LoggerFactory.getLogger(GuessTheNumberSolver.class);

	public SolverResult solve(GuessTheNumber game) {
		int attempts = 0;
		int min = 1;
		int max = game.getMaxTarget();
		while (!game.isLose() && !game.isWin()) {
			attempts++;
			int number = (max + min) / 2;
			var result = game.attempt(number);
			if (result == Result.LESS) {
				max = number;
			} else if (result == Result.GREATER) {
				min = number;
			}
			log.debug("number: {} [{},{}]", number, min, max);
		}
		return new SolverResult(game.isWin(), game.getTarget(), attempts);
	}
}
