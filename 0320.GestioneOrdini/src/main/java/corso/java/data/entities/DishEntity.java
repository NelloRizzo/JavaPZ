package corso.java.data.entities;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)

@Entity
@Table(name = "dishes")
public class DishEntity extends CompositeProductEntity {
	@Column(length = 20, nullable = false)
	private String unitMeasure;

	@Builder(setterPrefix = "with")
	public DishEntity(String name, BigDecimal unitPrice, String description, String unitMeasure) {
		super(name, unitPrice, description);
		this.unitMeasure = unitMeasure;
	}

}
