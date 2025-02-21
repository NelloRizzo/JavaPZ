package corso.java.tombola;

public class Program {

	public static void main(String[] args) {
		// Occorre modellare il sacchetto di estrazione dei numeri per la tombola
		var bag = new NumbersBag();
		bag.shuffle();
		while(!bag.isEmpty())
			System.out.println(bag.draw());
	}

}
