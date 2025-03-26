package corso.java.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import corso.java.entities.AuthorEntity;

public interface AuthorsRepository extends JpaRepository<AuthorEntity, Integer>{

}
