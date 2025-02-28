package corso.java.game;

import corso.java.entities.Monster;
import lombok.Setter;

public class MonsterDecorator extends Monster implements Pawn {

	@Setter
	private int row;
	@Setter
	private int column;
	
	public MonsterDecorator(Monster handler) {
		super(handler.getLifeLevel(), handler.getAttack(), handler.getSymbol());
	}

	@Override
	public int getRow() {
		return row;
	}

	@Override
	public int getColumn() {
		return column;
	}

}
