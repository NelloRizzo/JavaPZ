package corso.java.fiscalcode.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import corso.java.fiscalcode.entities.City;

public interface CitiesRepository extends JpaRepository<City, Integer> {

	Optional<City> findByName(String name);
}
