package corso.java.tombola;

public class Program {

	public static void main(String[] args) {
		// Occorre modellare il sacchetto di estrazione dei numeri per la tombola
		var bag = new NumbersBag();
		bag.shuffle();
		int n1 = bag.draw();
		System.out.println(n1);
		int n2 = bag.draw();
		System.out.println(n2);

		if (bag.isDrawn(n1)) {
			System.out.printf("Il numero %d è stato già estratto%n", n1);
		} else {
			System.out.printf("Il numero %d non è stato già estratto%n", n1);
		}
		if (bag.isDrawn(55)) {
			System.out.printf("Il numero %d è stato già estratto%n", 55);
		} else {
			System.out.printf("Il numero %d non è stato già estratto%n", 55);
		}

		while (!bag.isEmpty())
			System.out.println(bag.draw());

		System.out.println(bag.draw());

		bag.reset();
		System.out.println(bag.draw());
		System.out.println(bag.draw());
		System.out.println(bag.draw());
		System.out.println(bag.draw());
		System.out.println(bag.draw());
		System.out.println(bag.draw());
	}

}
