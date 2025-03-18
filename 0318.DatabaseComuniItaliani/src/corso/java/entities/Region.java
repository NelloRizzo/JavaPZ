package corso.java.entities;

import java.util.HashSet;
import java.util.Set;

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
@Table(name = "regioni")
public class Region {
	@Id
	private Integer id;
	@Column(name = "denominazione", length = 80, nullable = false)
	private String name;
	@ManyToOne
	private Area area;
	@OneToMany(mappedBy = "region", fetch = FetchType.LAZY)
	@ToString.Exclude
	private final Set<Province> provinces = new HashSet<>();
}
