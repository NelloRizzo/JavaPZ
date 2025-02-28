package corso.java.game;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class GameStatus {
	private int hunterLife;
	private int monstersCount;

	@Override
	public String toString() {
		return String.format("Life: %d - Monsters: %d", hunterLife, monstersCount);
	}
}
