package corso.java.entities;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
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
@Table(name = "ripartizioni")
public class Area {
	@Id
	private Integer id;
	@Column(name = "denominazione", length = 50, nullable = false)
	private String name;
	@OneToMany(mappedBy = "area", fetch = FetchType.EAGER)
	@ToString.Exclude
	private final Set<Region> regions = new HashSet<Region>();
}
