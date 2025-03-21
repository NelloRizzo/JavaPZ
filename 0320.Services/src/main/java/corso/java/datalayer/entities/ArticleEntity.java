package corso.java.datalayer.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Builder(setterPrefix = "with")

@Entity
@Table(name = "articles")
public class ArticleEntity extends BaseEntity {
	@Column(length = 80, nullable = false)
	private String title;
	@Column(length = 32768, nullable = false)
	private String content;
	@ManyToOne
	private UserEntity author;
}
