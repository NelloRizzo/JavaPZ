package corso.java.securitysample.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import corso.java.securitysample.entities.UserEntity;

public interface UsersRepository extends JpaRepository<UserEntity, Integer>{

	Optional<UserEntity> findByUsername(String username);
}
