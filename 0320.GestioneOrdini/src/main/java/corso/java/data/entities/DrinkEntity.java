package corso.java.data.entities;

import java.math.BigDecimal;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)

@Entity
@Table(name = "drinks")
public class DrinkEntity extends ProductEntity {
	private int ml;

	@Builder(setterPrefix = "with")
	public DrinkEntity(String name, BigDecimal unitPrice, String description, int ml) {
		super(name, unitPrice, description);
		this.ml = ml;
	}

}
