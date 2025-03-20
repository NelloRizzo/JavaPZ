package corso.java.entities;

import org.hibernate.annotations.Check;

import jakarta.persistence.Embedded;
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
@Table(name = "copies")
@Check(name = "location_copy_is_valid", constraints = "location_room IS NOT NULL OR location_shelf IS NOT NULL OR location_row IS NOT NULL or location_index IS NOT NULL")
public class BookCopy {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Embedded
	private Location location;
	@Builder.Default
	private boolean loanable = true;
	@ManyToOne
	@JoinColumn(foreignKey = @ForeignKey(name = "fk_copies_books"))
	public Book book;
}
