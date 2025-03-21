package corso.java.datalayer.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
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
@Table(name = "users")
public class UserEntity extends BaseEntity {
	@Column(length = 80, nullable = false, unique = true)
	private String email;
	@Column(length = 128, nullable = false)
	private String password;
	@Column(length = 25, nullable = false)
	private String friendlyName;
}
