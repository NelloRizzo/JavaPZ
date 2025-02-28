package corso.java.entities;

import lombok.Getter;

/*
 * Griglia di gioco insieme di celle con larghezza e altezza predefinite 
 * in fase di inizializzazione 
 * all'interno dell'insieme di celle ci sono [ELEMENTI DI GIOCO]
 */
public class GameGrid {
	@Getter
	private int width;
	@Getter
	private int height;
	@Getter
	private final GameActor[][] cells;

	public GameGrid(int width, int height) {
		this.width = width;
		this.height = height;

		cells = new GameActor[height][];
		for (int row = 0; row < height; ++row) {
			cells[row] = new GameActor[width];
		}
	}
}
