package corso.java;

import corso.java.entities.Area;
import corso.java.entities.City;
import corso.java.entities.Province;
import corso.java.entities.Region;
import jakarta.persistence.Persistence;

public class Program {

	private static final String FILE_NAME = "./comuni.csv";
	private static final String PERSISTENCE_UNIT = "JPA_Comuni_Italiani";

	public static void main(String[] args) {
		var loader = new CitiesLoader(FILE_NAME);
		var cities = loader.readFile();
		System.out.println(cities.size());

		var provinces = cities.stream() //
				.map(City::getProvince) //
				.distinct() //
				.toList();
		var regions = provinces.stream() //
				.map(Province::getRegion) //
				.distinct() //
				.toList();
		var areas = regions.stream() //
				.map(Region::getArea) //
				.distinct() //
				.toList();
		System.out.println(provinces.size());
		System.out.println(regions.size());
		System.out.println(areas.size());

		var emf = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT);
		var em = emf.createEntityManager();

		var trans = em.getTransaction();
		trans.begin();

		areas.forEach(a -> em.persist(a));
		regions.forEach(r -> {
			r.setArea(em.find(Area.class, r.getArea().getId()));
			em.persist(r);
		});
		provinces.forEach(p -> {
			p.setRegion(em.find(Region.class, p.getRegion().getId()));
			em.persist(p);
		});
		cities.forEach(c -> {
			c.setProvince(em.find(Province.class, c.getProvince().getId()));
			em.persist(c);
		});

		trans.commit();

		var firstArea = em.find(Area.class, 1);
		em.refresh(firstArea);
		System.out.println(firstArea);
		System.out.println(firstArea.getRegions().size());
		firstArea.getRegions().forEach(System.out::println);
	}

}
