package corso.java.dao;

import java.util.List;
import java.util.Optional;

import corso.java.entities.Property;

public interface PropertiesDao {
	Property create(Property property);

	Optional<Property> findByName(String property);

	List<Property> findAll();
}
