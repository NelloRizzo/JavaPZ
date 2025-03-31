package corso.java.translations.entities;

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

@Table(name = "languages")
@Entity
public class LanguageEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(length = 5, nullable = false, unique = true)
	private String code;
	@Column(length = 20, nullable = false, unique = true)
	private String name;
	@Column(length = 80, nullable = true, unique = false)
	private String description;
}
