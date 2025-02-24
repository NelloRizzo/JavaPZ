package corso.java;

import corso.java.data.City;
import corso.java.services.CityService;
import corso.java.services.InMemoryCityService;

public class Program {

	static void appContext(CityService service) {
		service.addCity(new City("Potenza", "PZ", "00000"));
		service.addCity(new City("Roma", "RM", "00000"));
		service.addCity(new City("Napoli", "NA", "00000"));
		service.addCity(new City("Salerno", "SA", "00000"));
		service.addCity(new City("Contursi", "SA", "00000"));
		service.addCity(new City("Ascea", "SA", "00000"));
		service.addCity(new City("Potenza", "PZ", "00000"));

		System.out.println("Tutte le città in archivio:");
		service.getAllCities().stream() //
			.distinct() //
			.forEach(c -> System.out.println(c));

		String prov = "SA";
		System.out.printf("Città in provincia di %s%n", prov);
		service.getAllCitiesByProvince(prov).stream().forEach(s -> System.out.println(s));
	}

	public static void main(String[] args) {
		// Supponiamo di voler gestire delle città italiane
		appContext(new InMemoryCityService());
	}

}
