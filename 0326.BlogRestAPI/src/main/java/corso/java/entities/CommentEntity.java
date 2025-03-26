package corso.java.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder(setterPrefix = "with")

@Entity
@Table(name = "comments")
public class CommentEntity extends BaseEntity {
	@Column(length = 2048, nullable = false)
	private String body;
	@ManyToOne
	private AuthorEntity author;
	@ManyToOne
	private ArticleEntity article;
}
