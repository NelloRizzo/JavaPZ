package corso.java.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import corso.java.entities.Vehicle;

public interface VehiclesRepository extends JpaRepository<Vehicle, Integer>{

}
