package corso.java;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SolverResult {
	private boolean win;
	private int target;
	private int attempts;
}
