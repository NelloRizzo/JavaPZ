package corso.java.entities.table;

import jakarta.persistence.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)

@Entity
public class CreditCardPayment extends Payment {
	private String number;

	public CreditCardPayment(double amount, String number) {
		super(amount);
		this.number = number;
	}
	
}
