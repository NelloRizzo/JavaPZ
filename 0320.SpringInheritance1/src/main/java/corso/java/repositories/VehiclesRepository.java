package corso.java.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import corso.java.entities.joined.Vehicle;

public interface VehiclesRepository extends JpaRepository<Vehicle, Integer>{

}
