package corso.java.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

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
	@ManyToOne
	private Region region;
}
