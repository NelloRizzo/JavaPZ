package corso;

import corso.java.CitiesLoader;

public class Program {

	public static void main(String[] args) {
		var cl = new CitiesLoader(".\\comuni.csv");
		var cities = cl.readFile();
		System.out.printf("Ho letto %s linee%n", cities.size());

		cities.stream() //
				.filter(c -> c.getProvince().getAcronym().equals("PZ")) //
				.forEach(c -> System.out.println(c));

		cities.stream() //
				.map(c -> c.getProvince()) //
				.distinct() //
				.forEach(c -> System.out.println(c));
		cities.stream() //
				.map(c -> c.getProvince().getRegion()) //
				.distinct() //
				.forEach(c -> System.out.println(c));
		cities.stream() //
				.map(c -> c.getProvince().getRegion().getArea()) //
				.distinct() //
				.forEach(c -> System.out.println(c));

		cities.stream().filter(c -> c.getName().contains("Potenza")) //
				.findAny().ifPresentOrElse( //
						c -> System.out.println(c), //
						() -> System.out.println("Nessuna città trovata"));
	}

}
