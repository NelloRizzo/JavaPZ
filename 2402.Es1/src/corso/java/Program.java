package corso.java;

import java.util.List;

import corso.java.data.Drink;
import corso.java.data.Dish;
import corso.java.services.InMemoryMenuService;
import corso.java.services.MenuService;

public class Program {

	static void application(MenuService service) {
		service.add(new Dish("Risotto alla milanese", 18, List.of("Riso", "Zafferano")));
		service.add(new Dish("Carbonara", 15, List.of("Pasta", "Uovo", "Guanciale")));
		service.add(new Dish("Pasta al sugo", 7, List.of("Pasta", "Sugo")));
		service.add(new Drink("CocaCola", 2, 330));
		service.add(new Drink("Vino della casa", 7, 1000));
		service.add(new Drink("Falanghina", 18, 750));

		System.out.println("Menu:");
		service.getAll().stream() //
				.sorted() //
				.forEach(i -> System.out.println(i));

		System.out.println("Somma di tutti i prezzi:" + //
				service.getAll().stream() //
						.map(i -> i.getPrice()).reduce((a, b) -> a += b));
	}

	public static void main(String[] args) {
		// Un ristorante propone un menu formato da
		// tante pietanze o bibite.
		// Un servizio di applicazione deve consentire
		// di aggiungere voci al menu e di
		// elencare le diverse pietanze, cercando sulla base
		// del nome assegnato alla pietanza stessa
		application(new InMemoryMenuService());
	}

}
