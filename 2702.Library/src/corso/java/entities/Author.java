package corso.java.entities;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Author {
	private String firstName;
	private String lastName;
	private String country;
}
