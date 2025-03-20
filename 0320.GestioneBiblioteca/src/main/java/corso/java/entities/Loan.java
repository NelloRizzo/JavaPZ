package corso.java.entities;

import java.time.LocalDate;

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
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(setterPrefix = "with")

@Entity
@Table(name = "loans")
@Check(constraints = "to_date > from_date", name="chk_to_after_from")
public class Loan {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@ManyToOne
	@JoinColumn(foreignKey = @ForeignKey(name = "fk_loans_books"))
	private BookCopy book;
	@Temporal(TemporalType.DATE)
	@Column(name = "from_date")
	private LocalDate from;
	@Temporal(TemporalType.DATE)
	@Column(name = "to_date")
	private LocalDate to;
	private boolean returned;
}
