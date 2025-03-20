package corso.java.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import corso.java.entities.User;

@Repository
public interface UsersRepository extends JpaRepository<User, Integer> {

}
