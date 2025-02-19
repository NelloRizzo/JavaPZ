package corso.java;

public class Program {

	static double calcAmount(Product[] p) {
		double total = 0;
		for(int i=0; i < p.length; ++i) {
			total = total + p[i].getPrice();
		}
		return total;
	}
	public static void main(String[] args) {
		Product[] products = {
				new Product("Pane", 1.2),
				new Product("Pasta", 1),
				new Product("Carne", 5.3)
		};
		double amount = calcAmount(products);
		for(int i=0; i < products.length; ++i) {
			System.out.println(products[i].getName() + '\t' + products[i].getPrice() + '€');
		}
		System.out.println("-".repeat(20));
		System.out.println("Totale\t" + amount + "€");
	}

}
