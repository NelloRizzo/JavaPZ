package corso.java.entities;

import jakarta.persistence.CascadeType;
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
@Table(name = "comuni")
public class City {
	@Id
	private Integer id;
	@Column(name = "denominazione", length = 80, nullable = false)
	private String name;
	private boolean capital;
	@Column(name = "codice_catastale", length = 4, nullable = false)
	private String cadastralCode;
	@ManyToOne(cascade = CascadeType.ALL)
	private Province province;
}
