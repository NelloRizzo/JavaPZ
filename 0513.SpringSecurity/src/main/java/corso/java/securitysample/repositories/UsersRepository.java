package corso.java.securitysample.entities;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepository extends JpaRepository<UserEntity, Integer>{

	Optional<UserEntity> findByUsername(String username);
}
