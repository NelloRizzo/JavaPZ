package corso.java.data.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder(setterPrefix = "with")

@Entity
@Table(name = "ordered_products")
public class OrderedProductEntity extends BaseEntity {
	@ManyToOne
	private OrderEntity order;
	@ManyToOne
	private ProductEntity product;
	private int quantity;
}
