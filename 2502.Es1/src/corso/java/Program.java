package corso.java;

import corso.java.utils.CityLoader;

public class Program {

	public static void main(String[] args) {
		var loader = new CityLoader(".\\comunali.csv");
		System.out.printf("Totale comuni caricati: %s%n", loader.getCities().count());
		loader.getCities().limit(10).forEach(c -> System.out.println(c));
		System.out.println("Superficie totale Italia: ");
		var hs = loader.getCities()
				// mapToDouble converte in uno Stream specializzato sui Double
				// il quale rende disponibili operazioni quali sum(), min(), max(), average()
				.mapToDouble(c -> c.getAcreage()).sum();
		var kms = loader.getCities().mapToDouble(c -> c.getKm2()).sum();
		System.out.printf("h = %.2f%n", hs);
		System.out.printf("Kmq = %.2f%n", kms);
		var ad = loader.getCities().mapToDouble(c -> c.getDensity())
				// average() restituisce un Optional<Double>
				// sull'Optional si può usare un metodo orElse
				// che prevede un valore di default nel caso in cui il
				// risultato fosse vuoto
				.average().orElse(0);
		System.out.printf("Densità media Italia: %.2f%n", ad);
		var n = 10;
		System.out.printf("Prime %d città con densità di popolazione superiore alla media:%n", n);
		loader.getCities() //
				.filter(c -> c.getDensity() >= ad) //
				// confronto tra densità tra due città per l'ordinamento
				// -1 se c1 viene prima di c2, 1 se c1 viene dopo c2
				.sorted((c1, c2) -> c1.getDensity() > c2.getDensity() ? -1 : 1)//
				.limit(n) //
				.forEach(c -> System.out.println(c));
	}

}
