package corso.java.entities;

import java.time.LocalDate;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class Newspaper extends Periodicals {
	private String name;

	public Newspaper(int id, Publisher publisher, LocalDate publishedAt, String name) {
		super(id, publisher, publishedAt, Frequency.Daily);
		this.name = name;
	}
}
