package corso.java.entities;

import java.util.ArrayList;
import java.util.List;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(setterPrefix = "with")
@Entity
@Table(name = "users")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(length = 80, nullable = false, unique = true)
	private String email;
	@Column(length = 128, nullable = false)
	private String password;
	@Column(length = 20, nullable = false)
	private String username;
	@OneToMany(mappedBy = "author")
	@ToString.Exclude
	private final List<Article> articles = new ArrayList<>();
	@OneToMany(mappedBy = "author")
	@ToString.Exclude
	private final List<Comment> comments = new ArrayList<>();
}
