package corso.java.entities.joined;

import jakarta.persistence.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@Entity
public class Car extends Vehicle {
	private int doors;
	
	public Car(String manufacturer, int doors) {
		super(manufacturer);
		this.doors = doors;
	}
}
