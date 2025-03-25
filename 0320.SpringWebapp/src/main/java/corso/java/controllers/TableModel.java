package corso.java.controllers;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder(setterPrefix = "with")
public class TableModel {
	private int number;
	private int factor;
	private int result;
}
