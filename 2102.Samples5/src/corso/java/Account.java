package corso.java;

public class Account {
	// saldo
	private float amount;

	// restituisce il saldo
	public float getAmount() {
		return amount;
	}

	// deposita una somma
	public void deposit(float amount) {
		System.out.printf("Deposito -> Richiesta di deposito di %.2f€%n", amount);
		this.amount += amount;
		System.out.printf("Deposito -> Saldo: %.2f€%n", this.amount);
	}

	// effettua un prelievo
	public void withdraw(float amount) {
		System.out.printf("Prelievo -> Richiesta di prelievo di %.2f€%n", amount);
		if (this.amount < amount) {
			System.out.println("Prelievo -> Fondi insufficienti, operazione non eseguita");
		} else {
			this.amount -= amount;
		}
		System.out.printf("Prelievo -> Saldo: %.2f€%n", this.amount);
	}
}
