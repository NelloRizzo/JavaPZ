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
@Table(name = "cities")
public class City {
	@Id
	@EqualsAndHashCode.Include
	private Integer id;
	@Column(length = 80, nullable = false)
	private String name;
	@Column(length = 4, nullable = false, unique = true)
	private String cadastralCode;
	@Column(length = 80, nullable = true)
	private String zips;
	private long people;
	@ManyToOne
	private Province province;

	@Builder(setterPrefix = "with")
	public City(int id, String name, String cadastralCode, String zips, long people, Province province) {
		this.id = id;
		this.name = name;
		this.cadastralCode = cadastralCode;
		this.zips = zips;
		this.people = people;
		this.province = province;
	}

}
