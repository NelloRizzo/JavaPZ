package corso.java.entities;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public abstract class LibraryRecord {
	private int id;
	private Publisher publisher;
}
