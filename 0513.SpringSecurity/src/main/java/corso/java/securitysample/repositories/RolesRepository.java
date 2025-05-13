package corso.java.securitysample.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import corso.java.securitysample.entities.RoleEntity;

public interface RolesRepository extends JpaRepository<RoleEntity, Integer> {

	Optional<RoleEntity> findByName(String roleName);

}
