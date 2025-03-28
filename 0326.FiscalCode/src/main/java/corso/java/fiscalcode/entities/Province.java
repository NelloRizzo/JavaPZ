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
@Table(name = "provinces")
public class Province  {
	@Id
	@EqualsAndHashCode.Include
	private Integer id;
	@Column(length = 50, nullable = false, unique = true)
	private String name;
	@Column(length = 2, nullable = false, unique = true)
	private String acronym;
	@ManyToOne
	private Region region;

	@Builder(setterPrefix = "with")
	public Province(int id, String name, String acronym, Region region) {
		this.id = id;
		this.name = name;
		this.acronym = acronym;
		this.region = region;
	}

}
