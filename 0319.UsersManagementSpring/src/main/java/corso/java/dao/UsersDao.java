package corso.java.dao;

import java.util.List;
import java.util.Optional;

import corso.java.entities.User;

public interface UsersDao {
	void create(User user);

	Optional<User> findByUsername(String username);

	List<User> findAll();
}
