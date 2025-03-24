package corso.java.data.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import corso.java.data.entities.CustomerEntity;

public interface CustomersRepository extends JpaRepository<CustomerEntity, Integer> {

}
