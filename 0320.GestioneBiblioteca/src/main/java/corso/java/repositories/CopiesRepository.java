package corso.java.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import corso.java.entities.BookCopy;

public interface CopiesRepository extends JpaRepository<BookCopy, Integer>{

}
