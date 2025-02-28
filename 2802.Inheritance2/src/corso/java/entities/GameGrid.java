package corso.java.entities;

/*
 * Griglia di gioco insieme di celle con larghezza e altezza predefinite 
 * in fase di inizializzazione 
 * all'interno dell'insieme di celle ci sono [ELEMENTI DI GIOCO]
 */
public class GameGrid {

	private int width;
	private int height;
	private GameActor[][] cells;
	
	public GameGrid(int width, int height) {
		this.width = width;
		this.height = height;
		
		cells = new GameActor[height][];
		for(int row=0; row < height; ++row) {
			cells[row] = new GameActor[width];
		}
	}
}
