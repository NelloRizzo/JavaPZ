package corso.java.game;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import corso.java.entities.DarkKnight;
import corso.java.entities.DirtySlime;
import corso.java.entities.GameGrid;

public class GameMasterV1 implements GameMaster {

	private final GameGrid gameGrid;
	private final HunterPawn hunter = new HunterPawn(20, 2);
	private final List<MonsterDecorator> monsters = new ArrayList<MonsterDecorator>();

	public GameMasterV1() {
		gameGrid = new GameGrid(20, 15);

		for (int i = 0; i < 5; ++i) {
			monsters.add(new MonsterDecorator(new DirtySlime()));
		}
		monsters.add(new MonsterDecorator(new DarkKnight(20, 5)));
		spawnMonsters();

		int row = gameGrid.getHeight() / 2;
		int column = gameGrid.getWidth() / 2;
		placeHunter(row, column);
	}

	private void spawnMonsters() {
		var rnd = new Random();
		for (var monster : monsters) {
			var x = rnd.nextInt(gameGrid.getWidth());
			var y = rnd.nextInt(gameGrid.getHeight());
			placeMonster(monster, y, x);
		}
	}

	private void placeMonster(MonsterDecorator monster, int row, int col) {
		gameGrid.getCells()[monster.getRow()][monster.getColumn()] = null;
		monster.setRow(row);
		monster.setColumn(col);
		gameGrid.getCells()[row][col] = monster;
	}

	private void placeHunter(int row, int col) {
		gameGrid.getCells()[hunter.getRow()][hunter.getColumn()] = null;
		hunter.setRow(row);
		hunter.setColumn(col);
		gameGrid.getCells()[row][col] = hunter;
	}

	@Override
	public void hunterMove(char direction) {
		// sulla base della direzione
		// dobbiamo prendere la posizione attuale del cacciatore
		// e cambiarla opportunamente
		var dx = 0;
		var dy = 0;
		if (direction == 'a')
			dx = -1;
		if (direction == 'd')
			dx = 1;
		if (direction == 'w')
			dy = -1;
		if (direction == 's')
			dy = 1;

		var px = hunter.getColumn();
		var py = hunter.getRow();

		var x = px + dx;
		var y = py + dy;

		if (x < 0)
			x = 0;
		if (x >= gameGrid.getWidth())
			x = gameGrid.getWidth() - 1;
		if (y < 0)
			y = 0;
		if (y >= gameGrid.getHeight())
			y = gameGrid.getHeight() - 1;
		placeHunter(y, x);
	}

	@Override
	public void monstersMove() {
		var rnd = new Random();
		// dobbiamo prendere la posizione attuale di ogni mostro
		// e cambiarla opportunamente
		for (var monster : monsters) {
			var dx = rnd.nextInt(3) - 1; // 0 1 2 -1 => -1 0 1
			var dy = rnd.nextInt(3) - 1;
			
			var px = monster.getColumn();
			var py = monster.getRow();

			var x = px + dx;
			var y = py + dy;

			if (x < 0)
				x = 0;
			if (x >= gameGrid.getWidth())
				x = gameGrid.getWidth() - 1;
			if (y < 0)
				y = 0;
			if (y >= gameGrid.getHeight())
				y = gameGrid.getHeight() - 1;
			placeMonster(monster, y, x);
	}
	}

	@Override
	public boolean hunterWon() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean hunterLost() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public GameGrid grid() {
		return this.gameGrid;
	}

}
