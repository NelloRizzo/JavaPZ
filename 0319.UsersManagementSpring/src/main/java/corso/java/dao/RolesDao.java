package corso.java.dao;

import java.util.List;
import java.util.Optional;

import corso.java.entities.Role;

public interface RolesDao {
	Role create(Role role);

	List<Role> findAll();

	Optional<Role> findByName(String name);
}
