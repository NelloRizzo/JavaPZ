package corso.java.entities;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OrderBy;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(setterPrefix = "with")

//@Embeddable
@Entity
@Table(name = "users")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(length = 80, nullable = false)
	private String username;
	@Column(length = 125, nullable = false)
	private String password;
	@Column(length = 25, nullable = false)
	private String friendlyName;
	@OneToMany(mappedBy = "author", fetch = FetchType.LAZY)
	@OrderBy("title DESC")
	@ToString.Exclude
	private final List<Article> articles = new ArrayList<Article>();
	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable(name = "users_roles_link", //
			joinColumns = @JoinColumn(name = "role_fk"), //
			inverseJoinColumns = @JoinColumn(name = "user_fk"))
	private final Set<Role> roles = new HashSet<Role>();
}
