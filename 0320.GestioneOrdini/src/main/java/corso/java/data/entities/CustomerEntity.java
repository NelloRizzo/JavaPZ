package corso.java.data.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Builder(setterPrefix = "with")

@Entity
@Table(name = "customers")
public class CustomerEntity extends BaseEntity {
	@Column(length = 25, nullable = false)
	private String firstName;
	@Column(length = 25, nullable = true)
	private String lastName;
}
