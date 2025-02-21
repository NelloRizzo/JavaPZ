package corso.java;

public class AccountWithFare extends Account {
	private float fare = 1;

	@Override
	public void deposit(float amount) {
		System.out.printf("Costo operazione: %.2f€%n", fare);
		super.deposit(amount - fare);
	}

	@Override
	public void withdraw(float amount) {
		System.out.printf("Costo operazione: %.2f€%n", fare);
		super.withdraw(amount + fare);
	}
}
