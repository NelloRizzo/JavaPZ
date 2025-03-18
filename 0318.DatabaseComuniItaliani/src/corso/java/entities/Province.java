package corso.java.entities;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
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
@Table(name = "province")
public class Province {
	@Id
	private Integer id;
	@Column(name = "denominazione", length = 80, nullable = false)
	private String name;
	@Column(name = "sigla", length = 2, nullable = false)
	private String acronym;
	@ManyToOne(cascade = CascadeType.ALL)
	private Region region;
	@OneToMany(mappedBy = "province", fetch = FetchType.EAGER)
	@ToString.Exclude
	private final Set<City> provinces = new HashSet<>();
}
