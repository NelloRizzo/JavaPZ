package corso.java.entities.dao;

import java.util.Optional;

import corso.java.entities.User;

public interface UsersDao {
	void registerUser(User user);

	Optional<User> getUserByUsername(String username);
}
