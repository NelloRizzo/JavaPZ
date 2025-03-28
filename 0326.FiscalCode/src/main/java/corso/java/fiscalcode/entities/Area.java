package corso.java.fiscalcode.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@NoArgsConstructor

@Entity
@Table(name = "geographicals_areas")
public class Area {
	@Id
	@EqualsAndHashCode.Include
	private Integer id;
	@Column(length = 20, nullable = false, unique = true)
	private String name;

	@Builder(setterPrefix = "with")
	public Area(int id, String name) {
		this.id = id;
		this.name = name;
	}

}
