package corso.java.dao;

import java.util.List;

import corso.java.entities.UserRole;

public interface UsersRolesDao {
	void create(UserRole userRole);

	void delete(UserRole userRole);

	List<UserRole> findAllByRoleName(String roleName);

	List<UserRole> findAllByUserUsername(String username);
}
