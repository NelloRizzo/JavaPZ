package corso.java.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(setterPrefix = "with")
public class Property {
	private int id;
	private String name;
	private String defaultValue;
}
