package corso.java.data.entities;

import java.util.ArrayList;
import java.util.List;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Builder(setterPrefix = "with")

@Entity
@Table(name = "orders")
public class OrderEntity extends BaseEntity {
	@Column(length = 10)
	private String number;
	@Temporal(TemporalType.TIMESTAMP)
	private LocalDateTime dateTime;
	@ManyToOne
	private CustomerEntity customer;
	private boolean completed;
	@OneToMany(mappedBy = "order")
	@ToString.Exclude
	private final List<OrderedProductEntity> products = new ArrayList<>();
}
