package corso.java.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import corso.java.entities.Loan;

public interface LoansRepository extends JpaRepository<Loan, Integer> {

}
