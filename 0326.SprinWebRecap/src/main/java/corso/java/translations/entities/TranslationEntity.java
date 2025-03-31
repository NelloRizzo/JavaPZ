package corso.java.translations.entities;

import org.hibernate.annotations.NaturalId;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
@Table(name = "translations")
public class TranslationEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@NaturalId
	@ManyToOne
	private MessageEntity message;
	@NaturalId
	@ManyToOne
	private LanguageEntity language;
	@Column(length = 80, nullable = false, unique = false)
	private String translation;
}
