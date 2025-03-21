package corso.java.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import corso.java.entities.table.Payment;

public interface PaymentsRepository extends JpaRepository<Payment, Integer>{

}
