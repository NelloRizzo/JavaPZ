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
@Table(name = "comments")
public class CommentEntity extends BaseEntity {
	@Column(length = 4096, nullable =  false)
	private String content;
	@ManyToOne
	private UserEntity author;
	@ManyToOne
	private ArticleEntity article;
}
