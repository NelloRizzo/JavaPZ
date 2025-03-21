package corso.java.entities.singletable;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor

@Entity
@DiscriminatorValue("1")
public class Book extends Product {
	@Column(length = 50, nullable = true)
	private String author;
	private int year;
	
	public Book(String name, Double price, String author, int year) {
		setName(name);
		setPrice(price);
		this.author = author;
		this.year = year;
	}
}
