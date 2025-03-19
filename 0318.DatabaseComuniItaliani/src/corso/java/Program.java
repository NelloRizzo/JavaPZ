package corso.java;

import corso.java.entities.Area;
import corso.java.entities.City;
import corso.java.entities.Province;
import corso.java.entities.Region;
import jakarta.persistence.Persistence;

public class Program {
	// SELECT p.denominazione, p.sigla, p.region_id, r.denominazione
	// r.id FROM province p JOIN regioni r ON p.region_id = r.id
	// WHERE r.denominazione = 'Lombardia'

	private static final String QUERY_PROVINCES = 
			"SELECT p FROM Province p WHERE p.region.name = :region";
	
	
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

		try (var emf = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT)) {
			try (var em = emf.createEntityManager()) {

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
				System.out.println("Province in Lombardia");
				var q = em.createQuery(QUERY_PROVINCES, Province.class);
				q.setParameter("region", "Lombardia");
				q.getResultStream().forEach(System.out::println);
			}
		}
	}

}
