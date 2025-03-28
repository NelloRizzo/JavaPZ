package corso.java.fiscalcode.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
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
@Table(name = "regions")
public class Region {
	@Id
	@EqualsAndHashCode.Include
	private Integer id;
	@Column(length = 50, nullable = false, unique = true)
	private String name;
	@ManyToOne
	private Area area;

	@Builder(setterPrefix = "with")
	public Region(int id, String name, Area area) {
		this.id = id;
		this.name = name;
		this.area = area;
	}

}
