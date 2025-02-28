package corso.java.entities;

import lombok.Data;

/*
 * Elemento di Gioco
 *  - Livello di vita
 *  - Capacità di attacco
 *  - ha una capacità di raccontare come viene visualizzato sulla griglia
 */
@Data
public abstract class GameActor {
	int lifeLevel;
	int attack;
	char symbol;

	public GameActor(int lifeLevel, int attack, char symbol) {
		this.lifeLevel = lifeLevel;
		this.attack = attack;
		this.symbol = symbol;
	}

}
