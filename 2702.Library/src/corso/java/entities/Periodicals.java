package corso.java.entities;

import java.time.LocalDate;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public abstract class Periodicals extends LibraryRecord {
	private LocalDate publishedAt;
	private Frequency frequency;

	public Periodicals(int id, Publisher publisher, LocalDate publishedAt, Frequency frequency) {
		super(id, publisher);
		this.publishedAt = publishedAt;
		this.frequency = frequency;
	}

}
