package corso.java.game;

import corso.java.entities.Hunter;

public class HunterPawn extends Hunter implements Pawn {

	private int row;
	private int column;

	public HunterPawn(int lifeLevel, int attack) {
		super(lifeLevel, attack);
	}

	@Override
	public int getRow() {
		return row;
	}

	@Override
	public int getColumn() {
		return column;
	}

	public void setRow(int row) {
		this.row = row;
	}

	public void setColumn(int column) {
		this.column = column;
	}

}
