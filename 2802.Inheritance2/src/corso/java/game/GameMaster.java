package corso.java.game;

import corso.java.entities.GameGrid;

public interface GameMaster {

	void hunterMove(char direction);

	void monstersMove();

	boolean hunterWon();

	boolean hunterLost();
	
	GameGrid grid();
}
