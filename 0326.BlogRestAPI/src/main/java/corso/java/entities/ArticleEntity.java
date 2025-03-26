package corso.java.entities;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
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
@Table(name = "articles")
public class ArticleEntity extends BaseEntity {
	@Column(length = 50, nullable = false)
	private String title;
	@Column(length = 4096, nullable = false)
	private String body;
	@ManyToOne
	private AuthorEntity author;
	
	@OneToMany(mappedBy = "article")
	private final List<CommentEntity> comments = new ArrayList<>();
}
