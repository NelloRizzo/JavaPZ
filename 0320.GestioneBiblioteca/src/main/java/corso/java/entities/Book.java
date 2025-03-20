package corso.java.entities;

import org.hibernate.annotations.Check;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(setterPrefix = "with")

@Entity
@Table(name = "books")
@Check(constraints = "pages > 0 AND year > 0", name ="chk_pages_and_year")
public class Book {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(length = 25)
	private String isbn;
	@Column(length = 80, nullable = false)
	private String title;
	@ManyToOne
	@JoinColumn(foreignKey = @ForeignKey(name = "fk_books_authors"))
	private Author author;
	@Column(nullable = true)
	private Integer pages;
	@Column(nullable = false)
	private Integer year;
	@ManyToOne
	@JoinColumn(foreignKey = @ForeignKey(name = "fk_books_categories"))
	private Category category;
}
