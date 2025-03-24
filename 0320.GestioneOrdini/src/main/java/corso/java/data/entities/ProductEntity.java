package corso.java.data.entities;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "products")
@Inheritance(strategy = InheritanceType.JOINED)
public class ProductEntity extends BaseEntity {
	@Column(length = 80, nullable = false)
	private String name;
	@Column(precision = 10, scale = 2)
	private BigDecimal unitPrice;
	@Column(length = 255, nullable = true)
	private String description;
}
