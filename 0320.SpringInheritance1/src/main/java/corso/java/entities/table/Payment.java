package corso.java.entities.table;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Payment {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int id;
	private double amount;
	public Payment(double amount) {
		this.amount = amount;
	}
}
