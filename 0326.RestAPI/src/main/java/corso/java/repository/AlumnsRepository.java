package corso.java.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import corso.java.entities.Alumn;

public interface AlumnsRepository extends JpaRepository<Alumn, Integer> {

}
