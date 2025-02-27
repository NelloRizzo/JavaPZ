package corso.java.entities;

import java.time.LocalDate;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class Magazine extends Periodicals {
	private String name;
	private String number;

	public Magazine(int id, Publisher publisher, LocalDate publishedAt, Frequency frequency, String name,
			String number) {
		super(id, publisher, publishedAt, frequency);
		this.name = name;
		this.number = number;
	}
}
