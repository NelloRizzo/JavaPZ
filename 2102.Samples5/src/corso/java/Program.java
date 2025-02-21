package corso.java;

public class Program {

	public static void operate(Account account) {
		account.deposit(100);
		account.withdraw(50);
		account.withdraw(50);
		account.withdraw(50);
		account.deposit(75);
		account.withdraw(50);
	}

	public static void main(String[] args) {
		// Occorre gestire un conto corrente
		// che consenta di fare depositi e prelievi
		// ovviamente non è possibile prelevare
		// più di quanto sia disponibile sul saldo
		System.out.println("Uso di c/c senza commissione");
		var account = new Account();
		operate(account);
		System.out.println("Uso di c/c con commissione");
		operate(new AccountWithFare());
	}
}
