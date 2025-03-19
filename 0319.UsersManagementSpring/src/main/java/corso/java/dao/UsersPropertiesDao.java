package corso.java.dao;

import java.util.List;

import corso.java.entities.UserProperty;

public interface UsersPropertiesDao {
	void create(UserProperty userProperty);

	void delete(UserProperty userProperty);

	List<UserProperty> findAllByPropertyName(String propertyName);

	List<UserProperty> findAllByUserUsername(String username);
}
