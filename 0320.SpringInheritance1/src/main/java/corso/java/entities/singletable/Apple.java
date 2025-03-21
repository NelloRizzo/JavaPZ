package corso.java.entities.singletable;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)

@Entity
@DiscriminatorValue("2")
public class Apple extends Product {
	@Column(length = 50)
	String quality;
	int quantity;
	
	public Apple(double price, String quality, int quantity) {
		setPrice(price);
		setName("Mele");
		this.quality = quality;
		this.quantity = quantity;
	}
}
