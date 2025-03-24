package corso.java.data.entities;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.OneToMany;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)

@MappedSuperclass
public abstract class CompositeProductEntity extends ProductEntity {
	@OneToMany
	@ToString.Exclude
	private final List<ProductEntity> components = new ArrayList<>();

	public BigDecimal getTotalPrice() {
		return components.stream() //
				.map(ProductEntity::getUnitPrice).reduce(BigDecimal.ZERO, (a, b) -> a.add(b));
	}

	public CompositeProductEntity(String name, BigDecimal unitPrice, String description) {
		super(name, unitPrice, description);
	}
}
