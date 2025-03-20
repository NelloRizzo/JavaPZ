package corso.java.entities;

import org.hibernate.annotations.Check;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
@Table(name = "authors")
@Check(constraints = "death > birth", name = "chk_birth_and_death")
public class Author {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(length = 25, nullable = true)
	private String firstName;
	@Column(length = 25, nullable = true)
	private String middleName;
	@Column(length = 25, nullable = false)
	private String lastName;
	@Column(length = 3, nullable = false)
	private String country;
	@Column(name = "birth", nullable = false)
	private Integer yearOfBirth;
	@Column(name = "death", nullable = true)
	private Integer yearOfDeath;
}
