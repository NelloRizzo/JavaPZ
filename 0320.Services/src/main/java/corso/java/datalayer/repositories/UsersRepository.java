package corso.java.datalayer.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import corso.java.datalayer.entities.UserEntity;

public interface UsersRepository extends JpaRepository<UserEntity, Integer>{

}
